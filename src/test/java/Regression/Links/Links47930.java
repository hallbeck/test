package Regression.Links;

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
public class Links47930 extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "47930";
    String typeOfTest = "Regression";
    String typeOfCust = "NA";
    String typeOfPayment = "Credit";
    String searchAllBrand = "solution";
    String accessoriesLink = "accessories.aspx";
    String returnPolicyLink = "ReturnPolicy";
    String EyeCareVeriLink = "ExternalRelations/EyeCareVeri.aspx";
    String EyeCareLegiLink = "ExternalRelations/EyeCareLegi.aspx";
    String EyeCareFCLCALink = "ExternalRelations/EyeCareFCLCA.aspx";
    String BuyersGuideLink = "BuyersGuide";
    String sitemapLink = "sitemap";
    String framesLink = "StaticContent/Vision101/frames.html";
    String privacyPolicyLink = "PrivacyPolicy";
    String CustomerResourcesTestLink = "ExternalRelations/CustomerResourcesTest.aspx";
    String eyeTermsLink = "Eye-Care-Terms.htm";
    String hsaLink = "fsa-fund-use.htm";
    String searchAllBrand2 = "Toric";
    String brandToClickOn = "FreshLookColors";
    String brandToClickOn2 = "";
    String brandVerifyPDP = "FreshLook Colors";
    String brandVerifyPDP2 = "";
    String rPower = "++++++++++++++++++";
    String lPower = "++++++++++++++";
    String rPower2 = "";
    String lPower2 = "";
    String rPowerDesktop2 = "";
    String lPowerDesktop2 = "";
    String rBC = "";
    String lBC = "";
    String rBC2 = "";
    String lBC2 = "";
    String rDia = "";
    String lDia = "";
    String rDia2 = "";
    String lDia2 = "";
    String rColor = "V";
    String lColor = "V";
    String rColor2 = "";
    String lColor2 = "";
    String rAdd = "";
    String lAdd = "";
    String rAdd2 = "";
    String lAdd2 = "";
    String rCyl = "";
    String lCyl = "";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "";
    String rAxis2 = "";
    String lAxis = "";
    String lAxis2 = "";
    String rBoxes = "2";
    String rBoxes2 = "";
    String lBoxes = "2";
    String lBoxes2 = "";
    String PatientFNameCart = "PatOneFirst";
    String PatientLNameCart = "PatientLast";
    String PatientFNameCart2 = "PatTwoFirst";
    String PatientLNameCart2 = "PatientLast";
    String fullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String fullPatientName2 = (PatientFNameCart2 + " " + PatientLNameCart2);
    String ShippingCart = "e";
    //String FullPatientName = (PatientFNameCart + " " + PatientLNameCart);
    String pricePerBox = "49.99";
    String priceREye = "99.98";
    String priceLEye = "199.96";
    String pricePerBox2 = "49.99";
    String priceREye2 = "99.98";
    String priceLEye2 = "199.96";
    String priceTotal = "314.93";
    String rsTotal = "230.77";
    String rsTotalAfterRebate = "147.92";
    String rsTax = "14.79";
    String rsRebate = "";
    String rsShipping = "14.99" ;
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "united states";
    String state = "utah";
    String city = "slc";
    String zip = "84121";
    String emailPrefix = "test";
    String password = "password";
    String drName = "test";
    String drState = "UT";
    String creditCard = "4012000077777777";
    String ccName = "Blah";
    String ccExpMo = "03";
    String ccExpYear = "2014";
    String creditCardBad = "4111111111111111";
    String ccExpMoBad = "01";
    String ccExpYearBad = "2013";
    String shippingVerify = "Expedited";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;



    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void LinksTest(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(privacyPolicyLink);
        takeScreenshot(screenshotTestName, "Accessories_search");
        verifyPageTitle("Privacy Policy | 1-800 CONTACTS");
        clickFindBrand(device);
        searchAllBrand(device,searchAllBrand);
        takeScreenshot(screenshotTestName, "accessories_search");
        verifyPageTitle("AquaSoft Contact Lens Solution (4 Pack) | 1-800 CONTACTS");
        gotoPage(accessoriesLink);
        takeScreenshot(screenshotTestName, "accessories");
        verifyPageTitle("Contact Lens Cases, Drops, and Solution | 1-800 CONTACTS");
        gotoPage(returnPolicyLink);
        takeScreenshot(screenshotTestName, "returnPolicy");
        verifyPageTitle("Return Policy | 1-800 CONTACTS");
        gotoPage(EyeCareVeriLink);
        takeScreenshot(screenshotTestName, "rxVerification");
        verifyPagePara("providers regarding prescription verification are regulated in detail.");
        gotoPage(EyeCareLegiLink);
        takeScreenshot(screenshotTestName, "legislation");
        verifyPagePara("1-800 CONTACTS adheres to the following principles when supporting any legislation:");
        gotoPage(EyeCareFCLCALink);
        takeScreenshot(screenshotTestName, "fclca");
        verifyPagePara("This act became law in February, 2004.");
        gotoPage(sitemapLink);
        takeScreenshot(screenshotTestName, "sitemap");
        verifyPageTitle("Sitemap | 1-800 CONTACTS");
        gotoPage(framesLink);
        takeScreenshot(screenshotTestName, "vision101");
        verifyPageTitle("vision101");
        gotoPage(CustomerResourcesTestLink);
        takeScreenshot(screenshotTestName, "CustTestimonials");
        verifyPageTitle("Customer Testimonials | 1-800 CONTACTS");
        gotoPage(eyeTermsLink);
        takeScreenshot(screenshotTestName, "EyeTerms");
        verifyPageTitle("Common Eye Care Terms | 1-800 CONTACTS");
        gotoPage(hsaLink);
        takeScreenshot(screenshotTestName, "HSA");
        verifyPagePara("Did you know you can purchase products from 1-800 CONTACTS using your flexible spending account");
        gotoPage(BuyersGuideLink);
        takeScreenshot(screenshotTestName, "BuyersGuide");
        verifyPagePara("Add Your Prescription Information");
        driver.quit();
    }
}
