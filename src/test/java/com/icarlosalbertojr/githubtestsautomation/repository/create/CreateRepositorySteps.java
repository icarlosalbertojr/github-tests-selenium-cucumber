package com.icarlosalbertojr.githubtestsautomation.repository.create;

import com.icarlosalbertojr.githubtestsautomation.login.LoginModel;
import com.icarlosalbertojr.githubtestsautomation.utils.GithubIntegration;
import com.icarlosalbertojr.githubtestsautomation.utils.GithubUrls;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.*;

public class CreateRepositorySteps {

    private GithubIntegration githubIntegration;
    private CreateRepositoryPage repositoryPage;
    private LoginModel loginModel;
    private final String REPOSITORY_NAME = "github-tests";

    @Before
    public void before() {
        githubIntegration = new GithubIntegration();
        repositoryPage = new CreateRepositoryPage();
    }

    @After
    public void after() {
        repositoryPage.close();
    }

    @Dado("que o usuário esteja logado")
    public void que_o_usuário_esteja_logado() {
        loginModel = repositoryPage.executeSignIn();
        assertEquals(GithubUrls.HOME, repositoryPage.getCurrentUrl());
    }

    @Dado("que o repositorio não exista")
    public void que_o_repositorio_não_exista() {
        boolean existsRepository = githubIntegration.existsRepository(loginModel, REPOSITORY_NAME);
        assertFalse(existsRepository);
    }

    @Quando("estiver na página de criação de repositório {string}")
    public void estiver_na_página_de_criação_de_repositório(String url) {
        repositoryPage.open(url);
        assertEquals(GithubUrls.NEW_REPOSITORY, repositoryPage.getCurrentUrl());
    }

    @Quando("inserir o nome do repositório no campo com a label {string}")
    public void inserir_o_nome_do_repositório_no_campo_com_a_label(String label) {
        repositoryPage.insertRepositoryName(REPOSITORY_NAME);
    }

    @Quando("clicar no botão para criar o repositório {string}")
    public void clicar_no_botão_para_criar_o_repositorio(String button) throws InterruptedException {
        repositoryPage.clickCreateRepository();
    }

    @Entao("o usuário deverá ir para a página de repositório onde a url termina com o nome do repositório criado")
    public void o_usuário_deverá_ir_para_a_página_de_repositório_onde_a_url_termina_com_o_nome_do_repositório_criado() {
        assertTrue(repositoryPage.isRepositoryPage(REPOSITORY_NAME));
    }
}
