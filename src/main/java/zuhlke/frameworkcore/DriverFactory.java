package zuhlke.frameworkcore;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;


public class DriverFactory {

    private static DriverFactory instance = null;
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverFactory() {

    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public final void setDriver(String BROWSER) throws Exception {

        DesiredCapabilities caps = null;

        if(ExecutionType.getInstance().isRemoteExecution){
            driver.set(createRemoteWebDriverFor(DesiredCapabilitiesFactory.getDesiredCapabilities(BrowserType.chrome)));
        }else {
            //LOCAL EXECUTION
            if(BROWSER.equals("Mozilla")){
                driver.set(new FirefoxDriver());
                // Log.info("New driver instantiated");
            }else if(BROWSER.equalsIgnoreCase("Chrome")){
                //java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
                driver.set(new ChromeDriver(DesiredCapabilitiesFactory.getDesiredCapabilities(BrowserType.chrome)));
            }
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public  void clearCurrentDriver() {

        System.out.println("Current thread removed and clearcurrentDriver() called.. ..");
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }

        driver.remove();
    }

    private <T extends MutableCapabilities> RemoteWebDriver createRemoteWebDriverFor(
            T browserOptions) {
        try {
            String url =
                    "http://seleniumchrome:4444/wd/hub";
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(url), browserOptions);
            // LocalFileDetector enables the remote web driver to upload file from
            // inside this automation project
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            return remoteWebDriver;
        } catch (MalformedURLException e) {
            String errorMsg = "Unable to create a remote web driver!";
            errorMsg +=
                    System.lineSeparator() + e.getMessage() + System.lineSeparator() + e.getStackTrace();
        }
        return null;
    }
}
