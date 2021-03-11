package newRegistraions.positive;

import help.Browser;
import org.openqa.selenium.By;

public class PragmaticShopPage {

    private static final By MY_ACCOUNT = By.cssSelector("li.dropdown >a > i.fa + span");
    private static final By REGISTRY = By.cssSelector("ul.dropdown-menu>li>a[href*='account/register']");
    private static final By LOGIN = By.cssSelector("ul.dropdown-menu>li>a[href*='account/login']");

    /**
     * This method opens the registry form.
     */
    public static void goToRegistrationForm() {
        Browser.driver.findElement(MY_ACCOUNT).click();
        Browser.driver.findElement(REGISTRY).click();
    }

    /**
     *  This method opens the login form.
     */
    public static void goToMyAccount() {
        Browser.driver.findElement(MY_ACCOUNT).click();
        Browser.driver.findElement(LOGIN).click();
    }
}
