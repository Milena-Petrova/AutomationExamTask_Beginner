package loginNewUser;

import help.Browser;
import org.openqa.selenium.By;

public class PragmaticLoginPage {

    private static final By USER_EMIAL = By.id("input-email");
    private static final By PASSWORD = By.id("input-password");
    private static final By LOGIN = By.cssSelector("input.btn-primary");

    /**
     * This method logins the registered user
     * @param password
     * @param email
     */
    public static void logIn(String password, String email) {
            Browser.driver.findElement(USER_EMIAL).sendKeys(email);
            Browser.driver.findElement(PASSWORD).sendKeys(password);
            Browser.driver.findElement(LOGIN).click();
    }
}
