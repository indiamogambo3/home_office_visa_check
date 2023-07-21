package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ResultPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You will not need a visa to come to the UK')]")
    WebElement verifyResultTourism;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You need a visa to work in health and care')]")
    WebElement verifyResultHealthCare;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You may need a visa')]")
    WebElement verifyResultFamily;


    public String getResultMessageTourism() {
        Reporter.log("Get result message." + verifyResultTourism.toString());
        CustomListeners.test.log(Status.PASS, "Get result message.");
        return getTextFromElement(verifyResultTourism);
    }
    public String getResultMessageHealthCare() {
        Reporter.log("Get result message." + verifyResultHealthCare.toString());
        CustomListeners.test.log(Status.PASS, "Get result message.");
        return getTextFromElement(verifyResultHealthCare);
    }
    public String getResultMessageFamily() {
        Reporter.log("Get result message." + verifyResultFamily.toString());
        CustomListeners.test.log(Status.PASS, "Get result message.");
        return getTextFromElement(verifyResultFamily);
    }


}
