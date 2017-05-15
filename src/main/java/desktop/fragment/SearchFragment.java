package desktop.fragment;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SearchFragment extends AbstractFragment {

    public SearchFragment(WebElement element){
        setRootElement(element);
    }

    private By searchField = By.cssSelector("input#js-site-search-input");

    private By searchButton = By.cssSelector("button.btn.btn-link>span.glyphicon.glyphicon-search");

    public void search(String searchText){
        getDriver().findElement(searchField).sendKeys(searchText);
        getDriver().findElement(searchButton).click();
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
