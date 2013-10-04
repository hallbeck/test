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
public class hitServers extends ContactsTestBase {

    @DataProvider(name = "Prod30_35")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\servers.xls",
                "inputsStage", "linksProd1");
        return(retObjArr);
    }
    @DataProvider(name = "Prod36_38")
    public Object[][] createData4() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\servers.xls",
                "inputsStage", "linksProd2");
        return(retObjArr);
    }
    @DataProvider(name = "Stage")
    public Object[][] createData3() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\servers.xls",
                "inputsStage", "linksStage");
        return(retObjArr);
    }
    @DataProvider(name = "39")
    public Object[][] createData2() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\servers.xls",
                "inputsStage", "links39");
        return(retObjArr);
    }

    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test (dataProvider = "Stage")
    @Parameters(value = "device")
    public void StageServers (String testNumber, String device, String typeOfTest, String page, String tag, String version) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page;
        openWebPage(device);
        printTestNumber(printTestName);
        openPage(page);
        verifyVersion(device,page,tag,version);
    }
    @Test (dataProvider = "Prod30_35")
         @Parameters(value = "device")
         public void ProdServers(String testNumber, String device, String typeOfTest, String page, String tag, String version) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page;
        openWebPage(device);
        printTestNumber(printTestName);
        openPage(page);
        verifyVersion(device,page,tag,version);
    }
    @Test (dataProvider = "Prod36_38")
    @Parameters(value = "device")
    public void ProdServers2(String testNumber, String device, String typeOfTest, String page, String tag, String version) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page;
        openWebPage(device);
        printTestNumber(printTestName);
        openPage(page);
        verifyVersion(device,page,tag,version);
    }
    @Test (dataProvider = "39")
    @Parameters(value = "device")
    public void prod39Servers(String testNumber, String device, String typeOfTest, String page, String tag, String version) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page;
        openWebPage(device);
        printTestNumber(printTestName);
        openPage(page);
        verifyVersion(device,page,tag,version);

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
