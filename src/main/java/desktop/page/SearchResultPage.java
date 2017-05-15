package desktop.page;

import abstractClasses.page.AbstractPage;
import desktop.fragment.SearchResultItemFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage extends AbstractPage {

    private By addToCartConfirmationPopUp = By.xpath("//div[@id='colorbox'][contains(@style, 'display: block;')]/div/div[2]/div[2]/div");
    private By productsLocator = By.xpath("//li[@class='product-item']");

    public SearchResultPage(){
        setUrl("/electronics/en/search");
        setTitle("Search");
    }

    public SearchResultItemFragment getSearchProductItemFragment(){
        return new SearchResultItemFragment($(productsLocator));
    }

//    create Main fragemnt for Product list
    public List<SearchResultItemFragment> getAllProductsFragment() {
        List<SearchResultItemFragment> list = new ArrayList<>();
        for(WebElement element: getDriver().findElements(productsLocator)) {
            list.add(new SearchResultItemFragment(element));
        }
        return list;
    }

    public SearchResultItemFragment findProductByText(String productName) {
        for (SearchResultItemFragment fragment: getAllProductsFragment()){
            if (fragment.getProductShortName().contains(productName))
                return fragment;
        }
        throw new IllegalArgumentException("Fragment "+ productName + "did not find!");
    }

    public void addProductByTextToBasket(String productName) {
        for (SearchResultItemFragment fragment: getAllProductsFragment()){
            if (fragment.getProductShortName().contains(productName))
                fragment.clickAddToBasket();
        }
        throw new IllegalArgumentException("Fragment "+ productName + "did not find!");
    }

    public List<SearchResultItemFragment> findProductsByText(String productName) {
        List<SearchResultItemFragment> elements = new ArrayList<>();
        for (SearchResultItemFragment fragment: getAllProductsFragment()) {
            if (fragment.getProductShortName().contains(productName))
                elements.add(fragment);
        }
        return elements;
    }


    public boolean isAddToCartConfirmationPopUpAppears() {
        sleep(1);
        if (!getDriver().findElement(addToCartConfirmationPopUp).isDisplayed()){
            return false;
        }
        return true;
    }
}
