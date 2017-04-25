package desktop.fragment;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SearchProductItemFragment extends AbstractFragment {

    public SearchProductItemFragment(WebElement element){
        setRootElement(element);
    }
//move to search fragment
    private By searchField = By.cssSelector("input#js-site-search-input");

    //move to search fragment
    private By searchButton = By.cssSelector("button.btn.btn-link>span.glyphicon.glyphicon-search");

    private By productImage = By.cssSelector("a.thumb>img");

    private By productPrice = By.cssSelector("div.price-panel>div>div.price");

    private By productName = By.cssSelector(".name");

    private By addToBasketButton = By.xpath("//button[contains(text(),'Add to cart')]");

    //move to search fragment
    public void search(String searchText){
        getDriver().findElement(searchField).sendKeys(searchText);
        getDriver().findElement(searchButton).click();
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    private boolean isImageDisplayed(){
        if (!getDriver().findElement(productImage).isDisplayed()){
            return false;
        }
        return true;
    }

    private boolean isPriceDisplayed(){
        if (!getDriver().findElement(productPrice).isDisplayed()){
            return false;
        }
        return true;
    }

    private boolean isAddToBasketButtonDisplayed(){
        if (!getDriver().findElement(addToBasketButton).isDisplayed()){
            return false;
        }
        return true;
    }

    public String getProductShortName() {
        return getChildElement(productName).getText().trim();
    }

    public boolean isProductFragmentContentCorrect(SearchProductItemFragment product){
        return  product.isImageDisplayed() && product.isPriceDisplayed() && product.isAddToBasketButtonDisplayed();
    }

//    move to srearchpage
    public void addToBasketProductByName(String productName) {
        getDriver().findElement(By.xpath("//input[@value='" + productName + "']/..//button[contains(text(),'Add to cart')]"));
    }
}
