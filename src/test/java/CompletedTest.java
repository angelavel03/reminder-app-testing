import org.junit.Test;

import static org.junit.Assert.*;

public class CompletedTest extends BaseTest {

    private MainPage mainPage;
    private ReminderDetailsPage reminderDetailsPage;

    @Test
    public void checkCompletedReminderTest() {
        String reminderTitle = "Hello World";
        mainPage = new MainPage(driver);
        mainPage.markAsCompleted(reminderTitle);
        assertTrue(BasePage.getReminder(reminderTitle).isDisplayed());
        System.out.println("Test passed successfully!");
    }


    @Test
    public void completedReminderWithCompleteButtonTest() {
        String reminderTitle = "I am not a reminder";

        mainPage = new MainPage(driver);
        mainPage.openReminder(reminderTitle);

        reminderDetailsPage = new ReminderDetailsPage(driver);
        reminderDetailsPage.clickCompleteButton();

        mainPage.appMenu.openMenu();
        mainPage.appMenu.openCompleted();
        assertTrue(BasePage.getReminder(reminderTitle).isDisplayed());

        System.out.println("Completed reminder with complete button test passed successfully!");
    }

    @Test
    public void completedReminderWithLongPressTest() {
        String reminderTitle = "Drink Water";

        mainPage = new MainPage(driver);
        mainPage.markAsCompletedLongPress(reminderTitle);

        assertTrue(BasePage.getReminder(reminderTitle).isDisplayed());
        System.out.println("Test passed successfully!");
    }
}