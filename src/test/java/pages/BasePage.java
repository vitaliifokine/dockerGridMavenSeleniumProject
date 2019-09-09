package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class BasePage extends DriverFactory {

    public BasePage(WebDriver driver) {
        this.wd = driver;
        PageFactory.initElements(driver, this);
    }

    public void openWebPage(String webpage){
        wd.get(webpage);
    }
}
