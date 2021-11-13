package zuhlke.pageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountHomePage {

    private static final Logger LOG = LogManager.getLogger(MyAccountHomePage.class);

    public MyAccountHomePage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    /**
     * @author Afsar Ali
     * @code Login page objects
     */


    @FindBy(how= How.CSS , using="a.logout")
    private WebElement button_logout;


    public void click_logout() {
        button_logout.click();
        LOG.info("Logout button clicked successfully");
    }

    public void verifyHomePage(){
        Assert.assertEquals(true,button_logout.isDisplayed());
    }
}
