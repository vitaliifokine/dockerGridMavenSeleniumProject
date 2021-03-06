package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static WebDriver wd;

    public static WebDriver setBrowser(String browser) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\MicrosoftWebDriver.exe");
        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            return new FirefoxDriver();
        } else if ("safari".equalsIgnoreCase(browser)) {
            return new SafariDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            return new EdgeDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            return new InternetExplorerDriver();
        }
        else if ("remote".equalsIgnoreCase(browser)) {
            // For Selenium Grid
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            cap.setVersion("");
            cap.setPlatform(Platform.LINUX);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("test-type");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.merge(cap);
            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);

            //
            // For Selenoid
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setBrowserName("opera");
//            capabilities.setVersion("63.0");
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", false);
//
//            RemoteWebDriver driver = new RemoteWebDriver(
//                    URI.create("http://localhost:4444/wd/hub").toURL(),
//                    capabilities
 //           );

            return driver;
        }
        return null;
    }
}
