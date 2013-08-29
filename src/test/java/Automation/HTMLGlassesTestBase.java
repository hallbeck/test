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


public class HTMLGlassesTestBase {




    //STAGING

    public String desktopBaseUrl = "http://www.glasses.com/";


    public String fileName = ("TestOut" + new Date().getTime());
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
        driver.get(desktopBaseUrl+url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
    public void order(String productID){
        selectGlasses(productID);
        addToCart();
        cartContinue();
    }
    public void search(String brand){
        //driver.findElement(By.xpath("//input[@id='q']")).sendKeys(brand, Keys.RETURN);
        String pageTxt = driver.getTitle();
        print(pageTxt);
    }
    public void selectGlasses(String productID){
        String pageTxt1 = driver.getTitle();
        print(pageTxt1);
        driver.findElement(By.xpath("//img[@id='frame-psku_"+productID+"']")).click();
        String pageTxt = driver.getTitle();
        print(pageTxt);
    }
    public void addToCart (){
        driver.findElement(By.xpath("//button[@name='add_to_cart']")).click();
    }
    public void cartContinue(){
        driver.findElement(By.xpath("//a[contains(.,'Have an offer code?')]")).sendKeys(Keys.TAB,Keys.RETURN);
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
        //driver.findElementByTagName("body").sendKeys(Keys.F5);
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

