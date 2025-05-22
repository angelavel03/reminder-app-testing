import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AddReminderPage extends BasePage {

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/add_viewholder_text_view")
    private WebElement titleInput;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/add_viewholder_condition_container")
    private WebElement time;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/action_save_reminder")
    private WebElement saveButton;

    public AddReminderPage(AndroidDriver driver) {
        super(driver);
    }

    public void createReminder(String title) {
        titleInput.sendKeys(title);
        time.click();
        saveButton.click();

        /* *
        WebElement hourField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.samsung.android.app.reminder:id/numberpicker_input\" and @text=\"7, Hour\"]")));
        hourField.click();

        WebElement minuteField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.samsung.android.app.reminder:id/numberpicker_input\" and @text=\"4, Minute\"]")));
        minuteField.click();

        WebElement ampm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"AM\"]")));
        ampm.click();

        WebElement dateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.samsung.android.app.reminder:id/condition_date_text")));
        dateButton.click();

        WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Tuesday, May 20, 2025\"]")));
        date.click();
        * */
    }
}
