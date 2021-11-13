package zuhlke.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageFactoryObject {

    CreateNewAccountPage newacc;
    HomePage home;
    MyAccountHomePage myacc;
    SignInPage signin;
    ProductPage productPage;

    /*** Getters ***/

    public CreateNewAccountPage getCreateNewAccoutPage() {
        return newacc;
    }

    public HomePage getHomePage() {
        return home;
    }

    public MyAccountHomePage getMyaccountHomePage() {
        return myacc;
    }

    public SignInPage getSigninPage() {
        return signin;
    }
    public ProductPage getProductPage() {
        return productPage;
    }

    public PageFactoryObject(WebDriver driver){

        newacc = new CreateNewAccountPage(driver);
        home = new HomePage(driver);
        myacc = new MyAccountHomePage(driver);
        signin = new SignInPage(driver);
        productPage = new ProductPage(driver);
    }





}
