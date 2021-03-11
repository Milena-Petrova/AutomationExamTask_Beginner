package help;

import org.testng.Assert;

public class Verifications {
    /**
     * Method which verifies the title based on the provided expected title and logs a message in case of assert failure.
     *
     * @param expected     the expected title
     * @param error_message error message in case the assert fails.
     */
    public static void verifyPageTitle(String expected, String error_message) {
        Assert.assertTrue( Browser.driver.getTitle().contains(expected),error_message);
    }
}
