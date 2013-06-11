/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 3/9/13
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 * DESKTOP TEST NEW USER ACUVUE

package org.openqa.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class FirstTest {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        //PLAIN OLD FF WINDOW
        WebDriver driver = new FirefoxDriver();

        ProfilesIni allProfiles = new ProfilesIni();
        //FirefoxProfile profile = allProfiles.getProfile("iPhone");
//       profile.setPreference("foo.bar", 23);
           //FOR RESPONSIVE
        //WebDriver driver = new FirefoxDriver(profile);

        //profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A403 Safari/8536.25");
         //END FOR RESPONSIVE


        // And now use this to visit the home page
        driver.get("http://www.1800contactstest.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());

        //click on interstitial for now
        //driver.findElement(By.xpath("//img[contains(@alt,'No Thanks')]")).click();
        //System.out.println("Page title is: " + driver.getTitle());

        // click on New to 1800contacts Find your brand
        driver.findElement(By.xpath("//img[contains(@alt,'New to 1-800 Contacts - Find your contact lens brand')]")).click();
        Wait(driver, 4);

        //click on Acuvue2
        System.out.println("Page title is: " + driver.getTitle());
        driver.findElement(By.xpath("//a[contains(@id,'BrandText_Biofinity')]")).click();

        //Product Detail page Enter Power
        System.out.println("Page title is: " + driver.getTitle());
        //right
        //mobile
       // driver.findElement(By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.SphericalPower')]")).click();
        //driver.findElement(By.xpath("//option[contains(@value,'-1.00')]")).click();
        //left
        //driver.findElement(By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.SphericalPower')]")).click();
        //driver.findElement(By.xpath("//option[contains(@value,'-0.50')]")).click();
        //Enter BC
        //right
       // driver.findElement(By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.RightEyeViewModel.EyePrescriptionViewModel.BaseCurve')]")).click();
        //driver.findElement(By.xpath("//option[contains(@value,'8.70')]")).click();
        //left
        //driver.findElement(By.xpath("//select[contains(@name,'ProductPageViewModel.PrescriptionViewModel.LeftEyeViewModel.EyePrescriptionViewModel.BaseCurve')]")).click();
        //driver.findElement(By.xpath("//option[contains(@value,'8.70')]")).click();

        //desktop
        //right
        driver.findElement(By.xpath("//input[contains(@id,'RightPowerPicker')]")).click();
        Wait(driver, 2);
        driver.findElement(By.xpath("//a[contains(@id,'Right_-1.00')]")).click();
        Wait(driver, 2);
        //left
        driver.findElement(By.xpath("//input[contains(@id,'LeftPowerPicker')]")).click();
        Wait(driver, 2);
        driver.findElement(By.xpath("//a[contains(@id,'Left_-1.00')]")).click();
        Wait(driver, 2);

        //BC NOTHING


        //enter patient name first then last
        driver.findElement(By.xpath("//input[contains(@id,'firstNameInput')]")).sendKeys("PatientFirst");
        driver.findElement(By.xpath("//input[contains(@id,'lastNameInput')]")).sendKeys("PatientLast");

        //Add to cart
        driver.findElement(By.xpath("//input[contains(@value,'Submit')]")).click();
        Wait(driver, 4);

        //cart page
        //click continue
        driver.findElement(By.xpath("//img[contains(@src,'/img/ui3/btn/orange_btn_continue.png')]")).click();
        Wait(driver, 4);

                //Enter Address Information
        System.out.println("Page title is: " + driver.getTitle());
        //fname
//        driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.FirstName')]")).sendKeys("ShippingFirst");
        //lname
//        driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.LastName')]")).sendKeys("ShippingLast");
        //country
        driver.findElement(By.xpath("//select[contains(@name,'ShippingAddress.Country')]")).click();
        driver.findElement(By.xpath("//option[contains(@value,'USA')]")).click();
        //address
        driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.AddressLine1')]")).sendKeys("ship address");
        driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.AddressLine2')]")).sendKeys("3456767777");
        driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.AddressLine2')]")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.AddressLine2')]")).sendKeys(Keys.CONTROL + "x");
        //city
        driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.City')]")).sendKeys("slc");
        //state
        driver.findElement(By.xpath("//select[contains(@id,'ShippingAddress_StateProvinceOrRegion')]")).sendKeys("UT");
         //zip
        driver.findElement(By.xpath("//input[contains(@name,'ShippingAddress.ZipOrPostalCode')]")).sendKeys("84121");
        //phone
        driver.findElement(By.xpath("//input[contains(@name,'Phone')]")).sendKeys(Keys.CONTROL + "v");
        //email
        driver.findElement(By.xpath("//input[contains(@name,'EmailAddress')]")).sendKeys("acuvuenew@a.a");
        //password and confirm password
        driver.findElement(By.xpath("//input[contains(@id,'a41-checkout-password')]")).sendKeys("password");
        driver.findElement(By.xpath("//input[contains(@id,'a41-checkout-confirm-password')]")).sendKeys("password");
        //Click Continue
        driver.findElement(By.xpath("//input[contains(@value,'continue')]")).click();
        Wait(driver, 4);

        //Find then select Doctor by name and state
        driver.findElement(By.xpath("//input[contains(@name,'DoctorSearchOptionsViewModel.DoctorOrClinic')]")).sendKeys("afttyg");
        driver.findElement(By.xpath("//select[contains(@name,'DoctorSearchOptionsViewModel.State')]")).click();
        driver.findElement(By.xpath("//option[contains(.,'Utah')]")).click();
        //find then select doctor by phone number
        //driver.findElement(By.xpath("//input[contains(@id,'a41-search-by-phone')]")).click();
        //driver.findElement(By.xpath("//input[contains(@id,'PhoneNumber')]")).sendKeys("5555554444");
        System.out.println("Page title is: " + driver.getTitle());
        //search
        driver.findElement(By.xpath("//img[contains(@alt,'search')]"));
        Wait(driver, 2);
        //select doctor  this will just take the first result
        driver.findElement(By.xpath("//img[contains(@src,'/img/UI3/DoctorSearch/bttn-select.png')]"));

        //review and submit page
        //enter credit card
        driver.findElement(By.xpath("//input[contains(@id,'CreditCardNumber')]")).sendKeys("4012000077777777");
        driver.findElement(By.xpath("//select[contains(@id,'CreditCardExpirationMonth')]")).click();
        driver.findElement(By.xpath("//option[contains(@value,'03')]")).click();
        driver.findElement(By.xpath("//select[contains(@id,'CreditCardExpirationYear')]")).click();
        driver.findElement(By.xpath("//option[contains(@value,'2015')]")).click();
        driver.findElement(By.xpath("//input[contains(@id,'CreditCardName')]")).sendKeys("CreditName");
        System.out.println("Page title is: " + driver.getTitle());
        //Place My Order top button
        driver.findElement(By.xpath("//input[contains(@id,'PlaceMyOrderButton')]"));
        Wait(driver, 6);
        //Place My Order Bottom button
        //driver.findElement(By.xpath("//input[contains(@id,'ReviewAndSubmit_BottomButton')]"));

        //Processing
        driver.findElement(By.xpath("//div[contains(@id,'CreditCardProcessingDiv')]"));
        System.out.println("Page title is: " + driver.getTitle());
        //ThankYou page
        driver.findElement(By.xpath("//h1[contains(.,'Thank you for your order!')]"));
        driver.findElement(By.xpath("//p[contains(.,'A confirmation of this order has been sent to:')]"));
        System.out.println("Page title is: " + driver.getTitle());
        //go to my account
        driver.findElement(By.xpath("//a[contains(@title,'My Account')]")).click();
        System.out.println("Page title is: " + driver.getTitle());
        //view daashboard
        driver.findElement(By.xpath("//img[contains(@alt,'Welcome to your personal contact lens dashboard.')]"));
        //click on and view order history
        driver.findElement(By.xpath("//a[contains(@id,'orderStatusAndHistoryForm')]")).click();
        driver.findElement(By.xpath("//img[contains(@id,'orderSummaryTitleImg')]"));
        System.out.println("Page title is: " + driver.getTitle());
        //view addresses
        driver.findElement(By.xpath("//a[contains(@id,'shippingBillingForm')]")).click();
        driver.findElement(By.xpath("//img[contains(@src,'/images/AccountHub/myBillingAddress.png')]"));
        System.out.println("Page title is: " + driver.getTitle());
        //view account settings and password
        driver.findElement(By.xpath("//a[contains(@id,'accountSettingsAndPasswordForm')]")).click();
        driver.findElement(By.xpath("//img[contains(@alt,'Account Settings & Password')]"));
        System.out.println("Page title is: " + driver.getTitle());

        // Find the text input element by its name
        //WebElement element = driver.findElement(By.name("q"));

        // Find the text input element by its name
      //  WebElement element = driver.findElement(By.name("search"));

        // Enter something to search for
        //element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        //element.submit();

        // Check the title of the page
        //System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        //(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
        //    public Boolean apply(WebDriver d) {
        //        return d.getTitle().toLowerCase().startsWith("cheese!");
        //    }
        //});

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
    }
} */
