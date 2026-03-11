import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.AndroidSettingsPage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SystemSettingsTest {
    static UiAutomator2Options configOptions;
    AndroidDriver appiumDriver;

    @BeforeAll
    public static void defineCapability() {
        configOptions = new UiAutomator2Options();
        configOptions.setDeviceName("emulator-5554");
        configOptions.setAutomationName("UiAutomator2");
        configOptions.setPlatformName("Android");
        configOptions.setPlatformVersion("15");
        configOptions.setAppPackage("com.android.settings");
        configOptions.setAppActivity("com.android.settings.Settings");
        configOptions.setNoReset(false);
        configOptions.setNewCommandTimeout(Duration.ofSeconds(150));
    }

    @BeforeEach
    public void loadDriver() throws MalformedURLException {
        // וודאי שהכתובת תואמת לשרת שלך
        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), configOptions);
    }

    @AfterEach
    public void closeDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

    @Test
    public void testSystemNavigation() {
        AndroidSettingsPage settingsActions = new AndroidSettingsPage(appiumDriver);

        settingsActions.navigateToSystemSettings();

        org.junit.jupiter.api.Assertions.assertTrue(settingsActions.isSystemSectionDisplayed(), "System configuration page failed to load");

        settingsActions.selectKeyboardOption();

        org.junit.jupiter.api.Assertions.assertTrue(settingsActions.isKeyboardSettingsVisible(), "Keyboard settings screen was not displayed");
    }
}