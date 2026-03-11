import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.ClockTimerPage;
import org.junit.jupiter.api.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;


public class ClockTaskTest {
    static UiAutomator2Options appOptions;
    AndroidDriver appiumDriver;

    @BeforeAll
    public static void defineCapability() {
        appOptions = new UiAutomator2Options();
        appOptions.setDeviceName("emulator-5554");
        appOptions.setAutomationName("UiAutomator2");
        appOptions.setPlatformName("Android");
        appOptions.setPlatformVersion("15");
        appOptions.setAppPackage("com.google.android.deskclock");
        appOptions.setAppActivity("com.android.deskclock.DeskClock");
        appOptions.setNoReset(false);
        appOptions.setNewCommandTimeout(Duration.ofSeconds(150));
    }

    @BeforeEach
    public void loadDriver() throws MalformedURLException {
        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), appOptions);
    }

    @AfterEach
    public void closeDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {
        ClockTimerPage timerPage = new ClockTimerPage(appiumDriver);

        timerPage.openTimerSection();

        Assertions.assertTrue(timerPage.isSetupScreenVisible(), "Timer page did not load!");

        timerPage.inputTimerDuration();

        Assertions.assertEquals("00h 00m 31s", timerPage.getEnteredTimeValue());

        timerPage.beginCountdown();

        Thread.sleep(30000);

        Assertions.assertTrue(timerPage.getRemainingTimeText().contains("1"));
    }
}