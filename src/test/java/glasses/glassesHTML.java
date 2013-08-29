package glasses;

import Automation.HTMLGlassesTestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class glassesHTML extends HTMLGlassesTestBase {

     String product = "/oakley";
    String productID = "7549";

    //change the Strings below to change the tests
/*    @BeforeMethod
    public void setUp() {


    }*/

    @Test (singleThreaded = true)
    @Parameters()
    public void test() {
        startNow(product);
        order(productID);
        quitme();
  }
}
