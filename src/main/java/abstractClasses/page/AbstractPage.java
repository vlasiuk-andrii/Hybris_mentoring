package abstractClasses.page;

import com.ServiceWD;
import org.openqa.selenium.By;

import static appendice.CommonConstants.ROOT_URL;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static junit.framework.TestCase.assertTrue;

public class AbstractPage extends ServiceWD {
    protected String title;
    protected String url;

    public void visit(){
//        System.setProperty("webdriver.chrome.driver", BROWSER_PATH_CHROME);
//        System.setProperty("selenide.browser", "Chrome");

//        FirefoxProfile geoDisabled = new FirefoxProfile();
//        geoDisabled.setPreference("geo.enabled", false);
//        geoDisabled.setPreference("geo.provider.use_corelocation", false);
//        geoDisabled.setPreference("geo.prompt.testing", false);
//        geoDisabled.setPreference("geo.prompt.testing.allow", false);
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
//        driver = new FirefoxDriver(geoDisabled);
        open(ROOT_URL + url);
    }

    public void visit(String requestText){
        open(ROOT_URL + url + requestText);
    }

    public void check(){
        assertTrue("URL is incorrect",url().contains(url));
        assertTrue("Title is incorrect",title().contains(title));
    }

    protected void setTitle(String title){
        this.title = title;
    }

    protected void setUrl(String url){
        this.url = url;
    }

    public void clickOnButtonByText(String buttonName){
        $(By.xpath("//*[contains(text(),'" + buttonName + "')]")).click();
        waitForJStoComplete();
    }

    public boolean isContentOnPageCorrect(String... args){
        for (String arg : args){
            $(By.xpath("//*[contains(text(),'" + arg + "')]"));
        }
        return true;
    }

}
