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
public class SmokeRIColorPlanoDeclinedCardTest extends TestBase {

    String testNumber = "44051";
    String testNumberDependentOn = "44037";
    String typeOfTest = "SMOKE";
    String typeOfCust = "RI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "Biofinity";
    String searchAllBrand2 = "Biofinity";
    String brandToClickOn = "Biofinity";
    String brandToClickOn2 = "AcuvueOasysforAstigmatism";
    String brandVerifyPDP = "Acuvue 2 Colours";
    String brandVerifyPDP2 = "Acuvue Oasys for Astigmatism";
    String posR = "+";
    String posL = "";
    String rPower = "0.25";
    String lPower = "-0.75";
    String rPower2 = "";
    String lPower2 = "";
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
    String rColor = "B";
    String lColor = "B";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatTwoLast";
    String ShippingCart = "n";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "37.99";
    String priceREye = "151.96";
    String priceLEye = "151.96";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "503.88";
    String rsTotal = "538.40";
    String rsTotalAfterRebate = "463.40";
    String rsTax = "34.52";
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
    String creditCard = "4012000077777777";
    String ccName = "Blah";
    String ccExpMo = "03";
    String ccExpYear = "2014";
    String creditCardBad = "4111111111111111";
    String ccExpMoBad = "01";
    String ccExpYearBad = "2013";
        String rebateNotShipped = "Your order has not shipped yet.";
    String shippingVerify = "Expedited";
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
        clickAddRxRI(device);
        clickPhoneBrand(device,brandToClickOn);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart2, PatientLNameCart2);
        takeScreenshot(screenshotTestName, "PDP1");
        clickAddToCart(device);
        verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
        clickCart_Continue(device);
        takeScreenshot(screenshotTestName, "Cart");
        selectDoctor(device);
        takeScreenshot(screenshotTestName, "ReviewSubmit1");
        typeCreditCard(device,creditCardBad);
        typeCreditCardName(device,ccName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear);
        clickBottomSubmitButton(device);
        takeScreenshot(screenshotTestName, "DeclinedCard");
        verifyDeclinedCard(device);
        goToCart(device);
        clickCart_Continue(device);
        typeCreditCard(device,creditCard);
        typeCreditCardName(device,ccName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear);
        takeScreenshot(screenshotTestName, "ReviewSubmit2");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(testNumber,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        driver.quit();
  }
}