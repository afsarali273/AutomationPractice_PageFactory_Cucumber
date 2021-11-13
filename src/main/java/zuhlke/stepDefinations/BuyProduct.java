package zuhlke.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import zuhlke.frameworkcore.DriverFactory;
import zuhlke.pageObjects.PageFactoryObject;

import java.util.concurrent.TimeUnit;

public class BuyProduct {

    PageFactoryObject factory = SignUpAndSignIn.pagefactory;
    @Given("I am on the product home page")
    public void i_am_on_the_product_home_page() throws Exception{
        factory.getProductPage().verifyProductPage();
    }

    @When("I add product to cart and checkout")
    public void i_add_product_to_cart_and_checkout() {

        factory.getProductPage().AddProductToCart();

    }

    @Then("I shall be able to Buy the product")
    public void i_shall_be_able_to_Buy_the_product() {

        factory.getProductPage().purchaseWithPayment();
    }
}
