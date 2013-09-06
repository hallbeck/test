package Business.done;

import Automation.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class NI_Business_Test_49962 extends TestBase {


    //change the Strings below to change the tests
    String testNumber = "49962";
    String typeOfTest = "BUSINESS";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "clear 58";
    String searchAllBrand2 = "clear 58";
    String brandToClickOn = "Clear58";
    String brandToClickOn2 = "Biomedics38";
    String brandVerifyPDP = "Clear 58";
    String brandVerifyPDP2 = "Biomedics 38";
    String posR = "";
    String posL = "";
    String posR2 = "";
    String posL2 = "";
    String rPower = "-3.25";
    String lPower = "-3.75";
    String rPower2 = "-0.25";
    String lPower2 = "-0.75";
    String rBC = "8.3";
    String lBC = "8.3";
    String rBC2 = "8";
    String lBC2 = "8";
    String rDia = "14.0";
    String lDia = "14.0";
    String rDia2 = "11";
    String lDia2 = "11";
    String rColor = "V";
    String lColor = "B";
    String rColor2 = "11";
    String lColor2 = "11";
    String rAdd;
    String lAdd;
    String rAdd2;
    String lAdd2;
    String rCyl = "";
    String lCyl = "";
    String rCyl2 = "--";
    String lCyl2 = "--";
    String rAxis = "";
    String rAxis2 = "111";
    String lAxis = "";
    String lAxis2 = "11";
    String rBoxes = "4";
    String rBoxes2 = "1";
    String lBoxes = "4";
    String lBoxes2 = "1";
    String PatientFNameCart = "FirstPaFirst";
    String PatientLNameCart = "FirstPaLast";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String PatientFNameCart2 = "SecondPaFirst";
    String PatientLNameCart2 = "SecondPaLast";
    String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
    String ShippingCart = "n";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "49.99";
    String priceREye = "49.99";
    String priceLEye = "149.97";
    String pricePerBox2 = "49.99";
    String priceREye2 = "49.99";
    String priceLEye2 = "149.97";
    String priceTotal = "1,063.88";
    String rsTotal = "1,136.76";
    String rsTotalAfterRebate = "1,106.76";
    String rsTax = "72.88";
    String rsRebate = "30";
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
    String ccExpMo = "";
    String ccExpYear = "";
    String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
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
        takeScreenshot(screenshotTestName, "PDP1");
        verifyPDP(brandVerifyPDP);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        clickRDia(rDia);
        clickLDia(lDia);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart,PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
        clickAddRx(device);
        searchAllBrand(device,searchAllBrand2);
        verifyPDP(brandVerifyPDP2);
        clickRPower(device,posR2,rPower2);
        clickLPower(device,posL2,lPower2);
        typePatientName(PatientFNameCart2,PatientLNameCart2);
        takeScreenshot(screenshotTestName, "PDP3");
        clickAddToCart(device);
        selectShippingCart(ShippingCart);
        takeScreenshot(screenshotTestName, "Cart");
        verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
        clickCart_Continue(device);
        typeShippingName(shippingFName,shippingLName);
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
