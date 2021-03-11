package newRegistraions.positive;

import help.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PragmaticShopRegistryFormPage {

    private static final By FIRST_NAME_FIELD = By.id("input-firstname");
    private static final By LAST_NAME_FIELD = By.id("input-lastname");
    private static final By EMAIL = By.id("input-email");
    private static final By PHONE_NUMBER = By.id("input-telephone");
    private static final By PASSWORD = By.id("input-password");
    private static final By PASS_CONFIRM = By.id("input-confirm");
    private static final By NEWS_SUBSCRIBE = By.cssSelector("label.radio-inline>input[value='1']");
    private static final By PRIVACY_CHECK = By.cssSelector("input[type=checkbox]");
    private static final By CONTINUE = By.cssSelector("input.btn-primary");
    private static final By FIRST_NAME_ERROR = By.cssSelector("input#input-firstname+div.text-danger");
    private static final By LAST_NAME_ERROR = By.cssSelector("input#input-lastname+div.text-danger");
    private static final By EMAIL_ERROR = By.cssSelector(" input#input-email+div.text-danger");
    private static final By PHONE_ERROR = By.cssSelector("input#input-telephone+div.text-danger");
    private static final By PASS_ERROR = By.cssSelector("input#input-password+div.text-danger");

    /**
     * This method creates a new registration
     * @param first_name first name of the user
     * @param last_name last name of the user
     * @param email valid and unique user email
     * @param phone phone number of the user
     * @param password password of the new user
     *
     */
    public static void createNewRegistration(String first_name, String last_name, String email, String phone, String password) {

        Browser.driver.findElement(FIRST_NAME_FIELD).sendKeys(first_name);
        Browser.driver.findElement(LAST_NAME_FIELD).sendKeys(last_name);
        Browser.driver.findElement(EMAIL).sendKeys(email);
        Browser.driver.findElement(PHONE_NUMBER).sendKeys(phone);
        Browser.driver.findElement(PASSWORD).sendKeys(password);
        Browser.driver.findElement(PASS_CONFIRM).sendKeys(password);
        WebElement subscribeElement = Browser.driver.findElement(NEWS_SUBSCRIBE);
        if (!subscribeElement.isSelected()) {
            subscribeElement.click();
        }
        Assert.assertTrue(subscribeElement.isSelected(), "Subscription YES is not selected");

        WebElement privacyElement = Browser.driver.findElement(PRIVACY_CHECK);
        if(!privacyElement.isSelected()){
            privacyElement.click();
        }
    Assert.assertTrue(privacyElement.isSelected());
        Browser.driver.findElement(CONTINUE).click();
    }

    /**
     * This method verifies that the proper message appears in case of empty name field
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationEmptyFirstNameMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(FIRST_NAME_ERROR).getText(),expected,error_message);
    }
    /**
     * This method verifies that the proper message appears in case of empty name field
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationEmptyLastNameMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(LAST_NAME_ERROR).getText(),expected,error_message);
    }
    /**
     * This method verifies that the proper message appears in case of empty email field
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationEmptyEmailMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(EMAIL_ERROR).getText(),expected,error_message);
    }
    /**
     * This method verifies that the proper message appears in case of empty telephone field
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationEmptyPhoneMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(PHONE_ERROR).getText(),expected,error_message);
    }
    /**
     * This method verifies that the proper message appears in case of empty password field
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationEmptyPasswordMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(PASS_ERROR).getText(),expected,error_message);
    }
}
