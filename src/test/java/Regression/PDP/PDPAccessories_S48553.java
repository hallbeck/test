package Regression.PDP;

import Base.ContactsTestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class PDPAccessories_S48553 extends ContactsTestBase {


    String testNumber = "48553_S";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";

    String search240 = "solution";
    String search241 = "saliene";
    String search242 = "saline";
    String search243 = "saline solution";
    String search244 = "sauflon";
    String search245 = "sauflon uv";
    String search246 = "sensitive eyes";
    String search247 = "small aquasoft";
    String search248 = "small bottle";
    String search249 = "small bottle of solution";
    String search250 = "small no-rub solution";
    String search251 = "small solution";
    String search252 = "small solution bottle";
    String search253 = "SoftWear Saline 12 oz";
    String search254 = "solo";
    String search255 = "solo care";
    String search256 = "solocare";
    String search257 = "SOLO-Care 12 oz";
    String search258 = "Solo-Care 12 oz (Special)";
    String search259 = "solus";
    String search260 = "Solution";
    String search261 = "solution,aquasoft cleaning solution";
    String search262 = "solution,clear care";
    String search263 = "solution,clear care solution";
    String search264 = "solution,complete";
    String search265 = "solution,opti free";
    String search266 = "solution,opti free replenish";
    String search267 = "solution,optifree";
    String search268 = "solution,opti-free";
    String search269 = "solution,optifree express";
    String search270 = "solution,optifree replenish";
    String search271 = "solution,opti-free replenish";
    String search272 = "solution,renu";
    String search273 = "solution,replenish";
    String search274 = "solution,replens";
    String search275 = "solution,saline";
    String search276 = "solution,sauflon";
    String search277 = "solution,solus";
    String search278 = "solution,solution";
    String search279 = "solution,solutions";
    String search280 = "solutionclear care";
    String search281 = "solutionopti free";
    String search282 = "solutionoptifree";
    String search283 = "solutionopti-free";
    String search284 = "solutionrenu";
    String search285 = "solutionreplenish";
    String search286 = "solutionreplens";
    String search287 = "solutions";
    String search288 = "solutionsaline";
    String search289 = "solutionsauflon";
    String search290 = "solutionsolutions";
    String search291 = "systane";

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

        searchAllBrand(device,search240);
        verifyProduct(device,searchResultAccessoriesPage,search240);
        searchAllBrand(device,search241);
        verifyProduct(device,searchResultAccessoriesPage,search241);
        searchAllBrand(device,search242);
        verifyProduct(device,searchResultAccessoriesPage,search242);
        searchAllBrand(device,search243);
        verifyProduct(device,searchResultAccessoriesPage,search243);
        searchAllBrand(device,search244);
        verifyProduct(device,searchResultAccessoriesPage,search244);
        searchAllBrand(device,search245);
        verifyProduct(device,searchResultAccessoriesPage,search245);
        searchAllBrand(device,search246);
        verifyProduct(device,searchResultAccessoriesPage,search246);
        searchAllBrand(device,search247);
        verifyProduct(device,searchResultAccessoriesPage,search247);
        searchAllBrand(device,search248);
        verifyProduct(device,searchResultAccessoriesPage,search248);
        searchAllBrand(device,search249);
        verifyProduct(device,searchResultAccessoriesPage,search249);
        searchAllBrand(device,search250);
        verifyProduct(device,searchResultAccessoriesPage,search250);
        searchAllBrand(device,search251);
        verifyProduct(device,searchResultAccessoriesPage,search251);
        searchAllBrand(device,search252);
        verifyProduct(device,searchResultAccessoriesPage,search252);
        searchAllBrand(device,search253);
        verifyProduct(device,searchResultAccessoriesPage,search253);
        searchAllBrand(device,search254);
        verifyProduct(device,searchResultAccessoriesPage,search254);
        searchAllBrand(device,search255);
        verifyProduct(device,searchResultAccessoriesPage,search255);
        searchAllBrand(device,search256);
        verifyProduct(device,searchResultAccessoriesPage,search256);
        searchAllBrand(device,search257);
        verifyProduct(device,searchResultAccessoriesPage,search257);
        searchAllBrand(device,search258);
        verifyProduct(device,searchResultAccessoriesPage,search258);
        searchAllBrand(device,search259);
        verifyProduct(device,searchResultAccessoriesPage,search259);
        searchAllBrand(device,search260);
        verifyProduct(device,searchResultAccessoriesPage,search260);
        searchAllBrand(device,search261);
        verifyProduct(device,searchResultAccessoriesPage,search261);
        searchAllBrand(device,search262);
        verifyProduct(device,searchResultAccessoriesPage,search262);
        searchAllBrand(device,search263);
        verifyProduct(device,searchResultAccessoriesPage,search263);
        searchAllBrand(device,search264);
        verifyProduct(device,searchResultAccessoriesPage,search264);
        searchAllBrand(device,search265);
        verifyProduct(device,searchResultAccessoriesPage,search265);
        searchAllBrand(device,search266);
        verifyProduct(device,searchResultAccessoriesPage,search266);
        searchAllBrand(device,search267);
        verifyProduct(device,searchResultAccessoriesPage,search267);
        searchAllBrand(device,search268);
        verifyProduct(device,searchResultAccessoriesPage,search268);
        searchAllBrand(device,search269);
        verifyProduct(device,searchResultAccessoriesPage,search269);
        searchAllBrand(device,search270);
        verifyProduct(device,searchResultAccessoriesPage,search270);
        searchAllBrand(device,search271);
        verifyProduct(device,searchResultAccessoriesPage,search271);
        searchAllBrand(device,search272);
        verifyProduct(device,searchResultAccessoriesPage,search272);
        searchAllBrand(device,search273);
        verifyProduct(device,searchResultAccessoriesPage,search273);
        searchAllBrand(device,search274);
        verifyProduct(device,searchResultAccessoriesPage,search274);
        searchAllBrand(device,search275);
        verifyProduct(device,searchResultAccessoriesPage,search275);
        searchAllBrand(device,search276);
        verifyProduct(device,searchResultAccessoriesPage,search276);
        searchAllBrand(device,search277);
        verifyProduct(device,searchResultAccessoriesPage,search277);
        searchAllBrand(device,search278);
        verifyProduct(device,searchResultAccessoriesPage,search278);
        searchAllBrand(device,search279);
        verifyProduct(device,searchResultAccessoriesPage,search279);
        searchAllBrand(device,search280);
        verifyProduct(device,searchResultAccessoriesPage,search280);
        searchAllBrand(device,search281);
        verifyProduct(device,searchResultAccessoriesPage,search281);
        searchAllBrand(device,search282);
        verifyProduct(device,searchResultAccessoriesPage,search282);
        searchAllBrand(device,search283);
        verifyProduct(device,searchResultAccessoriesPage,search283);
        searchAllBrand(device,search284);
        verifyProduct(device,searchResultAccessoriesPage,search284);
        searchAllBrand(device,search285);
        verifyProduct(device,searchResultAccessoriesPage,search285);
        searchAllBrand(device,search286);
        verifyProduct(device,searchResultAccessoriesPage,search286);
        searchAllBrand(device,search287);
        verifyProduct(device,searchResultAccessoriesPage,search287);
        searchAllBrand(device,search288);
        verifyProduct(device,searchResultAccessoriesPage,search288);
        searchAllBrand(device,search289);
        verifyProduct(device,searchResultAccessoriesPage,search289);
        searchAllBrand(device,search290);
        verifyProduct(device,searchResultAccessoriesPage,search290);
        searchAllBrand(device,search291);
        verifyProduct(device,searchResultAccessoriesPage,search291);

        driver.quit();
    }
}
