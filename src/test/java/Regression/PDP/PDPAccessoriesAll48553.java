package Regression.PDP;

import Base.ContactsTestBase;
import org.testng.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class PDPAccessoriesAll48553 extends ContactsTestBase {


    @DataProvider(name = "Accessories")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\PDP.xls",
                "inputsStage", "accessories1");
        return(retObjArr);
    }
    @DataProvider(name = "OneTest")
    public Object[][] createData2() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\SmokeOneinput.xls",
                "input", "smoke1");
        return(retObjArr);
    }


    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test (dataProvider = "Accessories")
    @Parameters(value = "device")
    public void AccessoriesTest(String testNumber, String device, String typeOfTest, String product, String expected) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + product;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_Accessories_" + product;
        openWebPage(device);
        printTestNumber(printTestName);
        searchAllBrand(device,product);
        verifyProduct(device,expected,product);
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
