import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected AndroidDriver driver;
    protected AppMenu appMenu;
    protected static WebDriverWait wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        appMenu = new AppMenu(wait);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    static WebElement getReminder(String title) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.TextView[@content-desc='"+ title+"']")));
    }
}