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
    String Aqualens38Pdp = "Aqualens 38";
    String Aqualens55 = "Aqualens 55 (Regional Retailers)";
    String Aqualens55Pdp = "Aqualens 55";
    String Aqualens55Asph = "Aqualens 55 Aspheric (Regional Retailers)";
    String Aqualens55AsphPdp = "Aqualens 55 Aspheric";
    String Aqualite38 = "Aqualite 38 (Internet Retailers)";
    String Aqualite38Pdp = "Aqualite 38";
    String Aqualite55 = "Aqualite 55 (Internet Retailers)";
    String Aqualite55Pdp = "Aqualite 55";
    String Aqualite55Pro = "Aqualite 55 Pro Aspheric (Internet Retailers)";
    String Aqualite55ProPdp = "Aqualite 55 Pro Aspheric";
    String Avaira = "Avaira";
    String AvairaToric = "Avaira Toric";
    String Biofinity = "Biofinity";
    String BiofinityMulti = "Biofinity Multifocal";
    //!!!String 2 of these = "Biofinity Multifocal";
    String BiofinityToric = "Biofinity Toric";
    String Biomedics = "Biomedics 1-Day 90 pack (National Brand)";
    String BiomedicsPdp = "Biomedics 1-Day 90 pack";
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
    String ClearSightToricPdp = "ClearSight 1 Day Toric 30 pack";
    String DailiesAquaComfort30 = "Dailies AquaComfort Plus 30pk";
    String DailiesAquaComfort30Pdp = "Dailies AquaComfort Plus 30 pack";
    String DailiesAquaComfort90 = "Dailies AquaComfort Plus 90pk";
    String DailiesAquaComfort90Pdp = "Dailies AquaComfort Plus 90 pack";
    String Encore = "Encore Premium";
    String Expressions = "Expressions";
    String ExtremeH2O_136 = "Extreme H2O 54% 13.6";
    String ExtremeH2O_142 = "Extreme H2O 54% 14.2";
    String ExtremeH2O_ToricLC = "Extreme H2O 54% Toric LC";
    String ExtremeH2O_ToricMC = "Extreme H2O 54% Toric MC";
    String ExtremeH2O_Thin = "Extreme H2O 59% Thin";
    String ExtremeH2O_Xtra = "Extreme H2O 59% Xtra";
    String Flextique38 = "Flextique 38 (Shopko Optical)";
    String Flextique38Pdp = "Flextique 38";
    String Flextique55 = "Flextique 55 (Shopko Optical)";
    String Flextique55Pdp = "Flextique 55";
    String Flextique55Asph = "Flextique 55 Aspheric (Shopko Optical)";
    String Flextique55AsphPdp = "Flextique 55 Aspheric";
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
    String Perspecta55Pdp = "Perspecta 55 Aspheric";
    String Polysoft38 = "Polysoft 38 (Pearle Vision)";
    String Polysoft38Pdp = "Polysoft 38";
    String Polysoft55 = "Polysoft 55 (Pearle Vision)";
    String Polysoft55Pdp = "Polysoft 55";
    String Polysoft55Asph = "Polysoft 55 Aspheric (Pearle Vision)";
    String Polysoft55AsphPdp = "Polysoft 55 Aspheric";
    String PreferenceDW = "Preference DW/FW";
    String PreferenceStd = "Preference Standard";
    String PreferenceToric = "Preference Toric";
    String Proclear = "Proclear";
    String Proclear90 = "Proclear 1-Day 90 pack";
    String Proclear30 = "Proclear 1-Day Multifocal 30";
    String ProclearEP = "Proclear EP (Biomedics EP)";
    String ProclearEPPdp = "Proclear EP";
    String ProclearMulti = "Proclear Multifocal";
    String ProclearToric = "Proclear Toric";
    String ProclearToricXR = "Proclear Toric XR";
    String Proflex38 = "Proflex 38";
    String Proflex55 = "Proflex 55";
    String Prosite38 = "Prosite 38 (For Eyes)";
    String Prosite38Pdp = "Prosite 38";
    String Prosite55 = "Prosite 55 (For Eyes)";
    String Prosite55Pdp = "Prosite 55";
    String Prosite55Asph = "Prosite 55 Aspheric (For Eyes)";
    String Prosite55AsphPdp = "Prosite 55 Aspheric";
    String Provision55 = "Provision 55";
    String ProvisionPremium = "Provision Premium";
    String PureVision = "PureVision";
    String PureVision2 = "PureVision 2";
    String PureVision2HD = "PureVision 2 HD For Astigmatism";
    String PureVisionMulti = "PureVision Multifocal";
    String PureVisionMultiPdp = "PureVision Multi-Focal";
    String PureVisionToric = "PureVision Toric (PureVision For As";
    String SofLens38 = "SofLens 38";
    String SofLens30 = "SofLens Daily Disposable for Astigmatism 30pk";
    String SofLens90 = "SofLens Daily Disposables 90pk";
    String SofLens90Pdp = "SofLens Daily Disposables 90 pack";
    String SofLensMulti = "SofLens Multi-Focal";
    String SofLensToric = "SofLens Toric (SofLens For Astigmatism)";
    String SoftconEW = "Softcon EW";
    String Sterling38 = "Sterling 38 (Sterling Optical)";
    String Sterling38Pdp = "Sterling 38";
    String Sterling55 = "Sterling 55 (Sterling Optical)";
    String Sterling55Pdp = "Sterling 55";
    String Sterling55Asph = "Sterling 55 Aspheric (Sterling Optical)";
    String Sterling55AsphPdp = "Sterling 55 Aspheric";
    String SuncloudCookie = "Suncloud Cookie";
    String SuncloudHook = "Suncloud Hook";
    String Target38 = "Target 38 (Target Optical)";
    String Target38Pdp = "Target 38";
    String Target55 = "Target 55 (Target Optical)";
    String Target55Pdp = "Target 55";
    String Target55Asph = "Target 55 Aspheric (Target Optical)";
    String Target55AsphPdp = "Target 55 Aspheric";
    String UltraFlex38 = "UltraFlex 7/14 38 (National Brand)";
    String UltraFlex38Pdp = "UltraFlex 7/14 38";
    String UltraFlex55 = "UltraFlex 7/14 55 (National Brand)";
    String UltraFlex55Pdp = "UltraFlex 7/14 55";
    String UltraFlexII = "UltraFlex II Aspheric ()";
    String UltraFlexIIPdp = "UltraFlex II Aspheric";
    String UltraFlexToric = "UltraFlex Toric (National Brand)";
    String UltraFlexToricPdp = "UltraFlex Toric";
    String UltraFlexXC = "UltraFlex XC (National Brand)";
    String UltraFlexXCPdp = "UltraFlex XC";
    String Versaflex38 = "Versaflex 38 (LensCrafters)";
    String Versaflex38Pdp = "Versaflex 38";
    String Versaflex55 = "Versaflex 55 (LensCrafters)";
    String Versaflex55Pdp = "Versaflex 55";
    String Versaflex55Ash = "Versaflex 55 Aspheric (LensCrafters)";
    String Versaflex55AshPdp = "Versaflex 55 Aspheric";
    String VertexSph = "Vertex Sphere (Encore Sphere)";
    String VertexSphPdp = "Vertex Sphere";
    String VertexToric = "Vertex Toric (Encore Toric)";
    String VertexToricPdp = "Vertex Toric";
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
        chooseBrand(device,Acuvue30);
        clickGo(device);
        verifyProduct(device,Acuvue30,Acuvue30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueMoist30);
        clickGo(device);
        verifyProduct(device,AcuvueMoist30,AcuvueMoist30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueMoist90);
        clickGo(device);
        verifyProduct(device,AcuvueMoist90,AcuvueMoist90);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueMoistAstig30);
        clickGo(device);
        verifyProduct(device,AcuvueMoistAstig30,AcuvueMoistAstig30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueTrueEye30);
        clickGo(device);
        verifyProduct(device,AcuvueTrueEye30,AcuvueTrueEye30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueTrueEye90);
        clickGo(device);
        verifyProduct(device,AcuvueTrueEye90,AcuvueTrueEye90);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Acuvue);
        clickGo(device);
        verifyProduct(device,Acuvue,Acuvue);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Acuvue2);
        clickGo(device);
        verifyProduct(device,Acuvue2,Acuvue2);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Acuvue2Colors);
        clickGo(device);
        verifyProduct(device,Acuvue2Colors,Acuvue2Colors);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueAdvance);
        clickGo(device);
        verifyProduct(device,AcuvueAdvance,AcuvueAdvance);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueAdvanceAstig);
        clickGo(device);
        verifyProduct(device,AcuvueAdvanceAstig,AcuvueAdvanceAstig);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueAdvance24);
        clickGo(device);
        verifyProduct(device,AcuvueAdvance24,AcuvueAdvance24);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueAdvance6);
        clickGo(device);
        verifyProduct(device,AcuvueAdvance6,AcuvueAdvance6);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueBi);
        clickGo(device);
        verifyProduct(device,AcuvueBi,AcuvueBi);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueOasysAstig);
        clickGo(device);
        verifyProduct(device,AcuvueOasysAstig,AcuvueOasysAstig);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueOasysPresb);
        clickGo(device);
        verifyProduct(device,AcuvueOasysPresb,AcuvueOasysPresb);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueOasys24);
        clickGo(device);
        verifyProduct(device,AcuvueOasys24,AcuvueOasys24);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AcuvueOasys6);
        clickGo(device);
        verifyProduct(device,AcuvueOasys6,AcuvueOasys6);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AirOptixAqua);
        clickGo(device);
        verifyProduct(device,AirOptixAqua,AirOptixAqua);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AirOptixAquaMulit);
        clickGo(device);
        verifyProduct(device,AirOptixAquaMulit,AirOptixAquaMulit);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AirOptixAstig);
        clickGo(device);
        verifyProduct(device,AirOptixAstig,AirOptixAstig);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AirOptixNight);
        clickGo(device);
        verifyProduct(device,AirOptixNight,AirOptixNight);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Aqualens38);
        clickGo(device);
        verifyProduct(device,Aqualens38Pdp,Aqualens38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Aqualens55);
        clickGo(device);
        verifyProduct(device,Aqualens55Pdp,Aqualens55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Aqualens55Asph);
        clickGo(device);
        verifyProduct(device,Aqualens55AsphPdp,Aqualens55Asph);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Aqualite38);
        clickGo(device);
        verifyProduct(device,Aqualite38Pdp,Aqualite38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Aqualite55);
        clickGo(device);
        verifyProduct(device,Aqualite55Pdp,Aqualite55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Aqualite55Pro);
        clickGo(device);
        verifyProduct(device,Aqualite55ProPdp,Aqualite55Pro);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Avaira);
        clickGo(device);
        verifyProduct(device,Avaira,Avaira);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,AvairaToric);
        clickGo(device);
        verifyProduct(device,AvairaToric,AvairaToric);


        gotoPage(BuyersGuideLink);
        chooseBrand(device,Biofinity);
        clickGo(device);
        verifyProduct(device,Biofinity,Biofinity);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,BiofinityMulti);
        clickGo(device);
        verifyProduct(device,BiofinityMulti,BiofinityMulti);
        //!!!String 2 of these = "Biofinity Multifocal";

        gotoPage(BuyersGuideLink);
        chooseBrand(device,BiofinityToric);
        clickGo(device);
        verifyProduct(device,BiofinityToric,BiofinityToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Biomedics);
        clickGo(device);
        verifyProduct(device,BiomedicsPdp,Biomedics);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Biomedics38);
        clickGo(device);
        verifyProduct(device,Biomedics38,Biomedics38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Biomedics55);
        clickGo(device);
        verifyProduct(device,Biomedics55,Biomedics55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Biomedics55Evo);
        clickGo(device);
        verifyProduct(device,Biomedics55Evo,Biomedics55Evo);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,BiomedicsPremier);
        clickGo(device);
        verifyProduct(device,BiomedicsPremier,BiomedicsPremier);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,BiomedicsEP);
        clickGo(device);
        verifyProduct(device,BiomedicsEP,BiomedicsEP);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,BiomedicsToric);
        clickGo(device);
        verifyProduct(device,BiomedicsToric,BiomedicsToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,BiomedicsXC);
        clickGo(device);
        verifyProduct(device,BiomedicsXC,BiomedicsXC);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,BioTrue);
        clickGo(device);
        verifyProduct(device,BioTrue,BioTrue);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Clarity);
        clickGo(device);
        verifyProduct(device,Clarity,Clarity);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Clea55A);
        clickGo(device);
        verifyProduct(device,Clea55A,Clea55A);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Clear58);
        clickGo(device);
        verifyProduct(device,Clear58,Clear58);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ClearAll);
        clickGo(device);
        verifyProduct(device,ClearAll,ClearAll);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ClearSight30);
        clickGo(device);
        verifyProduct(device,ClearSight30,ClearSight30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ClearSight90);
        clickGo(device);
        verifyProduct(device,ClearSight90,ClearSight90);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ClearSightToric);
        clickGo(device);
        verifyProduct(device,ClearSightToricPdp,ClearSightToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,DailiesAquaComfort30);
        clickGo(device);
        verifyProduct(device,DailiesAquaComfort30Pdp,DailiesAquaComfort30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,DailiesAquaComfort90);
        clickGo(device);
        verifyProduct(device,DailiesAquaComfort90Pdp,DailiesAquaComfort90);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Encore);
        clickGo(device);
        verifyProduct(device,Encore,Encore);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Expressions);
        clickGo(device);
        verifyProduct(device,Expressions,Expressions);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ExtremeH2O_136);
        clickGo(device);
        verifyProduct(device,ExtremeH2O_136,ExtremeH2O_136);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ExtremeH2O_142);
        clickGo(device);
        verifyProduct(device,ExtremeH2O_142,ExtremeH2O_142);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ExtremeH2O_ToricLC);
        clickGo(device);
        verifyProduct(device,ExtremeH2O_ToricLC,ExtremeH2O_ToricLC);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ExtremeH2O_ToricMC);
        clickGo(device);
        verifyProduct(device,ExtremeH2O_ToricMC,ExtremeH2O_ToricMC);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ExtremeH2O_Thin);
        clickGo(device);
        verifyProduct(device,ExtremeH2O_Thin,ExtremeH2O_Thin);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ExtremeH2O_Xtra);
        clickGo(device);
        verifyProduct(device,ExtremeH2O_Xtra,ExtremeH2O_Xtra);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Flextique38);
        clickGo(device);
        verifyProduct(device,Flextique38Pdp,Flextique38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Flextique55);
        clickGo(device);
        verifyProduct(device,Flextique55Pdp,Flextique55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Flextique55Asph);
        clickGo(device);
        verifyProduct(device,Flextique55AsphPdp,Flextique55Asph);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FocusDAILIES30);
        clickGo(device);
        verifyProduct(device,FocusDAILIES30,FocusDAILIES30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FocusDAILIES90);
        clickGo(device);
        verifyProduct(device,FocusDAILIES90,FocusDAILIES90);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FocusDAILIESProg30);
        clickGo(device);
        verifyProduct(device,FocusDAILIESProg30,FocusDAILIESProg30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FocusDAILIESToric30);
        clickGo(device);
        verifyProduct(device,FocusDAILIESToric30,FocusDAILIESToric30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FocusDAILIESToric90);
        clickGo(device);
        verifyProduct(device,FocusDAILIESToric90,FocusDAILIESToric90);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FocusSoftColors);
        clickGo(device);
        verifyProduct(device,FocusSoftColors,FocusSoftColors);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Frequency55);
        clickGo(device);
        verifyProduct(device,Frequency55,Frequency55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FrequencyAsph);
        clickGo(device);
        verifyProduct(device,FrequencyAsph,FrequencyAsph);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Frequency55TMulti);
        clickGo(device);
        verifyProduct(device,Frequency55TMulti,Frequency55TMulti);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Frequency55Toric);
        clickGo(device);
        verifyProduct(device,Frequency55Toric,Frequency55Toric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Frequency55ToricXR);
        clickGo(device);
        verifyProduct(device,Frequency55ToricXR,Frequency55ToricXR);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FreshLookColorblends);
        clickGo(device);
        verifyProduct(device,FreshLookColorblends,FreshLookColorblends);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FreshLookColorToric);
        clickGo(device);
        verifyProduct(device,FreshLookColorToric,FreshLookColorToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FreshLookColors);
        clickGo(device);
        verifyProduct(device,FreshLookColors,FreshLookColors);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FreshLookDim);
        clickGo(device);
        verifyProduct(device,FreshLookDim,FreshLookDim);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FreshLookTint);
        clickGo(device);
        verifyProduct(device,FreshLookTint,FreshLookTint);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FreshLookDay);
        clickGo(device);
        verifyProduct(device,FreshLookDay,FreshLookDay);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,FreshLookToric);
        clickGo(device);
        verifyProduct(device,FreshLookToric,FreshLookToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Icuity);
        clickGo(device);
        verifyProduct(device,Icuity,Icuity);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Mediflex38);
        clickGo(device);
        verifyProduct(device,Mediflex38,Mediflex38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Mediflex55);
        clickGo(device);
        verifyProduct(device,Mediflex55,Mediflex55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Noob);
        clickGo(device);
        verifyProduct(device,Noob,Noob);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,O2Optix);
        clickGo(device);
        verifyProduct(device,O2Optix,O2Optix);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,OptiFreeDrops);
        clickGo(device);
        verifyProduct(device,OptiFreeDrops,OptiFreeDrops);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,OptiFreePM);
        clickGo(device);
        verifyProduct(device,OptiFreePM,OptiFreePM);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,OptiFreePM2Pk);
        clickGo(device);
        verifyProduct(device,OptiFreePM2Pk,OptiFreePM2Pk);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,OptiFreeReplenish);
        clickGo(device);
        verifyProduct(device,OptiFreeReplenish,OptiFreeReplenish);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Optima38);
        clickGo(device);
        verifyProduct(device,Optima38,Optima38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,OptimaFW);
        clickGo(device);
        verifyProduct(device,OptimaFW,OptimaFW);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,OptimaToric);
        clickGo(device);
        verifyProduct(device,OptimaToric,OptimaToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Perspecta55);
        clickGo(device);
        verifyProduct(device,Perspecta55Pdp,Perspecta55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Polysoft38);
        clickGo(device);
        verifyProduct(device,Polysoft38Pdp,Polysoft38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Polysoft55);
        clickGo(device);
        verifyProduct(device,Polysoft55Pdp,Polysoft55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Polysoft55Asph);
        clickGo(device);
        verifyProduct(device,Polysoft55AsphPdp,Polysoft55Asph);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,PreferenceDW);
        clickGo(device);
        verifyProduct(device,PreferenceDW,PreferenceDW);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,PreferenceStd);
        clickGo(device);
        verifyProduct(device,PreferenceStd,PreferenceStd);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,PreferenceToric);
        clickGo(device);
        verifyProduct(device,PreferenceToric,PreferenceToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Proclear);
        clickGo(device);
        verifyProduct(device,Proclear,Proclear);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Proclear90);
        clickGo(device);
        verifyProduct(device,Proclear90,Proclear90);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Proclear30);
        clickGo(device);
        verifyProduct(device,Proclear30,Proclear30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ProclearEP);
        clickGo(device);
        verifyProduct(device,ProclearEPPdp,ProclearEP);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ProclearMulti);
        clickGo(device);
        verifyProduct(device,ProclearMulti,ProclearMulti);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ProclearToric);
        clickGo(device);
        verifyProduct(device,ProclearToric,ProclearToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ProclearToricXR);
        clickGo(device);
        verifyProduct(device,ProclearToricXR,ProclearToricXR);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Proflex38);
        clickGo(device);
        verifyProduct(device,Proflex38,Proflex38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Proflex55);
        clickGo(device);
        verifyProduct(device,Proflex55,Proflex55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Prosite38);
        clickGo(device);
        verifyProduct(device,Prosite38Pdp,Prosite38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Prosite55);
        clickGo(device);
        verifyProduct(device,Prosite55Pdp,Prosite55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Prosite55Asph);
        clickGo(device);
        verifyProduct(device,Prosite55AsphPdp,Prosite55Asph);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Provision55);
        clickGo(device);
        verifyProduct(device,Provision55,Provision55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ProvisionPremium);
        clickGo(device);
        verifyProduct(device,ProvisionPremium,ProvisionPremium);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,PureVision);
        clickGo(device);
        verifyProduct(device,PureVision,PureVision);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,PureVision2);
        clickGo(device);
        verifyProduct(device,PureVision2,PureVision2);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,PureVision2HD);
        clickGo(device);
        verifyProduct(device,PureVision2HD,PureVision2HD);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,PureVisionMulti);
        clickGo(device);
        verifyProduct(device,PureVisionMultiPdp,PureVisionMulti);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,PureVisionToric);
        clickGo(device);
        verifyProduct(device,PureVisionToric,PureVisionToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,SofLens38);
        clickGo(device);
        verifyProduct(device,SofLens38,SofLens38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,SofLens30);
        clickGo(device);
        verifyProduct(device,SofLens30,SofLens30);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,SofLens90);
        clickGo(device);
        verifyProduct(device,SofLens90Pdp,SofLens90);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,SofLensMulti);
        clickGo(device);
        verifyProduct(device,SofLensMulti,SofLensMulti);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,SofLensToric);
        clickGo(device);
        verifyProduct(device,SofLensToric,SofLensToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,SoftconEW);
        clickGo(device);
        verifyProduct(device,SoftconEW,SoftconEW);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Sterling38);
        clickGo(device);
        verifyProduct(device,Sterling38Pdp,Sterling38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Sterling55);
        clickGo(device);
        verifyProduct(device,Sterling55Pdp,Sterling55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Sterling55Asph);
        clickGo(device);
        verifyProduct(device,Sterling55AsphPdp,Sterling55Asph);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,SuncloudCookie);
        clickGo(device);
        verifyProduct(device,SuncloudCookie,SuncloudCookie);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,SuncloudHook);
        clickGo(device);
        verifyProduct(device,SuncloudHook,SuncloudHook);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Target38);
        clickGo(device);
        verifyProduct(device,Target38Pdp,Target38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Target55);
        clickGo(device);
        verifyProduct(device,Target55Pdp,Target55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Target55Asph);
        clickGo(device);
        verifyProduct(device,Target55AsphPdp,Target55Asph);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,UltraFlex38);
        clickGo(device);
        verifyProduct(device,UltraFlex38Pdp,UltraFlex38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,UltraFlex55);
        clickGo(device);
        verifyProduct(device,UltraFlex55Pdp,UltraFlex55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,UltraFlexII);
        clickGo(device);
        verifyProduct(device,UltraFlexIIPdp,UltraFlexII);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,UltraFlexToric);
        clickGo(device);
        verifyProduct(device,UltraFlexToricPdp,UltraFlexToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,UltraFlexXC);
        clickGo(device);
        verifyProduct(device,UltraFlexXCPdp,UltraFlexXC);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Versaflex38);
        clickGo(device);
        verifyProduct(device,Versaflex38Pdp,Versaflex38);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Versaflex55);
        clickGo(device);
        verifyProduct(device,Versaflex55Pdp,Versaflex55);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,Versaflex55Ash);
        clickGo(device);
        verifyProduct(device,Versaflex55AshPdp,Versaflex55Ash);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,VertexSph);
        clickGo(device);
        verifyProduct(device,VertexSphPdp,VertexSph);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,VertexToric);
        clickGo(device);
        verifyProduct(device,VertexToricPdp,VertexToric);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,VertexToricXR);
        clickGo(device);
        verifyProduct(device,VertexToricXR,VertexToricXR);

        gotoPage(BuyersGuideLink);
        chooseBrand(device,ZADITOR);
        clickGo(device);
        verifyProduct(device,ZADITOR,ZADITOR);

//driver.quit();
    }
}