package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends AbstractPage {
    public CartPage(){
        setUrl("/cart");
        setTitle("Your Shopping Cart | Electronics Site");
    }

    private By subTotal = By.cssSelector("div.col-xs-4.col-sm-3.col-md-2.col-lg-1");
    private By total = By.cssSelector("div.col-xs-4.col-sm-3.col-md-2.col-lg-1.grand-total");

    public boolean verifySummery(String subTotalPrice, String totalPrice) {
        if($(subTotal).getText().contains(subTotalPrice) & $(total).getText().contains(totalPrice)){
            return true;
        }
        return false;
    }
}
