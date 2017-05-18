package desktop.page;

import abstractClasses.page.AbstractPage;
import desktop.fragment.SearchFragment;
import desktop.fragment.SearchResultItemFragment;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends AbstractPage {

    private By logo = By.xpath("//img[@title='hybris Accelerator']");
    private By signIn = By.cssSelector("li.liOffcanvas");
    private By searchField = By.cssSelector("input#js-site-search-input");
    private By navigationMenu = By.cssSelector("nav.main-navigation.js-enquire-offcanvas-navigation");
    private By productsLocator = By.xpath("//li[@class='product-item']");
    private By basketItemsAmount = By.cssSelector("div.mini-cart-count.js-mini-cart-count");

    private SearchResultItemFragment searchResultItemFragment = new SearchResultItemFragment($(productsLocator));
    private SearchFragment searchFragment = new SearchFragment($(searchField));

    public HomePage(){
        setUrl("/");
        setTitle("");
    }

    public void isLogoDisplayed(){
        Assert.assertTrue("Logo is not displayed", $(logo).isDisplayed());
    }

    public void isSignInDisplayed(){
        Assert.assertTrue("SignIn is not displayed", $(signIn).isDisplayed());
    }

    public void isSearchFieldDisplayed(){
        Assert.assertTrue("SearchField is not displayed", $(searchField).isDisplayed());
    }

    public void isNavigationMenuDisplayed(){
        Assert.assertTrue("NavigationMenu is not displayed",$(navigationMenu).isDisplayed());
    }

    public void isContentOnPageCorrect(){
        isLogoDisplayed();
        isSignInDisplayed();
        isSearchFieldDisplayed();
        isNavigationMenuDisplayed();
    }

    public SearchResultItemFragment getSearchResultItemFragment(){
        return searchResultItemFragment;
    }

    public SearchFragment getSearchFragment(){
        return searchFragment;
    }

    public boolean isBasketAmountCorrect(String amount) {
        if($(basketItemsAmount).getText().contains(amount)){
            return true;
        }
        return false;
    }
}
