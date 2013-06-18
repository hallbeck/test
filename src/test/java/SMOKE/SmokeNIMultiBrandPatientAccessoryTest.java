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
public class SmokeNIMultiBrandPatientAccessoryTest extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "48928";
    String typeOfTest = "SMOKE";
String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "color";
    String searchAllBrand2 = "Toric";
    String searchAllBrand3 = "solution";
    String brandToClickOn = "FreshLookColors";
    String brandToClickOn2 = "VertexToricXR";
    String brandToClickOn3 = "ZADITOR®EyeDrops2pk";
    String brandVerifyPDP = "FreshLook Colors";
    String brandVerifyPDP2 = "Vertex Toric XR";
    String brandVerifyPDP3 = "ZADITOR® Eye Drops 2pk";
    String posR = "+";
    String posL = "+";
    String rPower = "0.25";
    String lPower = "0.75";
    String rPower2 = "0.25";
    String lPower2 = "0.75";
    String rBC = "8";
    String lBC = "8";
    String rBC2 = "8";
    String lBC2 = "8";
    String rDia = "11";
    String lDia = "11";
    String rDia2 = "11";
    String lDia2 = "11";
    String rColor = "V";
    String lColor = "V";
    String rColor2 = "11";
    String lColor2 = "11";
    String rAdd;
    String lAdd;
    String rAdd2;
    String lAdd2;
    String rCyl = "--";
    String lCyl = "--";
    String rCyl2 = "--";
    String lCyl2 = "--";
    String rAxis = "111";
    String rAxis2 = "111";
    String lAxis = "11";
    String lAxis2 = "11";
    String rBoxes = "2";
    String rBoxes2 = "2";
    String lBoxes = "4";
    String lBoxes2 = "2";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
    String ShippingCart = "e";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "49.99";
    String priceREye = "99.98";
    String priceLEye = "199.96";
    String pricePerBox2 = "49.99";
    String priceREye2 = "99.98";
    String priceLEye2 = "199.96";
    String priceTotal = "1,178.85";
    String rsTotal = "1,243.58";
    String rsTotalAfterRebate = "1,213.58";
    String rsTax = "79.72";
    String rsRebate = "30";
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
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "SearchBrand");
        clickPhoneBrand(device,brandToClickOn);
        takeScreenshot(screenshotTestName, "PDP1");
        verifyPDP(brandVerifyPDP);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRColor(rColor);
        clickLColor(lColor);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart,PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
        clickAddRx(device);
        searchAllBrand(device,searchAllBrand2);
        clickAccessory(device,brandToClickOn2);
        verifyPDP(brandVerifyPDP2);
        clickRPower(device,posR,rPower2);
        clickLPower(device,posL,lPower2);
        clickRCyl(rCyl2);
        clickLCyl(lCyl2);
        clickRAxis(rAxis2);
        clickLAxis(lAxis2);
        typePatientName(PatientFNameCart2,PatientLNameCart2);
        takeScreenshot(screenshotTestName, "PDP3");
        clickAddRx(device);
        searchAllBrand(device,searchAllBrand3);
        clickAccessory(device,brandToClickOn3);
        verifyPDP(brandVerifyPDP3);
        //boxes of solution
        takeScreenshot(screenshotTestName, "PDP4");
        clickAddAccessoryToCart(device);
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
        verifyRS(device,brandVerifyPDP3, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        gotoMyAccount(device);
        takeScreenshot(screenshotTestName, "Dashboard");
        verifyDashboard(device,brandVerifyPDP,fullPatientName);
        gotoOrderStatusHistory(device);
        verifyOrderStatusHistory(device,brandVerifyPDP,fullPatientName,rsShipping,shippingVerify,zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate);
        takeScreenshot(screenshotTestName, "OrderStatusHistory");
        driver.quit();
    }
}
