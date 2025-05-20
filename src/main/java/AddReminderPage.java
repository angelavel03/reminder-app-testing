import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddReminderPage extends BasePage {

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/add_viewholder_text_view")
    private WebElement titleInput;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/add_viewholder_condition_container")
    private WebElement time;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/numberpicker_input")
    private List<WebElement> timeInput;

    @AndroidFindBy(id = "com.samsung.android.app.reminder:id/action_save_reminder")
    private WebElement saveButton;

    public AddReminderPage(AndroidDriver driver) {
        super(driver);
    }

    public void createReminder(String title, Integer hours, Integer minutes, String ampm) {
        titleInput.sendKeys(title);
        time.click();

        timeInput.get(0).clear();
        timeInput.get(0).sendKeys(hours.toString());

        timeInput.get(1).clear();
        timeInput.get(1).sendKeys(minutes.toString());

        timeInput.get(2).clear();
        timeInput.get(2).sendKeys(ampm);

        saveButton.click();
    }
}
