package Business.done;

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
public class NI_Business_Test_49947 extends TestBase {


    //change the Strings below to change the tests
    String testNumber = "49947";
    String typeOfTest = "BUSINESS";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "Acuvue Moist 90";
    String searchAllBrand2 = "";
    String brandToClickOn = "1-DayAcuvueMoist90pack";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "1-Day Acuvue Moist 90 pack";
    String brandVerifyPDP2 = "";
    String posR = "+";
    String posL = "";
    String rPower2 = "";
    String lPower2 = "";
    String rPower = "0.75";
    String lPower = "-0.75";
    String rBC = "8.5";
    String lBC = "8.5";
    String rBC2 = "";
    String lBC2 = "";
    String rDia = "";
    String lDia = "";
    String rDia2 = "";
    String lDia2 = "";
    String rColor = "";
    String lColor = "";
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
    String rAxis = "";
    String rAxis2 = "";
    String lAxis = "";
    String lAxis2 = "";
    String rBoxes = "8";
    String rBoxes2 = "";
    String lBoxes = "8";
    String lBoxes2 = "";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
    String ShippingCart = "s";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "39.99";
    String priceREye = "119.97";
    String priceLEye = "119.97";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "199.95";
    String rsTotal = "213.65";
    String rsTotalAfterRebate = "193.65";
    String rsTax = "13.70";
    String rsRebate = "100 Acuvue Rebate";
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
    String ccExpMo = "";
    String ccExpYear = "";
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
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "PDP1");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
        clickAddToCart(device);
        takeScreenshot(screenshotTestName, "Cart");
        verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
        clickCart_Continue(device);
        typeShippingName(shippingFName, shippingLName);
        clickCountry(country);
        typeShippingAddress();
        typeShippingCity(city);
        typeShippingState(country,state);
        typeShippingZip(zip);
        typeShippingPhone(device);
        typeShippingEmail(emailPrefix,testNumber);
        typePassword_newcust(password);
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
        verifyThankYouPage(testNumber,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        gotoMyAccount(device);
        takeScreenshot(screenshotTestName, "Dashboard");
        verifyDashboard(device,brandVerifyPDP,fullPatientName);
        gotoOrderStatusHistory(device);
        verifyOrderStatusHistory(device,brandVerifyPDP,fullPatientName,rsShipping,shippingVerify,zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate,orderStatus);
        takeScreenshot(screenshotTestName, "OrderStatusHistory");
        driver.quit();
    }
}
