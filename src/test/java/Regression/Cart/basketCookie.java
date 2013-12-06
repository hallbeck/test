package Regression.Cart;

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
public class basketCookie extends ContactsTestBase {


    String testNumber = "basketCookie";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "Air Optix for Astigmatism";
    String searchAllBrand2 = "";
    String brandToClickOn = "Acuvue";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "Acuvue";
    String brandVerifyPDP2 = "";
    String posR = "+";
    String posL = "+";
    String rPower = "1.00";
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
    String rCyl = "-3.25";
    String lCyl = "-3.25";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "170";
    String rDiaBad = "";
    String rAxis2 = "";
    String lAxis = "170";
    String lDiaBad = "";
    String lAxis2 = "";
    String rBoxes = "";
    String rBoxes2 = "";
    String lBoxes = "";
    String lBoxes2 = "";
    String PatientFNameCart = "PatientFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String ShippingCart = "";
    String pricePerBox = "37.99";
    String priceREye = "75.98";
    String priceLEye = "227.94";
    String pricePerBox2 = "";
    String priceREye2 = "";
    String priceLEye2 = "";
    String priceTotal = "328.91";
    String rsTotal = "349.73";
    String rsTotalAfterRebate = "329.73";
    String rsTax = "20.82";
    String rsRebate = "";
    String rsShipping = "24.99" ;
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "united states";
    String state = "utah";
    String city = "slc";
    String zip = "84121";
    String billingFName = "BillFirst";
    String billingLName = "BillLast";
    String billingCountry = "united states";
    String billingState = "california";
    String billingCity = "scotts valley";
    String billingZip = "95066";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "test";
    String ccName = "Blah";
    String ccExpMo = "";
    String ccExpYear = "";
    String paymentType = "";
        String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
    String shippingVerify = "Next Day by Noon";
    String seperator = "/";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify + seperator;
    String BuyersGuideLink = "BuyersGuide/default.aspx";

    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        verifyCookie();
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "PDP1");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRCyl(rCyl);
        clickLCyl(lCyl);
        clickRAxis(rAxis);
        clickLAxis(lAxis);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
            typePatientName(PatientFNameCart,PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
        print("on PDP page");
        verifyCookie();
        clickAddToCart(device);
        takeScreenshot(screenshotTestName, "Cart");
        print("in Cart");
        verifyCookie();
        clickCart_Continue(device);
        print("on Address page");
        verifyCookie();
        gotoPage(device,BuyersGuideLink);
        print("on BuyersGuide page");
        verifyCookie();
        driver.quit();
    }
}
