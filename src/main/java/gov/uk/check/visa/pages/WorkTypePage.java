package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class WorkTypePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> selectTypesOfJob;


    public void selectJobTypes(String job) {
        Reporter.log("Select job type." + job + "from options" + selectTypesOfJob.toString());
        CustomListeners.test.log(Status.PASS, "Select job type." + job);
        for (WebElement jobType : selectTypesOfJob){
            if (jobType.getText().equalsIgnoreCase(job)) {
                clickOnElement(jobType);
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
