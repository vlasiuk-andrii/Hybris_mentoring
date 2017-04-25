package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static appendice.CommonConstants.BROWSER_PATH_CHROME;

public class ServiceWD {
    protected static WebDriver driver;

    public ServiceWD(){
        PageFactory.initElements(driver, this);
    }

    public static WebDriver initWD(){
        System.setProperty("webdriver.chrome.driver", BROWSER_PATH_CHROME);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        return driver = new ChromeDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
