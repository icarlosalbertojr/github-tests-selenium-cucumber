package com.icarlosalbertojr.githubtestsautomation.repository.create;

import com.icarlosalbertojr.githubtestsautomation.PageObject;
import com.icarlosalbertojr.githubtestsautomation.login.LoginModel;
import com.icarlosalbertojr.githubtestsautomation.login.LoginPage;
import org.openqa.selenium.WebElement;

public class CreateRepositoryPage extends PageObject {

    private LoginPage loginPage;

    public LoginModel executeSignIn() {
        loginPage = new LoginPage(browser);
        return loginPage.executeSignIn();
    }
    public void insertRepositoryName(String repositoryName) {
        String repositoryNameFieldId = getRepositoryNameLabelElement().getAttribute("for");
        findById(repositoryNameFieldId).sendKeys(repositoryName);
    }

    private WebElement getRepositoryNameLabelElement() {
        return findByXPath("/html/body/div[6]/main/div/form/div[2]/auto-check/dl/dt/label");
    }

    public void clickCreateRepository() throws InterruptedException {
        Thread.sleep(500);
        findByXPath("/html/body/div[6]/main/div/form/div[4]/button").click();
    }

    public boolean isRepositoryPage(String repositoryName) {
        return browser.getCurrentUrl().endsWith(repositoryName);
    }
}
