package Regression.Links;

import Base.ContactsTestBase;
import org.testng.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Links50356 extends ContactsTestBase {

    @DataProvider(name = "Links")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Links.xls",
                "inputsStage", "links");
        return(retObjArr);
    }
    @DataProvider(name = "Email")
    public Object[][] createData3() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Links.xls",
                "inputsStage", "email");
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
    @Test (dataProvider = "Links")
    @Parameters(value = "device")
    public void LinksTest(String testNumber, String device, String typeOfTest, String page, String link, String title, String tag) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page + " | " + link + " | " + title;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_Links" + link;
        openWebPage(device);
        printTestNumber(printTestName);
        gotoPage(page);
        clickAndAssertLink(link,title,tag);
        takeScreenshot(screenshotTestName, link);
    }
    @Test (dataProvider = "Email")
    @Parameters(value = "device")
    public void EmailLinkTest(String testNumber, String device, String typeOfTest, String page, String link, String title, String tag) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page + " | " + link + " | " + title;
        openWebPage(device);
        printTestNumber(printTestName);
        gotoPage(page);
        clickAndVerifyEmail(link,title);
    }
    @Test (dataProvider = "ClickLinks")
    @Parameters(value = "device")
    public void ClickLinkTest(String testNumber, String device, String typeOfTest, String page, String link, String title, String tag) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page + " | " + link + " | " + title;
        openWebPage(device);
        printTestNumber(printTestName);
        gotoPage(page);
        clickAndVerifyEmail(link,title);
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
