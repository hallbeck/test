package Automation;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;




/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */


public class TestBase {
    //change this to whatever browser you want to test on
    //choices are ie,firefox,chrome,safari         -- SAFARI DOES NOT SELECT RX VALUES WELL. DO NOT USE
    public String browser = "firefox";
    //only relevant to Firefox. otherwise enter the type of device for file name.
    public String deviceProfile = "desktopFF";

    //public String browser = "";
    public String mbrowser = "firefox";
    public String tbrowser = "chrome";
    public String dbrowser = "ie";
    //change this for ff browser only
    public String deviceProfilePhone = "iphoneOS61P";
    public String deviceProfileTablet = "ipadP";
    public String deviceProfileDesktop = "desktopFF";   //choices are iphoneP, iphoneL, iphoneOS61P, iphoneOS61L, - this is for firefox profiles only


    //public String desktopBaseUrl = "https://www.1800contactstest.com/";
    public String desktopBaseUrl = "https://ww1.1800contactstest.com/";
    //public String desktopBaseUrl = "https://www.1800contacts.com/";
    public String mobileBaseUrl = "https://ww1.1800contactstest.com/";
    public String mobileURL = (mobileBaseUrl + "?responsive=yes");
    public String tabletBaseUrl = "https://ww1.1800contactstest.com/";
    public String tabletURL = (tabletBaseUrl + "?responsive=yes");
    public String fileName = ("TestOut" + new Date().getTime());


    //profiles locations are stored in C:\Users\<user>\AppData\Roaming\Mozilla\Firefox
    //change this file to point to your personal profiles
     //I need to say if device is phone use device profile mobileProfile, if tablet tabletProfile, if desktop desktop

    public ChromeOptions options = new ChromeOptions();
    public DesiredCapabilities capabilities = DesiredCapabilities.chrome();

    public void defineProfile(String TestNumber,String profile){
        printToExcel(TestNumber + profile, profile);
    }
    public void getProfile(String sFileName){
        readFile(sFileName);
    }

    public WebDriver driver = makeDriver(browser,deviceProfile);
    public WebDriver makeDriver(String browser, String deviceProfile) {
        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile profile = allProfiles.getProfile(deviceProfile);
        WebDriver driver = null;
        if (browser.equals("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver(profile);
        } else if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("safari")) {
            driver = new SafariDriver();
        }
        return driver;
    }
    public String makeBaseUrl(String device) {
        String baseUrl = "";
        if (device.equals("phone")) {
            baseUrl = mobileURL;
        } else if (device.equals("desktop")) {
            baseUrl = desktopBaseUrl;
        } else if (device.equals("tablet")) {
            baseUrl = tabletURL;
        }
        return baseUrl;
    }
    public String makeBrowser(String makeBrowser) {
        if (makeBrowser.equals("firefox")) {
            browser = mbrowser;
        } else if (makeBrowser.equals("ie")) {
                browser = dbrowser;
        } else if (makeBrowser.equals("chrome")) {
            browser = tbrowser;
        }
        return browser;
    }
    public String makeProfile(String makeProfile) {
        if (makeProfile.equals("iPadP")) {
            deviceProfile = deviceProfileTablet;
        } else if (makeProfile.equals("ie")) {
            deviceProfile = dbrowser;
        } else if (makeProfile.equals("chrome")) {
            deviceProfile = tbrowser;
        }
        return deviceProfile;
    }
    public void print(String text){
        System.out.println(text);
    }

    public DateTime dt = new DateTime();
    public int iToD = dt.getHourOfDay();
    public int iDay = dt.getDayOfMonth();
    public int iMoY = dt.getMonthOfYear();
    public int iYr = dt.getYear();
    public int iMill = dt.getMillisOfSecond();
    public String pathForExcel = ("c:\\test\\emailAddresses\\" + iMoY + "\\" + iDay + "\\" + deviceProfile +"\\");
    public String pathForScreenshot = ("c:\\test\\screenshots\\"  + iMoY + "\\" + iDay + "\\" + browser + "\\" + deviceProfile +"\\");

    public void takeScreenshot (String screenshotName, String page){
        try{
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String path = (pathForScreenshot + screenshotName + "/" + page + iToD +"oclock.jpg");
            FileUtils.copyFile(scrFile, new File(path));
            System.out.println("screenshot path: " + path);
        }
       catch(Exception e) {
            System.out.println("screenshot did not work");
       }
    }
    public void openWebPage(String device) {
        String baseUrl = makeBaseUrl(device);
        driver.get("https://www.google.com");
        driver.manage().deleteAllCookies();
        Wait(5);
        driver.get(baseUrl);
        Wait(2);
        setCookie();
    }
    public void gotoPage(String addition) {
        driver.get(desktopBaseUrl + addition);
        System.out.println("went to: " + desktopBaseUrl  + addition);
        Wait(3);
    }
    public void gotoPageVTitle(String addition,String expected) {
        driver.get(desktopBaseUrl + addition);
        Wait(1);
        verifyPageTitle(expected);
    }
    public void clickRemove (String device){
        driver.findElement(By.xpath("//a[contains(@id,'cartRemoveLink')]")).click();
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
     public void verifyRebateCart(String device,String rebateAmount){
         if(rebateAmount.equals("0.0")){
             try{
                 WebElement weTotal = driver.findElement(By.xpath("//td[contains(@class,'a41-cart-right-final-total')]"));
                 String strTotal = weTotal.getText();
                 String strNoDollarTotal = strTotal.substring(1);
                 WebElement weTotalAfterRebate = driver.findElement(By.xpath("//td[contains(@style,'color: #0BA14B;')]"));
                 String strTotalAfterRebate = weTotalAfterRebate.getText();
                 String strNoDollarTotalAfterRebate = strTotalAfterRebate.substring(1);
                 float intTotal = Float.parseFloat(strNoDollarTotal);
                 float intTotalAfterRebate = Float.parseFloat(strNoDollarTotalAfterRebate);
                 double actualdRebateAmt = (Math.round(intTotal) - Math.round(intTotalAfterRebate));
                 double actualRebateAmt = Math.ceil(actualdRebateAmt);
                 String strActualRebate = String.valueOf(actualRebateAmt);
                 if(rebateAmount.equals(strActualRebate)){System.out.println("FAIL: " + rebateAmount + " != " + strActualRebate);
                     assert false;}
             }
                 catch(Exception e) {
                     System.out.println("No rebate. Rebate expected is: " + rebateAmount);
                 }
         }
         //add something here that checks if rebateAmount is 0.0 and if it is, make sure there is no weTotalAfterRebate.
       else{ WebElement weTotal = driver.findElement(By.xpath("//td[contains(@class,'a41-cart-right-final-total')]"));
         String strTotal = weTotal.getText();
         String strNoDollarTotal = strTotal.substring(1);
         WebElement weTotalAfterRebate = driver.findElement(By.xpath("//td[contains(@style,'color: #0BA14B;')]"));
         String strTotalAfterRebate = weTotalAfterRebate.getText();
         String strNoDollarTotalAfterRebate = strTotalAfterRebate.substring(1);
         float intTotal = Float.parseFloat(strNoDollarTotal);
         float intTotalAfterRebate = Float.parseFloat(strNoDollarTotalAfterRebate);

         double actualdRebateAmt = (Math.round(intTotal) - Math.round(intTotalAfterRebate));
         double actualRebateAmt = Math.ceil(actualdRebateAmt);
         String strActualRebate = String.valueOf(actualRebateAmt);
         if(rebateAmount.equals(strActualRebate)){System.out.println("PASS: " + rebateAmount + " = " + strActualRebate);
         assert true;
         }
         else {
             System.out.println("FAIL: " + rebateAmount + " != " + strActualRebate);
             assert false;
         }
         }
     }
    public void verifyRebateRS(String device,String rebateAmount){
        if(rebateAmount.equals("0.0")){
            try{
                WebElement weTotal = driver.findElement(By.xpath("(//dd[@class='a41-checkout-review-subtotal'])[4]"));
                String strTotal = weTotal.getText();
                String strNoDollarTotal = strTotal.substring(1);
                WebElement weTotalAfterRebate = driver.findElement(By.xpath("(//dd[@class='totalRebateAmount'])[2]"));
                String strTotalAfterRebate = weTotalAfterRebate.getText();
                String strNoDollarTotalAfterRebate = strTotalAfterRebate.substring(1);

                double intTotal = Double.parseDouble(strNoDollarTotal);
                double intTotalAfterRebate = Double.parseDouble(strNoDollarTotalAfterRebate);
                double actualdRebateAmt = (Math.round(intTotal) - Math.round(intTotalAfterRebate));
                double actualRebateAmt = Math.ceil(actualdRebateAmt);
                String strActualRebate = String.valueOf(actualRebateAmt);
                if(rebateAmount.equals(strActualRebate)){System.out.println("FAIL: " + rebateAmount + " != " + strActualRebate);
                    assert false;
                }
            }
        catch(Exception e) {
            System.out.println("No rebate. Rebate expected is: " + rebateAmount);
        }
        }
       else{
        WebElement weTotal = driver.findElement(By.xpath("(//dd[@class='a41-checkout-review-subtotal'])[4]"));
        String strTotal = weTotal.getText();
        String strNoDollarTotal = strTotal.substring(1);
        WebElement weTotalAfterRebate = driver.findElement(By.xpath("(//dd[@class='totalRebateAmount'])[2]"));
        String strTotalAfterRebate = weTotalAfterRebate.getText();
        String strNoDollarTotalAfterRebate = strTotalAfterRebate.substring(1);

        double intTotal = Double.parseDouble(strNoDollarTotal);
        double intTotalAfterRebate = Double.parseDouble(strNoDollarTotalAfterRebate);
        double actualdRebateAmt = (Math.round(intTotal) - Math.round(intTotalAfterRebate));
        double actualRebateAmt = Math.ceil(actualdRebateAmt);
        String strActualRebate = String.valueOf(actualRebateAmt);
        if(rebateAmount.equals(strActualRebate)){System.out.println("PASS: " + rebateAmount + " = " + strActualRebate);
            assert true;
        }
        else {
            System.out.println("FAIL: " + rebateAmount + " != " + strActualRebate);
            assert false;
        }
    }
}
    public void verifyProduct(String device, String expected, String searchedFor) {
        String state = "";
        try{
            WebElement weText = driver.findElement(By.xpath("//h1[contains(@class,'pageTitle')]"));
            String toVerify = weText.getText();
            verifyTxtPresent("Pages:  Searched for " + searchedFor,expected,toVerify);
            state = "PASS";
        }
        catch(Exception e)
        {
            System.out.println("FAIL: " + expected + "NOT Found. Searched for " + searchedFor );
            state = "FAIL";
        }
        String fileName = (state + "_" + searchedFor+ "_" + expected);
        takeScreenshot(fileName, "SearchBrand");
    }
    public void verifyPageTitle(String expected) {
        try{
        WebElement weText = driver.findElement(By.tagName("title"));
        String toVerify = weText.getText();
        verifyTxtPresent("Pages: ",expected,toVerify);
        }
        catch(Exception e)
        {
            System.out.println("FAIL: " + expected + "NOT Found " );
        }
    }
    public void assertPageTitleError(String expected) {
            WebElement weText = driver.findElement(By.tagName("title"));
            String toVerify = weText.getText();
            if (toVerify.contains(expected)){
                assertTxtPresent("Pages: ",expected,toVerify);
            }
            else{
                WebElement weErrorText = driver.findElement(By.xpath("//div[contains(.,'Error Report')]"));
                String toErrorVerify = weErrorText.getText();
                assertTxtNotPresent("FAIL: ","Error",toErrorVerify);
            }
        Wait(3);
    }
    public void verifyPagePara(String expected) {
        WebElement weText = driver.findElement(By.xpath("//p[contains(.,'" + expected +"')]"));
        String toVerify = weText.getText();
            if (toVerify.contains(expected)){
                assertTxtPresent("Pages: ",expected,toVerify);
            }
            else{
                WebElement weErrorText = driver.findElement(By.xpath("//div[contains(.,'Error Report')]"));
                String toErrorVerify = weErrorText.getText();
                assertTxtNotPresent("FAIL: ","Error",toErrorVerify);
            }
        Wait(3);
    }
    public void assertTxtNotPresent(String identifier, String notDesired, String actual){
        Pattern p = Pattern.compile(notDesired);
        Matcher m = p.matcher(actual);
        // try to find a match
        if (m.find()){
            System.out.println("FAIL " + identifier + "Found " + notDesired + " within " + actual + "." );
            assert false;
        }
        else {
            System.out.println("VERIFIED " + identifier + "NOT FOUND " + notDesired + " within " + actual + "." );
        }
    }
    public void setCookie(){
        String key1 = "fsr.r";
        String value1 = "{\"d\":590,\"i\":-1\"\",\"e\":\"v\":-2,}; path=/;";
        String key = "fsr.s";
        String value = "{\"v\":-2,\"rid\":\"1366734711827_458379\",\"to\":2.4,\"pv\":4,\"lc\":{\"d590\":{\"v\":-2,\"s\":true}},\"cd\":590,\"sd\":590,\"cp\":{\"s_prop2\":\"NI\",\"s_eVar29\\\":\"Control\"},\"f\":1366734744426,\"l\":\"en\",\"i\":-1}";
        Cookie cookie = new Cookie(key, value);
        driver.manage().addCookie(cookie);
        Cookie cookie2 = new Cookie(key1, value1);
        driver.manage().addCookie(cookie2);
        // uncomment if you want to see all the cookies being set.
        //Set<Cookie> allCookies = driver.manage().getCookies();
        // for (Cookie loadedCookie : allCookies) {
        //    System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
       // }
    }
    public void printToExcel(String sFileName, String textToWrite){
        try
        {
            FileWriter writer = new FileWriter(sFileName);
            writer.append(textToWrite);
            writer.append('\n');
            writer.flush();
            writer.close();
            File blah = new File (sFileName);
            FileUtils.copyFile(blah, new File(pathForExcel + sFileName + "_" + iToD +"oclock.csv"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public String readFile(String sFileName){
        BufferedReader br = null;
        String email = "";

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(sFileName));

            if ((sCurrentLine = br.readLine()) != null) {
                email = sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return email;
    }

    public void printPageTitle() {
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page title is: " + driver.getCurrentUrl());
        Wait(2);
  }
    public void printText(String text) {
        System.out.println(text);
        Wait(2);
    }
    public void printTestNumber(String test) {
        System.out.println("Test Covered is: " + test + " " + " " + deviceProfile);
        System.out.println(test);
    }

  public void Wait(long seconds) {
    try {
      Thread.sleep(seconds * 1000);
      //System.out.println("Waiting " + seconds + " seconds");
    } catch (Exception e) {
      print("Sleep exception...its a nightmare");
    }
  }

    public void clickNoThanksButton(String device) {
        printPageTitle();
        try{
        driver.findElement(By.xpath("//img[contains(@alt,'No Thanks')]")).click();
        System.out.println("Clicked No Thanks");
        clickSignOut(device);
        }
            catch (Throwable e)
            {
                System.out.println("No Interstitial Page");
                clickSignOut(device);
            }
        Wait(4);
    }
    public void clickYesButton(String device) {
        printPageTitle();
        String expected = "";
        try{
            driver.findElement(By.xpath("//img[contains(@alt,'Get The App')]")).click();
            System.out.println("Clicked Get the App");
            verifyGetApp(device,expected);
        }
        catch (Throwable e)
        {
            System.out.println("No Interstitial Page");
            clickSignOut(device);
        }
        Wait(4);
    }
  public void clickMainPage_NewButton(String device) {
      printPageTitle();
    driver.findElement(By.xpath("//img[contains(@alt,'New to 1-800 Contacts - Find your contact lens brand')]")).click();
      print("Clicked on New customer button");
    Wait(4);
  }
   public void gotoMyAccount(String device){
       Wait(5);
       if(device.equals("desktop")){
       driver.findElement(By.xpath("//a[contains(@title,'My Account')]")).click();
           print("Clicked on myaccount");
       }
       else if(device.equals("tablet")){
           WebElement weHeader = driver.findElement(By.cssSelector("li.tablet-header-account > a"));
           weHeader.click();
           print("Clicked on myaccount in header");
       }

       else if(device.equals("phone")){
       driver.findElement(By.xpath("//a[contains(@class,'Account-footer-link')]")).click();
           print("Clicked on myaccount footer");
       }
   }
    public void gotoDashboard(String device){
        if(device.equals("desktop")){
        driver.findElement(By.xpath("//a[contains(@id,'dashboardForm')]")).click();
            System.out.println("Clicked on dashboard");
        }
        else if(device.equals("phone")){
            WebElement eleMyAccount = driver.findElement(By.xpath("//div[contains(.,'Dashboard')]"));
            eleMyAccount.click();
            System.out.println("Clicked on dashboard");
        }
        else if(device.equals("tablet")){
            driver.findElement(By.xpath("//a[contains(.,'Dashboard')]")).click();
            System.out.println("Clicked on dashboard");
        }
    }
    public void gotoOrderStatusHistory(String device){
        if(device.equals("desktop")){
        driver.findElement(By.xpath("//a[contains(@id,'orderStatusAndHistoryForm')]")).click();
            System.out.println("Clicked on Order status and history");
        }
        else if(device.equals("phone")){
            WebElement eleOrderStatus = driver.findElement(By.xpath("//a[contains(@id,'orderStatusAndHistoryForm')]"));
            eleOrderStatus.click();
            System.out.println("Clicked on Order status and history");
        }
        else if(device.equals("tablet")){
            driver.get(desktopBaseUrl + "/accounthub/OrderStatusAndHistory");
            System.out.println("Navigated to Order status and history");
        }
    }
    public void gotoShippingBilling(String device){
        Wait(3);
        if(device.equals("desktop")){
        driver.findElement(By.xpath("//a[contains(@id,'shippingBillingForm')]")).click();
            System.out.println("Clicked on Shipping and Billing");
        }
        else if(device.equals("phone")){
            driver.findElement(By.xpath("//div[contains(.,'Shipping & Billing Info')]")).click();
            System.out.println("Clicked on Shipping and Billing");
        }
        else if(device.equals("tablet")){
            driver.findElement(By.cssSelector("#shippingBillingForm > div.tablet-menu-text")).click();
            System.out.println("Clicked on Shipping and Billing");
        }
    }
    public void clickEditBilling(String device){
        driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[3]")).click();
    }
    public void removeBillingAddress(String device){
        //this is a placeholder. confirm that it works. nothing uses it currently
        driver.findElement(By.id("RemoveBillingInformationForm")).click();
    }
    public void removeShippingAddress(String device){
        //this is a placeholder. confirm that it works. nothing uses it currently
        driver.findElement(By.id("RemoveShippingInformationForm")).click();
    }
    public void clickEditPayment(String device){
        driver.findElement(By.xpath("//a[contains(@id,'paymentEditLink')]")).click();
    }
    public void clickEditShipping(String device){
        Wait(3);
        System.out.println("clicking on edit");
        if(device.equals("tablet")){
            driver.findElement(By.linkText("Edit")).click();
        }
        else if(device.equals("phone")){
            driver.findElement(By.linkText("Edit")).click();
        }
        else if(device.equals("desktop")){
        driver.findElement(By.xpath("//a[contains(@class,'address-edit a41-edit-link popupTrigger')]")).click();
        }
        System.out.println("clicked on edit");
    }
    public String editShipping(String device,String fName,String lName,String country,String city, String state, String stateAbrev,String zip){
        /*try{
            driver.switchTo().defaultContent();
            WebElement frame = driver.findElement(By.id("ShippingAddress"));
            driver.switchTo().frame(frame);
            //System.out.println("Windows: ");
            //driver.switchTo().frame("s_objectID = 'shippingBillingForm';");
            System.out.println("shippingBillingForm");
        }*/
        //catch (Throwable e){System.out.println("Tried s_objectID = 'shippingBillingForm'");}
        //driver.findElement(By.xpath("//div[contains(@id,'ShippingAddress')]")).click();
        long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        String theNumberString = "" + number;

        print("find fname");
        WebElement weFirstName = driver.findElement(By.cssSelector("#editShippingAddress > div.a41-checkout-row.a41-clearfix > div > span.a41-checkout-half-col2 > #AddressDetailsViewModel_FirstName"));
        print("find lname");
        WebElement weLastName = driver.findElement(By.cssSelector("#editShippingAddress > div.a41-checkout-row.a41-clearfix > div > span.a41-checkout-half-col2 > #AddressDetailsViewModel_LastName"));
        print("find address");
        WebElement weAddress = driver.findElement(By.cssSelector("#editShippingAddress > div.a41-checkout-row.a41-clearfix  > div > span.a41-checkout-half-col2 > #AddressDetailsViewModel_AddressLine1"));
        print("find city");
        WebElement weCity = driver.findElement(By.xpath("(//input[@id='AddressDetailsViewModel_City'])[2]"));

        WebElement weZip = driver.findElement(By.xpath("(//input[@id='AddressDetailsViewModel_ZipOrPostalCode'])[2]"));

        WebElement weCountry = null;
        WebElement wePhone = null;

        if (country.equals("united states")){
            new Select(driver.findElement(By.xpath("(//select[@id='AddressDetailsViewModel_StateProvinceOrRegion'])[2]"))).selectByVisibleText(state);
            String strState =  "(//option[@value='" + stateAbrev + "'])[2]";
            driver.findElement(By.xpath(strState)).click();
            System.out.println("State is: " + state);
        }
        else if (country.equals("canada")) {
            print("find province");
            new Select(driver.findElement(By.xpath("(//select[@id='AddressDetailsViewModel_StateProvinceOrRegion'])[2]"))).selectByVisibleText(state);
            String strState =  "(//option[@value='" + stateAbrev + "'])[2]";
            driver.findElement(By.xpath(strState)).click();
            System.out.println("Canadian Province is: " + state);
        }
        else {
            print("find region");
            driver.findElement(By.xpath("(//input[@id='AddressDetailsViewModel_StateProvinceOrRegion'])[2]")).sendKeys(state,Keys.TAB);
            System.out.println("International Region is: " + state);
        }
        /*driver.findElement(By.xpath("//label[contains(@for,'a41-checkout-first-name')]")).clear();
        driver.findElement(By.xpath("//input[contains(@for,'a41-checkout-first-name')]")).sendKeys(fName);
        print("Clicked on name");
        driver.findElement(By.xpath("//input[contains(@for,'a41-checkout-last-name')]")).clear();
        driver.findElement(By.xpath("//input[contains(@for,'a41-checkout-last-name')]")).sendKeys(lName);
        driver.findElement(By.xpath("//div[contains(@id,'uniform-AddressDetailsViewModel_Country')]")).click();
        driver.findElement(By.xpath("//div[contains(@id,'uniform-AddressDetailsViewModel_Country')]")).sendKeys(country);
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_AddressLine1')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_AddressLine1')]")).sendKeys("ship address " + theNumberString);
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_City')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_City')]")).sendKeys(city);
        driver.findElement(By.xpath("//div[contains(@id,'uniform-AddressDetailsViewModel_StateProvinceOrRegion')]")).click();
        driver.findElement(By.xpath("//div[contains(@id,'uniform-AddressDetailsViewModel_StateProvinceOrRegion')]")).sendKeys();
        driver.findElement(By.xpath("//input[contains(@id,'PhoneNumber')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'PhoneNumber')]")).sendKeys(theNumberString);
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_ZipOrPostalCode')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_ZipOrPostalCode')]")).sendKeys();*/
        ///
        weFirstName.clear();
        weFirstName.sendKeys(fName);
        weLastName.clear();
        weLastName.sendKeys(lName);
        weAddress.clear();
        weAddress.sendKeys(theNumberString + " address");
        weCity.clear();
        weCity.sendKeys(city);
        weCity.clear();
        weCity.sendKeys(city);
        weZip.clear();
        weZip.sendKeys(zip);
        return (theNumberString + " address");
    }
    public void clickSaveShipping (String device){
        driver.findElement(By.xpath("//input[contains(@id,'SaveShippingButton')]")).click();
    }
    public String editBilling(String device,String fName,String lName,String country,String city, String state, String stateAbrev,String zip){
        /*try{
            driver.switchTo().defaultContent();
            WebElement frame = driver.findElement(By.id("ShippingAddress"));
            driver.switchTo().frame(frame);
            //System.out.println("Windows: ");
            //driver.switchTo().frame("s_objectID = 'shippingBillingForm';");
            System.out.println("shippingBillingForm");
        }*/
        //catch (Throwable e){System.out.println("Tried s_objectID = 'shippingBillingForm'");}
        //driver.findElement(By.xpath("//div[contains(@id,'ShippingAddress')]")).click();
        long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        String theNumberString = "" + number;

        print("find fname");
        WebElement weFirstName = driver.findElement(By.cssSelector("#editBillingAddress > div.a41-checkout-row.a41-clearfix > div > span.a41-checkout-half-col2 > #AddressDetailsViewModel_FirstName"));
        print("find lname");
        WebElement weLastName = driver.findElement(By.cssSelector("#editBillingAddress > div.a41-checkout-row.a41-clearfix > div > span.a41-checkout-half-col2 > #AddressDetailsViewModel_LastName"));
        print("find address");
        WebElement weAddress = driver.findElement(By.cssSelector("#editBillingAddress > div.a41-checkout-row.a41-clearfix  > div > span.a41-checkout-half-col2 > #AddressDetailsViewModel_AddressLine1"));
        print("find city");
        WebElement weCity = driver.findElement(By.xpath("(//input[@id='AddressDetailsViewModel_City'])[2]"));

        WebElement weZip = driver.findElement(By.xpath("(//input[@id='AddressDetailsViewModel_ZipOrPostalCode'])[2]"));

        WebElement weCountry = null;
        WebElement wePhone = null;

        if (country.equals("united states")){
            new Select(driver.findElement(By.xpath("(//select[@id='AddressDetailsViewModel_StateProvinceOrRegion'])[2]"))).selectByVisibleText(state);
            String strState =  "(//option[@value='" + stateAbrev + "'])[2]";
            driver.findElement(By.xpath(strState)).click();
            System.out.println("State is: " + state);
        }
        else if (country.equals("canada")) {
            print("find province");
            new Select(driver.findElement(By.xpath("(//select[@id='AddressDetailsViewModel_StateProvinceOrRegion'])[2]"))).selectByVisibleText(state);
            String strState =  "(//option[@value='" + stateAbrev + "'])[2]";
            driver.findElement(By.xpath(strState)).click();
            System.out.println("Canadian Province is: " + state);
        }
        else {
            print("find region");
            driver.findElement(By.xpath("(//input[@id='AddressDetailsViewModel_StateProvinceOrRegion'])[2]")).sendKeys(state,Keys.TAB);
            System.out.println("International Region is: " + state);
        }
        /*driver.findElement(By.xpath("//label[contains(@for,'a41-checkout-first-name')]")).clear();
        driver.findElement(By.xpath("//input[contains(@for,'a41-checkout-first-name')]")).sendKeys(fName);
        print("Clicked on name");
        driver.findElement(By.xpath("//input[contains(@for,'a41-checkout-last-name')]")).clear();
        driver.findElement(By.xpath("//input[contains(@for,'a41-checkout-last-name')]")).sendKeys(lName);
        driver.findElement(By.xpath("//div[contains(@id,'uniform-AddressDetailsViewModel_Country')]")).click();
        driver.findElement(By.xpath("//div[contains(@id,'uniform-AddressDetailsViewModel_Country')]")).sendKeys(country);
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_AddressLine1')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_AddressLine1')]")).sendKeys("ship address " + theNumberString);
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_City')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_City')]")).sendKeys(city);
        driver.findElement(By.xpath("//div[contains(@id,'uniform-AddressDetailsViewModel_StateProvinceOrRegion')]")).click();
        driver.findElement(By.xpath("//div[contains(@id,'uniform-AddressDetailsViewModel_StateProvinceOrRegion')]")).sendKeys();
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_ZipOrPostalCode')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'AddressDetailsViewModel_ZipOrPostalCode')]")).sendKeys();*/
        ///
        weFirstName.clear();
        weFirstName.sendKeys(fName);
        weLastName.clear();
        weLastName.sendKeys(lName);
        weAddress.clear();
        weAddress.sendKeys(theNumberString + " address");
        weCity.clear();
        weCity.sendKeys(city);
        weCity.clear();
        weCity.sendKeys(city);
        weZip.clear();
        weZip.sendKeys(zip);
        return (theNumberString + " address");
    }
    public void clickSaveBilling (String device){
        driver.findElement(By.xpath("//input[contains(@id,'SaveBillingButton')]")).click();
        Wait(5);
    }
    public void enterOrderCode (String device,String orderCode){
        //desktop
        driver.findElement(By.xpath("//a[contains(@id,'cartOrderCodeLink')]")).click();
        driver.findElement(By.xpath("//input[contains(@id,'couponCode')]")).sendKeys(orderCode);
        driver.findElement(By.xpath("//input[contains(@class,'applyCodeButton')]")).click();
    }

    //reorder checkboxes this uses tabs to click each. two tabs, click tab click
    public void checkReorderCheckboxOne(){
        //go to dashboard cause I can't use lightbox
        driver.get(desktopBaseUrl + "accounthub");
        Wait(2);
        printPageTitle();
        WebElement eleMyAccount = driver.findElement(By.xpath("//div[contains(@class,'rxSummaryLineItemColumn memberRecentPrescription')]"));
        eleMyAccount.click();
        Wait(2);
        //tab five times then space
        print("sending tabs");
        eleMyAccount.sendKeys(Keys.chord(Keys.SHIFT, Keys.TAB),Keys.SPACE);
        Wait(2);
    }
    public void checkReorderCheckboxTwo(String device){
        if(device.equals("desktop")){   //desktop
        driver.get(desktopBaseUrl + "accounthub");
        WebElement eleMyAccount = driver.findElement(By.xpath("//a[contains(@id,'dashboardForm')]"));
        eleMyAccount.click();
        Wait(2);
        eleMyAccount.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,Keys.SPACE);
        driver.findElement(By.xpath("//input[contains(@id,'reorderRx')]")).click();
        Wait(4);
        print("reordered desktop");
        Wait(4);
    }
        else if(device.equals("phone")){  //mobile
            driver.findElement(By.xpath("//div[contains(.,'Welcome to your personal contact lens dashboard.')]"));
            driver.get(desktopBaseUrl + "accounthub");
            WebElement eleMyAccount = driver.findElement(By.xpath("//div[contains(.,'Dashboard')]"));
            eleMyAccount.click();
            Wait(2);
            eleMyAccount.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,Keys.SPACE);
            Wait(2);
            driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-phone rd-orangeButton rd-stretchButton ')]")).click();
            Wait(4);
            print("reordered phone");
        }
        else if(device.equals("tablet")){     //tablet
            driver.findElement(By.xpath("//div[contains(.,'Welcome to your personal contact lens dashboard.')]"));
            driver.get(desktopBaseUrl + "accounthub");
            WebElement eleMyAccount = driver.findElement(By.xpath("//div[contains(.,'Dashboard')]"));
            Wait(2);
            eleMyAccount.click();
            Wait(2);
            eleMyAccount.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,Keys.SPACE);
            driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-tablet rd-orangeButton rd-tabletRightButton')]")).click();
            Wait(4);
            print("reordered tablet");
        }
        System.out.println("sent tabs");
    }

    //continue button from the reorder Lightbox
    public void clickContinueFromReorder(String device){
        System.out.println("clicking continue");
        driver.findElement(By.xpath("//input[contains(@src,'continue.png')]")).click();
    }
    public void clickReorderTheseRxButton(){
        driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-phone rd-orangeButton rd-stretchButton ')]")).click();
    }
    public void clickFindBrand(String device) {
        printPageTitle();
        Wait(4);
        if(device.equals("phone")){
        driver.findElement(By.xpath("//a[contains(@class,'FindBrand-footer-link')]")).click();
        System.out.println("Clicked on Find Your Brand footer link phone");
        }
        else if(device.equals("tablet")){
            driver.findElement(By.xpath("//a[contains(@id,'tablet-find-brand')]")).click();
            System.out.println("Clicked on Find Your Brand footer link tablet");
        }
        else if(device.equals("desktop")){
            driver.findElement(By.xpath("//input[contains(@id,'HeaderSearchTextBox')]")).click();
            System.out.println("Clicked Search by Brand box desktop");
        }
        Wait(4);
    }
    public void clickFindBrandDesktop() {
        printPageTitle();
        Wait(4);
        // phone
        driver.findElement(By.xpath("//img[contains(@alt,'New to 1-800 Contacts - Find your contact lens brand')]")).click();
        //driver.findElement(By.linkText("How to Order")).click();
        System.out.println("<H1>Clicked on Find your brand button</H1>");
        Wait(4);
    }
    public void clickReorderPhoneMainPage(String device) {
        printPageTitle();
        Wait(4);
        driver.findElement(By.xpath("//a[contains(@class,'Account-footer-link')]")).click();
        System.out.println("Clicked on My Account footer link");
        Wait(4);
    }
    public void clickPhoneMainPage_NewButton(String device) {
        printPageTitle();
        Wait(4);
        WebElement weNewCust = driver.findElement(By.partialLinkText("New"));
        System.out.println("Found" + weNewCust);
        weNewCust.click();
        System.out.println("Clicked on New customer button");
        System.out.println("Clicked" + weNewCust);
        Wait(4);
    }

    public void goToSignInPage(String device){
        if(device.equals("phone")){
            driver.get(desktopBaseUrl + "signin.aspx" + "?responsive=yes");
        }
        else if(device.equals("tablet")){
            driver.get(desktopBaseUrl + "signin.aspx" + "?responsive=yes");
        }
        else if(device.equals("desktop")){
            driver.get(desktopBaseUrl + "signin.aspx");
        }
    }
    public void selectNewCustomer(String device){
        Wait(5);
        if(device.equals("phone")){
            WebElement weNewCustomer = driver.findElement(By.xpath("//label[contains(@for,'rbNewCustomer')]"));
        weNewCustomer.click();
        }
        else if(device.equals("tablet")){
            WebElement weNewCustomer = driver.findElement(By.xpath("//div[contains(@class,'touchRadioBtn rd-phone rd-tablet')]"));
            weNewCustomer.click();
        }
        else if(device.equals("desktop")){
            WebElement weNewCustomer = driver.findElement(By.xpath("//label[contains(@for,'ctl00_contentPlaceHolderContent_SignIn1_rbNewCustomer')]"));
            weNewCustomer.click();
        }
    }
    public void typeNewCustomerSigninPage(String device,String email,String testNumber,String password){
        String theEmailString = email + "_" + new Date().getTime() + "@invalid.com";
        if(device.equals("tablet")){
        driver.findElement(By.xpath("//input[contains(@placeholder,'Email Address')]")).sendKeys(theEmailString);
        System.out.println("Email used is: " + theEmailString);
        printToExcel(testNumber,theEmailString);
        WebElement weEmailConfirm = driver.findElement(By.xpath("//input[contains(@onblur,'tbNewCustomerEmailConfirm(this.value);')]"));
        weEmailConfirm.sendKeys(theEmailString);
        typeNewCustPassword(device,password);
        }
        else if(device.equals("phone")){
            driver.findElement(By.xpath("//input[contains(@placeholder,'Email Address')]")).sendKeys(theEmailString);
            System.out.println("Email used is: " + theEmailString);
            printToExcel(testNumber,theEmailString);
            WebElement weEmailConfirm = driver.findElement(By.xpath("//input[contains(@onblur,'tbNewCustomerEmailConfirm(this.value);')]"));
            weEmailConfirm.sendKeys(theEmailString);
            typeNewCustPassword(device,password);
        }
        else if(device.equals("desktop")){
            driver.findElement(By.xpath("//input[contains(@onblur,'tbEmail(this.value);')]")).sendKeys(theEmailString);
            System.out.println("Email used is: " + theEmailString);
            printToExcel(testNumber,theEmailString);
            WebElement weEmailConfirm = driver.findElement(By.xpath("//input[contains(@onblur,'tbNewCustomerEmailConfirm(this.value);')]"));
            weEmailConfirm.sendKeys(theEmailString);
            typeNewCustPassword(device,password);
        }
    }
    public void clickReturningCustomer(String device){
        WebElement weRetCustomerButton = driver.findElement(By.xpath("//h1[contains(.,'Returning Customer?')]"));
        print("about to click returning customer");
        weRetCustomerButton.click();
        print("clicked returning customer");
    }

       public void typeReturningPhoneEmail(String testNumberDependentOn) {
        printPageTitle();
           String RIemail = readFile(testNumberDependentOn);
        Wait(4);
           WebElement emailInput = driver.findElement(By.xpath("//input[(@id='ctl00_contentPlaceHolderContent_SignIn1_tbEmail_tbEmail')]"));
           emailInput.click();
           emailInput.clear();
           System.out.println("clicked and cleared");
           emailInput.sendKeys(RIemail);
        System.out.println("Email used is: " + RIemail);
    }
    public void typeNewCustPassword(String device,String password){
        WebElement wePassword = driver.findElement(By.xpath("//input[contains(@id,'ctl00_contentPlaceHolderContent_SignIn1_tbNewCustomerPassword_tbPass')]"));
        WebElement wePasswordConfirm = driver.findElement(By.xpath("//input[contains(@id,'ctl00_contentPlaceHolderContent_SignIn1_tbNewCustomerPasswordConfirm_tbPass')]"));
        wePassword.sendKeys(password);
        wePasswordConfirm.sendKeys(password);
    }
    public void typeReturningPhonePassword(String device,String password) {
        Wait(4);
        WebElement passwordInput = driver.findElement(By.xpath("//input[(@id='ctl00_contentPlaceHolderContent_SignIn1_tbReturningCustomerPassword_tbPass')]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        System.out.println("Password used is: " + password);
    }
    public void typeReturningEmailLightbox(String device,String testNumberDependentOn) {
        printPageTitle();
        String RIemail = readFile(testNumberDependentOn);
        Wait(4);
        WebElement emailInput = driver.findElement(By.cssSelector("#reorderResponsifyPopUp > #signInForm > #signInLightBoxEmail"));
        emailInput.click();
        emailInput.clear();
        System.out.println("clicked and cleared");
        emailInput.sendKeys(RIemail);
        System.out.println("Email used is: " + RIemail);
    }
    public void typeReturningPasswordLightbox(String device,String password) {
        Wait(4);
        WebElement passwordInput = driver.findElement(By.cssSelector("#reorderResponsifyPopUp > #signInForm > #signInLightBoxPassword"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        System.out.println("Password used is: " + password);
    }
     public void clickSignInLightbox(String device){
         driver.findElement(By.xpath("(//input[@id='ReturningCustomerReOrderButton'])[6]")).click();
         Wait(5);
     }
    public void clickForgotPasswordLightbox(String device){
        driver.findElement(By.cssSelector("#reorderResponsifyPopUp > #signInForm > div.signInButtonDiv > div.helpLinks > #SignInLightBoxReturningCustomerForgotPassword")).click();
    }
    public void clickSignIn(String device) {
        printPageTitle();
        if(device.equals("phone")){
        try{   //phone
            driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-phone rd-stretchButton rd-orangeButton')]")).click();
            System.out.println("Clicked Sign In Phone");
            Wait(6);
        }
        catch (Throwable e){System.out.println("Could not Sign In phone");}
        }
        else if(device.equals("tablet")){
        try{   //tablet
            driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-tablet rd-tabletRightButton rd-orangeButton')]")).click();
            System.out.println("Clicked Sign In tablet");
            Wait(6);
        }
        catch (Throwable e){System.out.println("Could not Sign In tablet");}
        }
        else if(device.equals("desktop")){
        try{   //desktop
            driver.findElement(By.xpath("//input[contains(@class,'btnSignIn')]")).click();
            System.out.println("Clicked Sign In desktop");
            Wait(6);
        }
        catch (Throwable e){System.out.println("Could not Sign In desktop");}
        }
    }
    public void clickSignOut(String device){
        if(device.equals("desktop")){
            try{
            driver.findElement(By.xpath("//a[contains(@title,'Sign Out')]")).click();
            System.out.println("Signed out");
            Wait(3);
            }
            catch (Throwable e){System.out.println("Could not Sign Out - may be signed out already");}
        }
        else if(device.equals("phone")){
            try{
                gotoPage("Account/SignOut");
                print("Signed out");
                Wait(3);
            }
            catch (Throwable e){System.out.println("Could not Sign Out - may be signed out already");}
        }
        else if(device.equals("tablet")){
            try{
                gotoPage("Account/SignOut");
                System.out.println("Signed out");
                Wait(3);
            }
            catch (Throwable e){System.out.println("Could not Sign Out - may be signed out already");}
        }
        gotoPage("");
        print("back to home page");
    }



     //this is not working because it is not finding the search button. it has no link associated, just js. SO...
    //once it starts working uncomment searchAllBrand and rename the used searchAllBrand to Go to all Lenses
    public void searchAllBrand(String device,String search) {
        Wait(4);
        System.out.println("About to search for brand: " + search);
        if(device.equals("phone")){
        driver.findElement(By.xpath("//a[contains(.,'Search')]")).click();
        driver.findElement(By.xpath("//input[contains(@name,'searchTerm')]")).click();
        driver.findElement(By.xpath("//input[contains(@name,'searchTerm')]")).sendKeys(search, Keys.ENTER);
            System.out.println("Searched for brand: " + search);
        }
        else { //for desktop or tablet
            driver.findElement(By.xpath("//input[contains(@name,'searchTerm')]")).click();
            driver.findElement(By.xpath("//input[contains(@name,'searchTerm')]")).clear();
            driver.findElement(By.xpath("//input[contains(@name,'searchTerm')]")).sendKeys(search, Keys.ENTER);
            System.out.println("Searched for brand: " + search);
    }
        Wait(7);
    }
     //UNKNOWN if it works
    public void clickSeeAll(String device) {
        driver.findElement(By.xpath("//div[contains(.,'See All')]")).click();
        System.out.println("Clicked See All");
    }

    public void clickAccessory(String device,String brand) {
        if(device.equals("phone")){
            String theString = "//a[contains(@id,'" + brand + "')]";
            driver.findElement(By.xpath(theString)).click();
            System.out.println("Clicked on brand: " + brand);
        }
        else {
            String theString = "BrandText_" + brand;
            driver.findElement(By.id(theString)).click();
            print("Clicked on accessory: " + brand);
        }
        Wait(6);
    }
    public void clickPhoneBrand(String device,String brand) {
        if(device.equals("phone")){
            String theString = "//a[contains(@id,'" + brand + "')]";
            driver.findElement(By.xpath(theString)).click();
            System.out.println("Clicked on brand: " + brand);
        }
        else {
            String theString = "//a[contains(@id,'BrandSelectButton_" + brand + "')]";
            driver.findElement(By.xpath(theString)).click();
            System.out.println("Clicked on brand: " + brand);
        }
      Wait(6);
  }
   public void checkBoxLeftEye(String device) {
       driver.findElement(By.xpath("//input[contains(@class,'LeftEyeCheckBox')]")).click();
   }

    public void checkBoxRightEye(String device) {
        driver.findElement(By.xpath("//input[contains(@class,'RightEyeCheckBox')]")).click();
    }
  public void clickRPower(String device,String posR,String power) {
      if(device.equals("phone")){
          WebElement selectElement = driver.findElement
                    (By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.SphericalPower')]"));
// Then instantiate the Select class with that WebElement
          Select select = new Select(selectElement);
// Get a list of the options
          List<WebElement> options = select.getOptions();
// For each option in the list, verify if it's the one you want and then click it
          for (WebElement we : options) {
              if (we.getText().equals(posR+power)) {
                  we.click();
                  break;
              }
          }
    }
      else if(device.equals("tablet")){
          try {
              WebElement selectElement = driver.findElement
                      (By.xpath("//select[contains(@id,'ProductPageViewModel_PrescriptionViewModel_RightEyeViewModel_EyePrescriptionViewModel_SphericalPower')]"));
          Select select = new Select(selectElement);
          List<WebElement> options = select.getOptions();
          for (WebElement we : options) {
              if (we.getText().equals(posR+power)) {
                  we.click();
                  break;
              }
          }
          System.out.println("Power for right eye: " + posR + power);
      }
          catch (Throwable e){
               //this is for freshlook colorblends toric
              WebElement selectElement = driver.findElement
                      (By.xpath("//select[contains(@id,'PrescriptionViewModel_RightEyeViewModel_EyePrescriptionViewModel_SphericalPower')]"));
              Select select = new Select(selectElement);
              List<WebElement> options = select.getOptions();
              for (WebElement we : options) {
                  if (we.getText().equals(posR+power)) {
                      we.click();
                      break;
                  }
              }
              System.out.println("Power for right eye: " + posR + power);
          }
      }
      else if(device.equals("desktop")){
          Wait(5);
          try {
          driver.findElement(By.xpath("//input[contains(@id,'RightPowerPicker')]")).click();
              //WebElement selectElement = driver.findElement(By.xpath("//select[contains(@id,'PrescriptionViewModel_RightEyeViewModel_EyePrescriptionViewModel_SphericalPower')]"));
          WebElement wePower = driver.findElement(By.xpath("//a[contains(@id,'Right_" + power +"')]"));
          wePower.click();
          System.out.println("Power for right eye: " + posR + power);
          }
          catch (Throwable e){
              WebElement selectElement = driver.findElement(By.xpath("//select[contains(@id,'ProductPageViewModel_PrescriptionViewModel_RightEyeViewModel_EyePrescriptionViewModel_SphericalPower')]"));
              Select select = new Select(selectElement);
              driver.findElement(By.xpath("//a[contains(.,power)]"));
              List<WebElement> options = select.getOptions();
              for (WebElement we : options) {
              if (we.getText().equals(power)) {
              we.click();
              System.out.println("Power for right eye: " + posR + power);
               break;
               }
              }
          }
          Wait(5);
      }
  }

    public void clickLPower(String device,String posL,String power) {
        if(device.equals("desktop")){
            Wait(5);
            try {
            driver.findElement(By.xpath("//input[contains(@id,'LeftPowerPicker')]")).click();
            //WebElement selectElement = driver.findElement(By.xpath("//select[contains(@id,'PrescriptionViewModel_RightEyeViewModel_EyePrescriptionViewModel_SphericalPower')]"));
            WebElement wePower = driver.findElement(By.xpath("//a[contains(@id,'Left_" + power +"')]"));
            wePower.click();
            System.out.println("Power for Left eye: " + posL + power);
            Wait(5);
            }
            catch (Throwable e){
                WebElement selectElement = driver.findElement(By.xpath("//select[contains(@id,'ProductPageViewModel_PrescriptionViewModel_LeftEyeViewModel_EyePrescriptionViewModel_SphericalPower')]"));
                Select select = new Select(selectElement);
                driver.findElement(By.xpath("//a[contains(.,power)]"));
                List<WebElement> options = select.getOptions();
                for (WebElement we : options) {
                    if (we.getText().equals(power)) {
                        we.click();
                        System.out.println("Power for Left eye: " + posL + power);
                        break;
                    }
                }
            }
        }
        else{
            try {WebElement selectElement =
                    driver.findElement(By.xpath("//select[contains(@name,'PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.SphericalPower')]"));
// Then instantiate the Select class with that WebElement
            Select select = new Select(selectElement);
// Get a list of the options
            List<WebElement> options = select.getOptions();
// For each option in the list, verify if it's the one you want and then click it
            for (WebElement we : options) {
                if (we.getText().equals(posL + power)) {
                    we.click();
                    break;
                }
            }
        System.out.println("Power for left eye: "+ posL  + power);
            }
            catch (Throwable e){try {  //this is for freshlook colorblends toric
                WebElement selectElement = driver.findElement
                        (By.xpath("//select[contains(@id,'PrescriptionViewModel_LeftEyeViewModel_EyePrescriptionViewModel_SphericalPower')]"));
                Select select = new Select(selectElement);
                List<WebElement> options = select.getOptions();
                for (WebElement we : options) {
                    if (we.getText().equals(posL+power)) {
                        we.click();
                        break;
                    }
                }
                System.out.println("Power for left eye: " + posL  + power);
            }
            catch (Throwable E){}}
        }
        Wait(1);
    }
    public void clickRDN(String device,String DN) {
        WebElement weDNNumber = driver.findElement(By.xpath("//select[contains(@id,'ProductPageViewModel_PrescriptionViewModel_RightEyeViewModel_EyePrescriptionViewModel_Dominant')]"));
        weDNNumber.click();
        weDNNumber.sendKeys(DN);
        System.out.println("Dom/NonDom for right eye: " + DN);
        Wait(5);
    }
    public void clickLDN(String device,String DN) {
        WebElement weDNNumber = driver.findElement(By.xpath("//select[contains(@id,'ProductPageViewModel_PrescriptionViewModel_LeftEyeViewModel_EyePrescriptionViewModel_Dominant')]"));
        //WebElement weDNNumber = driver.findElement(By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.Dominant')]"));
        //weDNNumber.click();
        weDNNumber.sendKeys(DN);
        System.out.println("Dom/NonDom for left eye: " + DN);
        Wait(5);
    }

  public void clickRBC(String bc) {
    String thePickerString = "//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.BaseCurve')]";
      WebElement weBc = driver.findElement(By.xpath(thePickerString));
      weBc.click();
      System.out.println("BC for right eye: " + bc);
      weBc.sendKeys(bc,Keys.ENTER);
      Wait(1);
  }
    public void clickLBC(String bc) {
        String thePickerString = "//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.BaseCurve')]";
        WebElement weBc = driver.findElement(By.xpath(thePickerString));
        weBc.click();
        System.out.println("BC for left eye: " + bc);
        weBc.sendKeys(bc,Keys.ENTER);
        Wait(1);
    }
    public void clickRDia(String dia) {
        WebElement weDia2 = driver.findElement
                (By.xpath("//select[contains(@name,'PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.DiameterLength')]"));
        weDia2.click();
        weDia2.sendKeys(dia,Keys.ENTER);
        System.out.println("Dia for right eye: " + dia);
        Wait(1);
    }
    public void clickLDia(String dia) {
            WebElement weDia2 = driver.findElement
                    (By.xpath("//select[contains(@name,'PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.DiameterLength')]"));;
            weDia2.click();
            weDia2.sendKeys(dia,Keys.ENTER);
            System.out.println("Dia for left eye: " + dia);
        Wait(1);
    }

    public void clickRCyl(String cyl) {
        WebElement weCyl = driver.findElement
                (By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.CylinderPower')]"));
        weCyl.click();
        System.out.println("Cyl for right eye: " + cyl);
        weCyl.sendKeys(cyl,Keys.ENTER);
        Wait(1);
    }
    public void clickLCyl(String cyl) {
        WebElement weCyl = driver.findElement
                (By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.CylinderPower')]"));
        weCyl.click();
        System.out.println("Cyl for left eye: " + cyl);
        weCyl.sendKeys(cyl,Keys.ENTER);
        Wait(1);
    }
    public void clickRAxis(String axis) {
        WebElement weAxis = driver.findElement
                (By.xpath("//select[contains(@name,'PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.AxisDegree')]"));
        weAxis.click();
        System.out.println("Axis for right eye: " + axis);
        weAxis.sendKeys(axis,Keys.ENTER);
        Wait(1);
    }
    public void clickLAxis(String axis) {
        WebElement weAxis = driver.findElement
                (By.xpath("//select[contains(@name,'PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.AxisDegree')]"));
        weAxis.click();
        System.out.println("Axis for left eye: " + axis);
        weAxis.sendKeys(axis,Keys.ENTER);
        Wait(1);
    }
    public void clickRColor(String color) {
        WebElement weColor = driver.findElement
                (By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.ColorId')]"));
        weColor.click();
        weColor.sendKeys(color,Keys.ENTER);
        System.out.println("Color for right eye: " + color);
        Wait(1);
    }
    public void clickLColor(String color) {
        WebElement weColor = driver.findElement
                (By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.ColorId')]"));
        weColor.click();
        System.out.println("Color for left eye: " + color);
        weColor.sendKeys(color,Keys.ENTER);
        Wait(1);
    }
    public void clickRboxes(String box) {
        WebElement weBox = driver.findElement
                (By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.Quantity')]"));
        weBox.click();
        System.out.println("Boxes for right eye: " + box);
        weBox.sendKeys(box,Keys.ENTER);
        System.out.println(box + " boxes Right Eye");
        Wait(1);
    }
    public void clickLboxes(String box) {
        WebElement weBox = driver.findElement
                (By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.Quantity')]"));
        weBox.click();
        System.out.println("Boxes for left eye: " + box);
        weBox.sendKeys(box,Keys.ENTER);
        System.out.println(box + " boxes Left Eye");
        Wait(1);
    }

    public void clickRAdd(String add) {
        WebElement weAdd = driver.findElement
                (By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.AddPower')]"));
        weAdd.click();
        System.out.println("ADD for Right eye: " + add);
        weAdd.sendKeys(add,Keys.ENTER);
        Wait(1);
    }
    public void clickLAdd(String add) {
        WebElement weAdd = driver.findElement
                (By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.AddPower')]"));
        weAdd.click();
        System.out.println("ADD for left eye: " + add);
        weAdd.sendKeys(add,Keys.ENTER);
        Wait(1);
    }
  public void typePatientName(String first, String last) {
    WebElement firstPatientName = driver.findElement(By.xpath("//input[contains(@id,'firstNameInput')]"));
      firstPatientName.clear();
      firstPatientName.sendKeys(first);
      WebElement lastPatientName = driver.findElement(By.xpath("//input[contains(@id,'lastNameInput')]"));
      lastPatientName.clear();
      lastPatientName.sendKeys(last);
      System.out.println("Patient First Name is: " + first);
      System.out.println("Patient Last Name is: " + last);
  }

  public void clickAddRx(String device){
      if(device.equals("phone")){
        driver.findElement(By.xpath("//span[contains(.,'Add Another Rx')]")).click();
        System.out.println("Clicked Add Rx");
      }
      else if(device.equals("desktop")){
          driver.findElement(By.xpath("//a[contains(@name,'saveAndAddAnotherBrand')]")).click();
        System.out.println("Clicked Add Rx");
      }
      else if(device.equals("tablet")){
          driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-tablet rd-tabletLeftButton rd-grayButton')]")).click();
        System.out.println("Clicked Add Rx");
      }
  }
    public void clickAddRxRI(String device){
        if(device.equals("phone")){
            driver.findElement(By.xpath("//span[contains(.,'Add Another Rx')]")).click();
            System.out.println("Clicked Add Rx");
            Wait(5);
        }
        else if(device.equals("desktop")){
            driver.findElement(By.xpath("//a[contains(@id,'selectBrandForAnotherPersonLink')]")).click();
            System.out.println("Clicked Select Brand For Another Person");
            Wait(5);
        }
        else if(device.equals("tablet")){
            driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-tablet rd-tabletLeftButton rd-grayButton rd-anotherRXButton')]")).click();
            System.out.println("Clicked Add Rx");
        }
    }

    public void clickUpdateCart(String device) {
        printPageTitle();
        Wait(5);
        if(device.equals("phone")){
            driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-phone rd-stretchButton rd-orangeButton')]")).click();
            System.out.println("Clicked Update");
        }
        else if(device.equals("tablet")){
            driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-tablet rd-tabletRightButton rd-orangeButton')]")).click();
            System.out.println("Clicked Update");
        }
        else if(device.equals("desktop")){
            driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
            System.out.println("Clicked Update");
        }
        Wait(5);
    }
    public void clickEditRx(String device){
        Wait(5);
        if(device.equals("phone")){
            WebElement weEdit = driver.findElement(By.xpath("//a[contains(@id,'cartEditLink')]"));
            weEdit.click();
            System.out.println("Clicked edit cart");
            Wait(5);
        }
        else if(device.equals("tablet")){
            WebElement weEdit = driver.findElement(By.xpath("//a[contains(@id,'cartEditLink')]"));
            weEdit.click();
            System.out.println("Clicked edit cart");
            Wait(5);
        }
        else if(device.equals("desktop")){
            WebElement weEdit = driver.findElement(By.xpath("//a[contains(@id,'cartEditLink')]"));
            weEdit.click();
            System.out.println("Clicked edit cart");
            Wait(5);
        }
        Wait(5);
    }
  public void clickAddToCart(String device) {
      Wait(5);
      if(device.equals("phone")){
      WebElement weAdd = driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-phone rd-stretchButton rd-orangeButton rd-addToCartButton')]"));
       weAdd.click();
          System.out.println("Clicked add to cart");
          Wait(5);
      }
      else if(device.equals("tablet")){
              WebElement weAdd = driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-tablet rd-tabletRightButton rd-orangeButton rd-addToCartButton')]"));
              weAdd.click();
              print("Clicked add to cart");
          Wait(5);
          }
      else if(device.equals("desktop")){
          driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
          print("Clicked add to cart");
          Wait(5);
      }
      Wait(5);
  }
    public void clickAddAccessoryToCart(String device) {
        Wait(5);
        driver.findElement(By.cssSelector("input.accessoryAddToCart")).click();
        /*if(device.equals("phone")){
            WebElement weAdd = driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-phone rd-stretchButton rd-orangeButton rd-addToCartButton')]"));
            weAdd.click();
            System.out.println("Clicked add to cart");
            Wait(5);
        }
        else if(device.equals("tablet")){
            WebElement weAdd = driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-tablet rd-tabletRightButton rd-orangeButton rd-addToCartButton')]"));
            weAdd.click();
            print("Clicked add to cart");
            Wait(5);
        }
        else if(device.equals("desktop")){
            driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
            print("Clicked add to cart");
            Wait(5);
        }*/
        Wait(5);
    }
   /* driver.findElement(By.id("BrandText_OPTI-FREE®PureMoist®Drops")).click();
    assertEquals("", driver.getTitle());
    new Select(driver.findElement(By.id("quantity"))).selectByVisibleText("6");
    driver.findElement(By.cssSelector("option[value=\"6\"]")).click();
    driver.findElement(By.cssSelector("input.accessoryAddToCart")).click();*/
    public void clickCartEdit(String device){
        Wait(5);
        printPageTitle();
        driver.findElement(By.xpath("//a[contains(@id,'cartEditLink')]")).click();
        print("Clicked Edit");
        Wait(5);
    }
    //change shipping method on the cart page
    //enter the letter to type
    // s = standard
    // n = next day mail. nn = next day noon.
    // c = canada, cc= can exp.
    // e = expedited,
    // i = international, ii= international exp.
    public void selectShippingCart(String ship) {
        Wait(4);
            WebElement weShipping = driver.findElement(By.xpath("//select[contains(@id,'ShippingViewModel_SelectedShipperCode')]"));
            weShipping.click();
            weShipping.sendKeys(ship,Keys.TAB);
            Wait(4);
        print("Method of shipping: " + ship);
    }
    //change shipping method on the RS page DOES NOT WORK
    //enter the letter to type
    // MAIL = standard
    // USEM = next day mail. FED1 = next day noon.
    // c = canada, cc= can exp.
    // FED2 = expedited,
    // i = international, ii= international exp.
    public void selectShippingRS(String ship) {
        WebElement weShippingRS = driver.findElement(By.xpath("//a[contains(@id,'ReviewOrderSummary_EditShippingLink')]"));
        print("Found Edit");
        weShippingRS.click();
        System.out.println("Clicked on Edit");
        Wait(3);
        String theShippingString = "//input[contains(@id,'" + ship + "')]";
        //driver.findElement(By.xpath("//input[contains(@id, ship)]")).click();
        driver.findElement(By.xpath(theShippingString)).click();
        print("Method of shipping: " + ship);
        //driver.findElement(By.xpath("//span[contains(.,'Select')]")).click();
        Wait(4);
    }

     public void selectPromoCart(String device,String promoName){
         Wait(5);
         WebElement wePromo = driver.findElement(By.xpath("//img[contains(@src,'https://media.1800contacts.com/is/image/1800Contacts/website%5Fcartpagerbslot%5F"+ promoName +"%5Fimage')]"));
         print("Promo link: " + wePromo);
         wePromo.click();
         print("Clicked Promo in Cart");
     }
    public void verifyPromoCart(String device,String promoProdName,String pricePromo,String promoItemNumber,String promoText){
        verifyPromoProdName(device,promoProdName);
        verifyPricePromo(device,pricePromo);
        verifyPromoItemNumber(device,promoItemNumber);
        verifyPromoText(device,pricePromo,promoText);
    }
    public void verifyPromoRS(String device,String promoProdName,String pricePromo,String promoItemNumber,String promoText){
        verifyPromoProdNameRS(device,promoProdName);
        verifyPricePromoRS(device,pricePromo);
        verifyPromoItemNumberRS(device,promoItemNumber);
        verifyPromoTextRS(device,pricePromo,promoText);
    }
    public void verifyPromoProdName(String device,String promoProdName){
        String verifyPromoProdName =  driver.findElement(By.xpath("(//div[@id='productManufacturerDiv'])")).getText();
        verifyTxtPresent("Product offered on Promo: ", promoProdName, verifyPromoProdName);
    }
    public void verifyPromoText(String device,String pricePromo,String promoText){
        assertEquals("-$" + pricePromo,driver.findElement(By.id("discountTd")).getText());
        print("$ of Promo: -$" + pricePromo);
        assertEquals(promoText, driver.findElement(By.cssSelector("td.a41-cart-remove-code-spacer.a41-cart-discount  > span")).getText());
        print(promoText + " was present");

        assertEquals("-$" + pricePromo, driver.findElement(By.id("totalDiscount")).getText());
        print("$ Total Discount Applied: -$" + pricePromo);
        assertEquals("Total discount applied:", driver.findElement(By.cssSelector("td.a41-cart-right")).getText());
    }
    public void verifyPricePromo(String device,String pricePromo){
        String verifyPricePromo =  driver.findElement(By.xpath("(//div[@class='innerParam AccessoryViewModel.AccessoryPrescriptionViewModel.Price'])")).getText();
        verifyTxtPresent("Price of Promo: ", pricePromo, verifyPricePromo);
    }
    public void verifyPromoItemNumber(String device,String promoItemNumber){
        String VerifyPromoItemNumber =
                driver.findElement(By.id(promoItemNumber + "_hiddenField")).getAttribute("value");
        print ("Item Number of Promo: " + VerifyPromoItemNumber);
        verifyTxtPresent("Item Number of Promo: ", promoItemNumber, VerifyPromoItemNumber);
    }
    public void verifyPromoProdNameRS(String device,String promoProdName){
        assertEquals(promoProdName, driver.findElement(By.cssSelector("span.a41-blue-text")).getText());
        print("Product offered on Promo: " + promoProdName);
    }
    public void verifyPromoTextRS(String device,String pricePromo,String promoText){
        assertEquals("-$" + pricePromo,driver.findElement(By.cssSelector("#ReviewOrderPaymentSummaryDiv > #subtotals-top > dd.a41-total-savings-amount")).getText());
        print("$ of Promo: -$" + pricePromo);
        assertEquals(promoText, driver.findElement(By.cssSelector("#ReviewOrderPaymentSummaryDiv > #subtotals-top > dt")).getText());
        print(promoText + " was present");

        assertEquals("-$" + pricePromo, driver.findElement(By.cssSelector("#ReviewOrderPaymentSummaryDiv > #subtotals-top > dd.a41-total-savings-amount")).getText());
        print("$ Total Discount Applied: -$" + pricePromo);
        assertEquals("Total discount applied:", driver.findElement(By.cssSelector("#ReviewOrderPaymentSummaryDiv > #subtotals-top > dt.a41-total-savings")).getText());
    }
    public void verifyPricePromoRS(String device,String pricePromo){
        assertEquals("$" + pricePromo, driver.findElement(By.xpath("//form[@id='CreditCardContentForm']/div[3]/div[3]/div[2]/div/div/div/div/div/div[2]/div/div/div[3]/div[3]/div/div[2]/div[3]/div/label")).getText());
    }
    public void verifyPromoItemNumberRS(String device,String promoItemNumber){
        String VerifyPromoItemNumber =
                driver.findElement(By.id(promoItemNumber + "_hiddenField")).getAttribute("value");
        print ("Item Number of Promo: " + VerifyPromoItemNumber);
        verifyTxtPresent("Item Number of Promo: ", promoItemNumber, VerifyPromoItemNumber);
    }
    public void clickCart_Continue(String device) {
      printPageTitle();
      Wait(4);
      print("Find Continue");
      if(device.equals("phone")){
          WebElement weCartContinue = driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-phone rd-stretchButton rd-orangeButton rd-continueButton')]"));
          weCartContinue.click();
      }
      else if (device.equals("desktop")){
          WebElement weCartContinue = driver.findElement(By.xpath("//img[contains(@alt,'continue')]"));
          weCartContinue.click();
      }
      else if (device.equals("tablet")){
          WebElement weCartContinue = driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-tablet rd-tabletRightButton rd-orangeButton rd-continueButton')]"));
          weCartContinue.click();
      }
        print("Clicked Continue in Cart");
      Wait(10);
  }

  public void typeShippingName(String first, String last) {
      driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.FirstName')]")).clear();
    driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.FirstName')]")).sendKeys(first);
      System.out.println("Shipping First Name is: " + first);
      driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.LastName')]")).clear();
    driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.LastName')]")).sendKeys(last);
      System.out.println("Shipping Last Name is: " + last);
  }

  public void xclickCountry(String country) {
    driver.findElement(By.xpath("//select[contains(@name,'ShippingAddress.Country')]")).click();
    String theCountryString = "//option[contains(@value,'" + country + "')]";
    driver.findElement(By.xpath(theCountryString)).click();
      System.out.println("Country is: " + country);
      Wait(3);
  }
    public void clickCountry(String country) {
        WebElement weTheCountryString = driver.findElement(By.xpath("//select[contains(@name,'ShippingAddress.Country')]"));
        weTheCountryString.click();
        weTheCountryString.sendKeys(country, Keys.ENTER);
        Wait(3);
        System.out.println("Country is: " + country);
        Wait(3);
    }

  public void typeShippingAddress() {
      String theAddressString = "" + new Date().getTime();
    driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.AddressLine1')]")).sendKeys("ship address " + theAddressString);
      System.out.println("Shipping Address is: ship address " + theAddressString);
      Wait(3);
  }
    public void typeShippingAddressINI(String address) {
        driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.AddressLine1')]")).sendKeys(address);
        System.out.println("Shipping Address is: " +  address);
        Wait(3);
    }

  public void typeShippingCity(String city) {
    driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.City')]")).sendKeys(city);
      System.out.println("City is: " + city);
      Wait(3);
  }

  public void typeShippingState(String country,String state) {
      Wait(3);
      //2 of these work for phone
      //if(device.equals("phone")){

  //}
      if (country.equals("united states")){
          driver.findElement(By.xpath("//select[contains(@id,'ShippingAddress_StateProvinceOrRegion')]")).sendKeys(state,Keys.TAB);
          System.out.println("State is: " + state);
      }
      else if (country.equals("canada")){
          driver.findElement(By.xpath("//select[contains(@id,'ShippingAddress_StateProvinceOrRegion')]")).sendKeys(state,Keys.TAB);
          System.out.println("Province is: " + state);
      }
      else {
          driver.findElement(By.xpath("//input[contains(@id,'StateProvinceOrRegion')]")).sendKeys(state,Keys.TAB);
          System.out.println("Region is: " + state);
      }
      Wait(3);
  }
  public void typeShippingZip(String zip) {
    driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.ZipOrPostalCode')]")).sendKeys(zip);
      System.out.println("Zip is: " + zip);
  }

    public void typeIntShippingZip(String zip) {
        Wait(4);
        driver.findElement(By.xpath("//input[contains(@id,'ShippingAddress_ZipOrPostalCode')]")).sendKeys(zip);
        System.out.println("PostalCode is: " + zip);
    }

  public void typeShippingPhone(String device) {
      long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
      String thePhoneString = "" + number;
              //iMill + iMill + iYr;
      if(device.equals("phone")){
          Wait(3);
          driver.findElement(By.xpath("//input[contains(@name,'Phone')]")).sendKeys(thePhoneString);
          driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.AddressLine2')]")).click();
          System.out.println("Phone used is: " + thePhoneString);
          Wait(3);
      }
      else{
          Wait(3);
          driver.findElement(By.xpath("//input[contains(@name,'PhoneNumber')]")).click();
          driver.findElement(By.xpath("//input[contains(@name,'PhoneNumber')]")).clear();
          driver.findElement(By.xpath("//input[contains(@name,'PhoneNumber')]")).sendKeys(thePhoneString);
          System.out.println("Phone used is: " + thePhoneString);
          Wait(3);
      }
  }
    public void typeIntShippingPhone() {
        String thePhoneString = "" + new Date().getTime();
        driver.findElement(By.xpath("//input[contains(@id,'PhoneNumber')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'PhoneNumber')]")).sendKeys(thePhoneString);
        System.out.println("Phone used is: " + thePhoneString);
        Wait(3);
    }
  public void typeShippingEmail(String email, String testNumber) {
      Wait(3);
    String theEmailString = email + "_" + new Date().getTime() + "@invalid.com";
    driver.findElement(By.xpath("//input[contains(@name,'EmailAddress')]")).sendKeys(theEmailString);
    System.out.println("Email used is: " + theEmailString);
      printToExcel(testNumber,theEmailString);
  }
  public void typePassword_newcust(String password) {
      Wait(3);
    driver.findElement(By.xpath("//input[contains(@id,'a41-checkout-password')]")).sendKeys(password);
    driver.findElement(By.xpath("//input[contains(@id,'a41-checkout-confirm-password')]")).sendKeys(password);
      System.out.println("Password Entered: " + password);
  }

  public void clickNewAddress_Continue() {
      Wait(2);
    driver.findElement(By.xpath("//input[contains(@value,'continue')]")).click();
      System.out.println("Clicked Continue on New Address Page");
    Wait(5);
  }

  public void selectDiffBillingAddress(String device){
      driver.findElement(By.xpath("//select[contains(@id,'selectBillingAddressType')]")).click();
      driver.findElement(By.xpath("//option[contains(@value,'newBillingAddress')]")).click();
  }
    public void selectSameBillingAddress(String device){
        Wait(2);
        System.out.println("Clicked bill to address");
        driver.findElement(By.xpath("//option[contains(@value,'myShippingAddress')]")).click();
        System.out.println("Clicked My shipping address");
    }
    public void typeBillingName(String bFName,String bLName){
        WebElement weBFName = driver.findElement(By.xpath("//input[contains(@name,'BillingAddress.FirstName')]"));
        WebElement weBLName = driver.findElement(By.xpath("//input[contains(@name,'BillingAddress.LastName')]"));
        weBFName.clear();
        weBFName.sendKeys(bFName);
        weBLName.clear();
        weBLName.sendKeys(bLName);
    }
    public void clickBillingCountry(String country) {
        driver.findElement(By.xpath("//select[contains(@name,'BillingAddress.Country')]")).click();
        driver.findElement(By.xpath("//select[contains(@name,'BillingAddress.Country')]")).sendKeys(country, Keys.TAB);
        Wait(3);
        System.out.println("Country is: " + country);
        Wait(3);
    }
    public void typeBillingAddress() {
        String theAddressString = "" + new Date().getTime();
        driver.findElement(By.xpath("//input[contains(@name,'BillingAddress.AddressLine1')]")).sendKeys("bill address " + theAddressString);
        System.out.println("Shipping Address is: bill address " + theAddressString);
        Wait(3);
    }
    public void typeBillingAddressINI(String address) {
        driver.findElement(By.xpath("//input[contains(@name,'BillingAddress.AddressLine1')]")).sendKeys(address);
        System.out.println("Shipping Address is: " +  address);
        Wait(3);
    }

    public void typeBillingCity(String city) {
        driver.findElement(By.xpath("//input[contains(@name,'BillingAddress.City')]")).sendKeys(city);
        System.out.println("City is: " + city);
        Wait(3);
    }

    public void typeBillingState(String device,String state) {
        Wait(3);
            driver.findElement(By.xpath("//select[contains(@id,'BillingAddress_StateProvinceOrRegion')]")).sendKeys(state,Keys.ENTER);
            System.out.println("State is: " + state + " " + device);
        Wait(3);
    }

    public void typeBillingZip(String zip) {
        driver.findElement(By.xpath("//input[contains(@name,'BillingAddress.ZipOrPostalCode')]")).sendKeys(zip);
        System.out.println("Zip is: " + zip);
    }

  public void typeDoctorSearch(String doctor) {
      Wait(5);
    driver.findElement(By.xpath("//input[contains(@name,'DoctorSearchOptionsViewModel.DoctorOrClinic')]")).sendKeys(doctor);
      System.out.println("input dr name for search");
    Wait(2);
  }

  public void typeDoctorStateAndFind(String device,String state) {
        // this is required for all
         new Select(driver.findElement(By.xpath("//select[contains(@id,'DoctorSearchOptionsViewModel_State')]"))).selectByValue(state);
    Wait(2);
      if(device.equals("phone")){
      driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-phone rd-stretchButton rd-orangeButton rd-searchButton')]")).click();
          System.out.println("searched for Doctor");
      }
      else if(device.equals("tablet")){
      driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-tablet rd-tabletLeftButton rd-orangeButton  rd-searchButton')]")).click();
          System.out.println("searched for Doctor");
      }
      else if(device.equals("desktop")){
          driver.findElement(By.xpath("//img[contains(@alt,'search')]")).click();
          System.out.println("searched for Doctor");
      }
    Wait(2);
  }

  public void typeDoctorPhoneAndFind(String device,String phone) {
    driver.findElement(By.xpath("//input[contains(@id,'a41-search-by-phone')]")).click();
    driver.findElement(By.xpath("//input[contains(@id,'PhoneNumber')]")).sendKeys(phone);
    Wait(2);
    driver.findElement(By.xpath("//img[contains(@src,'DoctorSearch/search-orange.png')]")).click();
      System.out.println("searched for Doctor");
    Wait(2);
  }

  //select doctor  this will just take the first result
  public void selectDoctor(String device) {
      Wait(4);
      if(device.equals("phone")){
          driver.findElement(By.xpath("//a[contains(@id,'SelectDoctorButton2595945')]")).click();
          System.out.println("selected Doctor 2595945");
      }
      else if(device.equals("tablet")){
          driver.findElement(By.xpath("//a[contains(@id,'SelectDoctorButton2595945')]")).click();
          System.out.println("selected Doctor 2595945");
      }
      else if(device.equals("desktop")){
          driver.findElement(By.xpath("//img[contains(@src,'/img/UI3/DoctorSearch/bttn-select.png')]")).click();
          System.out.println("selected Doctor 2696254");
      }
      else if(device.equals("production")){
          driver.findElement(By.xpath("//a[contains(@id,'SelectDoctorButton3256437')]")).click();
          System.out.println("selected Doctor 3256437");
      }
    Wait(3);
  }
    public String iniAvailable(String device){
        String y = "yes";
        String n = "no";

        //goToCart(device);
        //clickCartContinue(device);
        driver.navigate().refresh();
        try{
        driver.findElement(By.xpath("//div[contains(@id,'InNetworkInsuranceWidget')]"));
            return y;
    }
        catch (Throwable e){
            try{ Wait(20);
            driver.findElement(By.xpath("//div[contains(@id,'InNetworkInsuranceWidget')]"));
            return y;}

            catch (Throwable E){System.out.println("No Insurance available");
            return n;}
        }
    }

    public void goback(){
        Wait(5);
        driver.navigate().back();
    }
    public void checkInsurance(String device,String patientName,String dob){
        String insurance =  iniAvailable(device);
        System.out.println("is insurance available? " + insurance);
        if(insurance.contains("y")){
            clickIniCheckNow(device);
            verifyIniMembersPotential(device,patientName);
            verifyIniNameDob(device,patientName);
            enterDOB(device,dob);
            clickIniContinueDob(device);
            checkIfIniFound(device);
            clickIniApply(device);
        }
        else{System.out.println("No Insurance available");
        }
    }
    public void checkInsurance2(String device,String patientName,String dob,String patientName2,String dob2){
        String insurance =  iniAvailable(device);
        System.out.println("is insurance available? " + insurance);
        if(insurance.contains("y")){
            clickIniCheckNow(device);
            print("verify patient1 on first insurance page");
            verifyIniMembersPotential(device,patientName);
            print("verify patient2 on first insurance page");
            verifyIniMembersPotential(device,patientName2);
            print("click continue to get to first dob page");
            try{
            clickIniContinue(device);
            }
            catch (Throwable e){System.out.println("did not need to click continue");}
            System.out.println("verify patient1 on dob page");
            verifyIniNameDob(device,patientName);
            System.out.println("about to enter dob patient 1");
            enterDOB(device,dob);
            clickIniContinueDob(device);
            checkIfIniFound(device);
            clickIniApply(device);
            //Patient 2
            System.out.println("clicked apply to get to second dob page");
            System.out.println("verify patient2 on dob page");
            verifyIniNameDob(device,patientName2);
            System.out.println("about to enter dob patient 2");
            enterDOB(device,dob2);
            clickIniContinueDob(device);
            checkIfIniFound(device);
            clickIniApply(device);
        }
        else{System.out.println("No Insurance available");
        }
    }
    public void enterDOB(String device,String dob){
        //desktop
        if(device.equals("desktop")){
            driver.findElement(By.xpath("//div[contains(@class,'white memberName')]")).click();
            driver.findElement(By.xpath("//input[contains(@placeholder,'Birthdate (MM/DD/YYYY)')]")).click();
            driver.findElement(By.xpath("//input[contains(@placeholder,'Birthdate (MM/DD/YYYY)')]")).sendKeys(dob);
            System.out.println("sent DOB: " + dob);
            driver.findElement(By.xpath("//div[contains(@class,'white memberName')]")).click();
            System.out.println("clicked on name");
        }
        if(device.equals("tablet")){
            Wait(2);
            System.out.println("finding name on dob");
            WebElement weName =  driver.findElement(By.xpath("//div[contains(@class,'white memberName')]"));
            System.out.println("name on dob: " + weName);
            System.out.println("sending tab and dob: " + weName);
            weName.sendKeys(Keys.TAB,dob);
            System.out.println("sent DOB: " + dob);
        }
        if(device.equals("phone")){
            Wait(2);
            System.out.println("finding name on dob");
            WebElement weName =  driver.findElement(By.xpath("//div[contains(@class,'white memberName')]"));
            System.out.println("name on dob: " + weName);
            System.out.println("sending tab and dob: " + weName);
            weName.sendKeys(Keys.TAB,dob);
            System.out.println("sent DOB: " + dob);
        }
        Wait(2);
    }
    public void clickIniContinue(String device){
        //desktop
        if(device.equals("desktop")){
        driver.findElement(By.xpath("//div[contains(@data-bind,'click:selectPatients')]")).click();
        System.out.println("clicked Continue on ini");
        }
        else if(device.equals("tablet")){
            driver.findElement(By.xpath("//div[contains(@data-bind,'click:selectPatients')]")).click();
            System.out.println("clicked Continue on ini");
        }
        else if(device.equals("phone")){
            driver.findElement(By.xpath("//div[contains(@data-bind,'click:selectPatients')]")).click();
            System.out.println("clicked Continue on ini");
        }
    }
    public void clickIniContinueDob(String device){
        //desktop
        WebElement weIniContinue = driver.findElement(By.xpath("//div[contains(@data-bind,'click:checkEligibilityResults')]"));
        weIniContinue.click();
        System.out.println("clicked Continue on DOB");
    }
    public void checkIfIniFound(String device){
        //desktop
        try{
            Wait(5);
            driver.findElement(By.xpath("//div[contains(@data-bind,'text:yesSlideName')]"));
            System.out.println("Found insurance");
        }
        catch (Throwable e){
            System.out.println("Couldn't find vision insurance to use towards ...");
            }
    }
    public void clickIniApply(String device){
        Wait(20);
        if(device.equals("desktop")){
        driver.findElement(By.xpath("//div[contains(@data-bind,'click:apply')]")).click();
        }
        if(device.equals("tablet")){
            driver.findElement(By.xpath("//div[contains(@data-bind,'click:apply')]")).click();
        }
        if(device.equals("phone")){
            driver.findElement(By.xpath("//div[contains(@data-bind,'click:apply')]")).click();
        }
        else{
            System.out.println("No apply button ...");
            //return;
        }
    }
    public void clickIniSkip(String device){
        try{
            driver.findElement(By.xpath("//a[contains(@data-bind,'click:yesSlideSkip')]")).click();
        }
        catch (Throwable e){
            System.out.println("No Skip button ...");
        }
    }
    public void clickIniCheckNow (String device){
        //if device=desktop
        driver.findElement(By.xpath("//div[contains(@data-bind,'click:checkNow')]")).click();
        System.out.println("Clicked Check Now ...by data bind");
            return;
    }
    public void verifyIniMembers (String device,String patientName){
        System.out.println("NEED TO ADD VERIFICATION FOR INSURANCE");
    }
    public void verifyIniMembersPotential (String device,String patientName){
        if(device.equals("desktop")){
            try{
                String verifyIniMembers =  driver.findElement(By.xpath("//div[contains(@class,'white memberName')]")).getText();
                verifyTxtPresent("Insurance Patient Names1: ", patientName, verifyIniMembers);
                clickIniContinue(device);
            }  catch (Throwable e){System.out.println("Patient was not covered by Insurance");}
            try{
                String verifyIniMembers =  driver.findElement(By.xpath("(//div[@class='member checked'])")).getText();
                verifyTxtPresent("Insurance Patient Names: ", patientName, verifyIniMembers);
            }
            catch (Throwable e){System.out.println("Patient was not covered by Insurance - or this is the first insured");}
            try{
                String verifyIniMembers =  driver.findElement(By.xpath("(//div[@class='member checked'])[2]")).getText();
                verifyTxtPresent("Insurance Patient Names: ", patientName, verifyIniMembers);
            }
            catch (Throwable e){System.out.println("Patient was not covered by Insurance - or this is the second insured");}
        }
        else if(device.equals("tablet")){
            try{
                Wait(5);
                String verifyIniMembers =  driver.findElement(By.xpath("//div[contains(@class,'white memberName')]")).getText();
                System.out.println("Patient covered by Insurance: " + verifyIniMembers);
                verifyTxtPresent("Insurance Patient Names: ", patientName, verifyIniMembers);
            }  catch (Throwable e){System.out.println("Patient was not covered by Insurance");}
            try{
                String verifyIniMembers =  driver.findElement(By.xpath("(//div[@class='member checked'])")).getText();
                verifyTxtPresent("Insurance Patient Names: ", patientName, verifyIniMembers);
            }
            catch (Throwable e){System.out.println("Patient was not covered by Insurance - or this is the first insured");}
            try{
                String verifyIniMembers =  driver.findElement(By.xpath("(//div[@class='member checked'])[2]")).getText();
                verifyTxtPresent("Insurance Patient Names: ", patientName, verifyIniMembers);
            }
            catch (Throwable e){System.out.println("Patient was not covered by Insurance - or this is the second insured");}
        }
        else if(device.equals("phone")){
            try{
                String verifyIniMembers =  driver.findElement(By.xpath("//div[contains(@class,'white memberName')]")).getText();
                verifyTxtPresent("Insurance Patient Names: ", patientName, verifyIniMembers);
            }  catch (Throwable e){System.out.println("Patient was not covered by Insurance - or there is more than one insured");}
            try{
                String verifyIniMembers =  driver.findElement(By.xpath("(//div[@class='member checked'])")).getText();
                verifyTxtPresent("Insurance Patient Names: ", patientName, verifyIniMembers);
            }
            catch (Throwable e){System.out.println("Patient was not covered by Insurance - or this is the first insured");}
            try{
                String verifyIniMembers =  driver.findElement(By.xpath("(//div[@class='member checked'])[2]")).getText();
                verifyTxtPresent("Insurance Patient Names: ", patientName, verifyIniMembers);
            }
            catch (Throwable e){System.out.println("Patient was not covered by Insurance - or this is the second insured");}
        }
    }
    public void verifyIniNameDob(String device,String patientName){
        if(device.equals("desktop")){
            try{
                Wait(5);
                String verifyIniName =  driver.findElement(By.xpath("//div[contains(@class,'white memberName')]")).getText();
                System.out.println("Patient covered by Insurance: " + verifyIniName);
                verifyTxtPresent("Insurance Patient Names on DOB page: ", patientName, verifyIniName);
            }
            catch (Throwable e){
                System.out.println("Patient name " + patientName + " not found... this should not happen at this point.");
            }
        }
        else {
            try{
                Wait(5);
                String verifyIniName =  driver.findElement(By.xpath("//div[contains(@class,'white memberName')]")).getText();
                System.out.println("Patient covered by Insurance: " + verifyIniName);
                verifyTxtPresent("Insurance Patient Names on DOB page: ", patientName, verifyIniName);
            }
            catch (Throwable e){
                System.out.println("Patient name " + patientName + " not found... this should not happen at this point.");
            }
        }
    }
    public void verifyGetApp(String device,String expected){
        try{
            WebElement weText = driver.findElement(By.tagName("title"));
            String toVerify = weText.getText();
            verifyTxtPresent("Pages: ",expected,toVerify);
        }
        catch(Exception e)
        {
            System.out.println("FAIL: " + expected + "NOT Found " );
        }
    }


  public void typeCreditCard(String device,String cardNumber) {
      Wait(4);
      if(device.equals("desktop")){
          WebElement weNumber2 = driver.findElement(By.xpath("(//input[@id='CreditCardNumber'])[2]"));
          System.out.println("enter credit card2");
          weNumber2.click();
          weNumber2.sendKeys(cardNumber);
      System.out.println("CC Used: " + cardNumber);
      }
      else if(device.equals("phone")){
          WebElement weCreditCard = driver.findElement(By.xpath("//input[contains(@id,'CreditCardNumber')]"));
          weCreditCard.click();
          weCreditCard.sendKeys(cardNumber);
          System.out.println("CC Used: " + cardNumber);
      }
      else if(device.equals("tablet")){
          WebElement weNumber2 = driver.findElement(By.xpath("(//input[@id='CreditCardNumber'])[2]"));
          System.out.println("enter credit card2");
          weNumber2.click();
          weNumber2.sendKeys(cardNumber);
          System.out.println("CC Used: " + cardNumber);
      }
  }
  public void typeCreditCardName(String device,String creditName) {
      if(device.equals("desktop")){
          WebElement weName = driver.findElement(By.xpath("(//input[@id='CreditCardName'])[2]"));
          weName.click();
          weName.sendKeys(creditName);
      }
      else if(device.equals("tablet")){
          WebElement weName = driver.findElement(By.xpath("(//input[@id='CreditCardName'])[2]"));
          weName.click();
          weName.sendKeys(creditName);
      }
      else if(device.equals("phone")){
          driver.findElement(By.xpath("//input[contains(@id,'CreditCardName')]")).sendKeys(creditName);
      }
      System.out.println("CC Name Used: " + creditName);
  }
  public void pickCreditCardExpDate(String device,String month, String year) {
      if(device.equals("phone")){
        driver.findElement(By.xpath("//select[contains(@id,'CreditCardExpirationMonth')]")).sendKeys(month);
        driver.findElement(By.xpath("//select[contains(@id,'CreditCardExpirationYear')]")).sendKeys(year);
      }
      else if(device.equals("tablet")){
          driver.findElement(By.xpath("(//select[@id='CreditCardExpirationMonth'])[2]")).sendKeys(month);
          driver.findElement(By.xpath("(//select[@id='CreditCardExpirationYear'])[2]")).sendKeys(year);
          System.out.println("CC exp date:" + month + " " + year);
      }
      else if(device.equals("desktop")){
          driver.findElement(By.xpath("(//select[@id='CreditCardExpirationMonth'])[2]")).sendKeys(month);
          driver.findElement(By.xpath("(//select[@id='CreditCardExpirationYear'])[2]")).sendKeys(year);
      System.out.println("CC exp date:" + month + " " + year);
      }
  }
  public void clickBottomSubmitButton(String device) {
      if(device.equals("phone")){
          Wait(3);
          WebElement weSubmit =
                  driver.findElement(By.xpath("//div[contains(@class,'rd-button rd-phone rd-stretchButton rd-orangeButton')]"));
          weSubmit.click();
          System.out.println("Clicked the Submit button");
      }
      else if(device.equals("tablet")){
          try{
              WebElement weSubmit =
                      driver.findElement(By.xpath("(//input[@id='ReviewAndSubmit_SelectPayment_PlaceMyOrderButton'])[2]"));
               weSubmit.click();
              System.out.println("Clicked the Submit button");
          }
          catch (Throwable e){
              WebElement weSubmit =
                  driver.findElement(By.xpath("//div[@class='rd-button rd-tablet rd-tabletRightButton rd-orangeButton']"));
              weSubmit.click();
              System.out.println("Clicked the Submit button");
          }
      }
      else if(device.equals("desktop")){
          driver.findElement(By.xpath("//input[contains(@id,'ReviewAndSubmit_BottomButton')]")).click();
          System.out.println("Clicked the Submit button");
      }
      Wait(20);
  }
    public void verifyExpiredCard(String device) {
        driver.findElement(By.id ("errorMessagesUl"));
        System.out.println("Got the Expired Card message");
        System.out.println("Next - Change exp date to be correct");
    }
    public void verifyCartNameError(String device) {
        String verifyCartNameError =  driver.findElement(By.xpath("//li[contains(.,'Please make sure your name does not contain numbers or special characters.')]")).getText();
        verifyTxtPresent("Error text is: ", "Please make sure your name does not contain numbers or special characters.", verifyCartNameError);
        System.out.println("Next - Change Name to be correct");
    }
    public void verifyCartRxError(String device) {
        String verifyCartRxError =  driver.findElement(By.xpath("//li[contains(.,'We do not carry the prescription entered. If you need help with your prescription, we have contact lens specialists available through live chat or by phone (1-800-266-8228).')]")).getText();
        verifyTxtPresent("Error text is: ", "We do not carry the prescription entered. If you need help with your prescription, we have contact lens specialists available through live chat or by phone (1-800-266-8228).", verifyCartRxError);
        System.out.println("Next - Change the Rx to be correct");
    }
    public void verifyAddressReq(String device){
        driver.findElement(By.xpath("//li[contains(.,'The lenses in your order require that your shipping address match your billing address. Please update your shipping information.')]"));
        System.out.println("shipping address must = billing address ");
        Wait(5);
    }
  public void verifyDeclinedCard(String device) {
          driver.findElement(By.xpath("//div[contains(@class,'errorPageHeader1')]"));
          System.out.println("Found CreditCard Error page");
  }
    public void verifyTestDeclinedCard(String device) {     //for the 4111111111 card
        driver.findElement(By.xpath("//div[contains(@class,'errorPageHeader1')]"));
        System.out.println("Found CreditCard Error page");
    }
    public void verifyInvalidCard(String device) {
        if(device.equals("desktop")){
            driver.findElement(By.xpath("//ul[contains(@id,'errorMessagesUl')]"));
            System.out.println("Found Invalid Card Error page");
        }
        else{
            driver.findElement(By.xpath("//ul[contains(@id,'errorMessagesUl')]"));
            System.out.println("Found Invalid Card Error page");
        }
    }

    public void goToCart1Item(String device) {
        System.out.println("Next Go To Cart");
        if(device.equals("phone")){
            driver.findElement(By.xpath("//a[contains(.,'Cart1')]")).click();
            Wait(2);
            driver.findElement(By.xpath("//p[contains(.,'	Please review your cart	')]"));
            System.out.println("You are in the cart... proceed as normal");
        }
        else if(device.equals("desktop")){
            System.out.println("Next Go To Cart");
            driver.findElement(By.xpath("//a[contains(@title,'View Cart')]")).click();
            Wait(2);
            driver.findElement(By.xpath("//p[contains(.,'	Please review your cart	')]"));
            System.out.println("You are in the cart... proceed as normal");
        }
        else if(device.equals("tablet")){
            System.out.println("Next Go To Cart");
            driver.get(desktopBaseUrl + "cart");
            Wait(2);
            driver.findElement(By.xpath("//p[contains(.,'Please review your cart')]"));
            System.out.println("You are in the cart... proceed as normal");
        }
        Wait(6);
    }
  //this is what should be used. we shouldn't have to specify how many items in a cart.
    public void goToCart(String device) {
        System.out.println("Next Go To Cart");
        if(device.equals("phone")){
            try{
            driver.findElement(By.xpath("//a[contains(.,'Cart1')]")).click();
            }
            catch (Throwable e){driver.get(desktopBaseUrl + "cart");
            }
            Wait(2);
            driver.findElement(By.xpath("//p[contains(.,'	Please review your cart	')]"));
            System.out.println("You are in the cart... proceed as normal");
        }
        else if(device.equals("desktop")){
            System.out.println("Next Go To Cart");
            driver.findElement(By.xpath("//a[contains(@title,'View Cart')]")).click();
            Wait(2);
            driver.findElement(By.xpath("//p[contains(.,'	Please review your cart	')]"));
            System.out.println("You are in the cart... proceed as normal");
        }
        else if(device.equals("tablet")){
            System.out.println("Next Go To Cart");
            driver.get(desktopBaseUrl + "cart");
            Wait(2);
            driver.findElement(By.xpath("//p[contains(.,'Please review your cart')]"));
            System.out.println("You are in the cart... proceed as normal");
        }
        Wait(6);
    }
    public void goToCart2Items() {
        System.out.println("Next Go To Cart");
        driver.findElement(By.xpath("//a[contains(.,'Cart2')]")).click();
        Wait(2);
        driver.findElement(By.xpath("//p[contains(.,'	Please review your cart	')]"));
        System.out.println("You are in the cart... proceed as normal");
        Wait(6);
    }
    public void verifyOrderStatusHistory(String device,String brand,String patientName,String shippingCost,String shippingType,String sState,String sCity,String tax,String total,String rebateText,String totalAfterRebate) {
        verifyTitleOrderStatusHistory(device);
        verifyBrandOrderStatusHistory(device,brand);
        verifyPatientOrderStatusHistory(device, patientName);
        verifyShippingCostOrderStatusHistory(device, shippingCost,shippingType,tax);
        verifyShippingOrderStatusHistory(device, sCity, sState);
        verifyTotalOrderStatusHistory(device, total);
        //verifyRebateTextStatusHistory(device, rebateText);
        //verifyTotalARebateOrderStatusHistory(device, totalAfterRebate);
    }
    public void verifyTitleOrderStatusHistory(String device){
        //if(device.equals("tablet")){
        //    Wait(5);
        //    driver.findElement(By.xpath("//img[contains(@src,'/images/AccountHub/OrderStatusAndHistory/orderStatusTrackerVerifyingLensAvailability.png')]"));
        //    String verifyTitleOrderStatusHistory =  driver.findElement(By.xpath("//h1[contains(@class,'pageTitle hidePrint accountHubHeader')]")).getText();
        //    verifyTxtPresent("Title is: ", "My 1‑800 CONTACTS Account", verifyTitleOrderStatusHistory);
        //    Wait(5);
       // }
        if(device.equals("desktop")) {
                Wait(5);
                driver.findElement(By.xpath("//img[contains(@src,'/images/AccountHub/OrderStatusAndHistory/orderStatusTrackerVerifyingLensAvailability.png')]"));
                String verifyTitleOrderStatusHistory =  driver.findElement(By.xpath("//h1[contains(@class,'pageTitle hidePrint accountHubHeader')]")).getText();
                verifyTxtPresent("Title is: ", "My 1‑800 CONTACTS Account", verifyTitleOrderStatusHistory);
                Wait(5);
            }
        else if(device.equals("phone")) {
            Wait(5);
            driver.findElement(By.xpath("//h1[contains(@class,'pageTitle hidePrint accountHubHeader')]"));
            String verifyTitleOrderStatusHistory =  driver.findElement(By.xpath("//h1[contains(@class,'pageTitle hidePrint accountHubHeader')]")).getText();
            verifyTxtPresent("Title is: ", "My 1‑800 CONTACTS Account", verifyTitleOrderStatusHistory);
            Wait(5);
        }
    }
    public void verifyBrandOrderStatusHistory(String device,String brand){
        if(device.equals("desktop")){
            String brandValidationOrderStatusHistory =  driver.findElement(By.xpath("//div[contains(@class,'productDetails')]")).getText();
            verifyTxtPresent("Brand on Order Status and History: ", brand, brandValidationOrderStatusHistory);
            Wait(6);
         }
       else if (device.equals("tablet")) {
            String brandValidationOrderStatusHistory =  driver.findElement(By.xpath("//span[contains(@class,'orderStatusAndHistoryProductNameLabel')]")).getText();
            verifyTxtPresent("Brand on Order Status and History: ", brand, brandValidationOrderStatusHistory);
            Wait(6);
        }
        else if (device.equals("phone")) {
            try {
            String brandValidationOrderStatusHistory =  driver.findElement(By.xpath("//div[contains(@class,'a41-checkout-review-product-name')]")).getText();
            verifyTxtPresent("Brand on Order Status and History: ", brand, brandValidationOrderStatusHistory);
            Wait(6);
            }
            catch (Throwable e){}
        }
    }
    public void verifyPatientOrderStatusHistory(String device,String patientName){
      //  if(device.equals("desktop")){
      //      try{
      //          String patientOrderStatusHistory =  driver.findElement(By.xpath("//div[contains(@class,'productDetails')]")).getText();
     //           verifyTxtPresent("Patient on Order Status and History: ", patientName, patientOrderStatusHistory);
      //          Wait(6);
      //      }
      //      catch (Throwable e) { System.out.println("verifyPatientOrderStatusHistory does not work for " + device);}
      //  }
        //else if(device.equals("phone")){
            try{
                String patientOrderStatusHistory =  driver.findElement(By.xpath("//div[contains(@class,'orderInformation')]")).getText();
                verifyTxtPresent("Patient on Order Status and History: ", patientName, patientOrderStatusHistory);
                Wait(6);
            }
            catch (Throwable e) { System.out.println("verifyPatientOrderStatusHistory does not work for " + device);}
    //    }
    }
    public void verifyShippingCostOrderStatusHistory(String device,String shippingCost,String shippingType,String tax){
        if(device.equals("desktop")){
                String shippingTypeValidationOrderStatusHistory =  driver.findElement(By.xpath("//dt[contains(@class,'a41-shipping-time')]")).getText();
                System.out.println(shippingTypeValidationOrderStatusHistory);
                String taxValidationOrderStatusHistory =  driver.findElement(By.xpath("//dd[contains(@id,'totalTax')]")).getText();
                System.out.println(taxValidationOrderStatusHistory);
                verifyTxtPresent("Shipping Type on Order Status and History: ", shippingType, shippingTypeValidationOrderStatusHistory);
                verifyTxtPresent("Shipping Cost on Order Status and History: ", shippingCost, shippingTypeValidationOrderStatusHistory);
                verifyTxtPresent("Tax on Order Status and History: ", tax, taxValidationOrderStatusHistory);
                Wait(6);
        }
        else {
                String shippingTypeValidationOrderStatusHistory =  driver.findElement(By.xpath("//dt[contains(@class,'a41-shipping-time')]")).getText();
                String taxValidationOrderStatusHistory =  driver.findElement(By.xpath("//dd[contains(@id,'totalTax')]")).getText();
                verifyTxtPresent("Shipping Type on Order Status and History: ", shippingType, shippingTypeValidationOrderStatusHistory);
                verifyTxtPresent("Shipping Cost on Order Status and History: ", shippingCost, shippingTypeValidationOrderStatusHistory);
                verifyTxtPresent("Tax on Order Status and History: ", tax, taxValidationOrderStatusHistory);
                Wait(6);
        }
    }
    public void verifyTotalOrderStatusHistory(String device,String total){
                String totalValidationOrderStatusHistory =  driver.findElement(By.xpath("//dd[contains(@id,'orderTotal')]")).getText();
                verifyTxtPresent("Total on Order Status and History: ", total, totalValidationOrderStatusHistory);
                Wait(6);
    }
    public void verifyShippingOrderStatusHistory(String device,String sCity,String sZip){
        //if(device.equals("desktop")){
                String shippingValidationOrderStatusHistory =  driver.findElement(By.xpath("//div[contains(@id,'shippingDetails')]")).getText();
                verifyTxtPresent("Shipping City on Order Status and History: ", sCity, shippingValidationOrderStatusHistory);
                verifyTxtPresent("Shipping Zip on Order Status and History: ", sZip, shippingValidationOrderStatusHistory);
                Wait(6);
    }

    public void verifyBrandDash(String device,String brand){
                String brandValidationDash =  driver.findElement(By.xpath("//div[contains(@class,'a41-checkout-review-product-name')]")).getText();
                verifyTxtPresent("Brand Name on Dash: ", brand, brandValidationDash);
                Wait(6);
    }
    public void verifyPatientDash(String device,String patientName){
        if(device.equals("desktop")){
            try{
            String patientValidationDash =  driver.findElement(By.xpath("//div[contains(@class,'rxSummaryLineItemColumn memberRecentPrescription')]")).getText();
            verifyTxtPresent("Patient Name on Dash: ", patientName, patientValidationDash);
            Wait(6);
            }
            catch (Throwable e){}
            try {
                String patientValidationDash =  driver.findElement(By.xpath("//div[contains(@class,'a41-checkout-review-details-name')]")).getText();
                verifyTxtPresent("Patient Name on Dash: ", patientName, patientValidationDash);
                Wait(6);
            }
            catch (Throwable e){}
           }
        else {
            try {
                String patientValidationDash =  driver.findElement(By.xpath("//div[contains(@class,'a41-checkout-review-details-name')]")).getText();
                verifyTxtPresent("Patient Name on Dash: ", patientName, patientValidationDash);
                Wait(6);
            }
            catch (Throwable e){}
        }
    }
    public void verifyTitleDash(String device){
        if(device.equals("desktop")){
                String titleDash =  driver.findElement(By.xpath("//div[contains(@id,'welcome')]")).getText();
                verifyTxtPresent("Title is: ", "Welcome to your personal contact lens dashboard.", titleDash);
            }
        if(device.equals("phone")){
                String titleDash =  driver.findElement(By.xpath("//div[contains(@id,'rp-subheader-phone')]")).getText();
                verifyTxtPresent("Title is: ", "Welcome to your personal contact lens dashboard.", titleDash);
        }
        if(device.equals("tablet")){
            String titleDash =  driver.findElement(By.xpath("//div[contains(@class,'pageTitle')]")).getText();
            verifyTxtPresent("Title is: ", "Welcome to your personal contact lens dashboard.", titleDash);
        }
    }
    public void verifyDashboard(String device,String brand,String patientName) {
        Wait(14);
        verifyTitleDash(device);
        verifyBrandDash(device,brand);
        verifyPatientDash(device, patientName);
    }
    public void verifyShipNameMyAcct (String device,String fname,String lname){
        Wait(5);
        String wename = driver.findElement(By.cssSelector("#shippingAddressInfo > div")).getText();
        print("finding shipping name: " + wename);
        assertEquals(fname + " " + lname, driver.findElement(By.cssSelector("#shippingAddressInfo > div")).getText());
    }
    public void verifyShipAddressMyAcct (String device,String address){
        assertEquals(address, driver.findElement(By.xpath("//div[@id='shippingAddressInfo']/div[2]")).getText());
    }
    public void verifyShipCityStateMyAcct (String device,String city, String state, String zip){
        assertEquals(city + ", " + state + " " + zip, driver.findElement(By.xpath("//div[@id='shippingAddressInfo']/div[3]")).getText());
    }
    public void verifyShipCountryMyAcct (String device,String country){
        if (country.equals("united states")) {
            country = "USA";
        }
        assertEquals(country, driver.findElement(By.xpath("//div[@id='shippingAddressInfo']/div[4]")).getText());
    }
    public void verifyPhoneCountryMyAcct (String device,String country){
        //have to get the phone somehow - - same way as getting address
        assertEquals("(762) 479-5674", driver.findElement(By.xpath("//div[@id='shippingAddressInfo']/div[5]")).getText());
    }
    public void verifyEditShipAddressMyAcct(String device,String fName,String lName,String address,String country,String city, String state, String zip){
        verifyShipNameMyAcct(device,fName,lName);
        verifyShipAddressMyAcct(device,address);
        verifyShipCityStateMyAcct(device, city,state,zip);
        verifyShipCountryMyAcct(device, country);
    }
    public void verifyEditBillAddressMyAcct(String device,String fName,String lName,String address,String country,String city, String state, String zip){
        verifyBillNameMyAcct(device,fName,lName);
        verifyBillAddressMyAcct(device,address);
        verifyBillCityStateMyAcct(device, city,state,zip);
        verifyBillCountryMyAcct(device, country);
    }
    public void editAndVerifyShipping(String device,String fName,String lName,String country,String city, String state,String stateAbrev, String zip){
        String shippingAddress = editShipping(device,fName,lName,country,city,state,stateAbrev,zip);
        clickSaveShipping(device);
        verifyEditShipAddressMyAcct(device,fName,lName,shippingAddress,country,city,stateAbrev,zip);
        Wait(14);
    }
    public void editAndVerifyBilling(String device,String fName,String lName,String country,String city, String state,String stateAbrev, String zip){
        String billingAddress = editBilling(device,fName,lName,country,city,state,stateAbrev,zip);
        clickSaveBilling(device);
        verifyEditBillAddressMyAcct(device,fName,lName,billingAddress,country,city,stateAbrev,zip);
        Wait(14);
    }
    public void verifyBillNameMyAcct (String device,String billingfname, String billinglname){
        assertEquals(billingfname +" " +billinglname, driver.findElement(By.cssSelector("#billingAddressInfo > div")).getText());
    }
    public void verifyBillAddressMyAcct (String device,String address){
        assertEquals(address, driver.findElement(By.xpath("//div[@id='billingAddressInfo']/div[2]")).getText());
    }
    public void verifyBillCityStateMyAcct (String device,String city, String state, String zip){
        assertEquals(city + ", " + state + " " + zip, driver.findElement(By.xpath("//div[@id='billingAddressInfo']/div[3]")).getText());
    }
    public void verifyBillCountryMyAcct (String device,String country){
        if (country.equals("united states")) {
            country = "USA";
        }
        assertEquals(country, driver.findElement(By.xpath("//div[@id='billingAddressInfo']/div[4]")).getText());
    }
  public void verifyThankYouPage(String ship) {
      //TODO: clean this up!
      Wait(14);
      System.out.println("Page title is: " + driver.getTitle());
    driver.findElement(By.xpath("//h1[contains(.,'Thank you for your order!')]"));
      System.out.println("Thank You page says Thank you for your order! ");
    driver.findElement(By.xpath("//p[contains(.,'A confirmation of this order has been sent to:')]"));
      System.out.println("A confirmation of this order has been sent to:");
      String shippingValidationTY =  driver.findElement(By.xpath("//dt[@class='a41-shipping-time']")).getText();
      System.out.println("Shipping method is:" + shippingValidationTY);
      verifyTxtPresent("Shipping Method is: : ", ship, shippingValidationTY);
      String theFinalPrice = driver.findElement(By.xpath("//dd[contains(@id,'orderTotal')]")).getText();
      System.out.println("Total: " + theFinalPrice);
      try
      {
          String theFinalPriceAfterRebate = driver.findElement(By.xpath("//dl[contains(@class,'total')]")).getText();
          System.out.println("Total after rebate: " + theFinalPriceAfterRebate);
      }
      catch (Throwable e)
      {
          System.out.println("No Rebate line found on ty page");
      }
      String theOrderNumber = driver.findElement(By.xpath("//td[contains(@id,'orderNumber')]")).getText();
      System.out.println("Order Number: " + theOrderNumber);
  }
    public void verifyPDP(String brand) {
        Wait(14);
        System.out.println("Page title is: " + driver.getTitle());
        String verifyProdPDP =  driver.findElement(By.xpath("//h1[@class='product-heading']")).getText();
        System.out.println("Brand is:" + verifyProdPDP);
        verifyTxtPresent("Title is: ", brand, verifyProdPDP);
    }
    public void verifyTxtPresent(String identifier, String desired, String actual){
        // the pattern we want to search for
        Pattern p = Pattern.compile(desired);
        Matcher m = p.matcher(actual);
        // try to find a match
        if (m.find())
            System.out.println("VERIFIED " + identifier + "Found :" + desired + ", within, " + actual );
        else
            System.out.println("FAIL " + identifier + "NOT FOUND :" + desired + ", within, " + actual );
    }
    public void verifyCart(String device,String brand,String patientName,String price,String totalR, String totalL, String cartTotal) {
        Wait(14);
        System.out.println("Page title is: " + driver.getTitle());
        //verify title
        try{   //NI
        String verifyTitleCart =  driver.findElement(By.xpath("//p[@class='']")).getText();
        verifyTxtPresent("Title is: ", "Please review your cart", verifyTitleCart);
        }
        catch (Throwable e){ }
        try{  //RI
            String verifyTitleCart =  driver.findElement(By.xpath("//p[@class='review-cart-p']")).getText();
            verifyTxtPresent("Title is: ", "Please review your cart", verifyTitleCart);
        }
        catch (Throwable e) { }

        //verify brand
        try{
            String verifyBrandCart =  driver.findElement(By.xpath("//div[@id='patientNameDiv']")).getText();
            verifyTxtPresent("Brand in Cart: ", brand, verifyBrandCart);
            //verifyTxtPresent("Patient Name in Cart: ", patientName, verifyBrandCart);
        }
        catch (Throwable e) { }
        //verify patient name
        try{
            String verifyPatNameCart =  driver.findElement(By.xpath("//div[@class='ri-name']")).getText();
            //verifyTxtPresent("Brand in Cart: ", brand, verifyBrandCart);
            verifyTxtPresent("Patient Name in Cart: ", patientName, verifyPatNameCart);
        }
        catch (Throwable e) { }
        //verify price
        String verifyPriceBoxCart =  driver.findElement(By.xpath("//div[@parameter='price']")).getText();
        verifyTxtPresent("Per Box Price in Cart: ", price, verifyPriceBoxCart);
        try
        {
            String verifyPriceREyeCart = driver.findElement(By.xpath("//div[@class='innerParam RightEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
            verifyTxtPresent("R Eye Price in Cart: ",totalR,verifyPriceREyeCart);
        }
        catch (Throwable e)
        {
            System.out.println("No Right Eye");
        }
        try
        {
            String verifyPriceLEyeCart =  driver.findElement(By.xpath("//div[@class='innerParam LeftEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
            verifyTxtPresent("L Eye Price in Cart: ",totalL,verifyPriceLEyeCart);
        }
        catch (Throwable e)
        {
            System.out.println("No Left Eye");
        }
        try
        {
            String verifyPriceTotalCart =  driver.findElement(By.xpath("//td[@id='cartTotalTd']")).getText();
            verifyTxtPresent("Cart total: ",cartTotal,verifyPriceTotalCart);
        }
        catch (Throwable e){ }
        String verifyPriceShippingCart =  driver.findElement(By.xpath("//div[contains(@id,'uniform-ShippingViewModel_SelectedShipperCode')]")).getText();
        System.out.println("Shipping: " + verifyPriceShippingCart);
    }
    private void verifyBrandRS(String device, String brand, String patientName){
        if(device.equals("phone")){
            try{   //phone NI
                String verifyBrandRS =  driver.findElement(By.xpath("//div[@class='review-order-payment-item-description']")).getText();
                verifyTxtPresent("Brand on RS: ", brand, verifyBrandRS);
                verifyTxtPresent("Patient Name in RS: ", patientName, verifyBrandRS);
                Wait(6);
            }
            catch (Throwable e){System.out.println("Not NI " + device);}
            try{   //phone RI
                String verifyBrandRS =  driver.findElement(By.xpath("//div[@class='ri-name']")).getText();
                verifyTxtPresent("Brand in RS: ", brand, verifyBrandRS);
                verifyTxtPresent("Patient Name in RS: ", patientName, verifyBrandRS);
                Wait(6);
            }
            catch (Throwable e){System.out.println("Could not find brand on RS " + device);}
        }
        else if(device.equals("tablet")){
            try{   //tablet NI
                String verifyBrandRS =  driver.findElement(By.xpath("//div[@class='review-order-payment-item-description']")).getText();
                verifyTxtPresent("Brand on RS: ", brand, verifyBrandRS);
                verifyTxtPresent("Patient Name in RS: ", patientName, verifyBrandRS);
                Wait(6);
            }
            catch (Throwable e){System.out.println("Not NI " + device);}
            try{   //tablet RI
                String verifyBrandRS =  driver.findElement(By.xpath("//div[@class='ri-name']")).getText();
                verifyTxtPresent("Brand in RS: ", brand, verifyBrandRS);
                verifyTxtPresent("Patient Name in RS: ", patientName, verifyBrandRS);
                Wait(6);
            }
            catch (Throwable e){System.out.println("Could not find brand on RS " + device);}
        }
        else if(device.equals("desktop")){
            try{   //desktop NI
                String verifyBrandRS =  driver.findElement(By.xpath("//div[@class='review-order-payment-item-description']")).getText();
                verifyTxtPresent("Brand on RS: ", brand, verifyBrandRS);
                verifyTxtPresent("Patient Name in RS: ", patientName, verifyBrandRS);
                Wait(6);
            }
            catch (Throwable e){System.out.println("Not NI " + device);}
            try{   //desktop RI
                String verifyBrandRS =  driver.findElement(By.xpath("//div[@class='ri-name']")).getText();
                verifyTxtPresent("Brand in RS: ", brand, verifyBrandRS);
                verifyTxtPresent("Patient Name in RS: ", patientName, verifyBrandRS);
                Wait(6);
            }
            catch (Throwable e){System.out.println("Could not find brand on RS " + device);}
        }
    }
    private void verifyTitleRS (String device){
        System.out.println("Page title is: " + driver.getTitle());
        if(device.equals("tablet")){   //NI
            String verifyTitleRS =  driver.findElement(By.xpath("//div[@class='a41-checkout-review-sub-header rd-tablet rd-native']")).getText();
            verifyTxtPresent("Title is: ", "Please review and place your order below", verifyTitleRS);
        }
        if(device.equals("desktop")){   //NI
            String verifyTitleRS =  driver.findElement(By.xpath("//div[@class='a41-checkout-review-sub-header rd-tablet rd-native']")).getText();
            verifyTxtPresent("Title is: ", "Please review and place your order below", verifyTitleRS);
        }
        else if (device.equals("phone")) {
            try{   //NI
                String verifyTitleRS =  driver.findElement(By.xpath("//body[@s.channel='Review & Submit']")).getText();
                verifyTxtPresent("Title is: ", "Review & Submit", verifyTitleRS);
            }
            catch (Throwable e){System.out.println("Could not find title on RS " + device);}
        }
    }
    private void verifyPriceEyesRS(String device,String price,String totalR,String totalL){
        //price
        //TODO add verification for mobile this is just desktop
        if(device.equals("desktop")){
        String verifyPriceBoxRS =  driver.findElement(By.xpath("//div[@parameter='price']")).getText();
        verifyTxtPresent("Per Box Price in RS: ", price, verifyPriceBoxRS);
            try
            {
                String verifyPriceREyeRS = driver.findElement(By.xpath("//div[@class='innerParam RightEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
                verifyTxtPresent("R Eye Price in RS: ",totalR,verifyPriceREyeRS);
            }
            catch (Throwable e)
            {
                System.out.println("No Right Eye");
            }
            try
            {
                String verifyPriceLEyeRS =  driver.findElement(By.xpath("//div[@class='innerParam LeftEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
                verifyTxtPresent("L Eye Price in RS: ",totalL,verifyPriceLEyeRS);
            }
            catch (Throwable e)
            {
                System.out.println("No Left Eye");
            }
        }
        else if(device.equals("tablet")){
            String verifyPriceBoxRS =  driver.findElement(By.xpath("//div[@parameter='price']")).getText();
            verifyTxtPresent("Per Box Price in RS: ", price, verifyPriceBoxRS);
            try
            {
                String verifyPriceREyeRS = driver.findElement(By.xpath("//div[@class='innerParam RightEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
                verifyTxtPresent("R Eye Price in RS: ",totalR,verifyPriceREyeRS);
            }
            catch (Throwable e)
            {
                System.out.println("No Right Eye");
            }
            try
            {
                String verifyPriceLEyeRS =  driver.findElement(By.xpath("//div[@class='innerParam LeftEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
                verifyTxtPresent("L Eye Price in RS: ",totalL,verifyPriceLEyeRS);
            }
            catch (Throwable e)
            {
                System.out.println("No Left Eye");
            }
        }
        //this is not opening the order details area
        else if(device.equals("phone")){
         driver.findElement(By.xpath("//div[contains(@class,'collapsingHeader rd-phone')]")).click();
        String verifyPriceBoxRS =  driver.findElement(By.xpath("//div[contains(.,'Order Details')]")).getText();
        verifyTxtPresent("Per Box Price in RS: ", price, verifyPriceBoxRS);
        try
        {
            String verifyPriceREyeRS = driver.findElement(By.xpath("//div[@class='innerParam RightEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
            verifyTxtPresent("R Eye Price in RS: ",totalR,verifyPriceREyeRS);
        }
        catch (Throwable e)
        {
            System.out.println("No Right Eye");
        }
        try
        {
            String verifyPriceLEyeRS =  driver.findElement(By.xpath("//div[@class='innerParam LeftEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
            verifyTxtPresent("L Eye Price in RS: ",totalL,verifyPriceLEyeRS);
        }
        catch (Throwable e)
        {
            System.out.println("No Left Eye");
        }
    }
    }
    private void verifySubTotalRS(String device,String rsSubTotal){
        if(!(rsSubTotal.equals(""))){

            String verifyPriceSubTotalRS =  driver.findElement(By.xpath("//dd[@class='a41-checkout-review-subtotal']")).getText();
            verifyTxtPresent("RS sub-total: ",rsSubTotal,verifyPriceSubTotalRS);
        }
        else {System.out.println("No Subtotal specified");}
    }
    private void verifyTotalRS(String device,String rsTotal){
        //total
        if(!(rsTotal.equals(""))){
            String verifyTotalRS =  driver.findElement(By.xpath("//dl[@class='a41-checkout-review-totals total']")).getText();
            verifyTxtPresent("Total on RS: ", rsTotal, verifyTotalRS);
        }
        else {System.out.println("No total specified");}
    }
    private void verifyTaxRS(String device,String rsTax){
        if(!(rsTax.equals(""))){ //NI
            String verifyTaxRS =  driver.findElement(By.xpath("//dl[@class='a41-checkout-review-totals a41-checkout-review-tax']")).getText();
            verifyTxtPresent("Tax in RS: ", rsTax, verifyTaxRS);
        }
        else {System.out.println("No Tax");}
    }
    private void verifyTotalAfterRebate(String device,String rsTotalAfterRebate){
        if(!(rsTotalAfterRebate.equals(""))){ //NI
            String verifyTotalAfterRebateRS =  driver.findElement(By.xpath("//dl[@class='a41-checkout-review-totals total']")).getText();
            verifyTxtPresent("Total on RS: ", rsTotalAfterRebate, verifyTotalAfterRebateRS);
        }
        else {System.out.println("No Rebate");}
    }
    private void verifyRebateText(String device,String rsRebate){
        //if(device.equals("desktop")){
       // try{ //NI
       //     String verifyRebateRS =  driver.findElement(By.xpath("//div[@class='review-order-payment-item-description']")).getText();
       //     verifyTxtPresent("Rebate on RS: ", rsRebate, verifyRebateRS);
       //     System.out.println("Rebate text RS desktop: " + verifyRebateRS);
       // }
       // catch (Throwable e) {}
       // }
        //else if (device.equals("phone")) {
        if(!(rsRebate.equals(""))){ //phone
            String verifyRebateRS =  driver.findElement(By.xpath("//div[contains(@class,'a41-checkout-review-details-right-padding')]")).getText();
            verifyTxtPresent("Rebate text RS: " + device, rsRebate, verifyRebateRS);
        }
        else {System.out.println("No Rebate");}
       // }
    }
    private void verifyShipping(String device,String rsShipping){
        if (device.equals("desktop")) {
            if(rsShipping.equals("FREE")){
                String verifyPriceShippingRS =  driver.findElement(By.xpath("//dt[contains(@class,'a41-shipping-time a41-shipping-padding')]")).getText();
                verifyTxtPresent("Shipping on RS: " + device,rsShipping,verifyPriceShippingRS);
            }

            else {
                String verifyPriceShippingRS =  driver.findElement(By.xpath("//dd[contains(@class,'a41-shipping-time')]")).getText();
            verifyTxtPresent("Shipping on RS: " + device,rsShipping,verifyPriceShippingRS);
            }
        }
        if (device.equals("phone")) {
            if(rsShipping.equals("FREE")){
                String verifyPriceShippingRS =  driver.findElement(By.xpath("//dt[contains(@class,'a41-shipping-time a41-shipping-padding')]")).getText();
                verifyTxtPresent("Shipping on RS: " + device,rsShipping,verifyPriceShippingRS);
            }

            else {
                String verifyPriceShippingRS =  driver.findElement(By.xpath("//dd[contains(@class,'a41-shipping-time')]")).getText();
            verifyTxtPresent("Shipping on RS: " + device,rsShipping,verifyPriceShippingRS);
            }
        }
        if (device.equals("tablet")) {
            if(rsShipping.equals("FREE")){
                String verifyPriceShippingRS =  driver.findElement(By.xpath("//dt[contains(@class,'a41-shipping-time a41-shipping-padding')]")).getText();
                verifyTxtPresent("Shipping on RS: " + device,rsShipping,verifyPriceShippingRS);
            }

           else { //add something for if rsShipping = free the look in another place
                String verifyPriceShippingRS =  driver.findElement(By.xpath("//dd[contains(@class,'a41-shipping-time')]")).getText();
                verifyTxtPresent("Shipping on RS: " + device,rsShipping,verifyPriceShippingRS);
            }
        }
    }

    public void verifyRS(String device,String brand,String patientName,String price,String totalR, String totalL, String rsSubTotal, String rsTax, String rsTotal,String rsTotalAfterRebate,String rsRebate,String rsShipping) {
        Wait(14);
        verifyBrandRS(device,brand,patientName);
        verifyIniMembers(device, patientName);
        verifyTitleRS(device);
        verifyPriceEyesRS(device, price, totalR, totalL);
        verifySubTotalRS(device,rsSubTotal);
        verifyTotalRS(device,rsTotal);
        verifyTaxRS(device,rsTax);
        verifyTotalAfterRebate(device,rsTotalAfterRebate);
        verifyRebateText(device,rsRebate);
        verifyShipping(device, rsShipping);
    }
    //asserts
    public void verifyRXCart (String device,String rPower,String lPower,String rDia,String lDia,String rAxis,String lAxis,String rColor,String lColor,String rAdd,String lAdd,String rCyl,String lCyl,String rBC,String lBC,String rBoxes,String lBoxes){
        assertRPowerCart(device,rPower);
        assertLPowerCart(device,lPower);
        assertRDiaCart(device,rDia);
        assertLDiaCart(device,lDia);
        assertRAxisCart(device,rAxis);
        assertLAxisCart(device,lAxis);
        assertRColorCart(device,rColor);
        assertLColorCart(device,lColor);
        assertRAddCart(device,rAdd);
        assertLAddCart(device,lAdd);
        assertRCylCart(device,rCyl);
        assertLCylCart(device,lCyl);
        assertRBCCart(device,rBC);
        assertLBCCart(device,lBC);
        assertRBoxesCart(device,rBoxes);
        assertLBoxesCart(device,lBoxes);
    }
    public void assertOrderStatusHistory(String device,String brand,String patientName,String shippingCost,String shippingType,String sState,String sCity,String tax,String total,String rebateText,String totalAfterRebate) {

        assertBrandOrderStatusHistory(device,brand);
        assertPatientOrderStatusHistory(device, patientName);
        assertShippingCostOrderStatusHistory(device, shippingCost,shippingType,tax);
        assertShippingOrderStatusHistory(device, sCity, sState);
        assertTotalOrderStatusHistory(device, total);
    }
    public void assertThankYouPage(String device,String ship) {
        Wait(14);
        System.out.println("Page title is: " + driver.getTitle());
        driver.findElement(By.xpath("//h1[contains(.,'Thank you for your order!')]"));
        System.out.println("Thank You page says Thank you for your order! ");
        driver.findElement(By.xpath("//p[contains(.,'A confirmation of this order has been sent to:')]"));
        System.out.println("A confirmation of this order has been sent to:");
        String theFinalPrice = driver.findElement(By.xpath("//dd[contains(@id,'orderTotal')]")).getText();
        System.out.println("Total: " + theFinalPrice);
        try
        {
            String theFinalPriceAfterRebate = driver.findElement(By.xpath("//dd[contains(@style,'color: #0BA14B; font-weight: bold;')]")).getText();
            System.out.println("Total after rebate: " + theFinalPriceAfterRebate);
        }
        catch (Throwable e)
        {
            System.out.println("No Rebate");
        }
        String theOrderNumber = driver.findElement(By.xpath("//td[contains(@id,'orderNumber')]")).getText();
        System.out.println("Order Number: " + theOrderNumber);
        String shippingValidationTY =  driver.findElement(By.xpath("//dt[@class='a41-shipping-time']")).getText();
        System.out.println("Shipping method is:" + shippingValidationTY);
        assertTxtPresent("Shipping Method is: : ", ship, shippingValidationTY);
    }
    public void assertPDP(String device,String brand) {
        Wait(14);
        System.out.println("Page title is: " + driver.getTitle());
        String verifyProdPDP =  driver.findElement(By.xpath("//h1[@class='product-heading']")).getText();
        System.out.println("Brand is:" + verifyProdPDP);
        verifyTxtPresent("Title is: ", brand, verifyProdPDP);
    }
    public void assertTxtPresent(String identifier, String desired, String actual){
        // the pattern we want to search for
        Pattern p = Pattern.compile(desired);
        Matcher m = p.matcher(actual);
        // try to find a match
        if (m.find()){
            System.out.println("VERIFIED " + identifier + "Found " + desired + " within " + actual + "." );
        }
        else {
            System.out.println("FAIL " + identifier + "NOT FOUND " + desired + " within " + actual + "." );
            assert false;
        }
    }
    public void assertRPowerCart(String device,String rPower){
        if (device.equals("phone")) {
            String assertRPower = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_SphericalPower')]")).getText();
            assertTxtPresent("Right Power Rx on Cart: ", rPower, assertRPower);
        }
        else if (device.equals("desktop")) {
            String assertRPower = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_SphericalPower')]")).getText();
            assertTxtPresent("Right Power Rx on Cart: ", rPower, assertRPower);
        }
        else if (device.equals("tablet")) {
            String assertRPower = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_SphericalPower')]")).getText();
            assertTxtPresent("Right Power Rx on Cart: ", rPower, assertRPower);
        }
    }
    public void assertLPowerCart(String device,String lPower){
        if (device.equals("phone")) {
            String assertLPower = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_SphericalPower')]")).getText();
            assertTxtPresent("Left Power Rx in Cart: ", lPower, assertLPower);
        }
        else if (device.equals("desktop")) {
            String assertLPower = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_SphericalPower')]")).getText();
            assertTxtPresent("Left Power Rx in Cart: ", lPower, assertLPower);
        }
        else if (device.equals("tablet")) {
            String assertLPower = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_SphericalPower')]")).getText();
            assertTxtPresent("Left Power Rx in Cart: ", lPower, assertLPower);
        }
    }
    public void assertRDiaCart(String device,String rDia){
        if(!(rDia.equals(""))){
            if (device.equals("phone")) {
                String assertRDia = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_DiameterLength')]")).getText();
                assertTxtPresent("Right Dia in Cart: ", rDia, assertRDia);
            }
            else if (device.equals("desktop")) {
                String assertRDia = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_DiameterLength')]")).getText();
                assertTxtPresent("Right Dia in Cart: ", rDia, assertRDia);
            }
            else if (device.equals("tablet")) {
                String assertRDia = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_DiameterLength')]")).getText();
                assertTxtPresent("Right Dia in Cart: ", rDia, assertRDia);
            }
        }
    }
    public void assertLDiaCart(String device,String lDia){
        if(!(lDia.equals(""))){
            if (device.equals("phone")) {
                String assertLDia = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_DiameterLength')]")).getText();
                assertTxtPresent("Left Dia in Cart: ", lDia, assertLDia);
            }
            else if (device.equals("desktop")) {
                String assertLDia = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_DiameterLength')]")).getText();
                assertTxtPresent("Left Dia in Cart: ", lDia, assertLDia);
            }
            else if (device.equals("tablet")) {
                String assertLDia = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_DiameterLength')]")).getText();
                assertTxtPresent("Left Dia in Cart: ", lDia, assertLDia);
            }
        }
    }
    public void assertRAxisCart(String device,String rAxis){
        if(!(rAxis.equals(""))){
            if (device.equals("phone")) {
                String assertRAxis = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_AxisDegree')]")).getText();
                assertTxtPresent("Right Axis in Cart: ", rAxis, assertRAxis);
            }
            else if (device.equals("desktop")) {
                String assertRAxis = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_AxisDegree')]")).getText();
                assertTxtPresent("Right Axis in Cart: ", rAxis, assertRAxis);
            }
            else if (device.equals("tablet")) {
                String assertRAxis = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_AxisDegree')]")).getText();
                assertTxtPresent("Right Axis in Cart: ", rAxis, assertRAxis);
            }
        }
    }
    public void assertLAxisCart(String device,String lAxis){
        if(!(lAxis.equals(""))){
            if (device.equals("phone")) {
              String assertLAxis = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_AxisDegree')]")).getText();
              assertTxtPresent("Left Axis in Cart: ", lAxis, assertLAxis);
            }
            else if (device.equals("desktop")) {
                String assertLAxis = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_AxisDegree')]")).getText();
                assertTxtPresent("Left Axis in Cart: ", lAxis, assertLAxis);
            }
            else if (device.equals("tablet")) {
                String assertLAxis = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_AxisDegree')]")).getText();
                assertTxtPresent("Left Axis in Cart: ", lAxis, assertLAxis);
            }
        }
    }
    public void assertRColorCart(String device,String rColor){
        if(!(rColor.equals(""))){
            if (device.equals("phone")) {}
        }
    }
    public void assertLColorCart(String device,String lColor){
        if(!(lColor.equals(""))){
            if (device.equals("phone")) {}
        }
    }
    public void assertRAddCart(String device,String rAdd){
        if(!(rAdd.equals(""))){
            if (device.equals("phone")) {}
        }
    }
    public void assertLAddCart(String device,String lAdd){
        if(!(lAdd.equals(""))){
            if (device.equals("phone")) {}
        }
    }
    public void assertRCylCart(String device,String rCyl){
        if(!(rCyl.equals(""))){
            if (device.equals("phone")) {
                String assertRCyl = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_CylinderPower')]")).getText();
                assertTxtPresent("Right Cyl in Cart: ", rCyl, assertRCyl);
            }
            else if (device.equals("desktop")) {
                String assertRCyl = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_CylinderPower')]")).getText();
                assertTxtPresent("Right Cyl in Cart: ", rCyl, assertRCyl);
            }
            else if (device.equals("tablet")) {
                String assertRCyl = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_CylinderPower')]")).getText();
                assertTxtPresent("Right Cyl in Cart: ", rCyl, assertRCyl);
            }
        }
    }
    public void assertLCylCart(String device,String lCyl){
        if(!(lCyl.equals(""))){
            if (device.equals("phone")) {
                String assertLCyl = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_CylinderPower')]")).getText();
                assertTxtPresent("Left Cyl in Cart: ", lCyl, assertLCyl);
            }
            else if (device.equals("desktop")) {
                String assertLCyl = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_CylinderPower')]")).getText();
                assertTxtPresent("Left Cyl in Cart: ", lCyl, assertLCyl);
            }
            else if (device.equals("tablet")) {
                String assertLCyl = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_CylinderPower')]")).getText();
                assertTxtPresent("Left Cyl in Cart: ", lCyl, assertLCyl);
            }
        }
    }
    public void assertRBCCart(String device,String rBC){
        if(!(rBC.equals(""))){
            if (device.equals("phone")) {
                String assertRBC = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_BaseCurve')]")).getText();
                assertTxtPresent("Right BC in Cart: ", rBC, assertRBC);
            }
            else if (device.equals("desktop")) {
                String assertRBC = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_BaseCurve')]")).getText();
                assertTxtPresent("Right BC in Cart: ", rBC, assertRBC);
            }
            else if (device.equals("tablet")) {
                String assertRBC = driver.findElement(By.xpath("//label[contains(@for,'RightEyeViewModel_EyePrescriptionViewModel_BaseCurve')]")).getText();
                assertTxtPresent("Right BC in Cart: ", rBC, assertRBC);
            }
        }
    }
    public void assertLBCCart(String device,String lBC){
        if(!(lBC.equals(""))){
            if (device.equals("phone")) {
                String assertLBC = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_BaseCurve')]")).getText();
                assertTxtPresent("Left BC in  Cart: ", lBC, assertLBC);
            }
            else if (device.equals("desktop")) {
                String assertLBC = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_BaseCurve')]")).getText();
                assertTxtPresent("Left BC in  Cart: ", lBC, assertLBC);
            }
            else if (device.equals("tablet")) {
                String assertLBC = driver.findElement(By.xpath("//label[contains(@for,'LeftEyeViewModel_EyePrescriptionViewModel_BaseCurve')]")).getText();
                assertTxtPresent("Left BC in  Cart: ", lBC, assertLBC);
            }
        }
    }
    public void assertRBoxesCart(String device,String rBoxes){
        if(!(rBoxes.equals(""))){
            if (device.equals("phone")) {
                String assertRBoxes = driver.findElement(By.xpath("//select[contains(@id,'RightEyeViewModel_EyePrescriptionViewModel_Quantity')]")).getText();
                assertTxtPresent("Right Boxes in Cart: ", rBoxes, assertRBoxes);
            }
            else if (device.equals("desktop")) {
                String assertRBoxes = driver.findElement(By.xpath("//select[contains(@id,'RightEyeViewModel_EyePrescriptionViewModel_Quantity')]")).getText();
                assertTxtPresent("Right Boxes in Cart: ", rBoxes, assertRBoxes);
            }
            else if (device.equals("tablet")) {
                String assertRBoxes = driver.findElement(By.xpath("//select[contains(@id,'RightEyeViewModel_EyePrescriptionViewModel_Quantity')]")).getText();
                assertTxtPresent("Right Boxes in Cart: ", rBoxes, assertRBoxes);
            }
        }
    }
    public void assertLBoxesCart(String device,String lBoxes){
        if(!(lBoxes.equals(""))){
            if (device.equals("phone")) {
                String assertLBoxes = driver.findElement(By.xpath("//select[contains(@id,'LeftEyeViewModel_EyePrescriptionViewModel_Quantity')]")).getText();
                assertTxtPresent("Left Boxes in Cart: ", lBoxes, assertLBoxes);
            }
            else if (device.equals("desktop")) {
                String assertLBoxes = driver.findElement(By.xpath("//select[contains(@id,'LeftEyeViewModel_EyePrescriptionViewModel_Quantity')]")).getText();
                assertTxtPresent("Left Boxes in Cart: ", lBoxes, assertLBoxes);
            }
            else if (device.equals("tablet")) {
                String assertLBoxes = driver.findElement(By.xpath("//select[contains(@id,'LeftEyeViewModel_EyePrescriptionViewModel_Quantity')]")).getText();
                assertTxtPresent("Left Boxes in Cart: ", lBoxes, assertLBoxes);
            }
        }
    }
    public void assertBrandOrderStatusHistory(String device,String brand){
        if (device.equals("phone")) {
            Wait(5);
            String assertBrand =  driver.findElement(By.xpath("//div[@class='productDetails']")).getText();
            assertTxtPresent("Brand on Order History: ", brand, assertBrand);
        }
        else if (device.equals("tablet")) {
            Wait(5);
            String assertBrand =  driver.findElement(By.xpath("//div[@class='productDetails']")).getText();
            assertTxtPresent("Brand on Order History: ", brand, assertBrand);
        }
        else if (device.equals("desktop")) {
            Wait(5);
            String assertBrand =  driver.findElement(By.xpath("//div[@class='productDetails']")).getText();
            assertTxtPresent("Brand on Order History: ", brand, assertBrand);
        }
    }
    public void assertPatientOrderStatusHistory(String device,String patientName){
        if (device.equals("phone")) {
        String assertPatientName =  driver.findElement(By.xpath("//div[@class='orderInformation']")).getText();
        assertTxtPresent("Patient Name on Order History: ", patientName, assertPatientName);
    }
        else if (device.equals("tablet")) {
            String assertPatientName =  driver.findElement(By.xpath("//div[@class='orderInformation']")).getText();
            assertTxtPresent("Patient Name on Order History: ", patientName, assertPatientName);
        }
        else if (device.equals("desktop")) {
            String assertPatientName =  driver.findElement(By.xpath("//div[@class='orderInformation']")).getText();
            assertTxtPresent("Patient Name on Order History: ", patientName, assertPatientName);
        }
    }
    public void assertShippingCostOrderStatusHistory(String device, String shippingCost,String shippingType,String tax){
        if (device.equals("phone")) {
            String assertShipCost =  driver.findElement(By.xpath("//dt[@class='a41-shipping-time']")).getText();
            System.out.println(assertShipCost);
            String assertShipType =  driver.findElement(By.xpath("//dt[@class='a41-shipping-time']")).getText();
            System.out.println(assertShipType);
            String assertTax =  driver.findElement(By.xpath("//dd[@id='totalTax']")).getText();
            System.out.println(assertTax);
            assertTxtPresent("Shipping Cost on Order History: ", shippingCost, assertShipCost);
            assertTxtPresent("Shipping Type on Order History: ", shippingType, assertShipType);
            assertTxtPresent("Tax on Order History: ", tax, assertTax);
        }
        else if (device.equals("tablet")) {
            String assertShipCost =  driver.findElement(By.xpath("//dt[@class='a41-shipping-time']")).getText();
            String assertShipType =  driver.findElement(By.xpath("//dt[@class='a41-shipping-time']")).getText();
            String assertTax =  driver.findElement(By.xpath("//dd[@id='totalTax']")).getText();
            assertTxtPresent("Shipping Cost on Order History: ", shippingCost, assertShipCost);
            assertTxtPresent("Shipping Type on Order History: ", shippingType, assertShipType);
            assertTxtPresent("Tax on Order History: ", tax, assertTax);
        }
        else if (device.equals("desktop")) {
            String assertShipCost =  driver.findElement(By.xpath("//dt[@class='a41-shipping-time']")).getText();
            System.out.println(assertShipCost);
            String assertShipType =  driver.findElement(By.xpath("//dt[@class='a41-shipping-time']")).getText();
            System.out.println(assertShipType);
            String assertTax =  driver.findElement(By.xpath("//dd[@id='totalTax']")).getText();
            System.out.println(assertTax);
            assertTxtPresent("Shipping Cost on Order History: ", shippingCost, assertShipCost);
            assertTxtPresent("Shipping Type on Order History: ", shippingType, assertShipType);
            assertTxtPresent("Tax on Order History: ", tax, assertTax);
        }
    }
    public void assertShippingOrderStatusHistory(String device, String sCity, String sState){
        if (device.equals("phone")) {
            String assertShipCity =  driver.findElement(By.xpath("//div[@id='shippingDetails']")).getText();
            String assertShipState =  driver.findElement(By.xpath("//div[@id='shippingDetails']")).getText();
            assertTxtPresent("Shipping City on Order History: ", sCity, assertShipCity);
            assertTxtPresent("Shipping State on Order History: ", sState, assertShipState);
        }
        else if (device.equals("tablet")) {
            String assertShipCity =  driver.findElement(By.xpath("//div[@id='shippingDetails']")).getText();
            String assertShipState =  driver.findElement(By.xpath("//div[@id='shippingDetails']")).getText();
            assertTxtPresent("Shipping City on Order History: ", sCity, assertShipCity);
            assertTxtPresent("Shipping State on Order History: ", sState, assertShipState);
        }
        else if (device.equals("desktop")) {
            String assertShipCity =  driver.findElement(By.xpath("//div[@id='shippingDetails']")).getText();
            String assertShipState =  driver.findElement(By.xpath("//div[@id='shippingDetails']")).getText();
            assertTxtPresent("Shipping City on Order History: ", sCity, assertShipCity);
            assertTxtPresent("Shipping State on Order History: ", sState, assertShipState);
        }
    }
    public void assertTotalOrderStatusHistory(String device, String total){
        if (device.equals("phone")) {
            String assertTotal =  driver.findElement(By.xpath("//dd[@id='orderTotal']")).getText();
            assertTxtPresent("Total on Order History: ", total, assertTotal);
        }
        else if (device.equals("tablet")) {
            String assertTotal =  driver.findElement(By.xpath("//dd[@id='orderTotal']")).getText();
            assertTxtPresent("Total on Order History: ", total, assertTotal);
        }
        else if (device.equals("desktop")) {
            String assertTotal =  driver.findElement(By.xpath("//dd[@id='orderTotal']")).getText();
            assertTxtPresent("Total on Order History: ", total, assertTotal);
        }
    }
    public void assertRebateTextStatusHistory(String device, String rebateText){
        if (device.equals("phone")) {
            String assertRebateText = driver.findElement(By.xpath("//div[contains(@class,'a41-checkout-review-details-right-padding')]")).getText();
            assertTxtPresent("Rebate Text on Order History: ", rebateText, assertRebateText);
        }
        else if (device.equals("tablet")) {
            String assertRebateText = driver.findElement(By.xpath("//div[contains(@class,'a41-checkout-review-details-right-padding')]")).getText();
            assertTxtPresent("Rebate Text on Order History: ", rebateText, assertRebateText);
        }
        else if (device.equals("desktop")) {
            String assertRebateText = driver.findElement(By.xpath("//div[contains(@class,'a41-checkout-review-details-right-padding')]")).getText();
            assertTxtPresent("Rebate Text on Order History: ", rebateText, assertRebateText);
        }
    }
    public void assertTotalARebateOrderStatusHistory(String device, String totalAfterRebate){
        if (device.equals("phone")) {
            String assertTotalAfterRebate =  driver.findElement(By.xpath("//dl[@class='a41-checkout-review-totals total']")).getText();
            assertTxtPresent("Total After Rebate on Order History: ", totalAfterRebate, assertTotalAfterRebate);
        }
        else if (device.equals("tablet")) {
            String assertTotalAfterRebate =  driver.findElement(By.xpath("//dl[@class='a41-checkout-review-totals total']")).getText();
            assertTxtPresent("Total After Rebate on Order History: ", totalAfterRebate, assertTotalAfterRebate);
        }
        else if (device.equals("desktop")) {
            String assertTotalAfterRebate =  driver.findElement(By.xpath("//dl[@class='a41-checkout-review-totals total']")).getText();
            assertTxtPresent("Total After Rebate on Order History: ", totalAfterRebate, assertTotalAfterRebate);
        }
    }
    private void assertTitleCart (String device){
        try{   //NI
            String verifyTitleCart =  driver.findElement(By.xpath("//p[@class='']")).getText();
            assertTxtPresent("Title is: ", "Please review your cart", verifyTitleCart);
        }
        catch (Throwable e){ }
        try{  //RI
            String verifyTitleCart =  driver.findElement(By.xpath("//p[@class='review-cart-p']")).getText();
            verifyTxtPresent("Title is: ", "Please review your cart", verifyTitleCart);
        }
        catch (Throwable e) { }
    }
    private void assertBrandCart (String device,String brand,String patientName){
        try{ //NI
            String verifyBrandCart =  driver.findElement(By.xpath("//div[@id='patientNameDiv']")).getText();
            verifyTxtPresent("Brand in Cart: ", brand, verifyBrandCart);
            verifyTxtPresent("Patient Name in Cart: ", patientName, verifyBrandCart);
        }
        catch (Throwable e) { }
        try{ //RI
            String verifyBrandCart =  driver.findElement(By.xpath("//div[@class='ri-name']")).getText();
            verifyTxtPresent("Brand in Cart: ", brand, verifyBrandCart);
            verifyTxtPresent("Patient Name in Cart: ", patientName, verifyBrandCart);
        }
        catch (Throwable e) { }
    }
    private void assertPriceCart (String device,String price){
        String verifyPriceBoxCart =  driver.findElement(By.xpath("//div[@parameter='price']")).getText();
        verifyTxtPresent("Per Box Price in Cart: ", price, verifyPriceBoxCart);
    }
    private void assertREyePriceCart(String device,String totalR){
        try
        {
            String verifyPriceREyeCart = driver.findElement(By.xpath("//div[@class='innerParam RightEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
            verifyTxtPresent("R Eye Price in Cart: ",totalR,verifyPriceREyeCart);
        }
        catch (Throwable e)
        {
            System.out.println("No Right Eye");
        }
    }
    private void assertLEyePriceCart(String device,String totalL){
        try
        {
            String verifyPriceLEyeCart =  driver.findElement(By.xpath("//div[@class='innerParam LeftEyeViewModel.EyePrescriptionViewModel.Total']")).getText();
            verifyTxtPresent("L Eye Price in Cart: ",totalL,verifyPriceLEyeCart);
        }
        catch (Throwable e)
        {
            System.out.println("No Left Eye");
        }
    }
    private void assertTotalPriceCart(String device,String cartTotal){
            String verifyPriceTotalCart =  driver.findElement(By.xpath("//td[@id='cartTotalTd']")).getText();
            verifyTxtPresent("Cart total: ",cartTotal,verifyPriceTotalCart);
    }
    public void assertCart(String device,String brand,String patientName,String price,String totalR, String totalL, String cartTotal) {
        Wait(14);
        System.out.println("Page title is: " + driver.getTitle());
        assertTitleCart(device);
        assertBrandCart(device,brand,patientName);
        assertPriceCart(device,price);
        assertREyePriceCart(device,totalR);
        assertLEyePriceCart(device,totalL);
        assertTotalPriceCart(device,cartTotal);
    }
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory){
        ISuiteResult results =suites.get(0).getResults().values().iterator().next();
//        ISuiteResult results =suites.get(0).getResults().get("Test");
        ITestContext context =results.getTestContext();

        IResultMap passedTests = context.getPassedTests();
        IResultMap failedTests = context.getFailedTests();

// Print all test exceptions...
        for( ITestResult r: failedTests.getAllResults()) {
            System.out.println(" Failed TestName :"+r.getName());
        }

        for( ITestResult r: passedTests.getAllResults()) {
            System.out.println(" Passed TestName :"+r.getName());
        }
        System.out.println(results);
    }
}
