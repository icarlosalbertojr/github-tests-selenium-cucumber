package com.icarlosalbertojr.githubtestsautomation.login;

import com.icarlosalbertojr.githubtestsautomation.PageObject;
import com.icarlosalbertojr.githubtestsautomation.utils.GetLoginDataFromCSV;
import com.icarlosalbertojr.githubtestsautomation.utils.GithubUrls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailLabelText() {
        return getEmailLabelElement().getText();
    }
    public String getPasswordLabelText() {
        return getPasswordLabelElement().getText();
    }
    public void insertEmail(String email) {
        String emailFieldId = getEmailLabelElement().getAttribute("for");
        findById(emailFieldId).sendKeys(email);
    }
    public void insertPassword(String password) {
        String passwordFieldId = getPasswordLabelElement().getAttribute("for");
        findById(passwordFieldId).sendKeys(password);
    }

    public LoginModel executeSignIn() {
        open(GithubUrls.LOGIN);
        LoginModel data = GetLoginDataFromCSV.getData();
        insertEmail(data.getEmail());
        insertPassword(data.getPassword());
        clickSignIn();
        return data;
    }

    public void clickSignIn() {
        findByXPath("/html/body/div[3]/main/div/div[4]/form/div/input[12]").click();
    }
    private WebElement getEmailLabelElement() {
        return findByXPath("/html/body/div[3]/main/div/div[4]/form/label");
    }
    private WebElement getPasswordLabelElement() {
        return findByXPath("/html/body/div[3]/main/div/div[4]/form/div/label");
    }

}
