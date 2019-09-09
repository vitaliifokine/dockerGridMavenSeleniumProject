package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import utils.DriverFactory;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest extends DriverFactory {

    @BeforeTest
    public void setUp() throws MalformedURLException {
        // Driver Factory Setup
        wd = DriverFactory.setBrowser("remote");
        wd.manage().window().maximize();
    }

    @Feature("Docker")
    @Test()
    public void dockerSeleniumHub() throws IOException {
        new BasePage(wd).openWebPage("https://cucumber.io/docs/guides/10-minute-tutorial/");
        saveScreenshot();
    }

    @Feature("Docker")
    @Test()
    public void dockerVolodya() throws IOException {
        new BasePage(wd).openWebPage("https://cucumber.io");
        saveScreenshot();
    }

    @AfterTest
    public void quit() {
        wd.quit();
    }

    @Step("Save attachment")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
    }
}
