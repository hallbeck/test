package Regression.Payment;

import Base.ContactsTestBase;
import org.testng.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Payment_Phone47577 extends ContactsTestBase {

    @DataProvider(name = "PayPal")
    public Object[][] createData4() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Payment.xls",
                "inputsStage", "PhonePayPalTest");
        return(retObjArr);
    }
    @DataProvider(name = "RI")
    public Object[][] createData3() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Payment.xls",
                "inputsStage", "PhoneCcardRI");
        return(retObjArr);
    }
    @DataProvider(name = "NI")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Payment.xls",
                "inputsStage", "PhoneCcard");
        return(retObjArr);
    }
    @DataProvider(name = "OneTest")
    public Object[][] createData2() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Payment.xls",
                "inputsStage", "CcardOne");
        return(retObjArr);
    }


    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test (dataProvider = "NI")
    @Parameters(value = "device")
    public void NItest(String testNumber, String testNumberDependentOn, String device,String typeOfTest, String typeOfCust, String typeOfPayment,
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
                       String ShippingCart,
                       String pricePerBox, String priceREye, String priceLEye, String pricePerBox2, String priceREye2, String priceLEye2,
                       String priceTotal, String rsTotal, String rsTotalAfterRebate, String rsTax, String rsRebate, String rsShipping,
                       String shippingFName, String shippingLName, String country, String state, String city, String zip,String bState, String bCity,
                       String rebateNotShipped, String orderStatus, String shippingVerify,
                       String oneEyeFirstOrder,String oneEyeSecondOrder,String drLastName,String drClinicName,String drPhone)
    {
        String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
        String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + typeOfPayment;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;

        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "PDP1");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
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
                addDoctorInfo(device,drLastName,drClinicName,city,drState,drPhone);
            }
            takeScreenshot(screenshotTestName, "DoctorSearch");
            if(drName.equals("test")){
                selectDoctor(device);
            }
        }
            typeCreditCard(device,CCNum);
            typeCreditCardName(device,CCName);
            pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);
        if(!error.equals("")){
            verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
            clickBottomSubmitButton(device);
            verifyDeclinedCard(device, error);
            takeScreenshot(screenshotTestName, "DeclinedCard");
        }
        if(error.equals("")){
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
    }
    @Test (dataProvider = "RI")
    @Parameters(value = "device")
    public void RItest(String testNumber, String testNumberDependentOn,String device,String typeOfTest, String typeOfCust, String typeOfPayment,
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
                       String ShippingCart,
                       String pricePerBox, String priceREye, String priceLEye, String pricePerBox2, String priceREye2, String priceLEye2,
                       String priceTotal, String rsTotal, String rsTotalAfterRebate, String rsTax, String rsRebate, String rsShipping,
                       String shippingFName, String shippingLName, String country, String state, String city, String zip,
                       String rebateNotShipped, String orderStatus, String shippingVerify,
                       String oneEyeFirstOrder,String oneEyeSecondOrder,String drLastName,String drClinicName,String drPhone)
    {
        String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
        String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;

        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        goToSignInPage(device);
        typeReturningPhoneEmail(testNumberDependentOn);
        typeReturningPhonePassword(device,password);
        clickSignIn(device);
        clickCart_Continue(device);
        takeScreenshot(screenshotTestName, "ReviewSubmit");
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        clickBottomSubmitButton(device);
        verifyExpiredCard(device);
        takeScreenshot(screenshotTestName, "Exp_cardRI");
    }
    @Test (dataProvider = "PayPal")
    @Parameters(value = "device")
    public void PayPaltest(String testNumber, String testNumberDependentOn, String device,String typeOfTest, String typeOfCust, String typeOfPayment,
                       String searchAllBrand, String brandclick, String brandVerifyPDP,
                       String searchAllBrand2, String brandclick2, String brandVerifyPDP2,
                       String ccExpMo, String ccExpYear, String CCNum, String badEmail, String badPassword, String BadCCNum, String error, String CCName, String paymentType,
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
                       String ShippingCart,
                       String pricePerBox, String priceREye, String priceLEye, String pricePerBox2, String priceREye2, String priceLEye2,
                       String priceTotal, String rsTotal, String rsTotalAfterRebate, String rsTax, String rsRebate, String rsShipping,
                       String shippingFName, String shippingLName, String country, String state, String city, String zip, String bState, String bCity,
                       String rebateNotShipped, String orderStatus, String shippingVerify,
                       String oneEyeFirstOrder,String oneEyeSecondOrder,String drLastName,String drClinicName,String drPhone)
    {
        String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
        String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + typeOfPayment;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;

        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "PDP1");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2");
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
            takeScreenshot(screenshotTestName, "DoctorSearch");
                selectDoctor(device);
        }
        verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        payPalPayment(device,badEmail,badPassword);
        if(badEmail.equals("bad")||badPassword.equals("bad")){
            goback();
            goback();
            takeScreenshot(screenshotTestName, "ReviewSubmit_after_bad_Paypal");
            verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
        }
        if(error.equals("")){
            takeScreenshot(screenshotTestName, "ReviewSubmit");
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
