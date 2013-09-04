package Promos.current;

import Automation.TestBase;
import org.testng.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class SunglassesPromo extends TestBase {


    @DataProvider(name = "sunglasses")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Promos.xls",
                "inputsStage", "smoke1");
        return(retObjArr);
    }


    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test (dataProvider = "sunglasses")
    @Parameters(value = "device")
    public void sunglassesTest(String testNumber, String testNumberDependentOn, String device,String typeOfTest, String typeOfCust, String typeOfPayment,
                       String searchAllBrand, String brandclick, String brandVerifyPDP,
                       String ccExpMo, String ccExpYear, String CCNum, String BadccExpMo, String BadccExpYear, String BadCCNum, String error, String CCName,
                       String emailPrefix, String password,
                       String posR, String posR2, String posL, String posL2, String rPower, String lPower, String rPower2, String lPower2,
                       String rBC, String lBC, String rBC2, String lBC2,
                       String rDia, String lDia, String rDia2, String lDia2,
                       String rColor, String lColor, String rColor2, String lColor2,
                       String rAdd, String lAdd, String rAdd2, String lAdd2,
                       String rCyl, String lCyl, String rCyl2, String lCyl2,
                       String rAxis, String lAxis, String rAxis2, String lAxis2,
                       String rDN, String lDN,
                       String rBoxes, String lBoxes, String rBoxes2, String lBoxes2,
                       String PatientFNameCart, String PatientLNameCart, String PatientFNameCart2, String PatientLNameCart2,
                       String ShippingCart,
                       String pricePerBox, String priceREye, String priceLEye, String pricePerBox2, String priceREye2, String priceLEye2,
                       String priceTotal, String rsTotal, String rsTotalAfterRebate, String rsTax, String rsRebate, String rsShipping,
                       String shippingFName, String shippingLName, String country, String state, String city, String zip,
                       String rebateNotShipped, String orderStatus, String shippingVerify,
                       String promoName, String promoProdName, String pricePromoCart, String promoItemNumber, String promoText, String sunglassesPromoLink, String promoCode)
    {
        String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + promoProdName;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + promoProdName;

        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(sunglassesPromoLink);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "SearchBrand");
        verifyPDP(brandVerifyPDP);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        typePatientName(PatientFNameCart,PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
        clickAddToCart(device);
        selectPromoCart(device,promoName);
        selectShippingCart(ShippingCart);
        takeScreenshot(screenshotTestName, "Cart");
        enterOrderCode(device,promoCode);
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

        typeCreditCard(device,CCNum);
        typeCreditCardName(device,CCName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear);
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
        verifyOrderStatusHistory(device,brandVerifyPDP,fullPatientName,rsShipping,shippingVerify,zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate,orderStatus);
        takeScreenshot(screenshotTestName, "OrderStatusHistory");
    }
        @AfterMethod
        public void tearDown(){
        driver.manage().deleteAllCookies();
    }
        @AfterClass
        public void shutDown(){
        //driver.quit();
    }
    }
