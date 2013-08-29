package stress;

import Automation.HTMLSeleniumTestBase;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class stress_productpageHTMLSelenium extends HTMLSeleniumTestBase {

    @DataProvider(name = "products")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\StressInputs.xls",
                "inputsStage", "AllProductsTEST");
        return(retObjArr);
    }
    @BeforeMethod
    public void setUp() {
        startNow("http://www.google.com");

    }
    @Test (singleThreaded = true,dataProvider = "products")
    @Parameters()
    public void productPage(String testNumber,String productPage,String title) {
        print(testNumber+"\n");
        getLink(productPage, title);
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
