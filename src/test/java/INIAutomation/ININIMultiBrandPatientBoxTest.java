package INIAutomation;

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
public class ININIMultiBrandPatientBoxTest extends TestBase {


    //change the Strings below to change the tests
    String testNumber = "MAKEONE";
    String typeOfTest = "INI";
    String typeOfCust = "NI";
    String typeOfPayment = "Insurance";
    String searchAllBrand = "color";
    String searchAllBrand2 = "Toric";
    String brandToClickOn = "FreshLookColors";
    String brandToClickOn2 = "VertexToricXR";
    String brandVerifyPDP = "FreshLook Colors";
    String brandVerifyPDP2 = "Vertex Toric XR";
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
    String lBoxes = "3";
    String lBoxes2 = "1";
    String PatientFNameCart2 = "B one";
    String PatientLNameCart2 = "testacct";
    String PatientFNameCart = "A one";
    String PatientLNameCart = "testacct";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String PatientBirth = "1/1/1985";
    String PatientBirth2 = "1/1/1985";
    String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
    String ShippingCart = "n";
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
    String ccExpMo = "03";
    String ccExpYear = "2014";
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
        clickPhoneBrand(device,brandToClickOn2);
        verifyPDP(brandVerifyPDP2);
        clickRPower(device,posR,rPower2);
        clickLPower(device,posL,lPower2);
        clickRCyl(rCyl2);
        clickLCyl(lCyl2);
        clickRAxis(rAxis2);
        clickLAxis(lAxis2);
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
        takeScreenshot(screenshotTestName, "RS1");
        checkInsurance2(device, fullPatientName, PatientBirth, fullPatientName2, PatientBirth2);
        takeScreenshot(screenshotTestName, "RS2");
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
