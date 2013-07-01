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
public class ShippingChanges47266 extends TestBase {


    //change the Strings below to change the tests
    String testNumber = "47266";
    String typeOfTest = "VERIFICATION";
String typeOfCust = "NI"; String posR = "+"; String posL = "+";
    String typeOfPayment = "Credit";
    String searchAllBrand = "Toric";
    String searchAllBrand2 = "Toric";
    String brandToClickOn = "VertexToricXR";
    String brandToClickOn2 = "VertexToricXR";
    String brandVerifyPDP = "Vertex Toric XR";
    String brandVerifyPDP2 = "Vertex Toric XR";
    String rPower = "--";
    String lPower = "--";
    String rPower2 = "+0.25";
    String lPower2 = "+0.75";
    String rBC = "8";
    String lBC = "8";
    String rBC2 = "8";
    String lBC2 = "8";
    String rDia = "11";
    String lDia = "11";
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
    String rBoxes = "1";
    String rBoxes2 = "1";
    String lBoxes = "1";
    String lBoxes2 = "1";
    String PatientFNameCart = "test";
    String PatientLNameCart = "testacct";
    String PatientFNameCart2 = "test";
    String PatientLNameCart2 = "testacct";
    String ShippingCart = "n";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "107.99";
    String priceREye = "107.99";
    String priceLEye = "107.99";
    String pricePerBox2 = "49.99";
    String priceREye2 = "49.99";
    String priceLEye2 = "149.97";
    String priceTotal = "235.97";
    String rsTotalAfterRebate = "147.92";
    String rsTotal = "230.77";
    String rsTax = "14.79";
    String rsRebate = "";
    String rsShipping = "19.99" ;
    String shippingFName = "test";
    String shippingLName = "testacct";
    String country = "united states";
    String state = "utah";
    String city = "slc";
    String zip = "84121";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "4012000077777777";
    String ccName = "test testacct";
    String ccExpMo = "03";
    String ccExpYear = "2014";
        String rebateNotShipped = "Your order has not shipped yet.";
    String shippingVerify = "Next";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        printTestNumber(printTestName + device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickSignOut(device);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand2);
        clickPhoneBrand(device,brandToClickOn2);
        verifyPDP(brandVerifyPDP2);
        clickRPower(device,posR,rPower2);
        clickLPower(device,posL,lPower2);
        clickRCyl(rCyl2);
        clickLCyl(lCyl2);
        clickRAxis(rAxis2);
        clickLAxis(lAxis2);
        clickRboxes(rBoxes2);
        clickLboxes(lBoxes2);
        typePatientName(PatientFNameCart,PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP3");
        clickAddToCart(device);
        selectShippingCart(ShippingCart);
        takeScreenshot(screenshotTestName, "Cart");
        assertCart(device,brandVerifyPDP, PatientFNameCart + " " + PatientLNameCart, pricePerBox, priceREye, priceLEye, priceTotal);
        clickCart_Continue(device);
        typeShippingName(shippingFName,shippingLName);
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
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        clickBottomSubmitButton(device);
        assertThankYouPage(device,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        driver.quit();
    }
}
