package Verification;

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
public class DiffShippingBillingColor47612 extends TestBase {


    String testNumber = "47612";
    String typeOfTest = "Regression";
String typeOfCust = "NI"; String posR = "+"; String posL = "+";
    String typeOfPayment = "Credit";
    String searchAllBrand = "Color Toric";
    String searchAllBrand2 = "";
    String brandToClickOn = "FreshLookColorblendsToric";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "FreshLook Colorblends Toric";
    String brandVerifyPDP2 = "";
    String rPower = "0.00";
    String lPower = "0.00";
    String rPower2 = "";
    String lPower2 = "";
    String rBC = "";
    String lBC = "";
    String rBC2 = "";
    String lBC2 = "";
    String rDia = "";
    String lDia = "";
    String rDia2 = "";
    String lDia2 = "";
    String rColor = "BB";
    String lColor = "BB";
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
    String rAxis = "11";
    String rAxis2 = "";
    String lAxis = "11";
    String lAxis2 = "";
    String rBoxes = "4";
    String rBoxes2 = "";
    String lBoxes = "4";
    String lBoxes2 = "";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String ShippingCart = "n";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "79.99";
    String priceREye = "319.96";
    String priceLEye = "159.98";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "499.93";
    String rsTotal = "532.81";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "32.88";
    String rsRebate = "";
    String rsShipping = "19.99" ;
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "united states";
    String state = "utah";
    String city = "slc";
    String zip = "84121";
    String billingFName = "BillFirst";
    String billingLName = "BillLast";
    String billingCountry = "united states";
    String billingState = "california";
    String billingCity = "scotts valley";
    String billingZip = "95066";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "4012000077777777";
    String ccName = "Blah";
    String ccExpMo = "03";
    String ccExpYear = "2014";
    String shippingVerify = "Next";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "SearchBrand");
        clickPhoneBrand(device,brandToClickOn);
        takeScreenshot(screenshotTestName, "PDP1");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRCyl(rCyl);
        clickLCyl(lCyl);
        clickRAxis(rAxis);
        clickLAxis(lAxis);
        clickRColor(rColor);
        clickLColor(lColor);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
        clickAddToCart(device);
        selectShippingCart(ShippingCart);
        takeScreenshot(screenshotTestName, "Cart");
        verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
        clickCart_Continue(device);
        typeShippingName(shippingFName, shippingLName);
        clickCountry(country);
        typeShippingAddress();
        typeShippingCity(city);
        typeShippingState(country,state);
        typeShippingZip(zip);
        typeShippingEmail(emailPrefix,testNumber);
        typePassword_newcust(password);
        selectDiffBillingAddress(device);
        typeBillingName(billingFName, billingLName);
        clickBillingCountry(billingCountry);
        typeBillingAddress();
        typeBillingCity(billingCity);
        typeBillingState(device,billingState);
        typeBillingZip(billingZip);
        typeShippingPhone(device);
        takeScreenshot(screenshotTestName, "NewAddress");
        clickNewAddress_Continue();
        verifyAddressReq(device);
        selectSameBillingAddress(device);
        clickNewAddress_Continue();
        typeDoctorSearch(drName);
        typeDoctorStateAndFind(device,drState);
        takeScreenshot(screenshotTestName, "DoctorSearch");
        selectDoctor(device);
        typeCreditCard(device,creditCard);
        typeCreditCardName(device,ccName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        driver.quit();
    }
}
