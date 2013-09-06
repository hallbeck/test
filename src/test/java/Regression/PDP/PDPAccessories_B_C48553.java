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
public class PDPAccessories_B_C48553 extends TestBase {


    String testNumber = "48553_B_C";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";
    String searchResultBiotrue = "BioTrue ONEDay 90 pack";
    String search55 = "bio true";
    String search56 = "biotrue";
    String search57 = "blink eye drops";
    String search58 = "blink n clean drops";
    String search59 = "boston contact lenses solution";
    String search60 = "care ciba clear vision";
    String search61 = "case";
    String search62 = "case contact lens mirror";
    String search63 = "case contact lens travel";
    String search64 = "case contact lenses mirror";
    String search65 = "case contact lenses travel";
    String search66 = "cases";
    String search67 = "ciba clear care";
    String search68 = "ciba saline";
    String search69 = "ciba saline solutions";
    String search70 = "ciba solution";
    String search71 = "CibaVision Clear Care";
    String search72 = "clean";
    String search73 = "clean and clear";
    String search74 = "clean care";
    String search75 = "cleaner";
    String search76 = "cleaner contact lens";
    String search77 = "cleaner contact lense";
    String search78 = "cleaner contact lenses";
    String search79 = "cleaners";
    String search80 = "cleaning";
    String search81 = "cleaning products";
    String search82 = "Cleaning Solution";
    String search83 = "cleaning solutions";
    String search84 = "cleanser";
    String search85 = "cleansers";
    String search86 = "clear care";
    String search87 = "clear care ciba vision";
    String search88 = "Clear Care Contact Solution";
    String search89 = "clear care solution";
    String search90 = "clear crae";
    String search91 = "Clear Eyes";
    String search92 = "clear pluz";
    String search93 = "clear view";
    String search94 = "clear vue";
    String search95 = "clearcare";
    String search96 = "clensatron";
    String search97 = "complete";
    String search98 = "complete moisture";
    String search99 = "complete moisture plus";
    String search100 = "Complete Multipurpose solution";
    String search101 = "complete solution";
    String search102 = "contact case";
    String search103 = "Contact Cases";
    String search104 = "contact cleaner";
    String search105 = "contact drop eye lens";
    String search106 = "contact drop eye lenses";
    String search107 = "contact drop eyes lens";
    String search108 = "contact dry eyes";
    String search109 = "contact eye free";
    String search110 = "contact holder";
    String search111 = "contact lens and dry eyes";
    String search112 = "contact lens care";
    String search113 = "contact lens case";
    String search114 = "contact lens cases";
    String search115 = "contact lens cleaner";
    String search116 = "contact lens solution uk";
    String search117 = "contact lens solutions";
    String search118 = "contact lens storage case";
    String search119 = "contact lense care";
    String search120 = "contact lense case";
    String search121 = "contact lense cleaner";
    String search122 = "contact lense express";
    String search123 = "contact lense solution";
    String search124 = "contact lenses and dry eye";
    String search125 = "contact lenses care";
    String search126 = "contact lenses case";
    String search127 = "contact lenses express";
    String search128 = "contact lenses solution";
    String search129 = "contact lenses storage case";
    String search130 = "contact solution";
    String search131 = "contact solutions";

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
        searchAllBrand(device,search55);
        verifyProduct(device,searchResultBiotrue,search55);
        searchAllBrand(device,search56);
        verifyProduct(device,searchResultBiotrue,search56);
        searchAllBrand(device,search57);
        verifyProduct(device,searchResultAccessoriesPage,search57);
        searchAllBrand(device,search58);
        verifyProduct(device,searchResultAccessoriesPage,search58);
        searchAllBrand(device,search59);
        verifyProduct(device,searchResultAccessoriesPage,search59);
        searchAllBrand(device,search60);
        verifyProduct(device,searchResultAccessoriesPage,search60);
        searchAllBrand(device,search61);
        verifyProduct(device,searchResultAccessoriesPage,search61);
        searchAllBrand(device,search62);
        verifyProduct(device,searchResultAccessoriesPage,search62);
        searchAllBrand(device,search63);
        verifyProduct(device,searchResultAccessoriesPage,search63);
        searchAllBrand(device,search64);
        verifyProduct(device,searchResultAccessoriesPage,search64);
        searchAllBrand(device,search65);
        verifyProduct(device,searchResultAccessoriesPage,search65);
        searchAllBrand(device,search66);
        verifyProduct(device,searchResultAccessoriesPage,search66);
        searchAllBrand(device,search67);
        verifyProduct(device,searchResultAccessoriesPage,search67);
        searchAllBrand(device,search68);
        verifyProduct(device,searchResultAccessoriesPage,search68);
        searchAllBrand(device,search69);
        verifyProduct(device,searchResultAccessoriesPage,search69);
        searchAllBrand(device,search70);
        verifyProduct(device,searchResultAccessoriesPage,search70);
        searchAllBrand(device,search71);
        verifyProduct(device,searchResultAccessoriesPage,search71);
        searchAllBrand(device,search72);
        verifyProduct(device,searchResultAccessoriesPage,search72);
        searchAllBrand(device,search73);
        verifyProduct(device,searchResultAccessoriesPage,search73);
        searchAllBrand(device,search74);
        verifyProduct(device,searchResultAccessoriesPage,search74);
        searchAllBrand(device,search75);
        verifyProduct(device,searchResultAccessoriesPage,search75);
        searchAllBrand(device,search76);
        verifyProduct(device,searchResultAccessoriesPage,search76);
        searchAllBrand(device,search77);
        verifyProduct(device,searchResultAccessoriesPage,search77);
        searchAllBrand(device,search78);
        verifyProduct(device,searchResultAccessoriesPage,search78);
        searchAllBrand(device,search79);
        verifyProduct(device,searchResultAccessoriesPage,search79);
        searchAllBrand(device,search80);
        verifyProduct(device,searchResultAccessoriesPage,search80);
        searchAllBrand(device,search81);
        verifyProduct(device,searchResultAccessoriesPage,search81);
        searchAllBrand(device,search82);
        verifyProduct(device,searchResultAccessoriesPage,search82);
        searchAllBrand(device,search83);
        verifyProduct(device,searchResultAccessoriesPage,search83);
        searchAllBrand(device,search84);
        verifyProduct(device,searchResultAccessoriesPage,search84);
        searchAllBrand(device,search85);
        verifyProduct(device,searchResultAccessoriesPage,search85);
        searchAllBrand(device,search86);
        verifyProduct(device,searchResultAccessoriesPage,search86);
        searchAllBrand(device,search87);
        verifyProduct(device,searchResultAccessoriesPage,search87);
        searchAllBrand(device,search88);
        verifyProduct(device,searchResultAccessoriesPage,search88);
        searchAllBrand(device,search89);
        verifyProduct(device,searchResultAccessoriesPage,search89);
        searchAllBrand(device,search90);
        verifyProduct(device,searchResultAccessoriesPage,search90);
        searchAllBrand(device,search91);
        verifyProduct(device,searchResultAccessoriesPage,search91);
        searchAllBrand(device,search92);
        verifyProduct(device,searchResultAccessoriesPage,search92);
        searchAllBrand(device,search93);
        verifyProduct(device,searchResultAccessoriesPage,search93);
        searchAllBrand(device,search94);
        verifyProduct(device,searchResultAccessoriesPage,search94);
        searchAllBrand(device,search95);
        verifyProduct(device,searchResultAccessoriesPage,search95);
        searchAllBrand(device,search96);
        verifyProduct(device,searchResultAccessoriesPage,search96);
        searchAllBrand(device,search97);
        verifyProduct(device,searchResultAccessoriesPage,search97);
        searchAllBrand(device,search98);
        verifyProduct(device,searchResultAccessoriesPage,search98);
        searchAllBrand(device,search99);
        verifyProduct(device,searchResultAccessoriesPage,search99);
        searchAllBrand(device,search100);
        verifyProduct(device,searchResultAccessoriesPage,search100);
        searchAllBrand(device,search101);
        verifyProduct(device,searchResultAccessoriesPage,search101);
        searchAllBrand(device,search102);
        verifyProduct(device,searchResultAccessoriesPage,search102);
        searchAllBrand(device,search103);
        verifyProduct(device,searchResultAccessoriesPage,search103);
        searchAllBrand(device,search104);
        verifyProduct(device,searchResultAccessoriesPage,search104);
        searchAllBrand(device,search105);
        verifyProduct(device,searchResultAccessoriesPage,search105);
        searchAllBrand(device,search106);
        verifyProduct(device,searchResultAccessoriesPage,search106);
        searchAllBrand(device,search107);
        verifyProduct(device,searchResultAccessoriesPage,search107);
        searchAllBrand(device,search108);
        verifyProduct(device,searchResultAccessoriesPage,search108);
        searchAllBrand(device,search109);
        verifyProduct(device,searchResultAccessoriesPage,search109);
        searchAllBrand(device,search110);
        verifyProduct(device,searchResultAccessoriesPage,search110);
        searchAllBrand(device,search111);
        verifyProduct(device,searchResultAccessoriesPage,search111);
        searchAllBrand(device,search112);
        verifyProduct(device,searchResultAccessoriesPage,search112);
        searchAllBrand(device,search113);
        verifyProduct(device,searchResultAccessoriesPage,search113);
        searchAllBrand(device,search114);
        verifyProduct(device,searchResultAccessoriesPage,search114);
        searchAllBrand(device,search115);
        verifyProduct(device,searchResultAccessoriesPage,search115);
        searchAllBrand(device,search116);
        verifyProduct(device,searchResultAccessoriesPage,search116);
        searchAllBrand(device,search117);
        verifyProduct(device,searchResultAccessoriesPage,search117);
        searchAllBrand(device,search118);
        verifyProduct(device,searchResultAccessoriesPage,search118);
        searchAllBrand(device,search119);
        verifyProduct(device,searchResultAccessoriesPage,search119);
        searchAllBrand(device,search120);
        verifyProduct(device,searchResultAccessoriesPage,search120);
        searchAllBrand(device,search121);
        verifyProduct(device,searchResultAccessoriesPage,search121);
        searchAllBrand(device,search122);
        verifyProduct(device,searchResultAccessoriesPage,search122);
        searchAllBrand(device,search123);
        verifyProduct(device,searchResultAccessoriesPage,search123);
        searchAllBrand(device,search124);
        verifyProduct(device,searchResultAccessoriesPage,search124);
        searchAllBrand(device,search125);
        verifyProduct(device,searchResultAccessoriesPage,search125);
        searchAllBrand(device,search126);
        verifyProduct(device,searchResultAccessoriesPage,search126);
        searchAllBrand(device,search127);
        verifyProduct(device,searchResultAccessoriesPage,search127);
        searchAllBrand(device,search128);
        verifyProduct(device,searchResultAccessoriesPage,search128);
        searchAllBrand(device,search129);
        verifyProduct(device,searchResultAccessoriesPage,search129);
        searchAllBrand(device,search130);
        verifyProduct(device,searchResultAccessoriesPage,search130);
        searchAllBrand(device,search131);
        verifyProduct(device,searchResultAccessoriesPage,search131);
        driver.quit();
    }
}
