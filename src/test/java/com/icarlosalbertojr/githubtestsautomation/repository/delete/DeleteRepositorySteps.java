package com.icarlosalbertojr.githubtestsautomation.repository.delete;

import com.icarlosalbertojr.githubtestsautomation.login.LoginModel;
import com.icarlosalbertojr.githubtestsautomation.utils.GithubIntegration;
import com.icarlosalbertojr.githubtestsautomation.utils.GithubUrls;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class DeleteRepositorySteps {

    private GithubIntegration githubIntegration;
    private DeleteRepositoryPage deleteRepositoryPage;
    private LoginModel loginModel;
    private final String REPOSITORY_NAME = "github-tests";

    @Before
    public void before() {
        githubIntegration = new GithubIntegration();
        deleteRepositoryPage = new DeleteRepositoryPage();
    }

    @After
    public void after() {
        deleteRepositoryPage.close();
    }

    @Dado("que o usuário esteja logado")
    public void que_o_usuário_esteja_logado() {
        loginModel = deleteRepositoryPage.executeSignIn();
        assertEquals(GithubUrls.HOME, deleteRepositoryPage.getCurrentUrl());
    }

    @Dado("que o repositório exista")
    public void que_o_repositório_exista() {
        boolean existsRepository = githubIntegration.existsRepository(loginModel, REPOSITORY_NAME);
        assertTrue(existsRepository);
    }

    @Quando("o usuário estiver na página de configurações")
    public void o_usuário_estiver_na_página_de_configurações() {
        String configurationUrl = UriComponentsBuilder
                .fromHttpUrl(GithubUrls.CONFIGURATIONS)
                .buildAndExpand(loginModel.getUsername(), REPOSITORY_NAME)
                .toString();
        deleteRepositoryPage.navigate(configurationUrl);
        assertEquals(configurationUrl, deleteRepositoryPage.getCurrentUrl());
    }

    @Quando("clicar no botao {string} para abrir o modal")
    public void clicar_no_botao_para_abrir_o_modal(String button) {
        deleteRepositoryPage.clickDeleteButton(button);
        assertTrue(deleteRepositoryPage.isConfirmationModalOpen());
    }

    @Quando("inserir o texto no formato usuario\\/repositorio no campo do modal de confirmação")
    public void inserir_o_texto_no_formato_usuario_repositorio_no_campo_do_modal_de_confirmação() {
        String formattedData = String.format("%s/%s", loginModel.getUsername(), REPOSITORY_NAME);
        deleteRepositoryPage.insertDeleteConfirmationText(formattedData);
    }

    @Quando("clicar no botao {string}")
    public void clicar_no_botao(String button) {
        deleteRepositoryPage.clickConfirmaionDeleteButton(button);
    }

    @Então("o repositório deverá ser apagado com sucesso")
    public void o_repositório_deverá_ser_apagado_com_sucesso() {
        boolean isDeletedRepository = deleteRepositoryPage.isDeletedRepository(loginModel.getUsername(), REPOSITORY_NAME);
        assertTrue(isDeletedRepository);
    }

}
