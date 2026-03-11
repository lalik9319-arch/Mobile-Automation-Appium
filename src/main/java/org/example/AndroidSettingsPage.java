package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidSettingsPage {

    @AndroidFindBy(accessibility = "System")
    private WebElement systemHeader;

    @AndroidFindBy(accessibility = "Keyboard")
    private WebElement keyboardHeader;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[.//android.widget.TextView[@text='Keyboard']]")
    private WebElement keyboardOptionBtn;

    private final AndroidDriver appiumDriver;

    public AndroidSettingsPage(AndroidDriver driver) {
        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void navigateToSystemSettings() {
        String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().text(\"" + DeviceCategory.CORE_SYSTEM.getLabel() + "\"));";

        WebElement systemElement = appiumDriver.findElement(AppiumBy.androidUIAutomator(scrollCommand));
        systemElement.click();
    }

    public boolean isSystemSectionDisplayed() {
        return systemHeader.isDisplayed();
    }

    public void selectKeyboardOption() {
        keyboardOptionBtn.click();
    }

    public boolean isKeyboardSettingsVisible() {
        return keyboardHeader.isDisplayed();
    }
}