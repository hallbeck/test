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
public class PDPAccessories_M_N48553 extends TestBase {


    String testNumber = "48553M_N";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";

    String   search179 = "miraflow";
    String   search180 = "mirror";
    String  search181 = "moisture";
    String  search182 = "moisture drops";
    String  search183 = "moisture loc";
    String  search184 = "moisture lock";
    String  search185 = "moistureloc";
    String  search186 = "moisturelock";
    String  search187 = "multiplus";
    String  search188 = "multipurpose";
    String   search189 = "multi-purpose";
    String  search190 = "multipurpose solution";
    String  search191 = "multi-purpose solution";
    String  search192 = "no rub";
    String   search193 = "no rub solution";
    String   search194 = "norub";
    String  search195 = "no-rub";


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

        searchAllBrand(device,search179);
        verifyProduct(device,searchResultAccessoriesPage,search179);
        searchAllBrand(device,search180);
        verifyProduct(device,searchResultAccessoriesPage,search180);
        searchAllBrand(device,search181);
        verifyProduct(device,searchResultAccessoriesPage,search181);
        searchAllBrand(device,search182);
        verifyProduct(device,searchResultAccessoriesPage,search182);
        searchAllBrand(device,search183);
        verifyProduct(device,searchResultAccessoriesPage,search183);
        searchAllBrand(device,search184);
        verifyProduct(device,searchResultAccessoriesPage,search184);
        searchAllBrand(device,search185);
        verifyProduct(device,searchResultAccessoriesPage,search185);
        searchAllBrand(device,search186);
        verifyProduct(device,searchResultAccessoriesPage,search186);
        searchAllBrand(device,search187);
        verifyProduct(device,searchResultAccessoriesPage,search187);
        searchAllBrand(device,search188);
        verifyProduct(device,searchResultAccessoriesPage,search188);
        searchAllBrand(device,search189);
        verifyProduct(device,searchResultAccessoriesPage,search189);
        searchAllBrand(device,search190);
        verifyProduct(device,searchResultAccessoriesPage,search190);
        searchAllBrand(device,search191);
        verifyProduct(device,searchResultAccessoriesPage,search191);
        searchAllBrand(device,search192);
        verifyProduct(device,searchResultAccessoriesPage,search192);
        searchAllBrand(device,search193);
        verifyProduct(device,searchResultAccessoriesPage,search193);
        searchAllBrand(device,search194);
        verifyProduct(device,searchResultAccessoriesPage,search194);
        searchAllBrand(device,search195);
        verifyProduct(device,searchResultAccessoriesPage,search195);

        driver.quit();
    }
}
