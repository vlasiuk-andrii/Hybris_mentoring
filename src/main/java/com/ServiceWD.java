package com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static appendice.CommonConstants.BROWSER_PATH_CHROME;

public class ServiceWD {
    protected static WebDriver driver;

    public ServiceWD(){
        //PageFactory.initElements(driver, this);
    }

    public static WebDriver initWD(){
        System.setProperty("webdriver.chrome.driver", BROWSER_PATH_CHROME);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        return driver = new ChromeDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void waitForJStoComplete(){
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
