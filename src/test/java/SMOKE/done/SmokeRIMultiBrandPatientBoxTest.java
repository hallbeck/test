package SMOKE.done;

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
public class SmokeRIMultiBrandPatientBoxTest extends TestBase {

    String testNumber = "44056";
    String testNumberDependentOn = "44042";
    String typeOfTest = "SMOKE";
    String typeOfCust = "RI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "multifocal";
    String brandToClickOn = "PureVisionMulti-Focal";
    String brandVerifyPDP = "FreshLook Colors";
    String posR = "";
    String posL = "";
    String rPower = "";
    String lPower = "";
    String rBC = "8";
    String lBC = "8";
    String rDia = "1";
    String lDia = "1";
    String rBoxes = "1";
    String rBoxes2 = "3";
    String lBoxes = "1";
    String lBoxes2 = "2";
    String rAdd = "2";
    String lAdd = "2";
    String rCyl;
    String lCyl;
    String PatientFNameCart = "FirstPaFirst";
    String PatientLNameCart = "FirstPaLast";
    String ShippingCart = "s";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "49.99";
    String priceREye = "49.99";
    String priceLEye = "49.99";
    String priceTotal = "963.90";
    String rsTotal = "1,029.93";
    String rsTotalAfterRebate = "1,029.93";
    String rsTax = "66.03";
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
    String creditCard = "test";
    String ccName = "Blah";
    String ccExpMo = "";
    String ccExpYear = "";
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
    String shippingVerify = "Standard";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;


  @Test(singleThreaded = true)
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
      checkReorderCheckboxTwo(device);
      clickCartEdit(device);
      clickRboxes(rBoxes);
      clickLboxes(lBoxes);
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
