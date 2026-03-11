import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.TimerPage;
import org.junit.jupiter.api.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Task1 {
    static UiAutomator2Options options;
    AndroidDriver driver;

    @BeforeAll
    public static void defineCapability() {
        options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setAppPackage("com.google.android.deskclock");
        options.setAppActivity("com.android.deskclock.DeskClock");
        options.setNoReset(false);
        options.setNewCommandTimeout(Duration.ofSeconds(150));
    }

    @BeforeEach
    public void loadDriver() throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

    }

    @AfterEach
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {
        TimerPage timerPage = new TimerPage(driver);
        timerPage.clickTimerButton();
        Assertions.assertTrue(timerPage.checkTimerExist(), "Timer page did not load!");
        timerPage.setTimer();
        Assertions.assertEquals("00h 00m 31s", timerPage.getTimerText());
        timerPage.clickStart();
        Thread.sleep(30000);
        Assertions.assertEquals("1", timerPage.getTimeRemained());
    }
}
