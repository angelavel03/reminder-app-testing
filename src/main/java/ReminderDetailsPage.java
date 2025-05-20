import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ReminderDetailsPage extends BasePage {

    @AndroidFindBy(id = "")
    private WebElement titleInput;
    @AndroidFindBy(id = "")
    private WebElement timeInputHours;
    @AndroidFindBy(id = "")
    private WebElement timeInputMinutes;
    @AndroidFindBy(id = "")
    private WebElement timeInputAMPM;
    @AndroidFindBy(id = "")
    private WebElement editButton;
    @AndroidFindBy(id = "")
    private WebElement deleteButton;
    @AndroidFindBy(id = "")
    private WebElement saveButton;
    @AndroidFindBy(id = "")
    private WebElement moveToTrashButton;

    public ReminderDetailsPage(AndroidDriver driver) {
        super(driver);
    }


    public void updateReminder(String title, Integer time, Integer hours, Integer minutes, String ampm) {
        titleInput.clear();
        titleInput.sendKeys(title);
        timeInputHours.sendKeys(time.toString());
        timeInputMinutes.sendKeys(minutes.toString());
        timeInputAMPM.sendKeys(ampm);
        saveButton.click();
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void deleteReminder() {
        deleteButton.click();
        moveToTrashButton.click();
    }
}
