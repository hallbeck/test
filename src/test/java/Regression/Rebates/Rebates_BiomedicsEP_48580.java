package Regression.Rebates;

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
public class Rebates_BiomedicsEP_48580 extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "48580";
    String typeOfTest = "Regression";
    String typeOfCust = "NA";
    String typeOfPayment = "Rebates";   
    //LENS//
    String BiomedicsEP="lens/biomedics-ep";
    String rebatesAvailable = "Rebate expected--save $20 on 8";
    String rebate6Month = "20.0";
    String rebate12Month = "";
    String posR = "";
    String posL = "+";
    String rPower = "-0.50";
    String lPower = "2.25";
    String rBC = "";
    String lBC = "";
    String rBC2 = "";
    String lBC2 = "";
    String rDia = "";
    String lDia = "";
    String rDia2 = "";
    String lDia2 = "";
    String rColor = "";
    String lColor = "";
    String rColor2 = "";
    String lColor2 = "";
    String rAdd;
    String lAdd;
    String rAdd2;
    String lAdd2;
    String rCyl = "-";
    String lCyl = "-";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "";
    String rAxis2 = "";
    String lAxis = "";
    String lAxis2 = "";
    String rBoxes = "4";
    String rBoxes2 = "";
    String lBoxes = "4";
    String lBoxes2 = "";
    String PatientFNameCart = "PatientFirst";
    String PatientLNameCart = "PatientLast";
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "BOLIVIA";
    String state = "Newberry";
    String city = "whatever";
    String zip = "K1A 0G9";
    String emailPrefix = "test";
    String password = "password";

    String shippingVerify = "Title tag";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust  + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + typeOfPayment + "_" + shippingVerify;



    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void titleTagTest(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(BiomedicsEP);
        print(rebatesAvailable);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP1_");
        clickAddToCart(device);
        verifyRebateCart(device,rebate6Month);
        clickCart_Continue(device);
        typeShippingName(shippingFName,shippingLName);
        clickCountry(country);
        typeShippingAddress();
        typeShippingCity(city);
        typeShippingState(country,state);
        typeShippingZip(zip);
        typeShippingPhone(device);
        typeShippingEmail(emailPrefix,testNumber);
        typePassword_newcust(password);
        takeScreenshot(screenshotTestName, "NewAddress");
        clickNewAddress_Continue();
        verifyRebateRS(device,rebate6Month);

        driver.quit();
    }
}
