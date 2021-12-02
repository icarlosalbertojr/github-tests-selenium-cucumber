package com.icarlosalbertojr.githubtestsautomation.profile;

import com.icarlosalbertojr.githubtestsautomation.login.LoginModel;
import com.icarlosalbertojr.githubtestsautomation.utils.GithubUrls;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EditProfileSteps {

    private static final String PROFILE_NAME = "Carlos Alberto";
    public static final String PROFILE_BIO = "Test Bio";

    private EditProfilePage editProfilePage;
    private LoginModel loginModel;

    @Before
    public void before() {
        editProfilePage = new EditProfilePage();
    }

    @After
    public void after() {
        editProfilePage.close();
    }

    @Dado("que o usuário esteja logado")
    public void que_o_usuário_esteja_logado() {
        loginModel = editProfilePage.executeSignIn();
        assertEquals(GithubUrls.HOME, editProfilePage.getCurrentUrl());
    }

    @Dado("na página do perfil")
    public void na_página_do_perfil() {
        String profileUrl = UriComponentsBuilder.fromHttpUrl(GithubUrls.PROFILE)
                .buildAndExpand(loginModel.getUsername()).toString();
        editProfilePage.navigate(profileUrl);
        assertEquals(profileUrl, editProfilePage.getCurrentUrl());
    }
    @Quando("o usuário clicar no botão com o texto {string}")
    public void o_usuário_clicar_no_botão_com_o_texto(String button) {
        editProfilePage.clickEditProfileButton(button);
    }

    @Quando("inserir o nome no campo com a label {string}")
    public void inserir_o_nome_no_campo_com_a_label(String label) {
        editProfilePage.insertName(PROFILE_NAME, label);
    }

    @Quando("clicar no botão com o texto {string}")
    public void clicar_no_botão_com_o_texto(String button) {
        editProfilePage.clickSaveButton(button);
    }

    @Quando("inserir a bio no campo com a label {string}")
    public void inserir_a_bio_no_campo_com_a_label(String label) {
        editProfilePage.insertBio(PROFILE_BIO, label);
    }

    @Então("o nome do perfil deverá ser alterado com sucesso")
    public void o_nome_do_perfil_deverá_ser_alterado_com_sucesso() throws InterruptedException {
        Thread.sleep(500);
        assertTrue(editProfilePage.validateProfileName(PROFILE_NAME));
    }

    @Então("a bio do perfil deverá ser alterado com sucesso")
    public void a_bio_do_perfil_deverá_ser_alterado_com_sucesso() throws InterruptedException {
        Thread.sleep(500);
        assertTrue(editProfilePage.validateProfileBio(PROFILE_BIO));
    }

}
