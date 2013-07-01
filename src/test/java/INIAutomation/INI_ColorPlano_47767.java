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
public class INI_ColorPlano_47767 extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "47767";
    String typeOfTest = "INI";
String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "color";
    String searchAllBrand2 = "";
    String brandToClickOn = "Acuvue2";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "Acuvue 2";
    String brandVerifyPDP2 = "";
    String posR = ""; String posL = "";
    String rPower = "0.00";
    String lPower = "0.00";
    String rPower2 = "";
    String lPower2 = "";
    String rBC = "8";
    String lBC = "8";
    String rBC2 = "";
    String lBC2 = "";
    String rDia = "";
    String lDia = "";
    String rDia2 = "";
    String lDia2 = "";
    String rColor = "E";
    String lColor = "E";
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
    String rBoxes = "1";
    String rBoxes2 = "";
    String lBoxes = "1";
    String lBoxes2 = "";
    String PatientLNameCart = "Charlotte";
    String PatientFNameCart = "Armstrong";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String PatientBirth = "08/11/1944";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String PatientBirth2 = "06/04/1981";
    String ShippingCart = "e";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "47.99";
    String priceREye = "";
    String priceLEye = "191.96";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "206.95";
    String rsSubTotal = "230.77";
    String rsTotal = "230.77";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "14.79";
    String rsRebate = "25 Acuvue Rebate";
    String rsINISubTotal = "230.77";
    String rsINITotal = "230.77";
    String rsINITotalAfterRebate = "147.92";
    String rsINITax = "14.79";
    String rsINIRebate = "-$130.00";
    String rsShipping = "FREE" ;
    String shippingFName = PatientFNameCart;
    String shippingLName = PatientLNameCart;
    String country = "united states";
    String address = "41 WHITE BEACH LN";
    String state = "mass";
    String city = "Sandisfield";
    String zip = "01255";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "4012000077777777";
    String ccName = "Blah";
    String ccExpMo = "03";
    String ccExpYear = "2014";
    String creditCardBad = "4111111111111111";
    String ccExpMoBad = "01";
    String ccExpYearBad = "2013";
        String rebateNotShipped = "Your order has not shipped yet.";
    String shippingVerify = "Expedited";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "SearchBrand");
        clickPhoneBrand(device,brandToClickOn);
        takeScreenshot(screenshotTestName, "PDP1");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        clickRColor(rColor);
        clickLColor(lColor);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP1");
        clickUpdateCart(device);
        takeScreenshot(screenshotTestName, "Cart");
        verifyCart(device, brandVerifyPDP, PatientFNameCart + " " + PatientLNameCart, pricePerBox, priceREye, priceLEye, priceTotal);
        clickCart_Continue(device);
        typeShippingName(shippingFName, shippingLName);
        clickCountry(country);
        typeShippingAddress();
        typeShippingCity(city);
        typeShippingState(country, state);
        typeShippingZip(zip);
        typeShippingPhone(device);
        typeShippingEmail(emailPrefix, testNumber);
        typePassword_newcust(password);
        clickNewAddress_Continue();
        typeDoctorSearch(drName);
        typeDoctorStateAndFind(device, drState);
        selectDoctor(device);
        takeScreenshot(screenshotTestName, "RS1");
        checkInsurance(device, fullPatientName, PatientBirth);
        takeScreenshot(screenshotTestName, "RS2");
        typeCreditCard(device,creditCard);
        typeCreditCardName(device,ccName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear);
        verifyRS(device, brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        takeScreenshot(screenshotTestName, "RS3");
        clickBottomSubmitButton(device);
        takeScreenshot(screenshotTestName, "TY");
        verifyThankYouPage(testNumber,shippingVerify);
        driver.quit();
    }
}
