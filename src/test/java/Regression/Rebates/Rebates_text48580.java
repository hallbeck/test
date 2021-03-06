package Regression.Rebates;

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
public class Rebates_text48580 extends ContactsTestBase {

    //change the Strings below to change the tests
    String testNumber = "48580";
    String orderNumberPlaceholder = "48580Acuvue2_rebate";
    String typeOfTest = "Regression";
    String typeOfCust = "NA";
    String typeOfPayment = "Rebates";   
    //LENS//
    String DayAcuvue30pk="lens/1-day-acuvue-30";
    String rebatesAvailable = "Rebate expected--save $30 on 12 -- save $65 on 24";
    String RebateTextRS = "Acuvue Rebate";
    String rebate6Month = "30.0";
    String rebate12Month = "65.0";
        String brandVerifyPDP = "Acuvue 2";
    String posR = "";
    String posL = "+";
    String rPower = "-0.50";
    String lPower = "2.25";
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
    String rCyl = "-";
    String lCyl = "-";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "";
    String rAxis2 = "";
    String lAxis = "";
    String lAxis2 = "";
    String rBoxes = "6";
    String rBoxes2 = "12";
    String lBoxes = "6";
    String lBoxes2 = "12";
    String PatientFNameCart = "PatientFirst";
    String PatientLNameCart = "PatientLast";
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "Bolivia";
    String state = "Newberry";
    String city = "whatever";
    String bState = "Newberry";
    String bCity = "whatever";
    String zip = "K1A 0G9";
    String emailPrefix = "test";
String password = "password";
    String creditCard = "373235387881007";
    String ccName = "Blah";
    String ccExpMo = "";
    String ccExpYear = "";  String paymentType = "";
    String creditCardBad = "36259600";
    String ccExpMoBad = "01";
    String ccExpYearBad = "2013";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String rsTotal = "339.73";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "20.82";
    String rsRebate = "20 Acuvue Rebate";
    String rsShipping = "14.99" ;
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
    String shippingVerify = "Title tag";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust  + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + typeOfPayment + "_" + shippingVerify;



    @Test (singleThreaded = true)
    @Parameters({ "device", "prod" })
    public void rebatesTest(String device,String prod) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(device,DayAcuvue30pk);
        print("Rebate expected--save $30 on 12 -- save 65 on 24");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP1_");
        clickAddToCart(device);
        verifyRebateCart(device,rebate6Month);
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
        verifyRebateRS(device,rebate6Month,RebateTextRS);
        goToCart(device);
        clickRemove(device);

        gotoPage(device,DayAcuvue30pk);
        print("Rebate expected--save $30 on 12 -- save 65 on 24");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        clickRboxes(rBoxes2);
        clickLboxes(lBoxes2);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2_");
        clickAddToCart(device);
        verifyRebateCart(device,rebate12Month);
        clickCart_Continue(device);
        verifyRebateRS(device,rebate12Month,RebateTextRS);

               typeCreditCard(device,creditCard);
        typeCreditCardName(device,ccName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        checkoutAndVerify(testNumber,device,shippingVerify,brandVerifyPDP,fullPatientName,rsShipping,zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate,orderStatus,bState,bCity);
        getRebate(device,orderNumberPlaceholder,rebateNotShipped);
        //shipOrder(testNumber);
        //getRebate(device,orderNumberPlaceholder,rebateShipped);
        driver.quit();
    }
}
