package com.icarlosalbertojr.githubtestsautomation.repository.delete;

import com.icarlosalbertojr.githubtestsautomation.PageObject;
import com.icarlosalbertojr.githubtestsautomation.login.LoginModel;
import com.icarlosalbertojr.githubtestsautomation.login.LoginPage;
import com.icarlosalbertojr.githubtestsautomation.utils.GithubUrls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DeleteRepositoryPage extends PageObject {

    private LoginPage loginPage;


    public LoginModel executeSignIn() {
        loginPage = new LoginPage(browser);
        return loginPage.executeSignIn();
    }


    public void clickDeleteButton(String button) {
        WebElement buttonElement = findByXPath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/summary");
        buttonElement.click();
    }

    public boolean isConfirmationModalOpen() {
        return findByXPath("/html/body/div[6]/div/main/div[2]/div/div/div[2]/div/div/div/div[10]/ul/li[4]/details/details-dialog")
                .isDisplayed();
    }

    public void insertDeleteConfirmationText(String formattedData) {
        findByXPath("/html/body/div[6]/div/main/div[2]/div/div/div[2]/div/div/div/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")
                .sendKeys(formattedData);
    }

    public void clickConfirmaionDeleteButton(String button) {
        WebElement buttonElement = findByXPath("/html/body/div[6]/div/main/div[2]/div/div/div[2]/div/div/div/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button");
        String textButton = findByXPath("/html/body/div[6]/div/main/div[2]/div/div/div[2]/div/div/div/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button/span[1]")
                .getText();
        if (textButton.equals(button) && buttonElement.isEnabled()) {
            buttonElement.click();
        }
    }

    public boolean isDeletedRepository(String username, String repositoryName) {
        return getCurrentUrl().equals(GithubUrls.HOME)
                && browser.getPageSource().contains("Your repository \"" + username + "/" + repositoryName + "\" was successfully deleted.");
    }
}
