package Regression.Rebates;

import Base.ContactsTestBase;
import org.testng.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rebates_48580_Prod_SiteSpect extends ContactsTestBase {

    @DataProvider(name = "Rebates")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\RebatesSiteSpect.xls",
                "inputsStage", "rebatesNI");
        return(retObjArr);
    }

    @DataProvider(name = "OneTestRebates")
    public Object[][] createData4() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\RebatesOneinput.xls",
                "inputs", "rebatesNI");
        return(retObjArr);
    }


    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPageSiteSpect(device);
    }
    @Test(dataProvider = "Rebates")
    @Parameters(value = "device")
    public void NItest(String testNumber, String orderNumberPlaceholder, String device,String typeOfTest, String typeOfCust, String typeOfPayment,
                       String searchAllBrand, String rebatesAvailable, String rebateTextRS,
                       String rebate6Month, String rebate12Month, String rebateShipped, String brandVerifyPDP,
                       String ccExpMo, String ccExpYear, String CCNum, String CCName, String paymentType,
                       String emailPrefix, String password,
                       String posR, String posL, String rPower, String lPower,
                       String rBC, String lBC,
                       String rDia, String lDia,
                       String rColor, String lColor,
                       String rAdd, String lAdd,
                       String rCyl, String lCyl,
                       String rAxis, String lAxis,
                       String rDN, String lDN,
                       String rBoxes, String lBoxes, String rBoxes2, String lBoxes2,
                       String PatientFNameCart, String PatientLNameCart,
                       String ShippingCart,
                       String pricePerBox, String priceREye, String priceLEye, String pricePerBox2, String priceREye2, String priceLEye2,
                       String priceTotal, String rsTotal, String rsTotalAfterRebate, String rsTax, String rsShipping,
                       String shippingFName, String shippingLName, String country, String state, String city, String zip,String bState, String bCity,
                       String rebateNotShipped, String brandclick, String shippingVerify)
    {
        String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust  + " | " + typeOfPayment + " | " + shippingVerify;
        String screenshotTestName =  "SiteSpect_" + "Variation2_"+testNumber;
        printTestNumber(printTestName);

        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        if (searchAllBrand.equals("acuvue")||searchAllBrand.equals("acuvue advance")||searchAllBrand.equals("proclear")||searchAllBrand.equals("purevision")||searchAllBrand.contains("drops")
                ||searchAllBrand.contains("solution")){
            clickPhoneBrand(device,brandVerifyPDP);
        }
        takeScreenshot(screenshotTestName, "PDP1_");
        print(rebatesAvailable);
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        clickRDia(rDia);
        clickLDia(lDia);
        clickRCyl(rCyl);
        clickLCyl(lCyl);
        clickRAxis(rAxis);
        clickLAxis(lAxis);
        clickRColor(rColor);
        clickLColor(lColor);
        clickRAdd(rAdd);
        clickLAdd(lAdd);
        clickRDN(device,rDN);
        clickLDN(device,lDN);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2_");
        clickAddToCart(device);
        minSiteSpect();
        verifyRebateCart(device,rebate6Month);
        clickCart_Continue(device);
        minSiteSpect();
        typeShippingName(shippingFName,shippingLName);
        typeShippingAddress();
        clickCountry(country);
        typeShippingState(country,state);
        typeShippingCity(city);
        typeShippingZip(zip);
        typeShippingPhone(device);
        typeShippingEmail(emailPrefix,testNumber);
        typePassword_newcust(password);
        clickNewAddress_Continue();
        verifyRebateRS(device,rebate6Month,rebateTextRS);
        appendToFile("sitespect.txt", iMoY+"_"+iDay+"_"+iYr+"_"+iToD);
        if (!rebate12Month.equals("")){
            goToCart(device);
            minSiteSpect();
            clickRemove(device);
            clickFindBrand(device);
            searchAllBrand(device,searchAllBrand);
            if (searchAllBrand.equals("Acuvue")||searchAllBrand.contains("drops")
                    ||searchAllBrand.contains("solution")){
                clickPhoneBrand(device,brandVerifyPDP);
            }
            print(rebatesAvailable);
            clickRPower(device,posR,rPower);
            clickLPower(device,posL,lPower);
            clickRBC(rBC);
            clickLBC(lBC);
            clickRDia(rDia);
            clickLDia(lDia);
            clickRCyl(rCyl);
            clickLCyl(lCyl);
            clickRAxis(rAxis);
            clickLAxis(lAxis);
            clickRColor(rColor);
            clickLColor(lColor);
            clickRAdd(rAdd);
            clickLAdd(lAdd);
            clickRDN(device,rDN);
            clickLDN(device,lDN);
            clickRboxes(rBoxes2);
            clickLboxes(lBoxes2);
            typePatientName(PatientFNameCart, PatientLNameCart);
            takeScreenshot(screenshotTestName, "PDP3_");
            clickAddToCart(device);
            verifyRebateCart(device,rebate12Month);
            clickCart_Continue(device);
            verifyRebateRS(device,rebate12Month,rebateTextRS);
        }
        //typeCreditCard(device,CCNum);
       //typeCreditCardName(device,CCName);
       // pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);
        //takeScreenshot(screenshotTestName, "ReviewSubmit");
        //shipOrder(testNumber);
        //getRebate(device,orderNumberPlaceholder,rebateShipped);
    }
    @AfterMethod
    public void tearDown(){

        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void shutDown(){
        driver.quit();
    }
}
