package stress;

import Automation.TestBase;
import org.testng.annotations.AfterClass;
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
public class stress_productpage extends TestBase {


    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String seperator = "/";


    @DataProvider(name = "products")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\StressInputs.xls",
                "inputsStage", "AllProducts");
        return(retObjArr);
    }
    @Test (dataProvider = "products")
    @Parameters(value = "device")
    public void test(String testNumber,String device,String typeOfTest,String productPage,String title) {
        String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + typeOfPayment;
        String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + typeOfPayment + "_" + seperator;
        openWebPage(device);
        printTestNumber(printTestName);
        gotoPageCookie(productPage);
        assertTag("H1",title);
        //pressKey();
        refresh();
        verifyTag("H1",title);
        refresh();
        verifyTag("H1",title);
        refresh();
        verifyTag("H1",title);
        refresh();
        verifyTag("H1",title);
        refresh();
        verifyTag("H1",title);
        refresh();
        verifyTag("H1",title);
        refresh();
        verifyTag("H1",title);
        refresh();
        verifyTag("H1",title);
    }
    @AfterClass
    public void shutDown(){
        driver.quit();
    }
}
