package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage extends AbstractPage {
    public ConfirmationPage() {
        setTitle("Order Confirmation | Electronics Site");
        setUrl("/checkout/orderConfirmation/");
    }

    private By successMessage = By.className("checkout-success-body-headline");
    private By orderNumber = By.cssSelector("div.checkout-success-body>p");

    public boolean successMessageIsShown(String message) {
        if (!$(successMessage).getText().contains(message)){
            return false;
        } else {
            return true;
        }

    }

    public boolean orderNumberIsShown() {
        if (!$(orderNumber).getText().contains("Order Number is")){
            return false;
        } else {
            return true;
        }
    }
}
