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


    @DataProvider(name = "signin")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\signin.xls",
                "inputsStage", "desktopRI");

        return(retObjArr);
    }

    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test (dataProvider = "signin")
    @Parameters(value = "device")
    public void SigninTest(String testNumber, String testNumberDependentOn,String device,String typeOfTest, String typeOfCust, String typeOfPayment,
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
                       String oneEyeFirstOrder,String oneEyeSecondOrder,
                       String multiRxReorder)
    {
        String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
        String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;

        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        hoverSignin(device, testNumberDependentOn,password);
        assertURL("https://www.1800contactstest.com/Cart");
        takeScreenshot(screenshotTestName, "Cart1");
    }
    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
    }
    @org.junit.AfterClass
    public void shutDown(){
        driver.quit();
    }
}

