package userinter;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    private Browser browser;
    private WebDriver driver;
//
//    @BeforeMethod
//    public void beforeTest() throws MalformedURLException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("browserVersion", Configuration.getChromeVersionForGrid());
//        chromeOptions.setCapability("platformName", Configuration.getPlatformNameForGrid());
//        driver = new RemoteWebDriver(new URL(Configuration.getUrlForGrid()), chromeOptions);
//        driver.manage().window().maximize();
//        driver.get(Configuration.getUrl());
//    }
//
//    @AfterMethod
//    public void afterTest() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @BeforeMethod
    public void beforeTest() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(Configuration.getUrl());
        browser.waitForPageToLoad();
    }

    @AfterMethod
    public void afterTest() {
        if (browser != null) {
            browser.quit();
        }
    }
}
