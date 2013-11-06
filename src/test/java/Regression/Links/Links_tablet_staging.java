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
public class Links_tablet_staging extends ContactsTestBase {

    @DataProvider(name = "Links")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Links.xls",
                "inputsStage", "tabletlinks");
        return(retObjArr);
    }
    @DataProvider(name = "Email")
    public Object[][] createData3() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Links.xls",
                "inputsStage", "tabletemail");
        return(retObjArr);
    }
    @DataProvider(name = "ClickLinks")
    public Object[][] createData4() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Links.xls",
                "inputsStage", "tabletclicklinks");
        return(retObjArr);
    }
    @DataProvider(name = "Other")
    public Object[][] createData5() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Links.xls",
                "inputsStage", "tabletotherlinks");
        return(retObjArr);
    }
    @DataProvider(name = "OneTest")
    public Object[][] createData2() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Links.xls",
                "inputsStage", "onetest");
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
        printTestNumber(printTestName);
        gotoPage(device,page);
        clickAndAssertLink(link,title,tag);
        takeScreenshot(screenshotTestName, link);
    }
    @Test (dataProvider = "Email")
    @Parameters(value = "device")
    public void EmailLinkTest(String testNumber, String device, String typeOfTest, String page, String link, String title, String tag) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page + " | " + link + " | " + title;
        printTestNumber(printTestName);
        gotoPage(device,page);
        clickAndVerifyEmail(link,title);
    }
    @Test (dataProvider = "ClickLinks")
    @Parameters(value = "device")
    public void ClickLinkTest(String testNumber, String device, String typeOfTest, String link1, String verify1, String expected1, String tag1) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + link1 + " | " + expected1;
        printTestNumber(printTestName);
        clickLink(link1);
        verifyTagContains(tag1,verify1,expected1);
    }
    @Test (dataProvider = "Other")
    @Parameters(value = "device")
    public void OtherLinkTest(String testNumber, String device, String typeOfTest, String page, String para, String title, String tag) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + page + " | " + para + " | " + title;
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(device,page);
        if (!title.equals("")){
            verifyPageTitle(title);
        }
        if (!para.equals("")){
            verifyPagePara(para);
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
