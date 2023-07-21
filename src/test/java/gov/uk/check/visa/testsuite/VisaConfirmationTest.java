package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class VisaConfirmationTest extends BaseTest {

    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    DurationOfStayPage durationOfStayPage;
    WorkTypePage workTypePage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;

    @BeforeMethod
    public void inIt() {

        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        durationOfStayPage = new DurationOfStayPage();
        workTypePage = new WorkTypePage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void anAustralianComingToUKForTourism() {

        //Accept cookies
        startPage.acceptAllCookies();
        // Click on start now button
        startPage.clickOnStartNowButton();
        // Select a Nationality 'Australia'
        selectNationalityPage.selectNationalityFromDropDown("Australia");
        // Click on Continue button
        selectNationalityPage.clickOnContinueButton();
        // Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");
        // Click on Continue button
        reasonForTravelPage.clickOnContinueButton();
        // Verify result 'You will not need a visa to come to the UK'
        Assert.assertEquals(resultPage.getResultMessageTourism(), "You will not need a visa to come to the UK", "Unable to verify message");
    }

    @Test(groups = {"smoke", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() throws InterruptedException {

        //Accept cookies
        startPage.acceptAllCookies();
        // Click on start button
        startPage.clickOnStartNowButton();
        // Select a Nationality 'Chile'
        selectNationalityPage.selectNationalityFromDropDown("Chile");
        // Click on Continue button
        selectNationalityPage.clickOnContinueButton();
        // Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        // Click on Continue button
        reasonForTravelPage.clickOnContinueButton();
        // Select intended to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        // Click on Continue button
        durationOfStayPage.clickOnContinueButton();
        // Select have planning to work for 'Health and care professional'
        workTypePage.selectJobTypes("Health and care professional");
        // Click on Continue button
        workTypePage.clickOnContinueButton();
        //Verify result 'You need a visa to work in health and care'
        Assert.assertEquals(resultPage.getResultMessageHealthCare(), "You need a visa to work in health and care", "Unable to verify message");
    }

    @Test(groups = {"regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {

        //Accept cookies
        startPage.acceptAllCookies();
        // Click on start button
        startPage.clickOnStartNowButton();
        // Select a Nationality 'Colombia'
        selectNationalityPage.selectNationalityFromDropDown("Colombia");
        // Click on Continue button
        selectNationalityPage.clickOnContinueButton();
        // Select reason 'Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        // Click on Continue button
        reasonForTravelPage.clickOnContinueButton();
        // Select state My partner of family member have uk immigration status 'yes'
        // Click on Continue button
        // Verify result 'You’ll need a visa to join your family or partner in the UK'
        Assert.assertEquals(resultPage.getResultMessageFamily(), "You may need a visa", "Unable to verify message");
    }

}
