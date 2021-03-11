package help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
/**
 * This class represents the utilization of a browser.
 */
public class Browser {

    public static WebDriver driver;
    /**
     * Method which opens a browser by passed browserType.
     * <p>
     * Valid options: chrome, firefox, opera
     * @param browser the browser type which will be opened.
     */

    public static void open(String browser) {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
                driver = new OperaDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;

            default:
                throw new RuntimeException("The browser that is chosen " + browser + " is not a valid browser!");
        }

    }

    /**
     * This method provides opening the customer page.
     */
    public static void goToPage(String url) {

        driver.get(url);
    }
    /**
     * This method closes the browser.
     */
    public static void quit() {
        driver.quit();
    }


}
