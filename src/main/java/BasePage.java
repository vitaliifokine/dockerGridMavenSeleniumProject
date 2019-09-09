import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends utils.DriverFactory {

    public BasePage(WebDriver driver) {
        this.wd = driver;
        PageFactory.initElements(driver, this);
    }

    public void openWebPage(String webpage){
        wd.get(webpage);
    }
}
