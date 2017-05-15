package stepdefs;

import com.ServiceWD;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.fragment.SearchResultItemFragment;
import desktop.page.HomePage;
import desktop.page.ProductDeatailsPage;
import desktop.page.SearchResultPage;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductSearchResultSteps extends ServiceWD {

    private SearchResultPage searchResultPage = new SearchResultPage();
    private HomePage homePage = new HomePage();
    private ProductDeatailsPage productDeatailsPage = new ProductDeatailsPage();

    private List<SearchResultItemFragment> searchResultCorrectProducts = new ArrayList<>();

    @Before
    public void setUp() {
        initWD();
    }

    @After
    public void tearDown(){
        getDriver().close();
        getDriver().quit();
    }

    @Given("I search for \"camileo\"")
    public void iSearchForCamileo(){
        homePage.getSearchFragment().search("camileo");
    }

    @Given("I am redirected to a Search page")
    public void iAmRedirectedToSearchPage(){
        searchResultPage.check();
    }

    @When("I find \"(.*?)\" products with name \"(.*?)\"")
    public void iFind2ProductsWithNeededName(int quantity, String producName){
        assertEquals(searchResultPage.findProductsByText(producName).size(), quantity);

    }

    @Then("all product contains image, price, button \"Add to cart\"")
    public void productContainsContent(){
        for (SearchResultItemFragment productItemFragment : searchResultCorrectProducts) {
            assertTrue("ProductItemContent is incorrect",productItemFragment.isProductFragmentContentCorrect(productItemFragment));
        }
    }

    @When("click \"Add to cart\" button for product \"(.*?)\"")
    public void clickAddToCartForProduct(String productName){
        searchResultCorrectProducts.addAll(searchResultPage.getAllProductsFragment());
        for (SearchResultItemFragment productItemFragment : searchResultCorrectProducts) {
            productItemFragment.addToBasketProductByName(productName);
        }
    }

    @Then("add to cart confirmation pop-up appears")
    public void addToCartPopUpAppears(){
        assertTrue("AddToCartPopUp didn't appear",searchResultPage.isAddToCartConfirmationPopUpAppears());
    }

    @When("click on product \"(.*?)\" on search result page")
    public void clickOnProductOnSearchResultPage(String productName) {
        searchResultCorrectProducts.addAll(searchResultPage.getAllProductsFragment());
        for (SearchResultItemFragment productItemFragment : searchResultCorrectProducts) {
            try {
                productItemFragment.clickOnProduct(productName);
            } catch (NoSuchElementException e){}
        }
    }

    @Then("I am redirected on product details page")
    public void iAmRedirectedOnProductDetailsPage() {
        productDeatailsPage.check("Camileo S10 EU");
    }
}
