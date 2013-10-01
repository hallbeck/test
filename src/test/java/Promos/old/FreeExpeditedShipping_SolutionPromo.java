package Promos.old;

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
public class FreeExpeditedShipping_SolutionPromo extends ContactsTestBase {


    //change the Strings below to change the tests
    String testNumber = "solution";
    String typeOfTest = "Promo";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "acuvue 2";
    String brandToClickOn = "Acuvue2";
    String brandVerifyPDP = "Acuvue 2";
    String brandVerifyPDP2 = "";
    String Acuvue2Colours="lens/acuvue-2-colours";
    String posR = "+";
    String posL = "";
    String rPower2 = "";
    String lPower2 = "";
    String rPower = "0.50";
    String lPower = "-1.00";
    String rBC = "8";
    String lBC = "8";
    String rBC2 = "";
    String lBC2 = "";
    String rDia = "";
    String lDia = "";
    String rDia2 = "";
    String lDia2 = "";
    String rColor = "E-Blue";
    String lColor = "E-Blue";
    String rColor2 = "";
    String lColor2 = "";
    String rAdd = "";
    String lAdd = "";
    String rAdd2 = "";
    String lAdd2 = "";
    String rCyl = "--";
    String lCyl = "--";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "11";
    String rAxis2 = "";
    String lAxis = "11";
    String lAxis2 = "";
    String rBoxes = "1";
    String rBoxes2 = "";
    String lBoxes = "1";
    String lBoxes2 = "";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
    String ShippingCart = "e";
    String promoName = "https://media.1800contacts.com/is/image/1800Contacts/website%5Fcartpageupsell%5Falconsingle%5Fmod?fmt=png-alpha";
    String promoProdName = "OPTI-FREE® PureMoist® Solution 10oz";
    String pricePromoCart = "12.99";
    String promoItemNumber = "002966";
    String promoText = "";
    //osta.1800contactstest.com/?rb=ACFSM2013
    String sunglassesPromoLink = "?rb=ACFSW2013";
    String promoCode = "ACFS2013";
    String pricePerBox = "39.99";
    String priceREye = "39.99";
    String priceLEye = "39.99";
    String pricePerBox2 = "49.99";
    String priceREye2 = "99.98";
    String priceLEye2 = "199.96";
    String priceTotal = "92.97";
    String rsTotal = "99.34";
    String rsTotalAfterRebate = "";
    String rsTax = "6.37";
    String rsRebate = "";
    String rsShipping = "FREE" ;
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
    String creditCard = "4012000077777777";
    String ccName = "Blah";
    String ccExpMo = "";
    String ccExpYear = "";
    String creditCardBad = "4111111111111111";
    String ccExpMoBad = "01";
    String ccExpYearBad = "2013";
    String paymentType = "";
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
    String shippingVerify = "FREE";
    String seperator = "/";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify + seperator;


    @Test (singleThreaded = true)
    @Parameters({ "device", "prod" })
    public void promoTest(String device,String prod) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(Acuvue2Colours);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        clickRColor(rColor);
        clickLColor(lColor);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP1_");
        clickAddToCart(device);
        selectPromoCart(device,promoName);
        selectShippingCart(ShippingCart);
        takeScreenshot(screenshotTestName, "Cart");
        //enterOrderCode(device,promoCode);
        verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
        verifyPromoCart(device,promoProdName,pricePromoCart,promoItemNumber,promoText);
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
        pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        verifyPromoRS(device,promoProdName,pricePromoCart,promoItemNumber,promoText);
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
