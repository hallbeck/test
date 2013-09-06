package Regression.OpenBugs;

import Automation.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class howToOrder_brands_46203 extends TestBase {

    String BuyersGuideLink = "BuyersGuide";

    //change the Strings below to change the tests
    @DataProvider(name = "DP1")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\HowToOrderInputs.xls",
                "inputsStage", "AllProducts");

        return(retObjArr);
    }
    @DataProvider(name = "OneTest")
    public Object[][] createData2() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\Oneinput.xls",
                "inputs", "business");
        return(retObjArr);
    }



    @BeforeMethod
    @Parameters(value = "device")
    public void setUp(String device) throws Exception {
        print("===========START TEST============="+device);
        openWebPage(device);
    }
    @Test (dataProvider = "DP1")
    @Parameters(value = "device")
    public void test(String testNumber, String device,String typeOfTest, String brand, String title)
    {

        String printTestName = typeOfTest + " | " + testNumber + " | " + brand ;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_"  + brand ;
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(BuyersGuideLink);
        chooseBrand(device,brand);
        clickGo(device);
        assertProduct(device,title);

//driver.quit();
    }
}