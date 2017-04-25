package stepdefs;

import com.ServiceWD;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.fragment.SearchProductItemFragment;
import desktop.page.HomePage;
import desktop.page.SearchResultPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProductSearchResultSteps extends ServiceWD {

    private SearchResultPage searchResultPage;
    private HomePage homePage;

    private List<SearchProductItemFragment> searchResultCorrectProducts = new ArrayList<>();

    @Before
    public void setUp() {
        searchResultPage = new SearchResultPage();
        homePage = new HomePage();
        initWD();
    }

    @After
    public void tearDown(){
        getDriver().close();
        getDriver().quit();
    }

    @Given("I search for \"camileo\"")
    public void iSearchForCamileo(){
        homePage.getSearchProductItemFragment().search("camileo");
    }

    @Given("I am redirected to a Search page")
    public void iAmRedirectedToSearchPage(){
        searchResultPage.check();
    }

    @When("I find 2 products with name \"CAMILEO\"")
    public void iFind2ProductsWithNeededName(){
        searchResultCorrectProducts = searchResultPage.findProductsByText("Camileo", 2);
    }

    @Then("all product contains image, price, button \"Add to cart\"")
    public void productContainsContent(){
        for (SearchProductItemFragment productItemFragment : searchResultCorrectProducts) {
            assertTrue("ProductItemContent is incorrect",productItemFragment.isProductFragmentContentCorrect(productItemFragment));
        }
    }

    @When("click \"Add to cart\" button for product \"CAMILEO S10 EU\"")
    public void clickAddToCartForProduct(){
        for (SearchProductItemFragment productItemFragment : searchResultCorrectProducts) {
            productItemFragment.addToBasketProductByName("Camileo S10 EU");
        }
    }

    @Then("add to cart confirmation pop-up appears")
    public void addToCartPopUpAppears(){
        assertTrue("AddToCartPopUp didn't appear",searchResultPage.isAddToCartConfirmationPopUpAppears());
    }
}
