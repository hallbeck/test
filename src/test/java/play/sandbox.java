package play;

import Automation.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * User: KHALLBEC
 * Date: 7/26/13
 * Time: 1:28 PM
 */
public class sandbox extends TestBase {
    @Test
    public void test() {
    driver.get("https://admin.dev.glasses.com/order/verify-line/?ordr_id=151905&orli_id=950462%20%3Chttps://admin.dev.glasses.com/order/verify-line/?ordr_id=151905&orli_id=950462");
        driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("khallbec@1800contacts.com");
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("sunnydays1");
        driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
        Wait(5);
        String  window = driver.getWindowHandle();
        print (window);
        driver.findElement(By.xpath("//a[contains(.,'Enter New Rx')]")).click();
        Wait(5);
/*        driver.findElement(By.xpath("./*//*[@id='modal-iframe']")).getTagName();
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));*/
        //driver.switchTo().frame(0);
        driver.switchTo().activeElement();
        Wait(5);
        //driver.findElement(By.xpath("//div[contains(@id,'edit-rx-iframe-cnt')]")).click();
        String rPower = "3.50";
        String  window2 = driver.getWindowHandle();
        print (window2);
        //driver.switchTo().frame("canvas_frame");

        WebElement weEnterRx =  driver.findElement(By.xpath("//div[contains(@class,'fancybox-title-inside')]"));
                //driver.findElement(By.xpath("//div[contains(.,'Edit RX Details')]"));
                //driver.findElement(By.xpath("//div[contains(@id,'fancybox-title')]"));

        weEnterRx.click();
        //send 12! tabs
                weEnterRx.sendKeys(Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),
                        Keys.chord(Keys.SHIFT,Keys.TAB),Keys.ADD, rPower);
//works also but is 62 tabs
 /*        weEnterRx.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,
                Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,
                Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,
                Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,
                Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,
                Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB,
                Keys.TAB, Keys.TAB,Keys.ADD, rPower);*/
    print("blah");

    }
}
