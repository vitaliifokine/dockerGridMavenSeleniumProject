package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class BasePage extends DriverFactory {

    public BasePage(WebDriver driver) {
        this.wd = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Open Webpage")
    public BasePage openWebPage(String webpage){
        wd.get(webpage);
        saveScreenshot();
        return this;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        byte[] screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}
