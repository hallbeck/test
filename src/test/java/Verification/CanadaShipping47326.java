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
public class CanadaShipping47326 extends TestBase {


    //change the Strings below to change the tests
    String testNumber = "47326";
    String typeOfTest = "VERIFICATION";
String typeOfCust = "NI"; String posR = "+"; String posL = "+";
    String typeOfPayment = "Credit";
    String searchAllBrand = "Acuvue";
    String searchAllBrand2 = "Toric";
    String brandToClickOn = "AcuvueAdvance";
    String brandToClickOn2 = "VertexToricXR";
    String brandVerifyPDP = "Acuvue Advance";
    String brandVerifyPDP2 = "Vertex Toric XR";
    String rPower = "+0.50";
    String lPower = "+0.75";
    String rPower2 = "";
    String lPower2 = "";
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
    String rColor2 = "";
    String lColor2 = "";
    String rAdd;
    String lAdd;
    String rAdd2;
    String lAdd2;
    String rCyl = "--";
    String lCyl = "---";
    String rCyl2 = "--";
    String lCyl2 = "--";
    String rAxis = "11";
    String rAxis2 = "111";
    String lAxis = "111";
    String lAxis2 = "11";
    String rBoxes = "8";
    String rBoxes2 = "1";
    String lBoxes = "8";
    String lBoxes2 = "1";
    String PatientFNameCart = "test";
    String PatientLNameCart = "testacct";
    String PatientFNameCart2 = "test";
    String PatientLNameCart2 = "testacct";
    String ShippingCart = "c";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "107.99";
    String priceREye = "107.99";
    String priceLEye = "107.99";
    String pricePerBox2 = "49.99";
    String priceREye2 = "49.99";
    String priceLEye2 = "149.97";
    String priceTotal = "235.97";
    String rsTotal = "230.77";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "14.79";
    String rsRebate = "";
    String rsShipping = "FREE" ;
    String shippingFName = "test";
    String shippingLName = "testacct";
    String country = "CANADA";
    String state = "ontario";
    String city = "Ottawa";
    String zip = "K1A 0G9";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "test";
    String ccName = "test testacct";
    String ccExpMo = "";
    String ccExpYear = "";
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
    String shippingVerify = "Canada";
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
        searchAllBrand(device,searchAllBrand);
        clickPhoneBrand(device,brandToClickOn);
        verifyPDP(brandVerifyPDP2);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRCyl(rCyl);
        clickLCyl(lCyl);
        clickRAxis(rAxis);
        clickLAxis(lAxis);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart,PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP3");
        clickAddToCart(device);
        takeScreenshot(screenshotTestName, "Cart");
        assertCart(device,brandVerifyPDP, PatientFNameCart + " " + PatientLNameCart, pricePerBox, priceREye, priceLEye, priceTotal);
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
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        clickBottomSubmitButton(device);
        assertThankYouPage(device,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        driver.quit();
    }
}
