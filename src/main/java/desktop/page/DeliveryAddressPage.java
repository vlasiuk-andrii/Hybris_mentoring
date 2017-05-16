package desktop.page;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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

    public void chooseCountry(String countryName){
        Select countryDropList = new Select(getDriver().findElement(countryDropDown));
        countryDropList.selectByVisibleText(countryName);
    }

    public void chooseTitle(String title){
        sleep(1);
        Select titleDropList = new Select(getDriver().findElement(titleDropDown));
        titleDropList.selectByVisibleText(title);
    }

    public void inputFirstName(String firstName){
        getDriver().findElement(firstNameInput).sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        getDriver().findElement(lastNameInput).sendKeys(lastName);
    }

    public void addAddress(String addressLine, String city, String state, String zip){
        getDriver().findElement(addressLineInput).sendKeys(addressLine);
        getDriver().findElement(cityInput).sendKeys(city);
        Select stateDropList = new Select(getDriver().findElement(stateDropDown));
        stateDropList.selectByVisibleText(state);
        getDriver().findElement(zipInput).sendKeys(zip);
    }

    public void clickNextButton() {
        getDriver().findElement(nextButton).click();
        sleep(1);
    }
}
