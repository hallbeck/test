package Regression.PDP;

import Automation.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class PDPAccessories_U_Z48553 extends TestBase {


    String testNumber = "48553";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";
    String zaditorResultsPage = "ZADITOR® Eye Drops 2pk";
    String search15 = "Zaditor";
    String search16 = "2 ounce solution";
    String search17 = "2oz";
    String search18 = "2oz solution";
    String search19 = "visine";
    String search20 = "wetting drops";
    String search21 = "wetting solution";
    String search22 = "Zaditor Eye Drops 2pk";

    String seperator = "\\";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust +  " | " + typeOfPayment;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + typeOfPayment + "_" + seperator;


    @Test (singleThreaded = false)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);

        searchAllBrand(device,search15);
        verifyProduct(device,zaditorResultsPage,search15);
        searchAllBrand(device,search16);
        verifyProduct(device,searchResultAccessoriesPage,search16);
        searchAllBrand(device,search17);
        verifyProduct(device,searchResultAccessoriesPage,search17);
        searchAllBrand(device,search18);
        verifyProduct(device,searchResultAccessoriesPage,search18);
        searchAllBrand(device,search19);
        verifyProduct(device,searchResultAccessoriesPage,search19);
        searchAllBrand(device,search20);
        verifyProduct(device,searchResultAccessoriesPage,search20);
        searchAllBrand(device,search21);
        verifyProduct(device,searchResultAccessoriesPage,search21);
        searchAllBrand(device,search22);
        verifyProduct(device,zaditorResultsPage,search21);
        driver.quit();
    }
}
