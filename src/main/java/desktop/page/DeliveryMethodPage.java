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

    public void chooseShipmentMethod(String shipmentMethod) {
        Select shipmentMethodDropList = new Select(getDriver().findElement(shipmentMethodDropDown));
        shipmentMethodDropList.selectByIndex(0);
//        shipmentMethodDropList.selectByVisibleText(shipmentMethod);
    }

    public void clickOnNextButton() {
        getDriver().findElement(deliveryMethodNextButton).click();
    }
}
