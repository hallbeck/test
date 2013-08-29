package Promos.current;

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
public class BrandCanvas_Click_Promo extends TestBase {


    //change the Strings below to change the tests
    String testNumber = "brand_canvas";
    String typeOfTest = "Promo";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchAllBrand = "";
    String brandVerifyPDP = "Air Optix Aqua Multifocal";
    String brandVerifyPDP2 = "Acuvue Oasys for Astigmatism";
    String brandVerifyPDP3 = "Biofinity Toric";
    String brandVerifyPDP4 = "Air Optix Night & Day Aqua";
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
    String rColor = "";
    String lColor = "";
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
    String rBoxes = "";
    String rBoxes2 = "";
    String lBoxes = "";
    String lBoxes2 = "";
    String bcButton1 = "aomulti";
    String bcButton2 = "oasysastig";
    String bcButton3 = "biotoric";
    String bcButton4 = "aond";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
    String ShippingCart = "ii";
    String promoName = "https://media.1800contacts.com/is/image/1800Contacts/website%5Fcartpagerbslot%5Facfsw2013%5Fimage";
    String promoProdName = "Suncloud Cookie";
    String pricePromoCart = "49.99";
    String promoItemNumber = "002568";
    String promoText = "FREE Polarized Sunglasses:";
    String sunglassesPromoLink = "?rb=ACFSW2013";
    String promoCode = "ACFS2013";
    String pricePerBox = "59.99";
    String priceREye = "119.98";
    String priceLEye = "119.98";
    String pricePerBox2 = "49.99";
    String priceREye2 = "99.98";
    String priceLEye2 = "199.96";
    String priceTotal = "275.95";
    String rsTotal = "275.95";
    String rsTotalAfterRebate = "230.95";
    String rsTax = "";
    String rsRebate = "";
    String rsShipping = "35.99" ;
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "BOLIVIA";
    String state = "whatever";
    String city = "newberry";
    String zip = "K1A 0G9";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "test";
    String ccName = "Blah";
    String ccExpMo = "";
    String ccExpYear = "";
    String creditCardBad = "4111111111111111";
    String ccExpMoBad = "01";
    String ccExpYearBad = "2013";
    String rebateNotShipped = "Your order has not shipped yet.";
    String orderStatus = "Checking Stock";
    String shippingVerify = "Int'l Express";
    String seperator = "/";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify + seperator;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickBC(device,bcButton1);
        assertPDP(device,brandVerifyPDP);
        gotoPage("");
        clickBC(device,bcButton2);
        assertPDP(device,brandVerifyPDP2);
        gotoPage("");
        clickBC(device,bcButton3);
        assertPDP(device,brandVerifyPDP3);
        gotoPage("");
        clickBC(device,bcButton4);
        assertPDP(device,brandVerifyPDP4);
        driver.quit();
  }
}
