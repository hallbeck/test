package stress;

import Automation.HTMLTestBase;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KHALLBEC
 * Date: 8/16/13
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class playtime extends HTMLTestBase {
    @DataProvider(name = "products")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("c:\\test\\src\\test\\resources\\StressInputs.xls",
                "inputsStage", "AllProducts");
        return(retObjArr);
    }
/*      @Test (dataProvider = "products")
      public void homePage(String testNumber,String device,String typeOfTest,String productPage,String title) throws Exception {
          final WebClient webClient = new WebClient();
          //final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
         // Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
          final HtmlPage page = webClient.getPage("http://www.1800contactstest.com/"+productPage);

          final String pageAsText = page.getTitleText();
          System.out.println(pageAsText);
          //Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));

      }*/
    @Test (dataProvider = "products")
    public void homePage(String testNumber,String device,String typeOfTest,String productPage,String title) throws Exception {
        final WebClient webClient = new WebClient();
        //final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        // Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
        final HtmlPage page = webClient.getPage("http://www.1800contactstest.com/"+productPage);

        final String pageAsText = page.getTitleText();
        System.out.println(pageAsText);
        //Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));

    }
 /*     //WORKS
    @Test
    public void homePage() throws Exception {
        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
        final HtmlPage page1 = webClient.getPage("http://www.1800contactstest.com/lens/acuvue-2");

        final String pageAsXml = page1.asXml();
        Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));

        final String pageAsText = page1.getTitleText();
        System.out.println(pageAsText);
        //Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));

        //webClient.closeAllWindows();
    }*/
}
