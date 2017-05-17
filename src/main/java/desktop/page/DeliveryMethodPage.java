package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DeliveryMethodPage extends AbstractPage {
    public DeliveryMethodPage(){
        setUrl("/checkout/multi/delivery-method/");
        setTitle("Checkout | Electronics Site");
    }

    private By shipmentMethodDropDown = By.id("delivery_method");
    private By deliveryMethodNextButton = By.id("deliveryMethodSubmit");
    private By subTotal = By.cssSelector("div.subtotal>span");
    private By total = By.cssSelector("div.totals>span");
    private By tax = By.cssSelector("div.tax>span");
    private By delivery = By.cssSelector("div.shipping>span");

    public void chooseShipmentMethod(String shipmentMethod) {
        Select shipmentMethodDropList = new Select(getDriver().findElement(shipmentMethodDropDown));
        shipmentMethodDropList.selectByIndex(0);
//        shipmentMethodDropList.selectByVisibleText(shipmentMethod);
    }

    public void clickOnNextButton() {
        getDriver().findElement(deliveryMethodNextButton).click();
    }

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
