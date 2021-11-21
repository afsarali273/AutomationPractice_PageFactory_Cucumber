package zuhlke.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo {


    @Given("^I am on the home page with (.*)$")
    public void i_am_on_the_home_page_with_url(String url) {

        System.out.println(" Opened url : "+url);
    }

    @When("^I click on (.*) button$")
    public void i_click_on_button(String button) {
        System.out.println(" Clicked on the  "+button+ "  button");
    }

    @Then("^I navigated to (.*) page$")
    public void navigated_to_page(String page) {
        System.out.println(" Navigated to Page : "+page);
    }
}
