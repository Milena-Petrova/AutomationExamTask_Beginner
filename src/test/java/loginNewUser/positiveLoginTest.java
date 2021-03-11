package loginNewUser;

import help.Browser;
import help.Verifications;
import newRegistraions.positive.PragmaticShopPage;
import newRegistraions.positive.MyAccountPage;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

public class positiveLoginTest {

    @Before
    public void setUp() {
        Browser.open("chrome");
        Browser.goToPage("http://shop.pragmatic.bg/");
    }

    @Test
    public void successfulLoginTest() {
        PragmaticShopPage.goToMyAccount();
        Verifications.verifyPageTitle("Account Login", "This is not the proper page.");
        PragmaticLoginPage.logIn("123456","milena@abv.bg");
        Verifications.verifyPageTitle("My Account","This is not account page.");
        MyAccountPage.logOut();
        Verifications.verifyPageTitle("Account Logout", "User is not log out.");
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }

}
