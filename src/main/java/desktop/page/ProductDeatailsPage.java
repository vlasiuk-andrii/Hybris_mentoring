package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static junit.framework.TestCase.assertTrue;

public class ProductDeatailsPage extends AbstractPage {
    public ProductDeatailsPage(){
        setUrl("/p");
        setTitle("");
    }

    private By addToCartButton = By.id("addToCartButton");

    public void check(String productName){
        assertTrue(title().contains(productName));
    }

    public void clickAddToCart(){
        $(addToCartButton).click();
        sleep(2);
    }


}
