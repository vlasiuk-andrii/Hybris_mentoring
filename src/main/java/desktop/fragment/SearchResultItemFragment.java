package desktop.fragment;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemFragment extends AbstractFragment {

    public SearchResultItemFragment(WebElement element){
        setRootElement(element);
    }

    private By productImage = By.cssSelector("a.thumb>img");

    private By productPrice = By.cssSelector("div.price-panel>div>div.price");

    private By productName = By.cssSelector(".name");

    private By addToBasketButton = By.xpath("//button[contains(text(),'Add to cart')]");

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

    public boolean isProductFragmentContentCorrect(SearchResultItemFragment product){
        return  product.isImageDisplayed() && product.isPriceDisplayed() && product.isAddToBasketButtonDisplayed();
    }

//    move to srearchpage
    public void addToBasketProductByName(String productName) {
        getDriver().findElement(By.xpath("//input[@value='" + productName + "']/..//button[contains(text(),'Add to cart')]")).click();
    }

    public void clickAddToBasket() {
        getDriver().findElement(addToBasketButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnProduct(String productName) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
    }
}
