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
public class PDPAccessories_F_L48553 extends TestBase {


    String testNumber = "48553F_L";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";

    String search159 = "Focus Aqua";
    String  search160 = "Focus Drops";
    String  search161 = "focus lubricating drops";
    String  search162 = "Focus Rewetting drops";
    String  search163 = "Focus wetting drops";
    String  search164 = "holder";
    String  search165 = "hydrating";
    String  search166 = "lens case";
    String   search167 = "Lens Cases";
    String  search168 = "lens cleaner";
    String  search169 = "lens cleaners";
    String  search170 = "lens drops";
    String  search171 = "lens plus";
    String  search172 = "Lens Solution";
    String   search173 = "lens solutions";
    String   search174 = "lense case";
    String   search175 = "lense cases";
    String  search176 = "lense cleaner";
    String search177 = "limited quantities";
    String search178 = "lubricant eye drops";

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

        searchAllBrand(device,search159);
        verifyProduct(device,searchResultAccessoriesPage,search159);
        searchAllBrand(device,search160);
        verifyProduct(device,searchResultAccessoriesPage,search160);
        searchAllBrand(device,search161);
        verifyProduct(device,searchResultAccessoriesPage,search161);
        searchAllBrand(device,search162);
        verifyProduct(device,searchResultAccessoriesPage,search162);
        searchAllBrand(device,search163);
        verifyProduct(device,searchResultAccessoriesPage,search163);
        searchAllBrand(device,search164);
        verifyProduct(device,searchResultAccessoriesPage,search164);
        searchAllBrand(device,search165);
        verifyProduct(device,searchResultAccessoriesPage,search165);
        searchAllBrand(device,search166);
        verifyProduct(device,searchResultAccessoriesPage,search166);
        searchAllBrand(device,search167);
        verifyProduct(device,searchResultAccessoriesPage,search167);
        searchAllBrand(device,search168);
        verifyProduct(device,searchResultAccessoriesPage,search168);
        searchAllBrand(device,search169);
        verifyProduct(device,searchResultAccessoriesPage,search169);
        searchAllBrand(device,search170);
        verifyProduct(device,searchResultAccessoriesPage,search170);
        searchAllBrand(device,search171);
        verifyProduct(device,searchResultAccessoriesPage,search171);
        searchAllBrand(device,search172);
        verifyProduct(device,searchResultAccessoriesPage,search172);
        searchAllBrand(device,search173);
        verifyProduct(device,searchResultAccessoriesPage,search173);
        searchAllBrand(device,search174);
        verifyProduct(device,searchResultAccessoriesPage,search174);
        searchAllBrand(device,search175);
        verifyProduct(device,searchResultAccessoriesPage,search175);
        searchAllBrand(device,search176);
        verifyProduct(device,searchResultAccessoriesPage,search176);
        searchAllBrand(device,search177);
        verifyProduct(device,searchResultAccessoriesPage,search177);
        searchAllBrand(device,search178);
        verifyProduct(device,searchResultAccessoriesPage,search178);

        driver.quit();
    }
}
