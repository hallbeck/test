package INIAutomation;

import Base.ContactsTestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ININIMultiBrand1EyeEachTest extends ContactsTestBase {


    //change the Strings below to change the tests
    String testNumber = "48504";
    String typeOfTest = "INI";
    String typeOfCust = "NI";
    String typeOfPayment = "Insurance";
    String searchAllBrand = "color";
    String searchAllBrand2 = "Astigmatism";
    String brandToClickOn = "FreshLookColors";
    String brandToClickOn2 = "AcuvueOasysforAstigmatism";
    String brandVerifyPDP = "FreshLook Colors";
    String brandVerifyPDP2 = "Acuvue Oasys for Astigmatism";
    String posR = "";
    String posL = "+";
    String lPower = "";
    String rPower2 = "";
    String rPower = "-0.50";
    String lPower2 = "0.75";
    String rBC = "";
    String lBC = "";
    String rBC2 = "";
    String lBC2 = "";
    String rDia = "";
    String lDia = "";
    String rDia2 = "";
    String lDia2 = "";
    String rColor = "V";
    String lColor = "";
    String rColor2 = "";
    String lColor2 = "";
    String rAdd;
    String lAdd;
    String rAdd2;
    String lAdd2;
    String rCyl = "";
    String lCyl = "";
    String rCyl2 = "";
    String lCyl2 = "--";
    String rAxis = "";
    String rAxis2 = "";
    String lAxis = "";
    String lAxis2 = "11";
    String rBoxes = "2";
    String rBoxes2 = "";
    String lBoxes = "";
    String lBoxes2 = "";
    String PatientFNameCart2 = "B one";
    String PatientLNameCart2 = "testacct";
    String PatientFNameCart = "A one";
    String PatientLNameCart = "testacct";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String PatientBirth = "1/1/1985";
    String PatientBirth2 = "1/1/1985";
    String ShippingCart = "n";
    String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
    String pricePerBox = "49.99";
    String priceREye = "99.98";
    String priceLEye = "191.96";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "291.94";
    String rsTotal = "331.94";
    String rsTotalAfterRebate = "306.93";
    String rsTax = "20.00";
    String rsRebate = "25 Acuvue Rebate";
    String rsShipping = "19.99" ;
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "united states";
String state = "utah";
    String city = "slc";
    String bState = "utah";
    String bCity = "slc";
    String zip = "84121";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "test";
    String ccName = "Blah";
    String ccExpMo = "";
    String ccExpYear = "";  String paymentType = "";
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
    String shippingVerify = "Next";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device){
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "SearchBrand");
        clickPhoneBrand(device,brandToClickOn);
        takeScreenshot(screenshotTestName, "PDP1");
        checkBoxLeftEye(device);
        clickRPower(device,posR,rPower);
        clickRColor(rColor);
        clickRboxes(rBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
        clickAddRx(device);
        searchAllBrand(device,searchAllBrand2);
        clickPhoneBrand(device,brandToClickOn2);
        checkBoxRightEye(device);
        clickLPower(device,posL,lPower2);
        clickLAxis(lAxis2);
        clickLCyl(lCyl2);
        typePatientName(PatientFNameCart2, PatientLNameCart2);
        takeScreenshot(screenshotTestName, "PDP3");
        clickAddToCart(device);
        selectShippingCart(ShippingCart);
        takeScreenshot(screenshotTestName, "Cart");
        verifyCart(device,brandVerifyPDP2,PatientFNameCart2 + " " + PatientLNameCart2,pricePerBox,priceREye,priceLEye,priceTotal);
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
        takeScreenshot(screenshotTestName, "RS1");
        checkInsurance2(device, fullPatientName, PatientBirth, fullPatientName2, PatientBirth2);
        takeScreenshot(screenshotTestName, "RS2");
        typeCreditCard(device,creditCard);
        typeCreditCardName(device,ccName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        verifyRS(device,brandVerifyPDP2, PatientFNameCart2, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(testNumber,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        gotoMyAccount(device);
        takeScreenshot(screenshotTestName, "Dashboard");
        verifyDashboard(device,brandVerifyPDP,fullPatientName);
        gotoOrderStatusHistory(device);
        verifyOrderStatusHistory(device,brandVerifyPDP,fullPatientName,rsShipping,shippingVerify,zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate,orderStatus,bState,bCity);
        takeScreenshot(screenshotTestName, "OrderStatusHistory");
        driver.quit();
    }
}
