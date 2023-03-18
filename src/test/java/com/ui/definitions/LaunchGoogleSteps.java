package com.ui.definitions;

import com.ui.pages.LaunchGooglePage;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.jbehave.core.annotations.*;

public class LaunchGoogleSteps extends PageObject {

    @Steps
    LaunchGooglePage launchGooglePage;

    @Given("user has launched $url_type url")
    public void launchGoogleUrl(@Named("$url_type") String url_type){
        launchGooglePage.launchUrlInChrome(url_type);
    }

    @When("user validates the page title")
    public void validatePageTitle(){
        launchGooglePage.verifyPageTitle();
    }

    @Then("user validates the search in google")
    public void validateGoogleSearch() {
        launchGooglePage.searchInGoogle();
    }
}
