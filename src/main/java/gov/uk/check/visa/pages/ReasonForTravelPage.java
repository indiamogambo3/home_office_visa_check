package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> selectReason;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;



    public void selectReasonForVisit(String reason) {

        Reporter.log("Select reason for visit." + reason + "from options" + selectReason.toString());
        CustomListeners.test.log(Status.PASS, "Select reason for visit." + reason);
        for (WebElement reasonForVisit : selectReason) {
            if (reasonForVisit.getText().equalsIgnoreCase(reason)) {
                clickOnElement(reasonForVisit);
                break;
            }
        }
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button." + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button.");
        clickOnElement(continueButton);
    }




}
