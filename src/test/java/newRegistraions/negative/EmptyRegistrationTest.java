package newRegistraions.negative;

import help.Browser;
import help.Verifications;
import newRegistraions.positive.PragmaticShopPage;
import newRegistraions.positive.PragmaticShopRegistryFormPage;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

public class EmptyRegistrationTest {

    @Before
    public void setUp() {
        Browser.open("chrome");
        Browser.goToPage("http://shop.pragmatic.bg/");
        PragmaticShopPage.goToRegistrationForm();
        Verifications.verifyPageTitle("Register Account", "This is not registry form page.");
    }
    @Test
    public void unSuccessfulEmptyRegistration() {
        PragmaticShopRegistryFormPage.createEmptyRegistration();
        PragmaticShopRegistryFormPage.verificationFirstNameMessage("First Name must be between 1 and 32 characters!", "Wrong first name message.");
        PragmaticShopRegistryFormPage.verificationLastNameMessage("Last Name must be between 1 and 32 characters!", "Wrong last name message.");
        PragmaticShopRegistryFormPage.verificationEmailMessage("E-Mail Address does not appear to be valid!", "Wrong email message.");
        PragmaticShopRegistryFormPage.verificationPhoneMessage("Telephone must be between 3 and 32 characters!", "Wrong phone message.");
        PragmaticShopRegistryFormPage.verificationPasswordMessage("Password must be between 4 and 20 characters!", "Wrong password message.");
        Verifications.verifyPageTitle("Register Account", "This is not registry form page.");
        Browser.driver.close();
    }
    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }
}

