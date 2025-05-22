import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/floating_action_button")
    private WebElement addReminderButton;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/quick_add_edittext")
    private WebElement quickReminderInputLayout;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/quick_add_activity_edit_text")
    private WebElement quickReminderInput;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/quick_add_floating_action_button")
    private WebElement addQuickReminderButton;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/menu_delete")
    private WebElement deleteReminderButton;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement moveToTrashButton;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/menu_complete")
    private WebElement completeReminderButton;

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    private void longPress(WebElement reminder) {
        Point location = reminder.getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1);

        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new Pause(finger, Duration.ofSeconds(2)));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(longPress));
    }

    public void openReminder(String title) {
        WebElement reminder = getReminder(title);
        reminder.click();
    }

    public void openAddReminderPage() {
        addReminderButton.click();
    }

    // nacin #1
    public void markAsCompleted(String title) {
        WebElement markCompletedCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.CheckBox[contains(@content-desc,'" + title + "')]")));
        markCompletedCheckbox.click();
        appMenu.openMenu();
        appMenu.openCompleted();
    }

    //nacin #2
    public void markAsCompletedLongPress(String title) {
        WebElement reminder = getReminder(title);
        longPress(reminder);
        completeReminderButton.click();
        appMenu.openMenu();
        appMenu.openCompleted();
    }

    public void addQuickReminder(String title) {
        quickReminderInputLayout.click();
        quickReminderInput.sendKeys(title);
        addQuickReminderButton.click();
    }

    public void quickDeleteReminder(String title) {
        WebElement reminder = getReminder(title);
        longPress(reminder);
        deleteReminderButton.click();
        moveToTrashButton.click();
        appMenu.openMenu();
        appMenu.openTrash();
    }
}