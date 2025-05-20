import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/floating_action_button")
    private WebElement addReminderButton;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/quick_add_edittext")
    private WebElement quickReminderInputLayout;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/quick_add_activity_edit_text")
    private WebElement quickReminderInput;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/quick_add_floating_action_button")
    private WebElement addQuickReminderButton;

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getReminder(String title) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.TextView[@content-desc='"+title+"']"
        )));
    }

    public void openReminder(String title) {
        WebElement reminder = getReminder(title);
        reminder.click();
    }

    public void openAddReminderPage() {
        addReminderButton.click();
    }

    public void markAsCompleted(String title) {
        WebElement markCompletedCheckbox = getReminder(title).findElement(By.id(""));
        markCompletedCheckbox.click();
    }

    public void addQuickReminder(String title) {
        quickReminderInputLayout.click();
        quickReminderInput.sendKeys(title);
        addQuickReminderButton.click();
    }
}