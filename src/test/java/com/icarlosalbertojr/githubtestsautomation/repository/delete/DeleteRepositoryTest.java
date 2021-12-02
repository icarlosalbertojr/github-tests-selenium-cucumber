package com.icarlosalbertojr.githubtestsautomation.repository.delete;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/scenarios/DeleteRepository.feature",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/reports/repository/delete/html/report.html",
                "json:target/reports/repository/delete/json/report.json"
        })
public class DeleteRepositoryTest {



}
