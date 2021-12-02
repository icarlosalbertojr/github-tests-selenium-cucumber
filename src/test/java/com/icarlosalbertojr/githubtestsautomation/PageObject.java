package com.icarlosalbertojr.githubtestsautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public abstract class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        init(browser);
    }

    public PageObject() {
        init(new ChromeDriver(incognitoMode()));
    }

    private void init(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        this.browser = browser;
        this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.browser.manage().window().maximize();
    }

    public void open(String url){
        browser.get(url);
    }

    public void navigate(String url){
        browser.navigate().to(url);
    }

    public void close() {
        this.browser.quit();
    }

    protected WebElement findByXPath(String xpath) {
        return this.browser.findElement(By.xpath(xpath));
    }

    protected WebElement findById(String id) {
        return this.browser.findElement(By.id(id));
    }

    public String getCurrentUrl() {
        return browser.getCurrentUrl();
    }

    public boolean existsInPage(String value) {
        return browser.getPageSource().contains(value);
    }

    private DesiredCapabilities incognitoMode() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;
    }
}
