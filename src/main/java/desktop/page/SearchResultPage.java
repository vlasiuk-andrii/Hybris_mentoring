package desktop.page;

import abstractClasses.page.AbstractPage;
import desktop.fragment.SearchProductItemFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage {

    private By addToCartConfirmationPopUp = By.xpath("//div[@id='colorbox'][contains(@style, 'display: block;')]");
    private By productsLocator = By.cssSelector(By.xpath("//li[@class='product-item']");

    public SearchResultPage(){
        setUrl("/electronics/en/search");
        setTitle("Search");
    }

    public SearchProductItemFragment getSearchProductItemFragment(){
        return new SearchProductItemFragment();
    }

//    create Main fragemnt for Product list
    public List<SearchProductItemFragment> getAllProductsFragment() {
        List<SearchProductItemFragment> list = new ArrayList<>();
        for(WebElement element: getDriver().findElements(productsLocator)) {
            list.add(new SearchProductItemFragment(element));
        }
        return list;
    }

    public SearchProductItemFragment findProductByText(String productName) {
        for (SearchProductItemFragment fragment: getAllProductsFragment()){
            if (fragment.getProductShortName().contains(productName))
                return fragment.clickAddToBasket();
        }
        throw new IllegalArgumentException("Fragment "+ productName + "did not find!");
    }

    public List<SearchProductItemFragment> findProductsByText(String productName) {
        List<SearchProductItemFragment> elements = new ArrayList<>();
        for (SearchProductItemFragment fragment: getAllProductsFragment()) {
            if (fragment.getProductShortName().contains(productName))
                elements.add(fragment);
        }
        return elements;
    }


    public boolean isAddToCartConfirmationPopUpAppears() {
        if (!getDriver().findElement(addToCartConfirmationPopUp).isDisplayed()){
            return false;
        }
        return true;
    }
}
