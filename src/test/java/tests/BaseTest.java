package tests;

import io.qameta.allure.Feature;
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

    @Feature("CucumberWebpage")
    @Test()
    public void testCucumber() throws IOException {
        new BasePage(wd).openWebPage("https://cucumber.io/docs/guides/10-minute-tutorial/")
        .openWebPage("https://stackoverflow.com/");
    }

    @Feature("StackOverflow")
    @Test()
    public void testStackOverflow() throws IOException {
        new BasePage(wd).openWebPage("https://stackoverflow.com/");
    }

    @Feature("Wikipedia")
    @Test()
    public void testWikipedia() throws IOException {
        new BasePage(wd).openWebPage("https://www.wikipedia.org/");
    }

    @AfterTest
    public void quit() {
        wd.quit();
    }
}
