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
public class ININIProgressiveCanadaTest extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "MAKEONE";
    String typeOfTest = "INI";
    String typeOfCust = "NI";
    String typeOfPayment = "Insurance";
    String searchAllBrand = "multifocal";
    String brandToClickOn = "PureVisionMulti-Focal";
    String brandVerifyPDP = "PureVision Multi-Focal";
    String posR = "+";
    String posL = "+";
    String rPower = "0.25";
    String lPower = "0.75";
    String rBC = "";
    String lBC = "";
    String rDia = "";
    String lDia = "";
    String rAdd = "2";
    String lAdd = "2";
    String rCyl;
    String lCyl;
    String PatientFNameCart2 = "B one";
    String PatientLNameCart2 = "testacct";
    String PatientFNameCart = "A one";
    String PatientLNameCart = "testacct";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String PatientBirth = "1/1/1985";
    String ShippingCart = "cc";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "69.99";
    String priceREye = "139.98";
    String priceLEye = "139.98";
    String priceTotal = "306.95";
    String rsTotal = "306.95";
    String rsTotalAfterRebate = "249.96";
    String rsTax = "";
    String rsRebate = "30";
    String rsShipping = "26.99" ;
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "canada";
    String state = "O";
    String city = "Ottawa";
    String zip = "K1A 0G9";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "4012000077777777";
    String ccName = "Blah";
    String ccExpMo = "03";
    String ccExpYear = "2014";
        String rebateNotShipped = "Your order has not shipped yet.";
    String shippingVerify = "Canada Express";
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
        clickPhoneBrand(device,brandToClickOn);
        verifyPDP(brandVerifyPDP);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRAdd(rAdd);
        clickLAdd(lAdd);
        typePatientName(PatientFNameCart,PatientLNameCart);
        clickAddToCart(device);
        selectShippingCart(ShippingCart);
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
        clickNewAddress_Continue();
        takeScreenshot(screenshotTestName, "RS1");
        checkInsurance(device, fullPatientName, PatientBirth);
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
        verifyOrderStatusHistory(device,brandVerifyPDP,fullPatientName,rsShipping,shippingVerify,zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate);
        takeScreenshot(screenshotTestName, "OrderStatusHistory");
        driver.quit();
    }
}
