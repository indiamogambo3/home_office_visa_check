package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {

    @CacheLookup
    @FindBy(tagName = "select")
    WebElement selectNationality;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;


    public void selectNationalityFromDropDown(String nationality) {
        Reporter.log("Select nationality." + nationality + "from drop down" + selectNationality.toString());
        CustomListeners.test.log(Status.PASS, "Select nationality from drop down." + nationality);
        selectByVisibleTextFromDropDown(selectNationality, nationality);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button." + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button.");
        clickOnElement(continueButton);
    }


}
