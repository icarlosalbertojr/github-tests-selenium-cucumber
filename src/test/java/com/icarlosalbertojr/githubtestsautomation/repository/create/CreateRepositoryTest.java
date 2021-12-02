package com.icarlosalbertojr.githubtestsautomation.repository.create;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/scenarios/CreateRepository.feature",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/reports/repository/create/html/report.html",
                "json:target/reports/repository/create/json/report.json"
        })
public class CreateRepositoryTest {

}
