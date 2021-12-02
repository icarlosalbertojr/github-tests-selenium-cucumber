package com.icarlosalbertojr.githubtestsautomation.login;

import com.icarlosalbertojr.githubtestsautomation.utils.GetLoginDataFromCSV;
import com.icarlosalbertojr.githubtestsautomation.utils.GithubUrls;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.*;

public class LoginSteps {

    private LoginPage loginPage;
    private LoginModel loginModel;

    public LoginSteps() {
        loginPage = new LoginPage();
        loginModel = GetLoginDataFromCSV.getData();
    }

    @Dado("que o usuário esteja na página de login")
    public void que_o_usuário_esteja_na_página_de_login() {
        loginPage.open(GithubUrls.LOGIN);
        assertEquals(GithubUrls.LOGIN,loginPage.getCurrentUrl());
    }
    @Dado("insira o e-mail no campo com a label {string}")
    public void insira_o_e_mail_no_campo_com_a_label(String label) {
        assertNotNull(loginModel.getEmail());
        String labelText = loginPage.getEmailLabelText();
        assertEquals(label,labelText);
        loginPage.insertEmail(loginModel.getEmail());
    }
    @Dado("insira um e-mail não cadastrado no campo com a label {string}")
    public void insira_um_e_mail_não_cadastrado_no_campo_com_a_label(String label) {
        assertNotNull(loginModel.getEmail());
        String labelText = loginPage.getEmailLabelText();
        assertEquals(label,labelText);
        loginPage.insertEmail(loginModel.getEmail() + "error");
    }
    @Dado("insira a senha no campo com a label {string}")
    public void insira_a_senha_no_campo_com_a_label(String label) {
        assertNotNull(loginModel.getPassword());
        String labelText = loginPage.getPasswordLabelText();
        assertEquals(label,labelText);
        loginPage.insertPassword(loginModel.getPassword());
    }
    @Quando("clicar no botão com o texto {string}")
    public void clicar_no_botão_com_o_texto(String button) {
        assertNotNull(button);
        loginPage.clickSignIn();
    }
    @Então("o usuário deverá ser redirecionado para a página principal {string}")
    public void o_usuário_deverá_ser_redirecionado_para_a_página_principal(String url) {
        assertEquals(url,loginPage.getCurrentUrl());
    }
    @Então("deverá aparecer a mensagem {string}")
    public void deverá_aparecer_a_mensagem(String message) {
        assertTrue(loginPage.existsInPage(message));
    }
    @After
    public void after() {
        loginPage.close();
    }
}
