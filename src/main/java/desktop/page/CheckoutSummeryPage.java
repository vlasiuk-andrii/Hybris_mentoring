package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;

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
        if(getDriver().findElement(subTotal).getText().contains(subtotalPrice) &
                getDriver().findElement(delivery).getText().contains(deliveryPrice) &
                getDriver().findElement(tax).getText().contains(taxPrice) &
                getDriver().findElement(total).getText().contains(totalPrice)){
            return true;
        } else {
            return false;
        }
    }
}
