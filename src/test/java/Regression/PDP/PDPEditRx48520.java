package Regression.PDP;

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
public class PDPEditRx48520 extends TestBase {


    String testNumber = "47802_rx";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "Acuvue ";
    String searchAllBrand2 = "";
    String brandToClickOn = "Acuvue";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "Acuvue";
    String brandVerifyPDP2 = "";
    String posR = "";
    String posL = "";
    String rPower = "-1.00";
    String lPower = "-0.75";
    String rPower2 = "";
    String lPower2 = "";
    String rAdd = "";
    String lAdd = "";
    String rBC = "8.4";
    String lBC = "8.4";
    String rBC2 = "";
    String lBC2 = "";
    String rDia = "14.0";
    String lDia = "14.0";
    String rDia2 = "";
    String lDia2 = "";
    String rColor = "";
    String lColor = "";
    String rColor2 = "";
    String lColor2 = "";
    String rCyl = "--";
    String lCyl = "--";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "";
    String rBCBad = "8.8";
    String rAxis2 = "";
    String lAxis = "";
    String lBCBad = "8.8";
    String lAxis2 = "";
    String rBoxes = "4";
    String rBoxes2 = "";
    String lBoxes = "4";
    String lBoxes2 = "";
    String PatientFNameCart = "PatientFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCartBad = "PatientFirst.,%";
    String PatientLNameCartBad = "Patient.,%Last";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String ShippingCart = "nn";
    String pricePerBox = "37.99";
    String priceREye = "75.98";
    String priceLEye = "227.94";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "328.91";
    String rsTotal = "349.73";
    String rsTotalAfterRebate = "329.73";
    String rsTax = "20.82";
    String rsRebate = "20 Icuity H2O Rebate";
    String rsShipping = "24.99" ;
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
    String shippingVerify = "Next Day by Noon";
    String seperator = "/";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify + seperator;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        takeScreenshot(screenshotTestName, "SearchBrand");
        gotoPage("lens/acuvue");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBCBad);
        clickLBC(lBCBad);
        clickRDia(rDia);
        clickLDia(lDia);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP1");
        clickAddToCart(device);
        takeScreenshot(screenshotTestName, "Cart1");
        clickEditRx(device);
        clickRBC(rBC);
        clickLBC(lBC);
        takeScreenshot(screenshotTestName, "PDP2");
        clickUpdateCart(device);
        verifyRXCart(device, rPower, lPower, rDia, lDia, rAxis, lAxis, rColor, lColor, rAdd, lAdd, rCyl, lCyl, rBC, lBC, rBoxes,lBoxes);
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
        typeShippingPhone(device);
        takeScreenshot(screenshotTestName, "NewAddress");
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
