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
public class EditShippingBilling44764 extends TestBase {


    //change the Strings below to change the tests
    String testNumber = "44764";
    String testNumberDependentOn = "47577";
    String typeOfTest = "VERIFICATION";
String typeOfCust = "NI"; String posR = "+"; String posL = "+";
    String typeOfPayment = "Credit";
    String searchAllBrand = "Acuvue";
    String searchAllBrand2 = "";
    String brandToClickOn = "AcuvueAdvance";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "Acuvue Advance";
    String brandVerifyPDP2 = "";
    String rPower2 = "";
    String lPower2 = "";
    String rPower = "+0.50";
    String lPower = "-0.75";
    String rBC = "8";
    String lBC = "8";
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
    String rCyl = "--";
    String lCyl = "---";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "";
    String rAxis2 = "";
    String lAxis = "";
    String lAxis2 = "";
    String rBoxes = "1";
    String rBoxes2 = "";
    String lBoxes = "2";
    String lBoxes2 = "";
    String PatientFNameCart = "test";
    String PatientLNameCart = "testacct";
    String PatientFNameCart2 = "test";
    String PatientLNameCart2 = "testacct";
    String ShippingCart = "e";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "26.99";
    String priceREye = "26.99";
    String priceLEye = "53.98";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "80.97";
    String rsTotal = "101.51";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "5.55";
    String rsRebate = "";
    String rsShipping = "14.99" ;
    String shippingFName = "test";
    String shippingLName = "testacct";
    String country = "united states";
    String state = "utah";
    String city = "slc";
    String zip = "84121";
    String shippingFNameEdit = "test edit";
    String shippingLNameEdit = "testacct edit";
    String countryEdit = "united states";
    String stateEdit = "california";
    String cityEdit = "santa cruz";
    String zipEdit = "95066";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "4012000077777777";
    String ccName = "test testacct";
    String ccExpMo = "03";
    String ccExpYear = "2014";
    String device,shippingVerify = "Standard";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify+ " | ";
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
        typeReturningPhonePassword(device,password);
        clickSignIn(device);
        gotoMyAccount(device);
        gotoShippingBilling(device);
        clickEditShipping(device);
        editShipping(device,shippingFNameEdit,shippingLNameEdit,countryEdit,cityEdit,stateEdit,zipEdit);
    }
}
