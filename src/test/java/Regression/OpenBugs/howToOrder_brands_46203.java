package Regression.OpenBugs;

import Base.ContactsTestBase;
import org.testng.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class howToOrder_brands_46203 extends ContactsTestBase {

    String BuyersGuideLink = "BuyersGuide/default.aspx";

    //change the Strings below to change the tests
    @DataProvider(name = "HowToOrder")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\HowToOrderInputs.xls",
                "inputsStage", "AllProducts");

        return(retObjArr);
    }
    @DataProvider(name = "OneTest")
    public Object[][] createData2() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\HowToOrderInputs.xls",
                "inputsStage", "oneTest");
        return(retObjArr);
    }

    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test (dataProvider = "HowToOrder")
    @Parameters(value = "device")
    public void howToOrderTest(String testNumber, String device,String typeOfTest, String brand, String title)
    {
        String printTestName = typeOfTest + " | " + testNumber + " | " + brand ;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_"  + brand ;
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(device,BuyersGuideLink);
        chooseBrand(device,brand);
        clickGo(device);
        assertProductTitlePDP(device,title);
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