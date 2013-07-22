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
public class SmokeRI1EyeAsphericPlusColorTest extends TestBase {

    String testNumber = "44053";
    String testNumberDependentOn = "44039";
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
    String rPower = "0.25";
    String lPower = "0.75";
    String rPower2 = "0.25";
    String lPower2 = "0.75";
    String rBC = "8";
    String lBC = "8";
    String rDia = "1";
    String lDia = "1";
    String rBoxes = "1";
    String rBoxes2 = "3";
    String lBoxes = "3";
    String lBoxes2 = "2";
    String rAdd = "2";
    String lAdd = "2";
    String rAxis = "11";
    String lAxis = "1";
    String rCyl = "--";
    String lCyl = "--";
    String rColor = "A";
    String lColor = "B";
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
        typeReturningPhonePassword(device,password);
        clickSignIn(device);
        takeScreenshot(screenshotTestName, "Cart1");
        verifyCart(device,brandVerifyPDP2,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
        clickAddRxRI(device);
        searchAllBrand(device,searchAllBrand);
        clickPhoneBrand(device,brandToClickOn);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRColor(rColor);
        clickLColor(lColor);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart2, PatientLNameCart2);
        takeScreenshot(screenshotTestName, "PDP");
        clickAddToCart(device);
        takeScreenshot(screenshotTestName, "Cart2");
        clickCart_Continue(device);
        selectDoctor(device);
        typeCreditCard(device,creditCard);
        typeCreditCardName(device,ccName);
        pickCreditCardExpDate(device,ccExpMoBad,ccExpYearBad);;
        takeScreenshot(screenshotTestName, "ReviewSubmit1");
        clickBottomSubmitButton(device);
        takeScreenshot(screenshotTestName, "ExpCard");
        verifyExpiredCard(device);
        typeCreditCard(device,creditCard);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear);
        takeScreenshot(screenshotTestName, "ReviewSubmit2");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(testNumber,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        driver.quit();
    }
}
