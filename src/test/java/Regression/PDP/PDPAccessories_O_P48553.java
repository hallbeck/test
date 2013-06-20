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
public class PDPAccessories_O_P48553 extends TestBase {


    String testNumber = "48553O_P";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";

    String search196 = "ocuclear";
    String search197 = "Ocupure	";
    String search198 = "ocupure 55";
    String search199 = "opti";
    String search200 = "opti clean";
    String search201 = "opti free";
    String search202 = "Opti Free Express";
    String search203 = "opti free replenish";
    String search204 = "opti free solution";
    String search205 = "opti frsh";
    String search206 = "opti one";
    String search207 = "optifree";
    String search208 = "Opti-Free";
    String search209 = "optifree express";
    String search210 = "opti-free express";
    String search211 = "optifree replenish";
    String search212 = "Opti-free RepleniSH";
    String search213 = "Opti-free Solution";
    String search214 = "optifres";
    String search215 = "optione";
    String search216 = "opti-one";
    String search217 = "Optiva";
    String search218 = "protein remover";
    String search219 = "pure eyes";
    String search220 = "pureeyes";
    String search221 = "opti-free";
    String search222 = "puremoist";
    String search223 = "pure moist";
    String search224 = "Opti-Free PureMoist Drops";
    String search225 = "Opti-Free PureMoist MPS";
    String search226 = "Opti-Free Replenish MPS 2pk";


    String seperator = "/";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + typeOfPayment;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust +  "_" + typeOfPayment + "_" + seperator;


    @Test (singleThreaded = false)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);

        searchAllBrand(device,search196);
        verifyProduct(device,searchResultAccessoriesPage,search196);
        searchAllBrand(device,search197);
        verifyProduct(device,searchResultAccessoriesPage,search197);
        searchAllBrand(device,search198);
        verifyProduct(device,searchResultAccessoriesPage,search198);
        searchAllBrand(device,search199);
        verifyProduct(device,searchResultAccessoriesPage,search199);
        searchAllBrand(device,search200);
        verifyProduct(device,searchResultAccessoriesPage,search200);

        searchAllBrand(device,search201);
        verifyProduct(device,searchResultAccessoriesPage,search201);
        searchAllBrand(device,search202);
        verifyProduct(device,searchResultAccessoriesPage,search202);
        searchAllBrand(device,search203);
        verifyProduct(device,searchResultAccessoriesPage,search203);
        searchAllBrand(device,search204);
        verifyProduct(device,searchResultAccessoriesPage,search204);
        searchAllBrand(device,search205);
        verifyProduct(device,searchResultAccessoriesPage,search205);
        searchAllBrand(device,search206);
        verifyProduct(device,searchResultAccessoriesPage,search206);
        searchAllBrand(device,search207);
        verifyProduct(device,searchResultAccessoriesPage,search207);
        searchAllBrand(device,search208);
        verifyProduct(device,searchResultAccessoriesPage,search208);
        searchAllBrand(device,search209);
        verifyProduct(device,searchResultAccessoriesPage,search209);
        searchAllBrand(device,search210);
        verifyProduct(device,searchResultAccessoriesPage,search210);

        searchAllBrand(device,search211);
        verifyProduct(device,searchResultAccessoriesPage,search211);
        searchAllBrand(device,search212);
        verifyProduct(device,searchResultAccessoriesPage,search212);
        searchAllBrand(device,search213);
        verifyProduct(device,searchResultAccessoriesPage,search213);
        searchAllBrand(device,search214);
        verifyProduct(device,searchResultAccessoriesPage,search214);
        searchAllBrand(device,search215);
        verifyProduct(device,searchResultAccessoriesPage,search215);
        searchAllBrand(device,search216);
        verifyProduct(device,searchResultAccessoriesPage,search216);
        searchAllBrand(device,search217);
        verifyProduct(device,searchResultAccessoriesPage,search217);
        searchAllBrand(device,search218);
        verifyProduct(device,searchResultAccessoriesPage,search218);
        searchAllBrand(device,search219);
        verifyProduct(device,searchResultAccessoriesPage,search219);
        searchAllBrand(device,search220);
        verifyProduct(device,searchResultAccessoriesPage,search220);
        searchAllBrand(device,search221);
        verifyProduct(device,searchResultAccessoriesPage,search221);
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

        driver.quit();
    }
}
