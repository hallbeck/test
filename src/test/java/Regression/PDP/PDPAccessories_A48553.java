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
public class PDPAccessories_A48553 extends TestBase {


    String testNumber = "48553_A";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";
    String search1 = "Accessories";
    String search2 = "Antihistamine";
    String search3 = "Alcon";
    String search4 = "accessories";
    String search5 = "ActiFresh 400";
    String search6 = "additions";
    String search7 = "aeosept";
    String search8 = "Alcon Opti-Free";
    String search9 = "ao sept";
    String search10 = "Ao spet";
    String search11 = "aosept";
    String search12 = "aosept clear care";
    String search13 = "aosept solution";
    String search14 = "aqua sof";
    String search15 = "aqua soft";
    String search16 = "Aqua Soft Multi-purpose solution";
    String search17 = "aqua soft rewetting drops";
    String search18 = "Aqua Soft solution";
    String search19 = "aquaflex";
    String search20 = "aquafy";
    String search21 = "aquafy solution";
    String search22 = "AquaSoft";
    String search23 = "AquaSoft cleaning solution";
    String search24 = "aquasoft drops";
    String search25 = "AquaSoft No-Rub Solution";
    String search26 = "Aquasoft rewetting drops";
    String search27 = "AquaSoft Re-Wetting Drops";
    String search28 = "aquasoft solution";
    String search29 = "AquaSoft Solution Bonus";
    String search30 = "AquaSoft Total Package";
    String search31 = "aquasofta";
    String search32 = "aquify";
    String search33 = "Aquify 12 oz No Rub Solution";
    String search34 = "Aquify no rub solution";
    String search35 = "Aquify norub solution";
    String search36 = "Aquify no-rub solution";
    String search37 = "aquify solution";
    String search38 = "Aquify Solution Bonus 4-pack";
    String search39 = "Aquify Total Package";


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
        searchAllBrand(device,search1);
        verifyProduct(device,searchResultAccessoriesPage,search1);
        searchAllBrand(device,search2);
        verifyProduct(device,searchResultAccessoriesPage,search2);
        searchAllBrand(device,search3);
        verifyProduct(device,searchResultAccessoriesPage,search3);
        searchAllBrand(device,search4);
        verifyProduct(device,searchResultAccessoriesPage,search4);
        searchAllBrand(device,search5);
        verifyProduct(device,searchResultAccessoriesPage,search5);
        searchAllBrand(device,search6);
        verifyProduct(device,searchResultAccessoriesPage,search6);
        searchAllBrand(device,search7);
        verifyProduct(device,searchResultAccessoriesPage,search7);
        searchAllBrand(device,search8);
        verifyProduct(device,searchResultAccessoriesPage,search8);
        searchAllBrand(device,search9);
        verifyProduct(device,searchResultAccessoriesPage,search9);
        searchAllBrand(device,search10);
        verifyProduct(device,searchResultAccessoriesPage,search10);
        searchAllBrand(device,search11);
        verifyProduct(device,searchResultAccessoriesPage,search11);
        searchAllBrand(device,search12);
        verifyProduct(device,searchResultAccessoriesPage,search12);
        searchAllBrand(device,search13);
        verifyProduct(device,searchResultAccessoriesPage,search13);
        searchAllBrand(device,search14);
        verifyProduct(device,searchResultAccessoriesPage,search14);
        searchAllBrand(device,search15);
        verifyProduct(device,searchResultAccessoriesPage,search15);
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
        verifyProduct(device,searchResultAccessoriesPage,search22);
        searchAllBrand(device,search23);
        verifyProduct(device,searchResultAccessoriesPage,search23);
        searchAllBrand(device,search24);
        verifyProduct(device,searchResultAccessoriesPage,search24);
        searchAllBrand(device,search25);
        verifyProduct(device,searchResultAccessoriesPage,search25);
        searchAllBrand(device,search26);
        verifyProduct(device,searchResultAccessoriesPage,search26);
        searchAllBrand(device,search27);
        verifyProduct(device,searchResultAccessoriesPage,search27);
        searchAllBrand(device,search28);
        verifyProduct(device,searchResultAccessoriesPage,search28);
        searchAllBrand(device,search29);
        verifyProduct(device,searchResultAccessoriesPage,search29);
        searchAllBrand(device,search30);
        verifyProduct(device,searchResultAccessoriesPage,search30);
        searchAllBrand(device,search31);
        verifyProduct(device,searchResultAccessoriesPage,search31);
        searchAllBrand(device,search32);
        verifyProduct(device,searchResultAccessoriesPage,search32);
        searchAllBrand(device,search33);
        verifyProduct(device,searchResultAccessoriesPage,search33);
        searchAllBrand(device,search34);
        verifyProduct(device,searchResultAccessoriesPage,search34);
        searchAllBrand(device,search35);
        verifyProduct(device,searchResultAccessoriesPage,search35);
        searchAllBrand(device,search36);
        verifyProduct(device,searchResultAccessoriesPage,search36);
        searchAllBrand(device,search37);
        verifyProduct(device,searchResultAccessoriesPage,search37);
        searchAllBrand(device,search38);
        verifyProduct(device,searchResultAccessoriesPage,search38);
        searchAllBrand(device,search39);
        verifyProduct(device,searchResultAccessoriesPage,search39);

        driver.quit();
    }
}
