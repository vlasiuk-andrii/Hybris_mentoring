package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.page.*;

import static com.ServiceWD.sleep;
import static junit.framework.TestCase.assertTrue;

public class DesktopCheckoutGuestUserSteps {
    private HomePage homePage = new HomePage();
    private ProductDeatailsPage productDeatailsPage = new ProductDeatailsPage();
    private CartPage cartPage = new CartPage();
    private CheckoutLoginPage checkoutLoginPage = new CheckoutLoginPage();
    private DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage();
    private DeliveryMethodPage deliveryMethodPage = new DeliveryMethodPage();
    private WorldPayPage worldPayPage = new WorldPayPage();
    private ConfirmationPage confirmationPage = new ConfirmationPage();

    @Given("^I select \"Add to cart\" for product \"([^\"]*)\"$")
    public void iSelectAddToCartForProduct(String productId){
        productDeatailsPage.visit("/" + productId);
        productDeatailsPage.clickAddToCart();
    }

    @And("^I select \"([^\"]*)\" in cart pop-up$")
    public void iSelectCheckoutInCartPopUp(String buttonName){
        productDeatailsPage.clickOnButtonByText(buttonName);
    }

    @And("^I am redirected to the cart page$")
    public void iAmRedirectedToTheCartPage(){
        cartPage.check();
    }

    @And("^I can view order summary$")
    public void iCanViewOrderSummary(DataTable table){
//        List<List<String>> asList = table.raw();
//        Map<String, String> asMap = new HashMap();
//        for(List<String> row : asList) {
//            System.out.println(row);
//        }
    }

    @And("^I click \"([^\"]*)\" button after redirect to cart page$")
    public void iClickButtonAfterRedirectToCartPage(String buttonName) {
        cartPage.clickOnButtonByText(buttonName);
    }

    @And("^I set \"([^\"]*)\" as e-mail address$")
    public void iSetEMailAddress(String email) {
        checkoutLoginPage.inputEmail(email);
        checkoutLoginPage.inputConfirmationEmail(email);
    }

    @And("^I proceed to checkout as a Guest user$")
    public void iProceedToCheckoutAsAGuestUser(){
        checkoutLoginPage.proceedAsGuest();
    }

    @And("^I am redirected to multicheckout delivery address page$")
    public void iAmRedirectedToMulticheckoutDeliveryAddressPage() {
        deliveryAddressPage.check();
    }

    @And("^I have the following final review$")
    public void iHaveTheFollowingFinalReview() {
        //tbd
    }

    @And("^I fill in delivery address information$")
    public void iFillInDeliveryAddressInformation() {
        deliveryAddressPage.chooseCountry("United States");
        deliveryAddressPage.chooseTitle("Mr.");
        deliveryAddressPage.inputFirstName("John");
        deliveryAddressPage.inputLastName("Doe");
        deliveryAddressPage.addAddress("16 Sandy Palace", "Honesdale", "Pennsylvania", "18431-0000");
    }

    @When("^I press \"Next\" button on delivery address page$")
    public void iPressButtonOnDeliveryAddressPage(){
        deliveryAddressPage.clickNextButton();
    }

    @And("^I am redirected to multicheckout delivery method page$")
    public void iAmRedirectedToMulticheckoutDeliveryMethodPage() {
        deliveryMethodPage.check();
    }

    @And("^I have the final review$")
    public void iHaveTheFinalReview() {
        //tbd
    }

    @And("^I select \"([^\"]*)\" delivery method$")
    public void iSelectDeliveryMethod(String shipmentMethod){
        deliveryMethodPage.chooseShipmentMethod(shipmentMethod);
    }

    @And("^I press \"Next\" button on delivery method page$")
    public void iPressNextButtonOnDeliveryMethodPage(){
        deliveryMethodPage.clickOnNextButton();
    }

    @And("^I am redirected to multicheckout payment method page$")
    public void iAmRedirectedToMulticheckoutPaymentMethodPage(){
        worldPayPage.check();
    }

    @And("^I select to use my delivery address$")
    public void iSelectToUseMyDeliveryAddress() {
        worldPayPage.makeUseMyDeliveryAddressTrue();
    }

    @And("^I agree with terms and conditions$")
    public void iAgreeWithTermsAndConditions(){
        worldPayPage.agreeWithTermsAndConditions();
    }

    @And("^I press \"Next\" button on payment method page$")
    public void iPressNextButtonOnPaymentMethodPage() {

    }

    @And("^I enter test card data$")
    public void iEnterTestCardData(DataTable cardTable) {
        worldPayPage.enterCardDetails("4111111111111111", "2019","03","123");
        worldPayPage.clickOnButtonByText("Next");
        }

    @And("^I click Make payment button$")
    public void iClickMakePaymentButton(){
        worldPayPage.clickOnButtonByText("Place Order");
        sleep(5);
    }

    @Then("^I am redirected to checkout confirmation page$")
    public void iAmRedirectedToCheckoutConfirmationPage() {
        confirmationPage.check();
    }

    @And("^checkout message is \"([^\"]*)\"$")
    public void checkoutMessageIs(String message){
        assertTrue("Success order message is incorrect",confirmationPage.successMessageIsShown(message));
    }

    @And("^I can obtain an order number$")
    public void iCanObtainAnOrderNumber() {
        assertTrue("Order number is not displayed", confirmationPage.orderNumberIsShown());
    }

    @And("^I press \"([^\"]*)\" button on checkout confirmation page$")
    public void iPressButtonOnCheckoutConfirmationPage(String buttonText){
        confirmationPage.clickOnButtonByText(buttonText);
    }

    @And("^I am redirected to the home page$")
    public void iAmRedirectedToTheHomePage() {
        homePage.check();
    }
}
