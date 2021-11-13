package zuhlke.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import zuhlke.frameworkcore.DriverFactory;
import zuhlke.pageObjects.PageFactoryObject;

import java.util.concurrent.TimeUnit;

public class SignUpAndSignIn {

    public static PageFactoryObject pagefactory;
    @Given("I am on the home page")
    public void i_am_on_the_home_page()  throws Exception{

        DriverFactory driverFactory = DriverFactory.getInstance();
        driverFactory.setDriver("Chrome");
        pagefactory=new PageFactoryObject(driverFactory.getDriver());
        driverFactory.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driverFactory.getDriver().get("http://automationpractice.com/");
        driverFactory.getDriver().manage().window().maximize();
    }

    @Then("Navigate to SignUp page")
    public void navigate_to_SignUp_page() {

        pagefactory.getHomePage().click_button_SignIn();
        pagefactory.getSigninPage().Enter_input_email();
        pagefactory.getSigninPage().click_button_Submit();

    }

    @Then("create an account with random username")
    public void craete_an_account_with_random_username() throws Exception{

        pagefactory.getCreateNewAccoutPage().createAccountForNewUser();
        pagefactory.getMyaccountHomePage().click_logout();
    }


    @Given("I am on the Sign In Page")
    public void i_am_on_the_Sign_In_Page() {
        pagefactory.getSigninPage().verifySignInPage();
    }

    @When("Login using newly created credentials")
    public void login_in_using_newly_created_credentials() {
        pagefactory.getSigninPage().SignInExistingUser( pagefactory.getSigninPage().enterEmailaddress,"Password");
    }

    @Then("I shall see Product page with successful login")
    public void i_shall_see_Product_page_with_successful_login() {
        pagefactory.getMyaccountHomePage().verifyHomePage();
    }

}
