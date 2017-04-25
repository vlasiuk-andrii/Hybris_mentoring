package desktop.page;

import abstractClasses.page.AbstractPage;
import desktop.fragment.SearchProductItemFragment;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage {

    private By addToCartConfirmationPopUp = By.xpath("//div[@id='colorbox'][contains(@style, 'block')]");

    public SearchResultPage(){
        setUrl("/electronics/en/search");
        setTitle("No Results | Electronics Site");
    }

    public SearchProductItemFragment getSearchProductItemFragment(){
        return new SearchProductItemFragment();
    }

    public List<SearchProductItemFragment> findProductsByText(String productName, int productsAmount) {
        List<SearchProductItemFragment> elements = new ArrayList<>();
        for (int i=0; i < productsAmount; i++){
            elements.add(
                    new SearchProductItemFragment(getDriver().findElement(By.xpath("//a[contains(text(),'" + productName + "')]" + "[" + i + "]/../../..")))
            );
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
