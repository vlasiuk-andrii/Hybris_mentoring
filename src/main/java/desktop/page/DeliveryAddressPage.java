package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

public class DeliveryAddressPage extends AbstractPage {
    public DeliveryAddressPage(){
        setUrl("/checkout/multi/delivery-address/");
        setTitle("Checkout | Electronics Site");
    }

    private By countryDropDown = By.id("address.country");
    private By titleDropDown = By.id("address.title");
    private By firstNameInput = By.id("address.firstName");
    private By lastNameInput = By.id("address.surname");
    private By addressLineInput = By.id("address.line1");
    private By cityInput = By.id("address.townCity");
    private By stateDropDown = By.id("address.region");
    private By zipInput = By.id("address.postcode");
    private By nextButton = By.id("addressSubmit");
    private By subTotal = By.cssSelector("div.subtotal>span");
    private By total = By.cssSelector("div.totals>span");
    private By tax = By.cssSelector("div.tax>span");

    public void chooseCountry(String countryName){
        Select countryDropList = new Select($(countryDropDown));
        countryDropList.selectByVisibleText(countryName);
    }

    public void chooseTitle(String title){
        sleep(1);
        Select titleDropList = new Select($(titleDropDown));
        titleDropList.selectByVisibleText(title);
    }

    public void inputFirstName(String firstName){
        $(firstNameInput).sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        $(lastNameInput).sendKeys(lastName);
    }

    public void addAddress(String addressLine, String city, String state, String zip){
        $(addressLineInput).sendKeys(addressLine);
        $(cityInput).sendKeys(city);
        Select stateDropList = new Select($(stateDropDown));
        stateDropList.selectByVisibleText(state);
        $(zipInput).sendKeys(zip);
    }

    public void clickNextButton() {
        $(nextButton).click();
        sleep(1);
    }

    public boolean verifySummery(String subTotalPrice, String totalPrice, String taxPrice) {
        if($(subTotal).getText().contains(subTotalPrice) &
                $(total).getText().contains(totalPrice) &
                $(tax).getText().contains(taxPrice)){
            return true;
        }
        return false;
    }
}
