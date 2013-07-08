package Regression.PDP;

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
public class PDPToolTips_45370 extends TestBase {


    String testNumber = "45370";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String toolTip1Xpath = "HeaderSelectBrandLink";
    String toolTip1Text = "Select Contact Lens Brand";
    String page = "lens";
    String seperator = "/";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + toolTip1Text;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + toolTip1Text + "_" + seperator;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        verifyToolTip(device,toolTip1Xpath,toolTip1Text);
        driver.quit();
    }
}
