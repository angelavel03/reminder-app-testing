import org.junit.Test;
import static org.junit.Assert.*;

public class DeleteReminderTest extends BaseTest {

    private MainPage mainPage;
    private ReminderDetailsPage reminderDetailsPage;

    @Test
    public void testDeleteReminder() {
        String title = "I am a reminder";

        mainPage = new MainPage(driver);
        mainPage.addQuickReminder(title);
        mainPage.openReminder(title);

        reminderDetailsPage = new ReminderDetailsPage(driver);
        reminderDetailsPage.deleteReminder();

        assertTrue(BasePage.getReminder(title).isDisplayed());
        System.out.println("Reminder deleted");
    }

    @Test
    public void testQuickDeleteReminder() {
        String title = "I am a reminder";

        mainPage = new MainPage(driver);
        mainPage.addQuickReminder(title);
        mainPage.quickDeleteReminder(title);

        assertTrue(BasePage.getReminder(title).isDisplayed());
        System.out.println("Reminder deleted");
    }
}