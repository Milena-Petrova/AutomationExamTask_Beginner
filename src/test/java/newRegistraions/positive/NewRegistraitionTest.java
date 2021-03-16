package newRegistraions.positive;

import help.Browser;
import help.Verifications;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

public class NewRegistraitionTest {

    @Before
    public void setUp(){
    Browser.open("chrome");
    Browser.goToPage("http://shop.pragmatic.bg/");
    }
    @Test
    public void successfulNewRegistrationTest(){
        PragmaticShopPage.goToRegistrationForm();
        Verifications.verifyPageTitle("Register Account","This is not registry form page.");
        PragmaticShopRegistryFormPage.createRandomRegistration();
        Verifications.verifyPageTitle("Your Account Has Been Created!","Unsuccessful registration");
        MyAccountPage.goToMyAccount();
        Verifications.verifyPageTitle("My Account","This is not account page form.");
        MyAccountPage.logOut();
        Verifications.verifyPageTitle("Account Logout","The user is not log out");
        Browser.driver.close();
   }
    @AfterMethod
    public void tearDown(){

        Browser.quit();
    }
}