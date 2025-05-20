import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import java.net.MalformedURLException;

public class AddReminderTest {

    private AndroidDriver driver;
    private AddReminderPage addReminderPage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        try {
            driver = PhoneAndAppCapabilities.initializeDriver();
            driver.startActivity(new Activity("com.samsung.android.app.reminder", ".ui.LaunchMainActivity"));
        } catch (MalformedURLException e) {
            e.printStackTrace(System.err);
        }
    }

    @Test
    public void testAddReminder() {
        String title = "Drink water";
        Integer hours = 11;
        Integer minutes = 45;
        String ampm = "am";

        mainPage = new MainPage(driver);
        addReminderPage = new AddReminderPage(driver);

        mainPage.openAddReminderPage();
        addReminderPage.createReminder(title, hours, minutes, ampm);
        WebElement reminder = mainPage.getReminder(title);

        assertTrue(reminder.isDisplayed());
    }

    @Test
    public void testAddQuickReminder() {
        String title = "Hello World";
        mainPage = new MainPage(driver);
        mainPage.addQuickReminder(title);
        WebElement reminder = mainPage.getReminder(title);
        assertTrue(reminder.isDisplayed());
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

}
