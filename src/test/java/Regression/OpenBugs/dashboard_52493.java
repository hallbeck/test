package Regression.OpenBugs;

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
public class dashboard_52493 extends ContactsTestBase {

    //change the Strings below to change the tests
    String testNumber = "50300";
    String testNumberDependentOn = "49773";
    String typeOfTest = "REGRESSION";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "";
    String searchAllBrand2 = "";
    String brandToClickOn = "";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "";
    String brandVerifyPDP2 = "";
    String posR = "";
    String posL = "";
    String rPower = "";
    String lPower = "";
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
    String rColor = "";
    String lColor = "";
    String rColor2 = "";
    String lColor2 = "";
    String rAdd = "";
    String lAdd = "";
    String rAdd2 = "";
    String lAdd2 = "";
    String rCyl = "";
    String lCyl = "";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "";
    String rAxis2 = "";
    String lAxis = "";
    String lAxis2 = "";
    String rBoxes = "";
    String rBoxes2 = "";
    String lBoxes = "";
    String lBoxes2 = "";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
    String ShippingCart = "e";
    String pricePerBox = "47.99";
    String priceREye = "";
    String priceLEye = "191.96";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "206.95";
    String rsTotal = "230.77";
    String rsTotalAfterRebate = "181.95";
    String rsTax = "13.15";
    String rsRebate = "25 Acuvue Rebate";
    String rsShipping = "14.99" ;
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
    String creditCardBad = "4111111111111111";
    String ccExpMoBad = "01";
    String ccExpYearBad = "2013";
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
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
        goToSignInPage(device);
        typeReturningPhoneEmail(testNumberDependentOn);
        typeReturningPhonePassword(device, password);
        clickSignIn(device);
        gotoMyAccount(device);
        Wait(3);
        printPageTitle();
        gotoOrderStatusHistory(device);
        Wait(3);
        printPageTitle();
        goback();
        Wait(3);
        printPageTitle();
        gotoDashboard(device);
        Wait(3);
        printPageTitle();
        goback();
        Wait(3);
        printPageTitle();
        gotoShippingBilling(device);
        Wait(3);
        printPageTitle();
        goback();
        Wait(3);
        printPageTitle();
        gotoAccountSettings(device);
        Wait(3);
        printPageTitle();
        goback();
        driver.quit();
    }
}
