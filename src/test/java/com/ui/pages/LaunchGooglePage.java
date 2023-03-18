package com.ui.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class LaunchGooglePage extends PageObject {

    String googleUrl = "https://www.google.com/";
    String facebookUrl = "https://www.facebook.com/";
    String instagramUrl = "https://www.instagram.com/";

    @FindBy(xpath = "//textarea[@name='q']")
    WebElementFacade searchTextBox;

    public void launchUrlInChrome(String url_type){
        if(url_type.equals("google")){
            getDriver().get(googleUrl);
        }
        else if(url_type.equals("Instagram")){
            getDriver().get(instagramUrl);
        }
        else{
            getDriver().get(facebookUrl);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(50000));
    }
    public void verifyPageTitle(){
        System.out.println("INFO!!: Page Title : "+ getDriver().getTitle());

    }

    public void searchInGoogle(){
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(60000));
        searchTextBox.waitUntilVisible().waitUntilClickable().click();
        searchTextBox.sendKeys("Healenium Automation");
        searchTextBox.sendKeys(Keys.ENTER);
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000));
    }
}
