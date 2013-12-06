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
public class BP_Copy_53976 extends ContactsTestBase {


    @DataProvider(name = "BP")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\PDPCopy.xls",
                "inputsStage", "pdpCopy");
        return(retObjArr);
    }
    @DataProvider(name = "BPError")
    public Object[][] createData3() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\PDPCopy.xls",
                "inputsStage", "pdpError");
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
    @Test (dataProvider = "BP")
    @Parameters(value = "device")
    public void bPTest(String testNumber, String device, String typeOfTest, String id,String product, String expected) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + product;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + product;
        printTestNumber(printTestName);
        gotoPage(device,product);
        takeScreenshot(screenshotTestName, "BP");
        verifyBPCopy(device,id,expected);
    }
    @Test (dataProvider = "BPError")
    @Parameters(value = "device")
    public void bPTestError(String testNumber, String device, String typeOfTest, String id,String product, String expected) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + product;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + product;
        printTestNumber(printTestName);
        gotoPage(device,product);
        verifyBPCopy(device,id,expected);
        takeScreenshot(screenshotTestName, "BP");
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
