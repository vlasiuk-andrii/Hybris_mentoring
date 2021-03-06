package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.page.HomePage;

public class HomePageSteps {

    private HomePage homePage = new HomePage();

    @Given("I am an anonymous customer with clear cookies")
    public void iAmAnonymousCustomerWithClearCookies(){
        homePage.visit();
    }

    @When("I am on home page")
    public void iAmOnHomePage(){
        homePage.check();
    }

    @Then("On the home page I can view logo, Sign in Register, icon, search field, navigation menu, banner")
    public void iCanSeeContent(){
        homePage.isContentOnPageCorrect();
    }

}
