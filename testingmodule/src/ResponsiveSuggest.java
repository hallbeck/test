/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/10/13
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */

package org.openqa.selenium.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ResponsiveSuggest {

        public static void main(String[] args) throws Exception {
            // The Firefox driver supports javascript
            ProfilesIni allProfiles = new ProfilesIni();
            FirefoxProfile profile = allProfiles.getProfile("iPhone");
            WebDriver driver = new FirefoxDriver(profile);

            profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A403 Safari/8536.25");


            // Go to the Google Suggest home page
            driver.get("http://ww1.1800contactstest.com");
            driver.findElement(By.id("NoThanks")).click();


            // Enter the query string "Cheese"
            WebElement query = driver.findElement(By.name("searchterm"));
            query.sendKeys("Acuvue");

            // Sleep until the div we want is visible or 5 seconds is over
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                WebElement resultsDiv = driver.findElement(By.className("ac_results"));

                // If results have been returned, the results are displayed in a drop down.
                if (resultsDiv.isDisplayed()) {
                    break;
                }
            }

            // And now list the suggestions
            List<WebElement> allSuggestions = driver.findElements(By.xpath("//li[@class='ac category']"));

            for (WebElement suggestion : allSuggestions) {
                System.out.println(suggestion.getText());
            }
        }
    }
