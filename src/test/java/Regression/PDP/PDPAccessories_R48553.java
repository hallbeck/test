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
public class PDPAccessories_R48553 extends TestBase {


    String testNumber = "48553_R";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";
    String  search222 = "re wetting drops";
    String  search223 = "refresh";
    String  search224 = "refresh contact drops";
    String  search225 = "refresh plus";
    String  search226 = "refresh tears";
    String   search227 = "renew";
    String   search228 = "renu";
    String  search229 = "ReNu MultiPlus";
    String  search230 = "renu no rub";
    String  search231 = "renu solution";
    String  search232 = "renu with moistureloc";
    String  search233 = "renue";
    String  search234 = "replenish";
    String  search235 = "Replens";
    String  search236 = "rewet";
    String  search237 = "rewetting";
    String  search238 = "re-wetting";
    String   search239 = "rewetting drops";
    String   search240 = "rewetting solution";


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

        searchAllBrand(device,search222);
        verifyProduct(device,searchResultAccessoriesPage,search222);
        searchAllBrand(device,search223);
        verifyProduct(device,searchResultAccessoriesPage,search223);
        searchAllBrand(device,search224);
        verifyProduct(device,searchResultAccessoriesPage,search224);
        searchAllBrand(device,search225);
        verifyProduct(device,searchResultAccessoriesPage,search225);
        searchAllBrand(device,search226);
        verifyProduct(device,searchResultAccessoriesPage,search226);
        searchAllBrand(device,search227);
        verifyProduct(device,searchResultAccessoriesPage,search227);
        searchAllBrand(device,search228);
        verifyProduct(device,searchResultAccessoriesPage,search228);
        searchAllBrand(device,search229);
        verifyProduct(device,searchResultAccessoriesPage,search229);
        searchAllBrand(device,search230);
        verifyProduct(device,searchResultAccessoriesPage,search230);
        searchAllBrand(device,search231);
        verifyProduct(device,searchResultAccessoriesPage,search231);
        searchAllBrand(device,search232);
        verifyProduct(device,searchResultAccessoriesPage,search232);
        searchAllBrand(device,search233);
        verifyProduct(device,searchResultAccessoriesPage,search233);
        searchAllBrand(device,search234);
        verifyProduct(device,searchResultAccessoriesPage,search234);
        searchAllBrand(device,search235);
        verifyProduct(device,searchResultAccessoriesPage,search235);
        searchAllBrand(device,search236);
        verifyProduct(device,searchResultAccessoriesPage,search236);
        searchAllBrand(device,search237);
        verifyProduct(device,searchResultAccessoriesPage,search237);
        searchAllBrand(device,search238);
        verifyProduct(device,searchResultAccessoriesPage,search238);
        searchAllBrand(device,search239);
        verifyProduct(device,searchResultAccessoriesPage,search239);
        searchAllBrand(device,search240);
        verifyProduct(device,searchResultAccessoriesPage,search240);
        driver.quit();
    }
}
