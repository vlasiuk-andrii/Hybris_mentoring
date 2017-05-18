package abstractClasses.page;

import com.ServiceWD;
import org.openqa.selenium.By;

import static appendice.CommonConstants.BROWSER_PATH_CHROME;
import static appendice.CommonConstants.ROOT_URL;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AbstractPage extends ServiceWD {
    protected String title;
    protected String url;

    public void visit(){
        System.setProperty("webdriver.chrome.driver", BROWSER_PATH_CHROME);
        System.setProperty("selenide.browser", "Chrome");
        open(ROOT_URL + url);
    }

    public void visit(String requestText){
        //getDriver().get(ROOT_URL + url + requestText);
        open(ROOT_URL + url + requestText);
    }

    public void check(){
        url().contains(url);
        title().contains(title);
    }

    protected void setTitle(String title){
        this.title = title;
    }

    protected void setUrl(String url){
        this.url = url;
    }

    public void clickOnButtonByText(String buttonName){
        $(By.xpath("//*[contains(text(),'" + buttonName + "')]")).click();
        sleep(2);
    }


}
