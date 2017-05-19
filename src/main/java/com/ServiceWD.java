package com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ServiceWD {
    protected static WebDriver driver = getWebDriver();

//    public static WebDriver initWD(){
//        System.setProperty("webdriver.chrome.driver", BROWSER_PATH_CHROME);
//        System.setProperty("webdriver.chrome.silentOutput", "true");
//        return driver = new ChromeDriver();
//    }

    public static void waitForJStoComplete(){
        new WebDriverWait(getWebDriver(), 30).until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
