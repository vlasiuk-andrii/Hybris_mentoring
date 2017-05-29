package desktop.page;

import abstractClasses.page.AbstractPage;
import desktop.fragment.PickUpFragment;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static junit.framework.TestCase.assertTrue;

public class ProductDeatailsPage extends AbstractPage {

    private By availabilityPopUp = By.id("cboxContent");
    private By locationLabel = By.cssSelector("label.js-select-store-label");

    private PickUpFragment pickUpFragment = new PickUpFragment($(availabilityPopUp));

    public ProductDeatailsPage(){
        setUrl("/p");
        setTitle("");
    }

    private By addToCartButton = By.id("addToCartButton");

    public void check(String productName){
        assertTrue(title().contains(productName));
    }

    public PickUpFragment getPickUpFragment(){
        return pickUpFragment;
    }

    public void clickAddToCart(){
        $(addToCartButton).click();
        waitForJStoComplete();
    }


    public boolean productAvailabilityPopUpAppears() {
        if (pickUpFragment.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean productAvailabilityPopUpHasData() {
        sleep(5);
        if($(locationLabel).isDisplayed()){
            return true;
        }
        return false;
    }

    public void clickOnLocation(String locationName) {
        $(By.xpath("//span[contains(text(),'" + locationName + "')]")).click();
        waitForJStoComplete();
    }
}
