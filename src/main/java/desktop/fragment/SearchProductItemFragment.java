package desktop.fragment;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SearchProductItemFragment extends AbstractFragment {

    public SearchProductItemFragment(){}

    public SearchProductItemFragment(WebElement element){
        setRootElement(element);
    }

    private By searchField = By.cssSelector("input#js-site-search-input");

    private By searchButton = By.cssSelector("span.glyphicon.glyphicon-search");

    public void search(String searchText){
        getDriver().findElement(searchField).sendKeys(searchText);
        getDriver().findElement(searchButton).click();
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
