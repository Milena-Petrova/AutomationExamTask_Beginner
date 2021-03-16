package newRegistraions.positive;

import help.Browser;
import help.RandomStringGenerator;
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
     * This method creates a random registration
     */
    public static void createRandomRegistration() {
        Browser.driver.findElement(FIRST_NAME_FIELD).clear();
        Browser.driver.findElement(FIRST_NAME_FIELD).sendKeys(RandomStringGenerator.randomName());
        Browser.driver.findElement(LAST_NAME_FIELD).clear();
        Browser.driver.findElement(LAST_NAME_FIELD).sendKeys(RandomStringGenerator.randomName());
        Browser.driver.findElement(EMAIL).clear();
        Browser.driver.findElement(EMAIL).sendKeys(RandomStringGenerator.randomEmail());
        Browser.driver.findElement(PHONE_NUMBER).clear();
        Browser.driver.findElement(PHONE_NUMBER).sendKeys(RandomStringGenerator.randomPhone());
        String passWord = RandomStringGenerator.randomPassword();
        Browser.driver.findElement(PASSWORD).clear();
        Browser.driver.findElement(PASSWORD).sendKeys(passWord);
        Browser.driver.findElement(PASS_CONFIRM).clear();
        Browser.driver.findElement(PASS_CONFIRM).sendKeys(passWord);
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
     * This method creates invalid registration with
     */
    public static void createInvalidPasswordRegistration() {
        Browser.driver.findElement(FIRST_NAME_FIELD).clear();
        Browser.driver.findElement(FIRST_NAME_FIELD).sendKeys(RandomStringGenerator.randomName());
        Browser.driver.findElement(LAST_NAME_FIELD).clear();
        Browser.driver.findElement(LAST_NAME_FIELD).sendKeys(RandomStringGenerator.randomName());
        Browser.driver.findElement(EMAIL).clear();
        Browser.driver.findElement(EMAIL).sendKeys(RandomStringGenerator.randomEmail());
        Browser.driver.findElement(PHONE_NUMBER).clear();
        Browser.driver.findElement(PHONE_NUMBER).sendKeys(RandomStringGenerator.randomPhone());
        String passWord = RandomStringGenerator.randomInvalidPassword();
        String testPass = passWord;
        Browser.driver.findElement(PASSWORD).clear();
        Browser.driver.findElement(PASSWORD).sendKeys(testPass);
        Browser.driver.findElement(PASS_CONFIRM).clear();
        Browser.driver.findElement(PASS_CONFIRM).sendKeys(testPass);
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

    public static void createInvalidMinLengthPasswordRegistration() {

    }

    /**
     * This method creates registration with empty fields
     */
    public static void createEmptyRegistration() {
        Browser.driver.findElement(FIRST_NAME_FIELD).clear();
        Browser.driver.findElement(FIRST_NAME_FIELD).sendKeys();
        Browser.driver.findElement(LAST_NAME_FIELD).clear();
        Browser.driver.findElement(LAST_NAME_FIELD).sendKeys();
        Browser.driver.findElement(EMAIL).clear();
        Browser.driver.findElement(EMAIL).sendKeys();
        Browser.driver.findElement(PHONE_NUMBER).clear();
        Browser.driver.findElement(PHONE_NUMBER).sendKeys();
        Browser.driver.findElement(PASSWORD).clear();
        Browser.driver.findElement(PASSWORD).sendKeys();
        Browser.driver.findElement(PASS_CONFIRM).clear();
        Browser.driver.findElement(PASS_CONFIRM).sendKeys();
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
     * This method verifies that the proper message appears in case of empty name field or invalid first name
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationFirstNameMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(FIRST_NAME_ERROR).getText(),expected,error_message);
    }
    /**
     * This method verifies that the proper message appears in case of empty name field or invalid last name
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationLastNameMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(LAST_NAME_ERROR).getText(),expected,error_message);
    }
    /**
     * This method verifies that the proper message appears in case of empty email field or invalid email
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationEmailMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(EMAIL_ERROR).getText(),expected,error_message);
    }
    /**
     * This method verifies that the proper message appears in case of empty telephone field or invalid telephone
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationPhoneMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(PHONE_ERROR).getText(),expected,error_message);
    }
    /**
     * This method verifies that the proper message appears in case of empty password field or invalid password
     * @param expected expected message in case of empty spaces
     * @param error_message message if the expected text is not visible
     */
    public static void verificationPasswordMessage(String expected, String error_message) {
        Assert.assertEquals(Browser.driver.findElement(PASS_ERROR).getText(),expected,error_message);
    }

}
