package desktop.page;

import abstractClasses.page.AbstractPage;

import static junit.framework.TestCase.assertTrue;

public class ProductDeatailsPage extends AbstractPage {
    public ProductDeatailsPage(){
        setUrl("/p");
        setTitle("");
    }

    public void check(String productName){
        assertTrue(driver.getTitle().contains(productName));
    }
}
