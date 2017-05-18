package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutSummeryPage extends AbstractPage {
    public CheckoutSummeryPage(){
        setTitle("Checkout | Electronics Site");
        setUrl("/checkout/multi/summary/view");
    }

    private By subTotal = By.cssSelector("div.subtotal>span");
    private By total = By.cssSelector("div.totals>span");
    private By tax = By.cssSelector("div.tax>span");
    private By delivery = By.cssSelector("div.shipping>span");

    public boolean verifySummery(String subtotalPrice, String deliveryPrice, String taxPrice, String totalPrice) {
        if($(subTotal).getText().contains(subtotalPrice) &
                $(delivery).getText().contains(deliveryPrice) &
                $(tax).getText().contains(taxPrice) &
                $(total).getText().contains(totalPrice)){
            return true;
        } else {
            return false;
        }
    }
}
