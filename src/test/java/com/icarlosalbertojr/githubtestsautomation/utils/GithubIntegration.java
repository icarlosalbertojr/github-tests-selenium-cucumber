package com.icarlosalbertojr.githubtestsautomation.utils;

import com.icarlosalbertojr.githubtestsautomation.login.LoginModel;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GithubIntegration {

    public boolean existsRepository(LoginModel loginModel , String repositoryName) {
        String url = UriComponentsBuilder
                .fromHttpUrl(GithubUrls.API_REPOSITORIES)
                .buildAndExpand(loginModel.getUsername()).toString();
        RestTemplate client = new RestTemplate();
        return client.getForObject(url, String.class)
                .contains(repositoryName);
    }

}
