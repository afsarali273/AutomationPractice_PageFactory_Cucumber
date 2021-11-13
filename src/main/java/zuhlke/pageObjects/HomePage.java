package zuhlke.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.CSS , using="a.login")
    private WebElement button_SignIn;



    public void waitForHomePageTobeVisible() {

    }

    public void click_button_SignIn() {
        button_SignIn.click();
        System.out.println("Clicked on the Sign In button ");
    }

}
