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
public class SmokeRIMultiBrandPatientTest extends TestBase {
    String testNumber = "44055";
    String testNumberDependentOn = "44041";
    String typeOfTest = "SMOKE";
    String typeOfCust = "RI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "color";
    String searchAllBrand2 = "Toric";
    String brandToClickOn = "FreshLookColors";
    String brandToClickOn2 = "VertexToricXR";
    String brandVerifyPDP = "FreshLook Colors";
    String brandVerifyPDP2 = "Vertex Toric XR";
    String posR = "";
    String posL = "";
    String rPower = "";
    String lPower = "";
    String rPower2 = "";
    String lPower2 = "";
    String rBC = "8";
    String lBC = "8";
    String rDia = "1";
    String lDia = "1";
    String rBoxes = "5";
    String rBoxes2 = "3";
    String lBoxes = "2";
    String lBoxes2 = "2";
    String rAdd = "2";
    String lAdd = "2";
    String rCyl;
    String lCyl;
    String rColor = "G";
    String lColor = "B";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String ShippingCart = "s";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "49.99";
    String priceREye = "199.96";
    String priceLEye = "199.96";
    String pricePerBox2 = "49.99";
    String priceREye2 = "199.96";
    String priceLEye2 = "199.96";
    String priceTotal = "2,527.68";
    String rsTotal = "2,700.83";
    String rsTotalAfterRebate = "2,580.83";
    String rsTax = "173.15";
    String rsRebate = "60 FreshLook Rebate";
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
    String shippingVerify = "Expedited";
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
        checkReorderCheckboxTwo(device);
        clickCartEdit(device);
        clickRColor(rColor);
        clickLColor(lColor);
        takeScreenshot(screenshotTestName, "PDP1");
        clickUpdateCart(device);
        takeScreenshot(screenshotTestName, "Cart");
        verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
        clickCart_Continue(device);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox2, priceREye2, priceLEye2, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(testNumber,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        driver.quit();
    }
}
