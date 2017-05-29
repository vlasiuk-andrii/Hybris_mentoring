package desktop.fragment;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class PickUpFragment extends AbstractFragment{
    public PickUpFragment(WebElement element){
        setRootElement(element);
    }

    private By qtyValue = By.cssSelector("form#add_to_cart_storepickup_form input.js-qty-selector-input");
    private By qtyPlus = By.cssSelector("div#cboxContent span.glyphicon-plus");
    private By qtyMinus = By.cssSelector("div#cboxContent span.glyphicon-minus");
    private By addToCartButton = By.cssSelector("div#cboxContent button.btn.btn-primary.js-add-to-cart-for-pickup-popup");

    public boolean iCanChangeProductAmount() {
        return iCanIncreaseAmount() & iCanDecreaseAmount();
    }

    private boolean iCanDecreaseAmount() {
        int startValue = Integer.parseInt($(qtyValue).getValue());
        $(qtyMinus).click();
        return Integer.parseInt($(qtyValue).getValue()) == startValue - 1;
    }

    private boolean iCanIncreaseAmount() {
        int startValue = Integer.parseInt($(qtyValue).getValue());
        $(qtyPlus).click();
        return Integer.parseInt($(qtyValue).getValue()) == startValue + 1;
    }

    public boolean iCanNotChangeProductAmount() {
        return !$(qtyValue).isDisplayed() & !$(qtyPlus).isDisplayed() & !$(qtyMinus).isDisplayed();
    }

    public boolean iCanNotAddProductToCart() {
        return !$(addToCartButton).isDisplayed();
    }
}
