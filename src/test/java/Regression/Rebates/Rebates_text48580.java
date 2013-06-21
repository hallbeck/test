package Regression.Rebates;

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
public class Rebates_text48580 extends TestBase {

    //change the Strings below to change the tests
    String testNumber = "48580";
    String typeOfTest = "Regression";
    String typeOfCust = "NA";
    String typeOfPayment = "Rebates";   
    //LENS//
    String DayAcuvue30pk="lens/1-day-acuvue-30";
    String rebatesAvailable = "Rebate expected--save $30 on 12 -- save $65 on 24";
    String rebate6Month = "30.0";
    String rebate12Month = "65.0";
    String posR = "";
    String posL = "+";
    String rPower = "-0.50";
    String lPower = "2.25";
    String rBC = "8";
    String lBC = "8";
    String rBC2 = "";
    String lBC2 = "";
    String rDia = "";
    String lDia = "";
    String rDia2 = "";
    String lDia2 = "";
    String rColor = "";
    String lColor = "";
    String rColor2 = "";
    String lColor2 = "";
    String rAdd;
    String lAdd;
    String rAdd2;
    String lAdd2;
    String rCyl = "-";
    String lCyl = "-";
    String rCyl2 = "";
    String lCyl2 = "";
    String rAxis = "";
    String rAxis2 = "";
    String lAxis = "";
    String lAxis2 = "";
    String rBoxes = "6";
    String rBoxes2 = "12";
    String lBoxes = "6";
    String lBoxes2 = "12";
    String PatientFNameCart = "PatientFirst";
    String PatientLNameCart = "PatientLast";
    String shippingFName = "ShipFirst";
    String shippingLName = "ShipLast";
    String country = "BOLIVIA";
    String state = "Newberry";
    String city = "whatever";
    String zip = "K1A 0G9";
    String emailPrefix = "test";
    String password = "password";


    String Flextique38="lens/flextique-38" ;
    String Flextique55Aspheric="lens/flextique-55-aspheric" ;
    String FocusDAILIES90pk="lens/focus-dailies-90";
    String FocusDAILIESToric30pk="lens/focus-dailies-toric-30" ;
    String FocusMonthlySoftcolors="lens/focus-monthly-softcolors";
    String Frequency55Aspheric="lens/frequency-55-aspheric";
    String Frequency55Toric="lens/frequency-55-toric" ;
    String FreshLookColorblends="lens/freshlook-colorblends" ;
    String FreshLookColors="lens/freshlook-colors";
    String FreshLookHandlingTint="lens/freshlook-handling-tint";
    String FreshLookToric="lens/freshlook-toric";
    String Flextique55="lens/flextique-55";
    String FocusDAILIES30pk="lens/focus-dailies-30";
    String FocusDAILIESProgressives30pk="lens/focus-dailies-progressives-30";
    String FocusDAILIESToric90pk="lens/focus-dailies-toric-90" ;
    String Frequency55="lens/frequency-55" ;
    String Frequency55Multifocal="lens/frequency-55-multifocal" ;
    String Frequency55ToricXR="lens/frequency-55-toric-xr" ;
    String FreshLookColorblendsToric="lens/freshlook-colorblends-toric";
    String FreshLookDimensions="lens/freshlook-dimensions" ;
    String FreshLookONEDAY="lens/freshlook-one-day";


    String IcuityH2O="lens/icuity-h2o" ;
    String Mediflex38="lens/mediflex-38" ;
    String Mediflex55="lens/mediflex-55" ;
    String O2Optix="lens/o2-optix" ;
    String OptimaFW="lens/optima-fw" ;
    String Optima38SP="lens/optima-38-sp";
    String OptimaToric="lens/optima-toric" ;

    String Perspecta55Aspheric="lens/perspecta-55-aspheric" ;
    String Polysoft55="lens/polysoft-55";
    String PreferenceDWFW="lens/preference-dw-fw";
    String PreferenceToric="lens/preference-toric";
    String Proclear1Day90pk="lens/proclear-1-day-90" ;
    String ProclearEP="lens/proclear-ep" ;
    String ProclearToric="lens/proclear-toric" ;
    String Proflex38="lens/proflex-38" ;
    String Prosite38="lens/prosite-38";
    String Prosite55Aspheric="lens/prosite-55-aspheric" ;
    String ProvisionPremium="lens/provision-premium" ;
    String PureVision2="lens/purevision-2-hd";
    String PureVisionMultiFocal="lens/purevision-multi-focal";
    String Polysoft38="lens/polysoft-38";
    String Polysoft55Aspheric="lens/polysoft-55-aspheric";
    String PreferenceStandard="lens/preference-standard";
    String Proclear="lens/proclear";
    String Proclear1DayMultifocal30pk="lens/proclear-1-day-multifocal-30" ;
    String ProclearMultifocal="lens/proclear-multifocal";
    String ProclearToricXR="lens/proclear-toric-xr";
    String Proflex55="lens/proflex-55" ;
    String Prosite55="lens/prosite-55";
    String Provision55="lens/provision-55";
    String PureVision="lens/purevision";
    String PureVision2HDforAstigmatism="lens/purevision-2-hd-for-astigmatism";
    String PureVisionToric="lens/purevision-toric";

    String SofLens38="lens/soflens-38" ;
    String SofLensDailyDisposables90pk="lens/soflens-daily-disposables-90" ;
    String SofLensToric="lens/soflens-toric" ;
    String Sofmed55Aspheric="lens/sofmed-55-aspheric";
    String SoftconEW="lens/softcon-ew";
    String Sterling55="lens/sterling-55";
    String SofLensDailyDisposableforAstigmatism="lens/soflens-daily-disposable-for-astigmatism-30";
    String SofLensMultiFocal="lens/soflens-multi-focal";
    String Sofmed38="lens/sofmed-38";
    String Sofmed55="lens/sofmed-55";
    String Sterling38="lens/sterling-38";
    String Sterling55Aspheric="lens/sterling-55-aspheric";

    String Target38="lens/target-38";
    String Target55Aspheric="lens/target-55-aspheric";
    String Target55="lens/target-55";
    String UltraFlex71438="lens/ultraflex-7-14-38";
    String UltraFlexIIAspheric="lens/ultraflex-II-aspheric";
    String UltraFlexXC="lens/ultraflex-xc";
    String UltraFlex71455="lens/ultraflex-7-14-55";
    String UltraFlexToric="lens/ultraflex-toric";
    String Versaflex38="lens/versaflex-38";
    String Versaflex55Aspheric="lens/versaflex-55-aspheric";
    String VertexToric="lens/vertex-toric";
    String Versaflex55="lens/versaflex-55";
    String VertexSphere="lens/vertex-sphere";
    String VertexToricXR="lens/vertex-toric-xr";
    String shippingVerify = "Title tag";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust  + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + typeOfPayment + "_" + shippingVerify;



    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void titleTagTest(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(DayAcuvue30pk);
        print("Rebate expected--save $30 on 12 -- save 65 on 24");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        clickRboxes(rBoxes);
        clickLboxes(lBoxes);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP1_");
        clickAddToCart(device);
        verifyRebateCart(device,rebate6Month);
        clickCart_Continue(device);
        typeShippingName(shippingFName,shippingLName);
        clickCountry(country);
        typeShippingAddress();
        typeShippingCity(city);
        typeShippingState(country,state);
        typeShippingZip(zip);
        typeShippingPhone(device);
        typeShippingEmail(emailPrefix,testNumber);
        typePassword_newcust(password);
        takeScreenshot(screenshotTestName, "NewAddress");
        clickNewAddress_Continue();
        verifyRebateRS(device,rebate6Month);
        goToCart(device);
        clickRemove(device);

        gotoPage(DayAcuvue30pk);
        print("Rebate expected--save $30 on 12 -- save 65 on 24");
        clickRPower(device,posR,rPower);
        clickLPower(device,posL,lPower);
        clickRBC(rBC);
        clickLBC(lBC);
        clickRboxes(rBoxes2);
        clickLboxes(lBoxes2);
        typePatientName(PatientFNameCart, PatientLNameCart);
        takeScreenshot(screenshotTestName, "PDP2_");
        clickAddToCart(device);
        verifyRebateCart(device,rebate12Month);
        clickCart_Continue(device);
        verifyRebateRS(device,rebate12Month);





        /*gotoPage(DayAcuvueMoist90pk);
        gotoPage(DayAcuvueTruEye30pk);
        gotoPage(DayAcuvueMoist30pk);
        gotoPage(DayAcuvueMoistforAstigmatism30pk);
        gotoPage(DayAcuvueTruEye90pk);
        gotoPage(Acuvue);
        gotoPage(Acuvue2Colours);
        gotoPage(AcuvueAdvanceAstigmatism);
        gotoPage(AcuvueAdvancePlus6pk);
        gotoPage(AcuvueOasysAstigmatism);
        gotoPage(AcuvueOasysHydraclearPlus24pk);
        gotoPage(AirOptixAqua);
        gotoPage(Aqualens38);
        gotoPage(Aqualens55Aspheric);
        gotoPage(Aqualite55);
        gotoPage(Avaira);
        gotoPage(Acuvue2);
        gotoPage(AcuvueAdvance);
        gotoPage(AcuvueAdvancePlus24pk);
        gotoPage(AcuvueBifocals);
        gotoPage(AcuvueOasysPresbyopia);
        gotoPage(AcuvueOasysHydraclearPlus6pk);
        gotoPage(AirOptixAquaMultifocal);
        gotoPage(AirOptixNightDayAqua);
        gotoPage(Aqualens55);
        gotoPage(Aqualite38);
        gotoPage(Aqualite55ProAspheric);
        gotoPage(AvairaToric);
        gotoPage(Biofinity);
        gotoPage(BiofinityToric);
        gotoPage(Biomedics38);
        gotoPage(Biomedics55Evolution);
        gotoPage(BiomedicsEP);
        gotoPage(BiomedicsXC);
        gotoPage(BiofinityMultifocal);
        gotoPage(Biomedics1Day90pk);
        gotoPage(Biomedics55);
        gotoPage(Biomedics55Premier);
        gotoPage(BiomedicsToric);
        gotoPage(ClarityH2O);
        gotoPage(Clear58);
        gotoPage(ClearSightDay30pk);
        gotoPage(ClearSight1DayToric30pk);
        gotoPage(Clear55A);
        gotoPage(ClearAllDay);
        gotoPage(ClearSight1Day90pk);
        gotoPage(DailiesAquaComfortPlus30pk);
        gotoPage(DailiesAquaComfortPlus90pk);
        gotoPage(EncorePremium);
        gotoPage(ExtremeH2O54136);
        gotoPage(ExtremeH2O54ToricLC);
        gotoPage(ExtremeH2O59Thin);
        gotoPage(Expressions);
        gotoPage(ExtremeH2O54142);
        gotoPage(ExtremeH2O54ToricMC);
        gotoPage(ExtremeH2O59Xtra);
        gotoPage(Flextique38);
        gotoPage(Flextique55Aspheric);
        gotoPage(FocusDAILIES90pk);
        gotoPage(FocusDAILIESToric30pk);
        gotoPage(FocusMonthlySoftcolors);
        gotoPage(Frequency55Aspheric);
        gotoPage(Frequency55Toric);
        gotoPage(FreshLookColorblends);
        gotoPage(FreshLookColors);
        gotoPage(FreshLookHandlingTint);
        gotoPage(FreshLookToric);
        gotoPage(Flextique55);
        gotoPage(FocusDAILIES30pk);
        gotoPage(FocusDAILIESProgressives30pk);
        gotoPage(FocusDAILIESToric90pk);
        gotoPage(Frequency55);
        gotoPage(Frequency55Multifocal);
        gotoPage(Frequency55ToricXR);
        gotoPage(FreshLookColorblendsToric);
        gotoPage(FreshLookDimensions);
        gotoPage(FreshLookONEDAY);
        gotoPage(IcuityH2O);
        gotoPage(Mediflex38);
        gotoPage(Mediflex55);
        gotoPage(O2Optix);
        gotoPage(OptimaFW);
        gotoPage(Optima38SP);
        gotoPage(OptimaToric);
        gotoPage(Perspecta55Aspheric);
        gotoPage(Polysoft55);
        gotoPage(PreferenceDWFW);
        gotoPage(PreferenceToric);
        gotoPage(Proclear1Day90pk);
        gotoPage(ProclearEP);
        gotoPage(ProclearToric);
        gotoPage(Proflex38);
        gotoPage(Prosite38);
        gotoPage(Prosite55Aspheric);
        gotoPage(ProvisionPremium);
        gotoPage(PureVision2);
        gotoPage(PureVisionMultiFocal);
        gotoPage(Polysoft38);
        gotoPage(Polysoft55Aspheric);
        gotoPage(PreferenceStandard);
        gotoPage(Proclear);
        gotoPage(Proclear1DayMultifocal30pk);
        gotoPage(ProclearMultifocal);
        gotoPage(ProclearToricXR);
        gotoPage(Proflex55);
        gotoPage(Prosite55);
        gotoPage(Provision55);
        gotoPage(PureVision);
        gotoPage(PureVision2HDforAstigmatism);
        gotoPage(PureVisionToric);
        gotoPage(SofLens38);
        gotoPage(SofLensDailyDisposables90pk);
        gotoPage(SofLensToric);
        gotoPage(Sofmed55Aspheric);
        gotoPage(SoftconEW);
        gotoPage(Sterling55);
        gotoPage(SofLensDailyDisposableforAstigmatism);
        gotoPage(SofLensMultiFocal);
        gotoPage(Sofmed38);
        gotoPage(Sofmed55);
        gotoPage(Sterling38);
        gotoPage(Sterling55Aspheric);
        gotoPage(Target38);
        gotoPage(Target55Aspheric);
        gotoPage(Target55);
        gotoPage(UltraFlex71438);
        gotoPage(UltraFlexIIAspheric);
        gotoPage(UltraFlexXC);
        gotoPage(UltraFlex71455);
        gotoPage(UltraFlexToric);
        gotoPage(Versaflex38);
        gotoPage(Versaflex55Aspheric);
        gotoPage(VertexToric);
        gotoPage(Versaflex55);
        gotoPage(VertexSphere);
        gotoPage(VertexToricXR);*/
       // driver.quit();
    }
}
