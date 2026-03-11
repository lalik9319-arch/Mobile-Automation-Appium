package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ClockTimerPage {
    private final AndroidDriver driver;

    @AndroidFindBy(accessibility = "Timer")
    private WebElement timerTabIcon;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_digit_3")
    private WebElement digitThreeKey;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_digit_1")
    private WebElement digitOneKey;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_time")
    private WebElement timerInputDisplay;

    @AndroidFindBy(accessibility = "Start")
    private WebElement startTimerBtn;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_text")
    private WebElement countdownDisplay;

    public ClockTimerPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void openTimerSection() {
        timerTabIcon.click();
    }

    public boolean isSetupScreenVisible() {
        return digitOneKey.isDisplayed();
    }


    public void inputTimerDuration() {
        digitThreeKey.click();
        digitOneKey.click();
    }

    public String getEnteredTimeValue() {
        return timerInputDisplay.getText();
    }

    public void beginCountdown() {
        startTimerBtn.click();
    }

    public String getRemainingTimeText() {
        return countdownDisplay.getText();
    }
}