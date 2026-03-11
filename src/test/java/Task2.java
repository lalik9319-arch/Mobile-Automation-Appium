import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.SettingPage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Task2 {
    static UiAutomator2Options options;
    AndroidDriver driver;

    @BeforeAll
    public static void defineCapability() {
        options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setAppPackage("com.android.settings");
        options.setAppActivity("com.android.settings.Settings");
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
    public void test(){
        SettingPage settingPage = new SettingPage(driver);
        settingPage.scrollToAndClickSystem();
        Assertions.assertTrue(settingPage.isSystem(),"The page was not loaded");
        settingPage.clickKeyboard();
        Assertions.assertTrue(settingPage.isKeyboard(),"The page was not loaded");
    }
}
