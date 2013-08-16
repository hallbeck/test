package stress;

import Automation.HTMLTestBase;
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
public class stress_productpageHTML extends HTMLTestBase {


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
    @Test (singleThreaded = false,dataProvider = "products")
    @Parameters(value = "device")
    public void productPage(String testNumber,String device,String typeOfTest,String productPage,String title) throws Exception {

        getLink(productPage,title);

    }
    @AfterClass
    public void shutDown(){
        quitme();
    }
}
