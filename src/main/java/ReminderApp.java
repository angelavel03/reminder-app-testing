import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class ReminderApp {

    private AndroidDriver driver;

    public ReminderApp() {
        try{
            driver = PhoneAndAppCapabilities.initializeDriver();
            driver.startActivity(new Activity("com.samsung.android.app.reminder", ".ui.LaunchMainActivity"));
        }catch (MalformedURLException me){
            me.printStackTrace(System.err);
        }
    }

    public void addReminder(String reminderText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.samsung.android.app.reminder:id/floating_action_button")));
        addButton.click();

        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.samsung.android.app.reminder:id/add_viewholder_text_view")));
        titleInput.sendKeys(reminderText);

        try {
            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("com.samsung.android.app.reminder:id/action_save_reminder")));
            saveButton.click();
        } catch (Exception e) {
            System.out.println("Standard Save button failed. Trying fallback...");
            WebElement saveFallback = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.Button[@content-desc='Save']")));
            String elementId = ((RemoteWebElement) saveFallback).getId();
            driver.executeScript("mobile: clickGesture", ImmutableMap.of("elementId", elementId));
        }
    }

    public WebElement getReminder(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String xpath = "//android.widget.TextView[@content-desc='"+title+"']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public boolean deleteReminder(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        String xpath = "//android.widget.TextView[@content-desc='"+title+"']";
        WebElement reminder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        reminder.click();

        WebElement deleteButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.samsung.android.app.reminder:id/detail_bottom_delete_btn")));
        deleteButton.click();

        WebElement moveToTrash = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
        moveToTrash.click();

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public void updateReminder(String title) {
        System.out.println("Starting clickExistingReminderTest...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement reminder = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.samsung.android.app.reminder:id/selected_ripple_layout")));
        reminder.click();

        WebElement editButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.samsung.android.app.reminder:id/detail_bottom_edit_btn")));
        editButton.click();

        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.samsung.android.app.reminder:id/add_viewholder_text_view")));

        titleInput.clear();

        titleInput.sendKeys("Drink Water");

        WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.samsung.android.app.reminder:id/action_save_reminder")));
        saveButton.click();
    }

    public void markAsCompletedReminder() {
        System.out.println("Starting markAsCompletedReminderTest...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement checkAsCompleted = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.samsung.android.app.reminder:id/reminder_color_complete_view")));
        checkAsCompleted.click();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
