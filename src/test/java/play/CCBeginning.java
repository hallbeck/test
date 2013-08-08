package play;

import Automation.CCBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * User: KHALLBEC
 * Date: 7/30/13
 * Time: 2:53 PM
 */
public class CCBeginning extends CCBase {
     String searchTerm1 = "Geronimo";

    @Test (singleThreaded = true)
    @Parameters(value = "user")
    public void test(String user) {
        openCCR(user);
        searchFor(searchTerm1);
        submitButton();
        verifySearch(searchTerm1);



    }
}
