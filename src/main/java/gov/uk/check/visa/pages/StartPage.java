package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage extends Utility {

    @CacheLookup
    @FindBy(partialLinkText = "Start n")
    WebElement startNowButton;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Accept additional cookies')]")
    WebElement acceptCookies;



public void clickOnStartNowButton() {
    Reporter.log("Click on start now button." + startNowButton.toString());
    CustomListeners.test.log(Status.PASS, "Click on 'Start now button.");
    clickOnElement(startNowButton);
}

    public void acceptAllCookies() {
        Reporter.log("Click on accept all cookies." + acceptCookies.toString());
        CustomListeners.test.log(Status.PASS, "Click on accept all cookies.");
        clickOnElement(acceptCookies);
    }







}
