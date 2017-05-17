package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class WorldPayPage extends AbstractPage {
    public WorldPayPage() {
        setUrl("/checkout/multi/payment-method/");
        setTitle("Checkout | Electronics Site");
    }

    private By useMyDeliveryAddressLabel = By.cssSelector("label[for=useDeliveryAddress]");
    private By cardTypeDropDown = By.id("card_cardType");
    private By cardNumerInput = By.id("card_accountNumber");
    private By cardYearDropDown = By.id("ExpiryYear");
    private By cardMonthDropDown = By.id("ExpiryMonth");
    private By cvvInput = By.id("card_cvNumber");
    private By agreeWithTermsAndConditionsCombobox = By.id("Terms1");

    public void makeUseMyDeliveryAddressTrue() {
        //is true by default
    }

    public void enterCardDetails(String type, String number, String year, String month, String cvv) {
        Select cardTypeDropList = new Select(getDriver().findElement(cardTypeDropDown));
        Select cardMonthDropList = new Select(getDriver().findElement(cardMonthDropDown));
        Select cardYearDropList = new Select(getDriver().findElement(cardYearDropDown));

        cardTypeDropList.selectByVisibleText(type);
        getDriver().findElement(cardNumerInput).sendKeys(number);
        cardMonthDropList.selectByVisibleText(month);
        cardYearDropList.selectByVisibleText(year);
        getDriver().findElement(cvvInput).sendKeys(cvv);
    }

    public void agreeWithTermsAndConditions() {
        getDriver().findElement(agreeWithTermsAndConditionsCombobox).click();
    }
}
