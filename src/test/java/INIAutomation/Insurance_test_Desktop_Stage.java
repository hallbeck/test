package INIAutomation;

import Base.ContactsTestBase;
import org.testng.annotations.*;


/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Insurance_test_Desktop_Stage extends ContactsTestBase{


    @DataProvider(name = "NI")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Insurance.xls",
                "inputsStage", "desktopNI");
        return(retObjArr);
    }

    @DataProvider(name = "OneTestNI")
    public Object[][] createData4() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Insurance.xls",
                "inputsStage", "OneTestNI");
        return(retObjArr);
    }


    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test(dataProvider = "NI")
    @Parameters(value = "device")
    public void NItest(String testNumber, String testNumberDependentOn, String device,String typeOfTest, String typeOfCust, String typeOfPayment,
                     String searchAllBrand, String brandclick, String brandVerifyPDP,
                     String searchAllBrand2, String brandclick2, String brandVerifyPDP2,
                     String searchAllBrand3, String brandclick3, String brandVerifyPDP3,
                     String ccExpMo, String ccExpYear, String CCNum, String BadccExpMo, String BadccExpYear, String BadCCNum, String error, String CCName, String paymentType,
                     String drName, String drState,
                     String emailPrefix, String password,
                     String posR, String posR2, String posL, String posL2, String rPower, String lPower, String rPower2, String lPower2,
                     String rBC, String lBC, String rBC2, String lBC2,
                     String rDia, String lDia, String rDia2, String lDia2,
                     String rColor, String lColor, String rColor2, String lColor2,
                     String rAdd, String lAdd, String rAdd2, String lAdd2,  //52
                     String rCyl, String lCyl, String rCyl2, String lCyl2,
                     String rAxis, String lAxis, String rAxis2, String lAxis2,
                     String rDN, String lDN,
                     String rBoxes, String lBoxes, String rBoxes2, String lBoxes2,
                     String PatientFNameCart, String PatientLNameCart, String PatientFNameCart2, String PatientLNameCart2,
                     String ShippingCart,
                     String pricePerBox, String priceREye, String priceLEye, String pricePerBox2, String priceREye2, String priceLEye2,
                     String priceTotal, String rsTotal, String rsTotalAfterRebate, String rsTax, String rsRebate, String rsShipping,
                     String shippingFName, String shippingLName, String country, String state, String city, String zip, String bState, String bCity,
                     String rebateNotShipped, String orderStatus, String shippingVerify,
                     String oneEyeFirstOrder,String oneEyeSecondOrder,
                     String patientBirth,String patientBirth2)
    {
        String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
        String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;

        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        if (searchAllBrand.equals("Acuvue")||searchAllBrand.contains("drops")
                ||searchAllBrand.contains("solution")){
            clickPhoneBrand(device,brandclick);
        }
        takeScreenshot(screenshotTestName, "PDP1");
        if (oneEyeFirstOrder.equals("R")){
            checkBoxRightEye(device);
        }
        if (oneEyeFirstOrder.equals("L")){
            checkBoxLeftEye(device);
        }
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
            if (searchAllBrand2.equals("Acuvue")||searchAllBrand2.contains("drops")
                    ||searchAllBrand2.contains("solution")){
                clickPhoneBrand(device,brandclick2);
            }
            verifyPDP(brandVerifyPDP2);
            if (oneEyeSecondOrder.equals("R")){
                checkBoxRightEye(device);
            }
            if (oneEyeSecondOrder.equals("L")){
                checkBoxLeftEye(device);
            }
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
        if (!searchAllBrand3.equals("")){
            clickAddRx(device);
            searchAllBrand(device,searchAllBrand3);
            if (searchAllBrand3.contains("drops")
                    ||searchAllBrand3.contains("solution")){
                clickPhoneBrand(device,brandclick3);
            }
            verifyPDP(brandVerifyPDP3);
            //removed power and other settings because this is intended for accessories.
            clickRboxes(rBoxes2);
            clickLboxes(lBoxes2);
            takeScreenshot(screenshotTestName, "PDP3");
        }
        clickAddToCart(device);
        if (!ShippingCart.equals("")){
            selectShippingCart(ShippingCart);
        }
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
        if (country.equals("united states")){
        typeDoctorSearch(drName);
        typeDoctorStateAndFind(device,drState);
            if(!drName.equals("test")){
                typeDoctorSearch(drName);
                typeDoctorStateAndFind(device,drState);
                typeDoctorSearch(drName);
                typeDoctorStateAndFind(device,drState);
                addDoctor(device);
                //addDoctorInfo(device,drLastName,drClinicName,city,drState,drPhone);
            }
        takeScreenshot(screenshotTestName, "DoctorSearch");
            if(drName.equals("test")){
                selectDoctor(device);
            }
        }
        if (patientBirth2.equals("")) {
            checkInsurance(device, fullPatientName, patientBirth);
        }
        if (!patientBirth2.equals("")) {
            checkInsurance2(device, fullPatientName,patientBirth,fullPatientName2,patientBirth2);
        }
        if(!BadCCNum.equals("")||BadccExpMo.equals("bad")||BadccExpYear.equals("bad")){
            if(!BadCCNum.equals("")){
                typeCreditCard(device,BadCCNum);
            }
            if(BadCCNum.equals("")){
                typeCreditCard(device,CCNum);
            }
            typeCreditCardName(device, CCName);
            if(BadccExpMo.equals("bad")||BadccExpYear.equals("bad")){
                pickCreditCardExpDate(device, BadccExpMo, BadccExpYear,paymentType);
            }
            if(BadccExpMo.equals("")||BadccExpYear.equals("")){
                pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);
            }
            clickBottomSubmitButton(device);
            verifyDeclinedCard(device, error);
            takeScreenshot(screenshotTestName, "DeclinedCard");
            goToCart1Item(device);
            clickCart_Continue(device);
        }
        typeCreditCard(device,CCNum);
        typeCreditCardName(device,CCName);
        pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);


        takeScreenshot(screenshotTestName, "ReviewSubmit");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyThankYouPage(testNumber,shippingVerify);
        takeScreenshot(screenshotTestName, "ThankYou");
        gotoMyAccount(device);
        takeScreenshot(screenshotTestName, "Dashboard");
        verifyDashboard(device,brandVerifyPDP,fullPatientName);
        gotoOrderStatusHistory(device);
        verifyOrderStatusHistory(device,brandVerifyPDP,fullPatientName,rsShipping,shippingVerify,zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate,orderStatus,bState,bCity);
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

