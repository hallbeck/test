package Regression.PDP.done;

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
public class PDPAccessories_D_E48553 extends ContactsTestBase {


    String testNumber = "48553D_E";
    String typeOfTest = "Regression";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String searchResultAccessoriesPage = "Eye Care Solutions";

    String search132 = "disinfect";
    String  search133 = "disinfectant";
    String  search134 = "disinfecting solution";
    String  search135 = "drops";
    String  search136 = "dry";
    String  search137 = "dry eye";
    String  search138 = "dry eyes";
    String  search139 = "equate";
    String  search140 = "equate lubricating & rewetting drops";
    String  search141 = "equate lubricating & rewetting drops twin pack";
    String  search142 = "equate lubricating and rewetting drops";
    String  search143 = "equate lubricating and rewetting drops twin pack";
    String  search144 = "equate lubricating drops";
    String  search145 = "equate multi-purpose solution";
    String  search146 = "equate multi-purpose solution 2oz";
    String  search147 = "equate rewetting drops";
    String  search148 = "equate rewetting drops twin pack";
    String  search149 = "equate solution";
    String  search150 = "eye contact lens care";
    String  search151 = "eye drop";
    String  search152 = "eye drops";
    String  search153 = "eye lubricant";
    String  search154 = "eye solution";
    String  search155 = "eye solutions";
    String  search156 = "eyedrops";
    String  search157 = "eyes care contact";
    String  search158 = "eyes contact lens";

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

        searchAllBrand(device,search132);
        verifyProduct(device,searchResultAccessoriesPage,search132);
        searchAllBrand(device,search133);
        verifyProduct(device,searchResultAccessoriesPage,search133);
        searchAllBrand(device,search134);
        verifyProduct(device,searchResultAccessoriesPage,search134);
        searchAllBrand(device,search135);
        verifyProduct(device,searchResultAccessoriesPage,search135);
        searchAllBrand(device,search136);
        verifyProduct(device,searchResultAccessoriesPage,search136);
        searchAllBrand(device,search137);
        verifyProduct(device,searchResultAccessoriesPage,search137);
        searchAllBrand(device,search138);
        verifyProduct(device,searchResultAccessoriesPage,search138);
        searchAllBrand(device,search139);
        verifyProduct(device,searchResultAccessoriesPage,search139);
        searchAllBrand(device,search140);
        verifyProduct(device,searchResultAccessoriesPage,search140);
        searchAllBrand(device,search141);
        verifyProduct(device,searchResultAccessoriesPage,search141);
        searchAllBrand(device,search142);
        verifyProduct(device,searchResultAccessoriesPage,search142);
        searchAllBrand(device,search143);
        verifyProduct(device,searchResultAccessoriesPage,search143);
        searchAllBrand(device,search144);
        verifyProduct(device,searchResultAccessoriesPage,search144);
        searchAllBrand(device,search145);
        verifyProduct(device,searchResultAccessoriesPage,search145);
        searchAllBrand(device,search146);
        verifyProduct(device,searchResultAccessoriesPage,search146);
        searchAllBrand(device,search147);
        verifyProduct(device,searchResultAccessoriesPage,search147);
        searchAllBrand(device,search148);
        verifyProduct(device,searchResultAccessoriesPage,search148);
        searchAllBrand(device,search149);
        verifyProduct(device,searchResultAccessoriesPage,search149);
        searchAllBrand(device,search150);
        verifyProduct(device,searchResultAccessoriesPage,search150);
        searchAllBrand(device,search151);
        verifyProduct(device,searchResultAccessoriesPage,search151);
        searchAllBrand(device,search152);
        verifyProduct(device,searchResultAccessoriesPage,search152);
        searchAllBrand(device,search153);
        verifyProduct(device,searchResultAccessoriesPage,search153);
        searchAllBrand(device,search154);
        verifyProduct(device,searchResultAccessoriesPage,search154);
        searchAllBrand(device,search155);
        verifyProduct(device,searchResultAccessoriesPage,search155);
        searchAllBrand(device,search156);
        verifyProduct(device,searchResultAccessoriesPage,search156);
        searchAllBrand(device,search157);
        verifyProduct(device,searchResultAccessoriesPage,search157);
        searchAllBrand(device,search158);
        verifyProduct(device,searchResultAccessoriesPage,search158);
        driver.quit();
    }
}
