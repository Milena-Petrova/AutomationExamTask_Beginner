package newRegistraions.positive;

import help.Browser;
import help.Verifications;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

public class newRegistraitionTest {

    @Before
    public void setUp(){
    Browser.open("chrome");
    Browser.goToPage("http://shop.pragmatic.bg/");
    }
    @Test
    public void successfulNewRegistrationTest(){
        PragmaticShopPage.goToRegistrationForm();
        Verifications.verifyPageTitle("Register Account","This is not registry form page.");
        //опитах да направя Random email-a, но не успях, оставям си го за по-натам да го направя
        PragmaticShopRegistryFormPage.createNewRegistration("Milena","Petrova","tosho@gmail.com","0887000000","123456");
        Verifications.verifyPageTitle("Your Account Has Been Created!","Unsuccessful registration");
        MyAccountPage.goToMyAccount();
        Verifications.verifyPageTitle("My Account","This is not account page form.");
        MyAccountPage.logOut();
        Verifications.verifyPageTitle("Account Logout","The user is not log out");
   }
    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }
}