package newRegistraions.negative;

import help.Browser;
import help.Verifications;
import newRegistraions.positive.PragmaticShopPage;
import newRegistraions.positive.PragmaticShopRegistryFormPage;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

public class newRegitrationTest {

    @Before
    public void setUp(){
        Browser.open("chrome");
        Browser.goToPage("http://shop.pragmatic.bg/");
    }
    @Test
    public void unSuccessfulNewRegistrationTest(){
        PragmaticShopPage.goToRegistrationForm();
        Verifications.verifyPageTitle("Register Account","This is not registry form page.");
        PragmaticShopRegistryFormPage.createNewRegistration("","","","","");
        PragmaticShopRegistryFormPage.verificationEmptyFirstNameMessage("First Name must be between 1 and 32 characters!","Wrong first name message.");
        PragmaticShopRegistryFormPage.verificationEmptyLastNameMessage("Last Name must be between 1 and 32 characters!","Wrong last name message.");
        PragmaticShopRegistryFormPage.verificationEmptyEmailMessage("E-Mail Address does not appear to be valid!","Wrong email message.");
        PragmaticShopRegistryFormPage.verificationEmptyPhoneMessage("Telephone must be between 3 and 32 characters!","Wrong phone message.");
        PragmaticShopRegistryFormPage.verificationEmptyPasswordMessage("Password must be between 4 and 20 characters!","Wrong password message.");
        Verifications.verifyPageTitle("Register Account","This is not registry form page.");
    }
    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }
}
