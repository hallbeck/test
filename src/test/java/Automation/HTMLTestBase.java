package Automation;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.javascript.*;
import com.gargoylesoftware.htmlunit.WebAssert;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/17/13
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */


public class HTMLTestBase {



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

    public String desktopBaseUrl = "https://www.1800contactstest.com/"/*"http://DR0-EVASILEV-79.ctac.1800contacts.com/"*/;
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


    public WebClient webClient = new WebClient(/*BrowserVersion.FIREFOX_17*/);

    public void getLink(String addition,String text)throws Exception{
        //webClient.setJavaScriptEnabled(true);
        webClient.getCookieManager().setCookiesEnabled(true);
        print("sarting");
       final HtmlPage page = webClient.getPage(desktopBaseUrl+addition);
        print("getting title");
        String pageTxt = page.getTitleText();
        //WebAssert.assertTitleContains(page, text);
        print(pageTxt+"\n");
        //page.refresh();
        //WebAssert.assertTitleContains(page, text);
/*        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);
        page.refresh();
        WebAssert.assertTitleContains(page, text);*/
    }


    public void runtest (String addition)throws Exception {
        final WebClient webClient = new WebClient();
        //final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        final HtmlPage page1 = webClient.getPage(desktopBaseUrl+addition);
        final String pageAsText = page1.getTitleText();
        print(pageAsText);
    }
    public void quitme (){
        webClient.closeAllWindows();
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

