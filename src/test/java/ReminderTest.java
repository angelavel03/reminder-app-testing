import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

public class ReminderTest {

    private ReminderApp reminderApp;

    @Before
    public void setUp() {
        reminderApp = new ReminderApp();
    }

    @Ignore
    @Test
    public void addReminderTest() {
        String title = "Hello World!";
        reminderApp.addReminder(title);
        WebElement reminder = reminderApp.getReminder(title);
        assertTrue(reminder.isDisplayed());
        System.out.println("The test for AddReminder successfully passed");
    }

    @Test
    public void deleteReminderTest() {
        String title = "Drink Coffee!";
        reminderApp.addReminder(title);
        boolean isDeleted = reminderApp.deleteReminder(title);
        assertTrue(isDeleted);
        System.out.println("The test for Delete successfully passed");
    }

    @Ignore
    @Test
    public void markAsCompletedReminderTest() {

    }

    @Ignore
    @Test
    public void updateReminderTest() {

    }

    @After
    public void tearDown() {
        reminderApp.quitDriver();
    }
}
