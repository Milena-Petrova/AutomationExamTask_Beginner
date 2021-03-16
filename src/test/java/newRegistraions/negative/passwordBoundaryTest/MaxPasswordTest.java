package newRegistraions.negative.passwordBoundaryTest;

import help.Browser;
import help.Verifications;
import newRegistraions.positive.PragmaticShopPage;
import newRegistraions.positive.PragmaticShopRegistryFormPage;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

public class MaxPasswordTest {
    @Before
    public void setUp() {
        Browser.open("chrome");
        Browser.goToPage("http://shop.pragmatic.bg/");
        PragmaticShopPage.goToRegistrationForm();
        Verifications.verifyPageTitle("Register Account", "This is not registry form page.");
    }
    @Test
    public void unsuccessfulBoundaryPasswordRegistration(){
        PragmaticShopRegistryFormPage.createInvalidPasswordRegistration();
        Verifications.verifyPageTitle("Register Account","Password must be between 4 and 20 characters!");
        Browser.driver.close();
    }
    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }
}

