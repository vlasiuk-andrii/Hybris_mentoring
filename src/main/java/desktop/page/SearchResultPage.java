package desktop.page;

import abstractClasses.page.AbstractPage;
import desktop.fragment.SearchProductItemFragment;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage {
    public SearchResultPage(){
        setUrl("/electronics/en/search");
        setTitle("No Results | Electronics Site");
    }

    public List<SearchProductItemFragment> findProductsByText(String productName, int productsAmount) {
        List<SearchProductItemFragment> elements = new ArrayList<>();
        for (int i=0; i < productsAmount; i++){
            elements.add(
                    new SearchProductItemFragment(getDriver().findElement(By.xpath("//{contains(text(),'" + productName + "')}" + "[" + i + "]")))
                    //getDriver().findElement(By.xpath("//{contains(text(),'" + productName + "')}" + "[" + i + "]"))
            ); // TBD
        }
        return elements;
    }
}
