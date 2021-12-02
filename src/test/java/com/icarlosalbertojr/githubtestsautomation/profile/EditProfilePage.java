package com.icarlosalbertojr.githubtestsautomation.profile;

import com.icarlosalbertojr.githubtestsautomation.PageObject;
import com.icarlosalbertojr.githubtestsautomation.login.LoginModel;
import com.icarlosalbertojr.githubtestsautomation.login.LoginPage;
import org.openqa.selenium.WebElement;

public class EditProfilePage extends PageObject {

    private LoginPage loginPage;

    public LoginModel executeSignIn() {
        loginPage = new LoginPage(browser);
        return loginPage.executeSignIn();
    }

    public void clickEditProfileButton(String button) {
        String xpath = "/html/body/div[6]/main/div[2]/div/div[1]/div/div[2]/div[3]/div[2]/div[2]/button";
        clickButton(xpath, button);
    }

    public void clickSaveButton(String button) {
        String xpath = "/html/body/div[6]/main/div[2]/div/div[1]/div/div[2]/div[3]/div[1]/form/div[7]/button[1]";
        clickButton(xpath, button);
    }

    private void clickButton(String xPath, String button) {
        WebElement saveButton = findByXPath(xPath);
        if (saveButton.getText().equals(button)) {
            saveButton.click();
        }
    }

    public void insertName(String name, String label) {
        String xpath = "/html/body/div[6]/main/div[2]/div/div[1]/div/div[2]/div[3]/div[1]/form/div[1]/label";
        insertField(xpath, name, label);
    }

    public void insertBio(String profileBio, String label) {
        String xpath = "/html/body/div[6]/main/div[2]/div/div[1]/div/div[2]/div[3]/div[1]/form/div[2]/label";
        insertField(xpath, profileBio, label);
    }

    private void insertField(String xpath, String value, String label) {
        WebElement labelElement = findByXPath(xpath);
        if (labelElement.getText().equals(label)) {
            String fieldId = labelElement.getAttribute("for");
            WebElement field = findById(fieldId);
            field.clear();
            field.sendKeys(value);
        }
    }

    public boolean validateProfileName(String profileName) {
        return findByXPath("/html/body/div[6]/main/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/h1/span[1]")
                .getText()
                .equals(profileName);
    }

    public boolean validateProfileBio(String profileBio) {
        return findByXPath("/html/body/div[6]/main/div[2]/div/div[1]/div/div[2]/div[3]/div[2]/div[1]/div")
                .getText()
                .equals(profileBio);
    }
}
