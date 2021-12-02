package com.icarlosalbertojr.githubtestsautomation.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/scenarios/Login.feature",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/reports/login/html/report.html",
                "json:target/reports/login/json/report.json"
        })
public class LoginTest {
}
