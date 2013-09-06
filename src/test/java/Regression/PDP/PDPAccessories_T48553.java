package Regression.PDP;

import Automation.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class PDPAccessories_T48553 extends TestBase {


    String testNumber = "48553_T";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";

    String search292 = "travel";
    String  search293 = "travel bag";
    String  search294 = "travel bottle";
    String search295 = "travel case";
    String search296 = "travel kit";

    String seperator = "/";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + typeOfPayment;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + typeOfPayment + "_" + seperator;


    @Test (singleThreaded = false)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);

        searchAllBrand(device,search292);
        verifyProduct(device,searchResultAccessoriesPage,search292);
        searchAllBrand(device,search293);
        verifyProduct(device,searchResultAccessoriesPage,search293);
        searchAllBrand(device,search294);
        verifyProduct(device,searchResultAccessoriesPage,search294);
        searchAllBrand(device,search295);
        verifyProduct(device,searchResultAccessoriesPage,search295);
        searchAllBrand(device,search296);
        verifyProduct(device,searchResultAccessoriesPage,search296);

        driver.quit();
    }
}
