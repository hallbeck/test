package SMOKE;

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
public class SmokeRIAcuvue2PlanoCanadaTest extends TestBase {

    String testNumber = "44052";
    String testNumberDependentOn = "44038";
    String typeOfTest = "SMOKE";
    String typeOfCust = "RI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "color";
    String searchAllBrand2 = "Astigmatism";
    String brandToClickOn = "FreshLookColorblendsToric";
    String brandToClickOn2 = "AcuvueOasysforAstigmatism";
    String brandVerifyPDP = "Acuvue 2 Colours";
    String brandVerifyPDP2 = "Acuvue Oasys for Astigmatism";
    String posR = ""; String posL = "";
    String rPower = "";
    String lPower = "-0.75";
    String rPower2 = "";
    String lPower2 = "";
    String rBC = "8";
    String lBC = "8";
    String rDia = "1";
    String lDia = "1";
    String rBoxes = "3";
    String rBoxes2 = "3";
    String lBoxes = "1";
    String lBoxes2 = "2";
    String rAdd = "2";
    String lAdd = "2";
    String rAxis = "11";
    String lAxis = "1";
    String rCyl = "--";
    String lCyl = "--";
    String rColor = "B";
    String lColor = "B";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String ShippingCart = "c";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "37.99";
    String priceREye = "113.97";
    String priceLEye = "37.99";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "151.96";
    String rsTotal = "151.96";
    String rsTotalAfterRebate = "151.96";
    String rsTax = "";
    String rsRebate = "";
    String rsShipping = "FREE" ;
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "united states";
    String state = "utah";
    String city = "slc";
    String zip = "84121";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "4012000077777777";
    String ccName = "Blah";
    String ccExpMo = "03";
    String ccExpYear = "2014";
    String shippingVerify = "Canada Standard";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        goToSignInPage(device);
        typeReturningPhoneEmail(testNumberDependentOn);
        typeReturningPhonePassword(device,password);
        clickSignIn(device);
        clickCartEdit(device);
        clickLPower(device,posL,lPower);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        takeScreenshot(screenshotTestName, "PDP1");
        clickUpdateCart(device);
        takeScreenshot(screenshotTestName, "Cart");
        verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
        clickCart_Continue(device);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        driver.quit();
    }
}
