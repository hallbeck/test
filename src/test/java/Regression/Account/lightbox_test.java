package Regression.Account;

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
public class lightbox_test extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "48412";
    String testNumberDependentOn = "48412_signin";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "N/A";
    String searchAllBrand = "color";
    String searchAllBrand2 = "";
    String brandToClickOn = "Acuvue2";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "Acuvue 2";
    String brandVerifyPDP2 = "";
    String posR = "+";
    String posL = "";
    String rPower = "0.25";
    String lPower = "-0.25";
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
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "37.99";
    String priceREye = "151.96";
    String priceLEye = "151.96";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "318.91";
    String rsTotal = "339.73";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "20.82";
    String rsRebate = "20 Acuvue Rebate";
    String rsShipping = "14.99" ;
    String shippingFName = "ShipyFirst";
    String shippingLName = "ShipyLast";
    String billingFName = "BillyFirst";
    String billingLName = "BillyLast";
    String country = "united states";
    String state = "Utah";
    String stateAbrev = "UT";
    String city = "cottonwood";
    String billCity = "slc";
    String zip = "84120";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "4500600000000061";
    String ccName = "Blah";
    String ccExpMo = "03";
    String ccExpYear = "2014";
    String creditCardBad = "36259600";
    String ccExpMoBad = "01";
    String ccExpYearBad = "2013";
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
        clickReturningCustomer(device);
        typeReturningEmailLightbox(device,testNumberDependentOn);
        typeReturningPasswordLightbox(device,password);
        clickSignInLightbox(device);
        //go to account hub and change shipping, billing, credit card number
        gotoMyAccount(device);
        gotoShippingBilling(device);
        clickEditShipping(device);
        editAndVerifyShipping(device,shippingFName,shippingLName,country,city,state,stateAbrev,zip);
        clickEditBilling(device);
        editAndVerifyBilling(device,billingFName,billingLName,country,billCity,state,stateAbrev,zip);
        // change address from RS page
        /*clickFindBrand(device);
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
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
        clickAddToCart(device);
        selectShippingCart(ShippingCart);
        takeScreenshot(screenshotTestName, "Cart");
        verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
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
        openWebPage(device);
        goToSignInPage(device);
        typeReturningPhoneEmail(testNumberDependentOn);
        typeReturningPhonePassword(device,password);
        clickSignIn(device);
        goToCart(device);
        clickCart_Continue(device);
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
        verifyOrderStatusHistory(device,brandVerifyPDP,fullPatientName,rsShipping,shippingVerify,zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate);
        takeScreenshot(screenshotTestName, "OrderStatusHistory");
        driver.quit();*/
    }
}
