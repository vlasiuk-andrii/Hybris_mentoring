package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import desktop.page.*;

public class DesktopCheckoutGuestUserSteps {
    private HomePage homePage = new HomePage();
    private ProductDeatailsPage productDeatailsPage = new ProductDeatailsPage();
    private CartPage cartPage = new CartPage();
    private CheckoutLoginPage checkoutLoginPage = new CheckoutLoginPage();
    private DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage();

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
}
