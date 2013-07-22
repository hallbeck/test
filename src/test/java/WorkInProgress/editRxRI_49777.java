package WorkInProgress;

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
public class editRxRI_49777 extends TestBase {

    String testNumber = "49777";
    String testNumberDependentOn = "49773";
    String typeOfTest = "SMOKE";
    String typeOfCust = "RI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "color";
    String searchAllBrand2 = "Astigmatism";
    String brandToClickOn = "FreshLookColorblends";
    String brandToClickOn2 = "AcuvueOasysforAstigmatism";
    String brandVerifyPDP = "FreshLook Colorblends";
    String brandVerifyPDP2 = "Acuvue Oasys for Astigmatism";
    String posR = "+";
    String posL = "+";
    String rPower = "0.75";
    String lPower = "1.25";
    String rPower2 = "";
    String lPower2 = "";
    String rBC = "";
    String lBC = "";
    String rDia = "";
    String lDia = "";
    String rBoxes = "";
    String rBoxes2 = "";
    String lBoxes = "";
    String lBoxes2 = "";
    String rAdd = "";
    String lAdd = "";
    String rAxis = "11";
    String lAxis = "1";
    String rCyl = "--";
    String lCyl = "-";
    String rColor = "";
    String lColor = "";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "SecondPFirst";
    String PatientLNameCart2 = "SecondPLast";
    String ShippingCart = "c";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "47.99";
    String priceREye = "48.99";
    String priceLEye = "191.96";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "387.92";
    String rsTotal = "414.49";
    String rsTotalAfterRebate = "364.49";
    String rsTax = "26.57";
    String rsRebate = "25 Acuvue Rebate";
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
    String ccExpMoBad = "02";
    String ccExpYearBad = "2013";
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
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
        typeReturningPhonePassword(device, password);
        clickSignIn(device);
        takeScreenshot(screenshotTestName, "Cart1");
        verifyCart(device, brandVerifyPDP2, PatientFNameCart + " " + PatientLNameCart, pricePerBox, priceREye, priceLEye, priceTotal);
        cartRemove(device);
        gotoMyAccount(device);
        editRxDashboard(device);
        clickRPower(device, posR, rPower);
        clickRCyl(rCyl);
        clickRAxis(rAxis);
        clickLPower(device, posL, lPower);
        clickLCyl(lCyl);
        clickLAxis(lAxis);
        takeScreenshot(screenshotTestName, "PDP");
        clickUpdateCart(device);
        takeScreenshot(screenshotTestName, "Cart2");
        clickCart_Continue(device);
        takeScreenshot(screenshotTestName, "ReviewSubmit1");
        verifyRS(device, brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(testNumber,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        driver.quit();
    }
}
