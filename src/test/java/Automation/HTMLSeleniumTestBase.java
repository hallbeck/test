package Automation;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */


public class HTMLSeleniumTestBase {



   //PRODUCTION
   //public String desktopBaseUrl = "https://www.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-30.ctac.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-31.ctac.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-32.ctac.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-33.ctac.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-34.ctac.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-35.ctac.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-36.ctac.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-37.ctac.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-38.ctac.1800contacts.com/";
    //public String desktopBaseUrl = "https://dr0-web-39.ctac.1800contacts.com/";
/*    public String mobileBaseUrl = "https://www.1800contacts.com/";
    public String mobileURL = (mobileBaseUrl + "?responsive=yes");
    public String tabletBaseUrl = "https://www.1800contacts.com/";
    public String tabletURL = (tabletBaseUrl + "?responsive=yes");*/

    //STAGING

    public String desktopBaseUrl = "http://www.1800contactstest.com/"/*"http://DR0-EVASILEV-79.ctac.1800contacts.com/"*/;
    //Garys machine
    //SETEMPNAME.ctac.1800contacts.com

    public String mobileBaseUrl = "https://www.1800contactstest.com/";
    public String mobileURL = (mobileBaseUrl + "?responsive=yes");
    public String tabletBaseUrl = "https://www.1800contactstest.com/";
    public String tabletURL = (tabletBaseUrl + "?responsive=yes");
    public String fileName = ("TestOut" + new Date().getTime());
    public String emailFile = "./out/Aug_2013_email_addresses.txt";
    public String prodVisa = "4111111111111111";
    public String prodMC = "5111111111111118";
    public String prodAmex = "300000000000007";
    public String prodDiscover = "6000000000000007";
    public String testCard = "4012000077777777";
    public String badProdCard = "4012000077777777";
    public String testAmex = "373235387881007";
    public String testDiscover = "6011000990139424";
    public String testMCForeign = "5434842555555556";
    public String testVisaForeign = "4500600000000061";
    public String testDeclinedVisa = "4111111111111103";
    public String testDeclinedMC = "5111111111111126";
    public String testDeclinedAmex = "300000000000015";
    public String testDeclinedDiscover = "6000000000000015";
    public String testDiners = "36259600000004";
    public String testBlank = "";
    public String ccErrorInvalid = "We're sorry, that credit card number appears to be invalid. Please update the credit card number to continue.";
    public String ccErrorDecline = "We're sorry, that credit card number appears to be invalid. Please update the credit card number to continue.";


    private HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_17);
    public void startNow(String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    public void getLink(String addition,String text){
       driver.get(desktopBaseUrl + addition);
        String pageTxt = driver.getTitle();
        print(pageTxt + "\n");
        assertTxtPresent("Looked for and ", text, pageTxt);
        driver.navigate().refresh();
        print(pageTxt);
        driver.navigate().refresh();
        print(pageTxt);
        driver.navigate().refresh();
        print(pageTxt);
        driver.navigate().refresh();
        print(pageTxt);
        driver.navigate().refresh();
        print(pageTxt);
        driver.navigate().refresh();
        print(pageTxt);
        driver.navigate().refresh();
        print(pageTxt);
    }
    public void verifyTag(String tag,String expected) {
        try{
            WebElement weText = driver.findElement(By.tagName(tag));
            String toVerify = weText.getText();
            print("found this text: " + toVerify);
            verifyTxtPresent("Pages: ", expected, toVerify);
        }
        catch(Exception e)
        {
            String errorText = driver.findElement(By.xpath("//div[@class='HeaderText']")).getText();
            print("found this text: " + errorText);
            verifyTxtPresent("Pages: ",expected,errorText);
            print("FAIL: " + expected + " NOT Found " );
        }
    }
    public void verifyTxtPresent(String identifier, String desired, String actual){
        // the pattern we want to search for
        Pattern p = Pattern.compile(desired);
        Matcher m = p.matcher(actual);
        // try to find a match
        if (m.find())
            System.out.println("VERIFIED " + identifier + ". Found : " + desired + ", within, " + actual );
        else
            System.out.println("FAIL " + identifier + ". NOT FOUND : " + desired + ", within, " + actual );
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
    public void runtest (String addition) {

        //final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        driver.get(desktopBaseUrl+addition);
        String pageAsText = driver.getTitle();
        print(pageAsText);
    }
    public void quitme (){
        driver.quit();
    }
    public void print(String text){
        System.out.println(text);
    }

    public ChromeOptions options = new ChromeOptions();
    public DesiredCapabilities capabilities = DesiredCapabilities.chrome();

    //for reading datapool
    public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
        String[][] tabArray=null;
        try{
            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
            Sheet sheet = workbook.getSheet(sheetName);
            int startRow,startCol, endRow, endCol,ci,cj;
            Cell tableStart=sheet.findCell(tableName);
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();

            Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);

            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", " +
                    "startCol=" + startCol + ", endCol=" + endCol);
            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
            ci=0;

            for (int i=startRow+1;i<endRow;i++,ci++){
                cj=0;
                for (int j=startCol+1;j<endCol;j++,cj++){
                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
                }
            }
        }
        catch (Exception e)    {
            System.out.println("error in getTableArray()" + e);
        }

        return(tabArray);
    }
    public void Wait(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
            //System.out.println("Waiting " + seconds + " seconds");
        } catch (Exception e) {
            print("Sleep exception...its a nightmare");
        }
    }



}

