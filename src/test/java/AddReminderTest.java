import org.junit.Test;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

public class AddReminderTest extends BaseTest {

    private AddReminderPage addReminderPage;
    private MainPage mainPage;

    @Test
    public void testAddReminder() {
        String title = "Drink water";

        mainPage = new MainPage(driver);
        addReminderPage = new AddReminderPage(driver);

        mainPage.openAddReminderPage();
        addReminderPage.createReminder(title);
        WebElement reminder = BasePage.getReminder(title);

        assertTrue(reminder.isDisplayed());
    }

    @Test
    public void testAddQuickReminder() {
        String title = "Hello World";
        mainPage = new MainPage(driver);
        mainPage.addQuickReminder(title);
        WebElement reminder = BasePage.getReminder(title);
        assertTrue(reminder.isDisplayed());
    }
}