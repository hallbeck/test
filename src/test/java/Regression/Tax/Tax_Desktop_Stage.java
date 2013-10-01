package Regression.Tax;

import Base.ContactsTestBase;
import org.testng.annotations.*;


/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tax_Desktop_Stage extends ContactsTestBase{


    @DataProvider(name = "Tax")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Tax.xls",
                "inputsStage", "desktopTax");
        return(retObjArr);
    }
    @DataProvider(name = "OneTestTax")
         public Object[][] createData3() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Tax.xls",
                "inputs", "OneTest");
        return(retObjArr);
    }



    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test(dataProvider = "Tax")
    @Parameters(value = "device")
    public void NItest(String testNumber, String device,String typeOfTest, String typeOfCust, String typeOfPayment,
                     String searchAllBrand, String brandclick, String brandVerifyPDP,
                     String searchAllBrand2, String brandclick2, String brandVerifyPDP2,
                     String ccExpMo, String ccExpYear, String CCNum, String BadccExpMo, String BadccExpYear, String BadCCNum, String error, String CCName, String paymentType,
                     String drName, String drState,
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
                     String pricePerBox, String priceREye, String priceLEye,
                     String priceTotal, String rsTotal, String rsTotalAfterRebate, String rsTax, String rsRebate, String rsShipping,
                     String shippingFName, String shippingLName, String country, String state, String city, String zip,String bState, String bCity)
    {
        String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust;

        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        if (searchAllBrand.contains("solution")){
            clickPhoneBrand(device,brandclick);
        }
        takeScreenshot(screenshotTestName, "PDP1");
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
        try{
            typePatientName(PatientFNameCart,PatientLNameCart);
        }
        catch(Throwable e){print("must be solution, no place for a name.");
        }
        takeScreenshot(screenshotTestName, "PDP2");
        if (!searchAllBrand2.equals("")){
            clickAddRx(device);
            searchAllBrand(device,searchAllBrand2);
            if (searchAllBrand2.contains("solution")){
                clickPhoneBrand(device,brandclick2);
            }
            verifyPDP(brandVerifyPDP2);
            clickRPower(device,posR2,rPower2);
            clickLPower(device,posL2,lPower2);
            clickRBC(rBC2);
            clickLBC(lBC2);
            clickRDia(rDia2);
            clickLDia(lDia2);
            clickRCyl(rCyl2);
            clickLCyl(lCyl2);
            clickRAxis(rAxis2);
            clickLAxis(lAxis2);
            clickRColor(rColor2);
            clickLColor(lColor2);
            clickRAdd(rAdd2);
            clickLAdd(lAdd2);
            clickRDN(device,rDN);
            clickLDN(device,lDN);
            clickRboxes(rBoxes2);
            clickLboxes(lBoxes2);
            try{
                typePatientName(PatientFNameCart2,PatientLNameCart2);
            }
            catch(Throwable e){print("must be solution, no place for a name.");
            }
            takeScreenshot(screenshotTestName, "PDP3");
        }
        clickAddToCart(device);
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
        typeDoctorSearch(drName);
        typeDoctorStateAndFind(device,drState);
        takeScreenshot(screenshotTestName, "DoctorSearch");
                selectDoctor(device);

        typeCreditCard(device,CCNum);
        typeCreditCardName(device,CCName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(testNumber,"standard");
        takeScreenshot(screenshotTestName, "ThankYou");
        gotoMyAccount(device);
        takeScreenshot(screenshotTestName, "Dashboard");
        verifyDashboard(device,brandVerifyPDP,fullPatientName);
        gotoOrderStatusHistory(device);
        verifyOrderStatusHistory(device,brandVerifyPDP,fullPatientName,rsShipping,"standard",zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate,"blah",bState,bCity);
        takeScreenshot(screenshotTestName, "OrderStatusHistory");
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

