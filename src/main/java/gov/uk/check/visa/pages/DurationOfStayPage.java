package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;
    @CacheLookup
    @FindBy(id = "response-0")
    WebElement lessThanSixMonths;
    @CacheLookup
    @FindBy(id = "response-1")
    WebElement moreThanSixMonths;

    public void selectLengthOfStay(String moreOrLess) {
        Reporter.log("Select length of stay." + moreOrLess + "from radio options");
        CustomListeners.test.log(Status.PASS, "Select length of stay." + moreOrLess);
        switch (moreOrLess) {
            case "6 months or less":
                clickOnElement(lessThanSixMonths);
                break;
            case "longer than 6 months":
                clickOnElement(moreThanSixMonths);
                break;
            default:
                break;
        }
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button." + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button.");
        clickOnElement(continueButton);
    }

}
