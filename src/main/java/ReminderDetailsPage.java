import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReminderDetailsPage extends BasePage {

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/add_viewholder_text_view")
    private WebElement titleInput;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/detail_bottom_edit_btn")
    private WebElement editButton;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/detail_bottom_complete_btn")
    private WebElement completeButton;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/detail_bottom_delete_btn")
    private WebElement deleteButton;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/action_save_reminder")
    private WebElement saveButton;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement moveToTrashButton;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/add_viewholder_condition_container")
    private WebElement time;

    public ReminderDetailsPage(AndroidDriver driver) {
        super(driver);
    }

    public void updateReminder(String title) {
        titleInput.click();
        titleInput.clear();
        titleInput.sendKeys(title);
        time.click();
        saveButton.click();
    }

    public void updateReminderWithEditButton(String title) {
        editButton.click();
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.samsung.android.app.reminder:id/add_viewholder_text_view")));
        titleInput.clear();
        titleInput.sendKeys(title);
        saveButton.click();
    }

    public void deleteReminder() {
        deleteButton.click();
        moveToTrashButton.click();
        appMenu.openMenu();
        appMenu.openTrash();
    }

    public void clickCompleteButton() {
        completeButton.click();
    }
}