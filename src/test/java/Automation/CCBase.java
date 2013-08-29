package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: KHALLBEC
 * Date: 7/30/13
 * Time: 2:53 PM
 */
public class CCBase {
   //LOGINS
    String csLogin = "cccc1";
    String csPassword = "!QAZ2wsx";
    String login1 = "login1";
    String password1 = "!QAZ2wsx";

    //URL
    String ccURLBeg = "https://";
    String ccURLEnd = "sta-webg-01.resource.1800contacts.com/callcenter/2/";

    public WebDriver driver = new InternetExplorerDriver();
    public String makeLogin(String user) {
        String login = "";
        if (user.equals("customerService")) {
            login = csLogin;
        } else if (user.equals("login1")) {
            login = login1;
        }
        return (login);
    }
    public String makePassword(String user) {
        String password = "";
        if (user.equals("customerService")) {
            password = csPassword;
        } else if (user.equals("login1")) {
            password = password1;
        }
        return (password);
    }
    public void openCCR(String user){
        String ccUser = makeLogin(user);
        String ccPassword = makePassword(user);
        driver.get(ccURLBeg+ccUser+":"+ccPassword+"@"+ccURLEnd);
        driver.get(ccURLBeg + ccURLEnd);
    }
    public void searchFor(String searchTerm){
        WebElement weSearch = driver.findElement(By.xpath("//input[@name='SearchText']"));
        weSearch.click();
        weSearch.sendKeys(searchTerm);
    }
    //doesnt work. need to fix TODO
    public void clickRecentAccounts (){
        driver.findElement(By.xpath("//select[@class='value recently-accessed-select focus']")).click();
    }
    public void print(String text){
        System.out.println(text);
    }
    public void Wait(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
            //System.out.println("Waiting " + seconds + " seconds");
        } catch (Exception e) {
            print("Sleep exception...its a nightmare");
        }
    }
    public void verifySearch(String searchText){
        Wait(6);
        String searchResult = driver.findElement(By.xpath("//section[@id='account-search-results']")).getText();
        verifyTxtPresent("Search Attempted ",searchText,searchResult);
    }
    public void submitButton(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
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
    public void newCust (){
        driver.findElement(By.xpath("//span[@title='Create Customer Account']")).click();
        Wait(5);
    }
    public void enterPhone (){
        WebElement wePhone = driver.findElement(By.xpath("//input[@value='Phone']"));
        wePhone.click();
        wePhone.sendKeys(Keys.TAB,"12345678");

    }
}
