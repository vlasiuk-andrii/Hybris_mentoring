package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.page.ProductDeatailsPage;

import static junit.framework.TestCase.assertTrue;

public class PickUpProductStep {

    private ProductDeatailsPage productDeatailsPage = new ProductDeatailsPage();

    @And("^I am on product deatils page for product \"([^\"]*)\"$")
    public void iAmOnProductDeatilsPageForProduct(String productId) {
        productDeatailsPage.visit("/" + productId);
    }

    @And("^I click on \"([^\"]*)\"$")
    public void iClickOn(String buttonText) {
        productDeatailsPage.clickOnButtonByText(buttonText);
    }

    @And("^Product availability PopUp appears$")
    public void productAvailabilityPopUpAppears() {
        assertTrue(productDeatailsPage.productAvailabilityPopUpAppears());
        assertTrue(productDeatailsPage.productAvailabilityPopUpHasData());
    }

    @When("^I select location \"([^\"]*)\"$")
    public void iSelectLocationByLocationName(String location) {
        productDeatailsPage.clickOnLocation(location);
    }

    @And("^I can change product amount$")
    public void iCanChangeProductAmount() {
        assertTrue("ProductAmount can't be changed",productDeatailsPage.getPickUpFragment().iCanChangeProductAmount());
    }

    @And("^\"([^\"]*)\" button is enabled$")
    public void iSelectButton(String buttonName) {
        assertTrue("AddToCartButton is disable",productDeatailsPage.getPickUpFragment().isButtonEnabled(buttonName));
    }

    @Then("^I see \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" on the right side of the pop up$")
    public void iSeeAndOnTheRightSideOfThePopUp(String locationName, String address, String city, String productName) {
        assertTrue("Content in productAvailabilityPopUp is incorrect",productDeatailsPage.isContentOnPageCorrect(locationName, address, city, productName));
    }

    @And("^I see price \"([^\"]*)\" and stockLevel \"([^\"]*)\"$")
    public void iSeePriceAndStockLevel(String price, String stockLevel) {
        assertTrue("Price or stockLevel are incorrect",productDeatailsPage.isContentOnPageCorrect(price, stockLevel));
    }

    @And("^I can't change product amount$")
    public void iCanTChangeProductAmount() {
        assertTrue("Out of stock product has amount buttons",productDeatailsPage.getPickUpFragment().iCanNotChangeProductAmount());
    }

    @And("^\"([^\"]*)\" button is not visible$")
    public void iCanTSelectButton(String buttonName) {
        assertTrue("Out of stock product has addToCartButton",productDeatailsPage.getPickUpFragment().iCanNotAddProductToCart());
    }

}
