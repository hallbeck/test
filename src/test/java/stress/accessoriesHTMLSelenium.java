package stress;

import Automation.HTMLSeleniumTestBase;
import org.testng.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class accessoriesHTMLSelenium extends HTMLSeleniumTestBase {
    String BuyersGuideLink = "BuyersGuide/default.aspx";
    @DataProvider(name = "HowToOrder")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\HowToOrderInputs.xls",
                "inputsStage", "AllProducts");

        return(retObjArr);
    }
    @BeforeMethod
    public void setUp() {
        startNow("http://www.google.com");

    }
    @Test (dataProvider = "HowToOrder")
    @Parameters(value = "device")
    public void howToOrderTest(String testNumber, String device,String typeOfTest, String brand, String title)
    {
        String printTestName = typeOfTest + " | " + testNumber + " | " + brand ;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_"  + brand ;
        print(testNumber+"\n");
        goToPage(BuyersGuideLink);
        chooseBrand(device,brand);
        clickGo();
        //assertProductTitlePDP(device,title);
    }
    @AfterMethod
    public void afterMethod(){
     print("+++++++++++++++++++++++++++");
    }

    @AfterClass
    public void shutDown(){
        quitme();
    }
}
