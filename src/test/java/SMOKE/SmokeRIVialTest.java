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
public class SmokeRIVialTest extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "44046";
    String testNumberDependentOn = "44032";
    String typeOfTest = "SMOKE";
    String typeOfCust = "RI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "vial";
    String brandToClickOn = "SoftconEW";
    String brandVerifyPDP = "Softcon EW";
    String posR = "";
    String posL = "";
    String rPowerDesktop = "";
    String lPowerDesktop = "";
    String rBC = "8";
    String lBC = "8";
    String rDia = "1";
    String lDia = "1";
    String rBoxes = "1";
    String rBoxes2 = "3";
    String lBoxes = "1";
    String lBoxes2 = "2";
    String rAdd;
    String lAdd;
    String rCyl;
    String lCyl;
    String PatientFNameCart = "PatientFirst";
    String PatientLNameCart = "PatientLast";
    String ShippingCart = "nn";
    String pricePerBox = "59.99";
    String priceREye = "59.99";
    String priceLEye = "59.99";
    String priceTotal = "119.98";
    String rsTotal = "230.77";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "14.79";
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
    String shippingVerify = "Standard";
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
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
      typePatientName(PatientFNameCart, PatientLNameCart);
      takeScreenshot(screenshotTestName, "PDP2");
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
