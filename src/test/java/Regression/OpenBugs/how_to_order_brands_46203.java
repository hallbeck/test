package Regression.OpenBugs;

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
public class how_to_order_brands_46203 extends TestBase {


    //change the Strings below to change the tests
    String testNumber = "46203";
    String typeOfTest = "REGRESSION";
    String typeOfCust = "NI";
    String typeOfPayment = "Credit";
    String BuyersGuideLink = "BuyersGuide";String searchAllBrand = "toric";
    String brandToClickOn = "1-Day Acuvue 30 pack";
    String brandVerifyPDP = "Vertex Toric XR";
    String reg = "®";
    String Acuvue30 = "1-Day Acuvue 30 pack";
    String AcuvueMoist30 = "1-Day Acuvue Moist 30 pack";
    String AcuvueMoist90 = "1-Day Acuvue Moist 90 pack";
    String AcuvueMoistAstig30 = "1-Day Acuvue Moist for Astigmatism 30 Pack";
    String AcuvueTrueEye30 = "1-Day Acuvue TruEye 30 pack";
    String AcuvueTrueEye90 = "1-Day Acuvue TruEye 90 pack";
    String Acuvue = "Acuvue";
    String Acuvue2 = "Acuvue 2";
    String Acuvue2Colors = "Acuvue 2 Colours";
    String AcuvueAdvance = "Acuvue Advance";
    String AcuvueAdvanceAstig = "Acuvue Advance for Astigmatism";
    String AcuvueAdvance24 = "Acuvue Advance Plus 24 pack";
    String AcuvueAdvance6 = "Acuvue Advance Plus 6 pack";
    String AcuvueBi = "Acuvue Bifocals";
    String AcuvueOasysAstig = "Acuvue Oasys for Astigmatism";
    String AcuvueOasysPresb = "Acuvue Oasys for Presbyopia";
    String AcuvueOasys24 = "Acuvue Oasys with Hydraclear Plus 24 Pack";
    String AcuvueOasys6 = "Acuvue Oasys with Hydraclear Plus 6 Pack";
    String AirOptixAqua = "Air Optix Aqua";
    String AirOptixAquaMulit = "Air Optix Aqua Multifocal";
    String AirOptixAstig = "Air Optix for Astigmatism";
    String AirOptixNight = "Air Optix Night & Day Aqua";
    String Aqualens38 = "Aqualens 38 (Regional Retailers)";
    String Aqualens55 = "Aqualens 55 (Regional Retailers)";
    String Aqualens55Asph = "Aqualens 55 Aspheric (Regional Retailers)";
    String Aqualite38 = "Aqualite 38 (Internet Retailers)";
    String Aqualite55 = "Aqualite 55 (Internet Retailers)";
    String Aqualite55Pro = "Aqualite 55 Pro Aspheric (Internet Retailers)";
    String Avaira = "Avaira";
    String AvairaToric = "Avaira Toric";
    String Biofinity = "Biofinity";
    String BiofinityMulti = "Biofinity Multifocal";
    //!!!String 2 of these = "Biofinity Multifocal";
    String BiofinityToric = "Biofinity Toric";
    String Biomedics = "Biomedics 1-Day 90 pack (National Brand)";
    String Biomedics38 = "Biomedics 38";
    String Biomedics55 = "Biomedics 55";
    String Biomedics55Evo = "Biomedics 55 Evolution";
    String BiomedicsPremier = "Biomedics 55 Premier";
    String BiomedicsEP = "Biomedics EP";
    String BiomedicsToric = "Biomedics Toric";
    String BiomedicsXC = "Biomedics XC";
    String BioTrue = "BioTrue ONEDay 90";
    String Clarity = "Clarity H2O";
    String Clea55A = "Clear 55A";
    String Clear58 = "Clear 58";
    String ClearAll = "Clear All-Day";
    String ClearSight30 = "ClearSight 1 Day 30 pack";
    String ClearSight90 = "ClearSight 1 Day 90 pack";
    String ClearSightToric = "ClearSight 1 Day Toric 30pk";
    String DailiesAquaComfort30 = "Dailies AquaComfort Plus 30pk";
    String DailiesAquaComfort90 = "Dailies AquaComfort Plus 90pk";
    String Encore = "Encore Premium";
    String Expressions = "Expressions";
    String ExtremeH2O_136 = "Extreme H2O 54% 13.6";
    String ExtremeH2O_142 = "Extreme H2O 54% 14.2";
    String ExtremeH2O_ToricLC = "Extreme H2O 54% Toric LC";
    String ExtremeH2O_ToricMC = "Extreme H2O 54% Toric MC";
    String ExtremeH2O_Thin = "Extreme H2O 59% Thin";
    String ExtremeH2O_Xtra = "Extreme H2O 59% Xtra";
    String Flextique38 = "Flextique 38 (Shopko Optical)";
    String Flextique55 = "Flextique 55 (Shopko Optical)";
    String Flextique55Asph = "Flextique 55 Aspheric (Shopko Optical)";
    String FocusDAILIES30 = "Focus DAILIES 30 pack";
    String FocusDAILIES90 = "Focus DAILIES 90 pack";
    String FocusDAILIESProg30 = "Focus DAILIES Progressives 30 pack";
    String FocusDAILIESToric30 = "Focus DAILIES Toric 30 pack";
    String FocusDAILIESToric90 = "Focus DAILIES Toric 90 pack";
    String FocusSoftColors = "Focus Monthly Softcolors";
    String Frequency55 = "Frequency 55";
    String FrequencyAsph = "Frequency 55 Aspheric";
    String Frequency55TMulti = "Frequency 55 Multifocal";
    String Frequency55Toric = "Frequency 55 Toric";
    String Frequency55ToricXR = "Frequency 55 Toric XR";
    String FreshLookColorblends = "FreshLook Colorblends";
    String FreshLookColorToric = "FreshLook Colorblends Toric";
    String FreshLookColors = "FreshLook Colors";
    String FreshLookDim = "FreshLook Dimensions";
    String FreshLookTint = "FreshLook Handling Tint";
    String FreshLookDay = "FreshLook ONE-DAY";
    String FreshLookToric = "FreshLook Toric";
    String Icuity = "Icuity H2O";
    String Mediflex38 = "Mediflex 38";
    String Mediflex55 = "Mediflex 55";
    String Noob = "Noob Tv";
    String O2Optix = "O2 Optix";
    String OptiFreeDrops = "OPTI-FREE"+reg+" PureMoist"+reg+" Rewetting Drops";
    String OptiFreePM = "OPTI-FREE"+reg+" PureMoist"+reg+" Solution 10oz";
    String OptiFreePM2Pk = "OPTI-FREE"+reg+" PureMoist"+reg+" Solution 2 pack (2-10oz)";
    String OptiFreeReplenish = "OPTI-FREE"+reg+" RepleniSH"+reg+" Solution 2 pack (2-10oz)";
    String Optima38 = "Optima 38/SP";
    String OptimaFW = "Optima FW";
    String OptimaToric = "Optima Toric";
    String Perspecta55 = "Perspecta 55 Aspheric (Sears Optical)";
    String Polysoft38 = "Polysoft 38 (Pearle Vision)";
    String Polysoft55 = "Polysoft 55 (Pearle Vision)";
    String Polysoft55Asph = "Polysoft 55 Aspheric (Pearle Vision)";
    String PreferenceDW = "Preference DW/FW";
    String PreferenceStd = "Preference Standard";
    String PreferenceToric = "Preference Toric";
    String Proclear = "Proclear";
    String Proclear90 = "Proclear 1-Day 90 pack";
    String Proclear30 = "Proclear 1-Day Multifocal 30";
    String ProclearEP = "Proclear EP (Biomedics EP)";
    String ProclearMulti = "Proclear Multifocal";
    String ProclearToric = "Proclear Toric";
    String ProclearToricXR = "Proclear Toric XR";
    String Proflex38 = "Proflex 38";
    String Proflex55 = "Proflex 55";
    String Prosite38 = "Prosite 38 (For Eyes)";
    String Prosite55 = "Prosite 55 (For Eyes)";
    String Prosite55Asph = "Prosite 55 Aspheric (For Eyes)";
    String Provision55 = "Provision 55";
    String ProvisionPremium = "Provision Premium";
    String PureVision = "PureVision";
    String PureVision2 = "PureVision 2";
    String PureVision2HD = "PureVision 2 HD For Astigmatism";
    String PureVisionMulti = "PureVision Multifocal";
    String PureVisionToric = "PureVision Toric (PureVision For As";
    String SofLens38 = "SofLens 38";
    String SofLens30 = "SofLens Daily Disposable for Astigmatism 30pk";
    String SofLens90 = "SofLens Daily Disposables 90pk";
    String SofLensMulti = "SofLens Multi-Focal";
    String SofLensToric = "SofLens Toric (SofLens For Astigmatism)";
    String SoftconEW = "Softcon EW";
    String Sterling38 = "Sterling 38 (Sterling Optical)";
    String Sterling55 = "Sterling 55 (Sterling Optical)";
    String Sterling55Asph = "Sterling 55 Aspheric (Sterling Optical)";
    String SuncloudCookie = "Suncloud Cookie";
    String SuncloudHook = "Suncloud Hook";
    String Target38 = "Target 38 (Target Optical)";
    String Target55 = "Target 55 (Target Optical)";
    String Target55Asph = "Target 55 Aspheric (Target Optical)";
    String UltraFlex38 = "UltraFlex 7/14 38 (National Brand)";
    String UltraFlex55 = "UltraFlex 7/14 55 (National Brand)";
    String UltraFlexII = "UltraFlex II Aspheric ()";
    String UltraFlexToric = "UltraFlex Toric (National Brand)";
    String UltraFlexXC = "UltraFlex XC (National Brand)";
    String Versaflex38 = "Versaflex 38 (LensCrafters)";
    String Versaflex55 = "Versaflex 55 (LensCrafters)";
    String Versaflex55Ash = "Versaflex 55 Aspheric (LensCrafters)";
    String VertexSph = "Vertex Sphere (Encore Sphere)";
    String VertexToric = "Vertex Toric (Encore Toric)";
    String VertexToricXR = "Vertex Toric XR";
    String ZADITOR = "ZADITOR"+reg+" Eye Drops 2pk";


    String shippingVerify = "Expedited";
    String printTestName = typeOfTest + " | " + testNumber + " | " + typeOfCust + " | " + searchAllBrand + " | " + typeOfPayment + " | " + shippingVerify;
    String screenshotTestName =  testNumber + "_" + typeOfTest + "_" + typeOfCust + "_" + searchAllBrand + "_" + typeOfPayment + "_" + shippingVerify;


    @Test (singleThreaded = true)
    @Parameters(value = "device")
    public void test(String device) {
        openWebPage(device);
        takeScreenshot(screenshotTestName, "Interstitial");
        clickNoThanksButton(device);
        printTestNumber(printTestName);
        gotoPage(BuyersGuideLink);
        chooseBrand(device,brandToClickOn);
        driver.quit();
    }
}