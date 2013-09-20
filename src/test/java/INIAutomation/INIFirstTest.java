package INIAutomation;

import Base.ContactsTestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13                                      String typeOfCust = "NI";
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class INIFirstTest extends ContactsTestBase {

    //change the Strings below to change the tests
    String testNumber = "44039";
    String typeOfTest = "INI";
String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "Astigmatism";
    String searchAllBrand2 = "";
    String brandToClickOn = "AcuvueOasysforAstigmatism";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "Acuvue Oasys for Astigmatism";
    String brandVerifyPDP2 = "";
    String posR = "";
    String posL = "+";
    String rPower = "";
    String lPower = "0.75";
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
    String lCyl = "--";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "";
    String rAxis2 = "";
    String lAxis = "11";
    String lAxis2 = "";
    String rBoxes = "";
    String rBoxes2 = "";
    String lBoxes = "";
    String lBoxes2 = "";
    String PatientLNameCart = "Haywood";
    String PatientFNameCart = "Justin";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String PatientBirth = "03/28/1958";
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
    String address = "Sandisfield";
    String state = "mass";
    String city = "WOODBRIDGE";
    String zip = "01255";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "4012000077777777";
    String ccName = "Blah";
    String ccExpMo = "";
    String ccExpYear = "";  String paymentType = "";
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
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "SearchBrand");
        clickPhoneBrand(device,brandToClickOn);
        takeScreenshot(screenshotTestName, "PDP1");
        checkBoxRightEye(device);
        clickLPower(device,posL,lPower);
        clickLCyl(lCyl);
        clickLAxis(lAxis);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP1");
        clickUpdateCart(device);
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
        typeShippingEmail(emailPrefix, testNumber);
        typePassword_newcust(password);
        clickNewAddress_Continue();
        typeDoctorSearch(drName);
        typeDoctorStateAndFind(device,drState);
        selectDoctor(device);
        takeScreenshot(screenshotTestName, "RS1");
        checkInsurance(device,fullPatientName,PatientBirth);
        takeScreenshot(screenshotTestName, "RS2");
        typeCreditCard(device,creditCard);
        typeCreditCardName(device,ccName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        takeScreenshot(screenshotTestName, "RS3");
        clickBottomSubmitButton(device);
        takeScreenshot(screenshotTestName, "TY");
        verifyThankYouPage(testNumber,shippingVerify);
        driver.quit();
    }
}
