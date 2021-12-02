package com.icarlosalbertojr.githubtestsautomation.profile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/scenarios/EditProfile.feature",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/reports/profile/edit/html/report.html",
                "json:target/reports/profile/edit/json/report.json"
        })
public class EditProfileTest {
}
