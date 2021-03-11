package newRegistraions.positive;

import help.Browser;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MyAccountPage {

    private static final By CONTINUE_ =  By.cssSelector("a.btn-primary");
    private static final By LOG_OUT = By.cssSelector("ul.dropdown-menu a[href*='account/logout']");
    private static final By MY_ACCOUNT = By.cssSelector("a.dropdown-toggle>i +span");

    /**
     * This method provides access to the new user account after the registration
     */
    public static void goToMyAccount() {

        Browser.driver.findElement(CONTINUE_).click();
    }

    /**
     * This method logs out the user
     */
    public static void logOut() {
        Browser.driver.findElement(MY_ACCOUNT).click();
        Browser.driver.findElement(LOG_OUT).click();
    }
}
