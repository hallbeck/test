package INIAutomation;
import Automation.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class INI_dob_entry48496 extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "48496";
    String typeOfTest = "INI";
    String typeOfCust = "NI";
    String typeOfPayment = "Insurance";
    String searchAllBrand = "vial";
    String brandToClickOn = "SoftconEW";
    String brandVerifyPDP = "Softcon EW";
    String posR = "+";
    String posL = "+";
    String rPower = "0.25";
    String lPower = "0.75";
    String rBC = "8";
    String lBC = "8";
    String rDia = "11";
    String lDia = "11";
    String rAdd;
    String lAdd;
    String rCyl;
    String lCyl;
    String PatientFNameCart2 = "B one";
    String PatientLNameCart2 = "testacct";
    String PatientFNameCart = "A one";
    String PatientLNameCart = "testacct";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String PatientBirth = "jan/1/1985";
    String ShippingCart = "nn";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "59.99";
    String priceREye = "119.98";
    String priceLEye = "119.98";
    String priceTotal = "264.95";
    String rsTotal = "281.39";
    String rsTotalAfterRebate = "";
    String rsTax = "16.44";
    String rsRebate = "";
    String rsShipping = "24.99" ;
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
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
    String shippingVerify = "Noon";
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
      clickRBC(rBC);
      clickLBC(lBC);
      clickRDia(rDia);
      clickLDia(lDia);
    typePatientName(PatientFNameCart,PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
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
        checkInsurance(device, fullPatientName, PatientBirth);
        takeScreenshot(screenshotTestName, "RS2");
    typeCreditCard(device,creditCard);
    typeCreditCardName(device,ccName);
    pickCreditCardExpDate(device,ccExpMo, ccExpYear);
        takeScreenshot(screenshotTestName, "ReviewSubmit3");
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
