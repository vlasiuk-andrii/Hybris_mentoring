package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertTrue;

public class ProductDeatailsPage extends AbstractPage {
    public ProductDeatailsPage(){
        setUrl("/p");
        setTitle("");
    }

    private By addToCartButton = By.id("addToCartButton");

    public void check(String productName){
        assertTrue(driver.getTitle().contains(productName));
    }

    public void clickAddToCart(){
        getDriver().findElement(addToCartButton).click();
        sleep(2);
    }


}
