package Regression.Links;

import Automation.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Links50356 extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "50356";
    String typeOfTest = "Regression";
    String typeOfCust = "NA";
    String typeOfPayment = "Credit";
    String searchAllBrand = "solution";
    String amaAssn = "DocAndRx/DocRx-Release-3.aspx";
    String amaLink = "American Medical Association";
    String amaTitle = "Opinion 8.06 - Prescribing and Dispensing Drugs and Devices"; //this is an H1 -- url is http://www.ama-assn.org/ama/pub/physician-resources/medical-ethics/code-medical-ethics/opinion806.page
    String ftcGov1 = "DocAndRx/DocRx-Charge.aspx";
    String ftcLink = "i1";
    String FTCTitle = "Complying with the Contact Lens Rule";
    String ftcGov2 = "DocAndRx/DocRx-Release.aspx";
    String ftcGov3 = "DocAndRx/DocRx-Release-1.aspx";
    String ftcGov4 = "DocAndRx/DocRx-release-2.aspx";
    String ftcGov5 = "DocAndRx/DocRx-Release-2.aspx";
    String ftcGov6 = "DocAndRx/DocRx-Release-3.aspx ";
    String jdPower = "ExternalRelations/CommunityAcc.aspx";
    String jdPowerLink = "jdpower.com";//
    //bad page is <h1>This page is in the shop</h1> not sure where this should go
    String jdTitle = "This page is in the shop";
    String affiliatesEmail = "Company/AffiliateRestrictedTerms";
    String affiliatesEmailLink = "dedicated Affiliate Manager"; //this is the text of the link that would be clicked on
    String affEmail = "affiliates@1800contacts.com";
    String pressReleases = "PressReleases";
    String pressRelEmailLink = "mgsullivan@utah.gov";
    String prEmail = "mgsullivan@utah.gov";
    String shippingVerify = "Expedited";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void LinksTest(String device) {
        openWebPage(device);
        printTestNumber(printTestName);
        gotoPage(amaAssn);
        clickAndVerifyLink(amaLink,amaTitle,"h1");
        takeScreenshot(screenshotTestName, "AMA");
        closeNewWindow();

        gotoPage(ftcGov1);
        clickAndVerifyName(ftcLink,FTCTitle,"h2");
        takeScreenshot(screenshotTestName, "FTC1");
        closeNewWindow();

        gotoPage(ftcGov2);
        clickAndVerifyName(ftcLink,FTCTitle,"h2");
        takeScreenshot(screenshotTestName, "FTC2");
        closeNewWindow();

        gotoPage(ftcGov3);
        clickAndVerifyName(ftcLink,FTCTitle,"h2");
        takeScreenshot(screenshotTestName, "FTC3");
        closeNewWindow();

        gotoPage(ftcGov4);
        clickAndVerifyName(ftcLink,FTCTitle,"h2");
        takeScreenshot(screenshotTestName, "FTC4");
        closeNewWindow();

        gotoPage(ftcGov5);
        clickAndVerifyName(ftcLink,FTCTitle,"h2");
        takeScreenshot(screenshotTestName, "FTC5");
        closeNewWindow();

        gotoPage(ftcGov6);
        clickAndVerifyName(ftcLink,FTCTitle,"h2");
        takeScreenshot(screenshotTestName, "FTC6");
        closeNewWindow();

        gotoPage(jdPower);
        clickAndVerifyLink(jdPowerLink,jdTitle,"h1");
        takeScreenshot(screenshotTestName, "JDPower");
        closeNewWindow();

        gotoPage(affiliatesEmail);
        clickAndVerifyEmail(affiliatesEmailLink,affEmail);

        gotoPage(pressReleases);
        clickAndVerifyEmail(pressRelEmailLink,prEmail);

        driver.quit();
    }
}
