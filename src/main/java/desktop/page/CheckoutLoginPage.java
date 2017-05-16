package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;

public class CheckoutLoginPage  extends AbstractPage {
    public CheckoutLoginPage(){
        setUrl("/login/checkout");
        setTitle("Proceed to Checkout | Electronics Site");
    }

    private By emailInput = By.id("guest.email");
    private By emailConfirmationInput = By.id("guest.confirm.email");
    private By checkoutAsGuestButton = By.cssSelector("button.btn.btn-default.btn-block.guestCheckoutBtn");

    public void inputEmail(String email) {
        getDriver().findElement(emailInput).sendKeys(email);
    }

    public void inputConfirmationEmail(String email) {
        getDriver().findElement(emailConfirmationInput).sendKeys(email);
    }

    public void proceedAsGuest() {
        getDriver().findElement(emailInput).click();
        getDriver().findElement(checkoutAsGuestButton).click();
        sleep(1);
    }
}
