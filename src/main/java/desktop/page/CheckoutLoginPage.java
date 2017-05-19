package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutLoginPage  extends AbstractPage {
    public CheckoutLoginPage(){
        setUrl("/login/checkout");
        setTitle("Proceed to Checkout | Electronics Site");
    }

    private By emailInput = By.id("guest.email");
    private By emailConfirmationInput = By.id("guest.confirm.email");
    private By checkoutAsGuestButton = By.cssSelector("button.btn.btn-default.btn-block.guestCheckoutBtn");

    public void inputEmail(String email) {
        $(emailInput).sendKeys(email);
    }

    public void inputConfirmationEmail(String email) {
        $(emailConfirmationInput).sendKeys(email);
    }

    public void proceedAsGuest() {
        $(emailInput).click();
        $(checkoutAsGuestButton).click();
        waitForJStoComplete();
    }
}
