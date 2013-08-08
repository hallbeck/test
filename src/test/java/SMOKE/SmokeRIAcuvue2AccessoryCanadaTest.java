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
public class SmokeRIAcuvue2AccessoryCanadaTest extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "48933";
    String testNumberDependentOn = "48932";
    String typeOfTest = "SMOKE";
    String typeOfCust = "RI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "acuvue";
    String searchAllBrand2 = "Astigmatism";
    String brandToClickOn = "FreshLookColorblendsToric";
    String brandToClickOn2 = "AcuvueOasysforAstigmatism";
    String brandVerifyPDP = "Acuvue 2";
    String brandVerifyPDP2 = "Acuvue Oasys for Astigmatism";
    String posR = "+"; String posL = "+";
    String posR2 = ""; String posL2 = "";
    String rPower = "0.25";
    String lPower = "0.75";
    String rPower2 = "-0.25";
    String lPower2 = "-0.75";
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
    String pricePerBox = "20.99";
    String priceREye = "83.96";
    String priceLEye = "83.96";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "167.92";
    String rsTotal = "167.92";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "";
    String rsRebate = "20 Acuvue Rebate";
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
    String creditCard = "prod";
    String ccName = "Blah";
    String ccExpMo = "";
    String ccExpYear = "";
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
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
        takeScreenshot(screenshotTestName, "Cart");
        verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
        clickCart_Continue(device);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(testNumber,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        driver.quit();
    }
}