import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Before;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @Before
    public void setUp() {
        try {
            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName("Android");
            options.setPlatformVersion("14");
            options.setDeviceName("Galaxy A52");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.samsung.android.app.reminder");
            options.setAppActivity(".ui.LaunchMainActivity");
            options.setNoReset(true);
            options.setNewCommandTimeout(Duration.ofSeconds(300));

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.startActivity(new Activity("com.samsung.android.app.reminder", ".ui.LaunchMainActivity"));
        } catch (MalformedURLException e) {
            e.printStackTrace(System.err);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}