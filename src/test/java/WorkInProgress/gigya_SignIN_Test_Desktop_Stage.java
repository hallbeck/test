package WorkInProgress;

import Base.ContactsTestBase;
import org.testng.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class gigya_SignIN_Test_Desktop_Stage extends ContactsTestBase {


    @DataProvider(name = "gigya")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\signin.xls",
                "inputsStage", "desktopGigya");

        return(retObjArr);
    }

    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test (dataProvider = "gigya")
    @Parameters(value = "device")
    public void FBLoginTest(String testNumber, String testNumberDependentOn,String device,String typeOfTest, String typeOfCust, String typeOfPayment,
                       String searchAllBrand, String brandclick, String brandVerifyPDP,
                       String FBPassword, String AmazonPassword, String GooglePassword,
                       String FBEmail, String AmazonEmail, String GoogleEmail,
                       String ccExpMo, String ccExpYear, String CCNum, String BadccExpMo, String BadccExpYear, String BadCCNum, String error, String CCName, String paymentType,
                       String drName, String drState,
                       String webEmail, String password,
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
                       String typeFirstOrder,String typeSecondOrder,
                       String placeOrder)
    {
        String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
        String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;

        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        print("COOKIE BEFORE: ") ;
        verifyCookie();
        if (typeFirstOrder.equalsIgnoreCase("fb")) {
        hoverSigninFacebook(device,FBEmail,FBPassword);
        }
        else if (typeFirstOrder.equalsIgnoreCase("amazon")) {
            hoverSigninAmazon(device,AmazonEmail,AmazonPassword);
        }
        else if (typeFirstOrder.equalsIgnoreCase("google")) {
            hoverSigninGoogle(device,GoogleEmail,GooglePassword);
        }
        else if (typeFirstOrder.equalsIgnoreCase("web")) {
          //do nothing, you are a ni
        }

        if (placeOrder.equals("yes")){
            clickFindBrand(device);
            searchAllBrand(device,searchAllBrand);
            takeScreenshot(screenshotTestName, "PDP1");
            clickRPower(device,posR,rPower);
            clickLPower(device,posL,lPower);
            typePatientName(PatientFNameCart, PatientLNameCart);
            takeScreenshot(screenshotTestName, "PDP2");
            clickAddToCart(device);
            takeScreenshot(screenshotTestName, "Cart");
            verifyCart(device,brandVerifyPDP,PatientFNameCart + " " + PatientLNameCart,pricePerBox,priceREye,priceLEye,priceTotal);
            clickCart_Continue(device);
            clickCountry(country);
            typeShippingState(country,state);
            typeShippingAddress();
            typeShippingCity(city);
            typeShippingZip(zip);
            typeShippingPhone(device);
            if (typeFirstOrder.equalsIgnoreCase("web")) {
                typeShippingGivenEmail(webEmail,testNumber);
                typePassword_newcust(password);
            }
            takeScreenshot(screenshotTestName, "NewAddress");
            clickNewAddress_Continue();
            if (country.equals("united states")){
                typeDoctorSearch(drName);
                typeDoctorStateAndFind(device,drState);
                takeScreenshot(screenshotTestName, "DoctorSearch");
                if(drName.equals("test")){
                    selectDoctor(device);
                }
            }
            typeCreditCard(device,CCNum);
            typeCreditCardName(device,CCName);
            pickCreditCardExpDate(device,ccExpMo, ccExpYear,paymentType);
            takeScreenshot(screenshotTestName, "ReviewSubmit1");
            verifyRS(device,brandVerifyPDP, PatientFNameCart, pricePerBox, priceREye, priceLEye, priceTotal, rsTax, rsTotal, rsTotalAfterRebate, rsRebate, rsShipping);
            clickBottomSubmitButton(device);
            verifyThankYouPage(testNumber,shippingVerify);
            takeScreenshot(screenshotTestName, "ThankYou1");
            gotoMyAccount(device);
            takeScreenshot(screenshotTestName, "Dashboard1");
            verifyDashboard(device,brandVerifyPDP,fullPatientName);
            gotoOrderStatusHistory(device);
            verifyOrderStatusHistory(device,brandVerifyPDP,fullPatientName,rsShipping,shippingVerify,zip,city,rsTax,rsTotal,rsRebate,rsTotalAfterRebate,orderStatus,bState,bCity);
            takeScreenshot(screenshotTestName, "OrderStatusHistory1");
        }
        clickSignOut(device);
        driver.manage().deleteAllCookies();
        if (typeSecondOrder.equalsIgnoreCase("fb")) {
            hoverSigninFacebook(device,FBEmail,FBPassword);
        }
        else if (typeSecondOrder.equalsIgnoreCase("amazon")) {
            hoverSigninAmazon(device,AmazonEmail,AmazonPassword);
        }
        else if (typeSecondOrder.equalsIgnoreCase("google")) {
            hoverSigninGoogle(device,GoogleEmail,GooglePassword);
        }
        else if (typeSecondOrder.equalsIgnoreCase("web")) {
            hoverSigninGivenEmail(device,webEmail,password);
            clickSendEmailButton(device);
            print("MUST TEST MANUALLY:\n check qtest87@gmail.com for password reset emial.\n click the link and you should be brought to a age to enter a new password.\n you should see the account info and order info from the social login.");
        }

    }
    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        print("COOKIE AFTER: ") ;
        verifyCookie();
    }
    @org.junit.AfterClass
    public void shutDown(){
        //.quit();
    }
}

