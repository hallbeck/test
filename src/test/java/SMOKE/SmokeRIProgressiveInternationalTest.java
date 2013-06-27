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
public class SmokeRIProgressiveInternationalTest extends TestBase {
 String testNumber = "44049";
    String testNumberDependentOn = "44035";
    String typeOfTest = "SMOKE";
    String typeOfCust = "RI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "progressive";
    String brandToClickOn = "FocusDAILIESProgressives30pack";
    String brandVerifyPDP = "Focus DAILIES Progressives 30 pack";
    String posR = "";
    String posL = "";
    String rPower = "-0.50";
    String lPower = "-1.75";
    String rBC = "8";
    String lBC = "8";
    String rDia = "1";
    String lDia = "1";
    String rBoxes = "5";
    String rBoxes2 = "3";
    String lBoxes = "2";
    String lBoxes2 = "2";
    String rAdd;
    String lAdd;
    String rCyl;
    String lCyl;
    String PatientFNameCart = "PatFirstNew";
    String PatientLNameCart = "PatientLast";
    String ShippingCart = "e";
    String pricePerBox = "39.99";
    String priceREye = "199.95";
    String priceLEye = "799.80";
    String priceTotal = "1,019.74";
    String rsTotal = "230.77";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "";
    String rsRebate = "";
    String rsShipping = "19.99" ;
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
    String shippingVerify = "Int'l Standard";
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
      takeScreenshot(screenshotTestName, "PDP1");
      clickRPower(device,posR,rPower);
      clickLPower(device,posL,lPower);
      clickRboxes(rBoxes);
      clickLboxes(lBoxes);
      typePatientName(PatientFNameCart, PatientLNameCart);
      clickUpdateCart(device);
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
