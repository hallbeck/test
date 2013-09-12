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

    @DataProvider(name = "Prod")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\servers.xls",
                "inputsStage", "linksProd");
        return(retObjArr);
    }
    @DataProvider(name = "Stage")
    public Object[][] createData3() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\servers.xls",
                "inputsStage", "linksStage");
        return(retObjArr);
    }
    @DataProvider(name = "OneTest")
    public Object[][] createData2() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\SmokeOneinput.xls",
                "inputs", "smoke1");
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
    public void StageServers (String testNumber, String device, String typeOfTest, String page) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page;
        openWebPage(device);
        printTestNumber(printTestName);
        openPage(page);
    }
    @Test (dataProvider = "Prod")
    @Parameters(value = "device")
    public void ProdServers(String testNumber, String device, String typeOfTest, String page) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page;
        openWebPage(device);
        printTestNumber(printTestName);
        openPage(page);

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
