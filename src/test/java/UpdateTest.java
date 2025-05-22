import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class UpdateTest extends BaseTest {

    private MainPage mainPage;
    private ReminderDetailsPage reminderDetailsPage;

    @Test
    public void testUpdate() {
        String title = "I am a reminder";
        String newReminderTitle = "I am not a reminder";

        mainPage = new MainPage(driver);
        mainPage.openReminder(title);

        reminderDetailsPage = new ReminderDetailsPage(driver);
        reminderDetailsPage.updateReminder(newReminderTitle);
        WebElement reminder = BasePage.getReminder(newReminderTitle);

        assertTrue(reminder.isDisplayed());
        System.out.println("Update reminder test passed.");
    }

    @Test
    public void testUpdateWithButton() {
        String title = "I am a reminder";
        String newReminderTitle = "I am not a reminder";

        mainPage = new MainPage(driver);
        mainPage.openReminder(title);

        reminderDetailsPage = new ReminderDetailsPage(driver);
        reminderDetailsPage.updateReminderWithEditButton(newReminderTitle);
        WebElement reminder = BasePage.getReminder(newReminderTitle);

        assertTrue(reminder.isDisplayed());
        System.out.println("Update reminder test passed.");
    }
}
