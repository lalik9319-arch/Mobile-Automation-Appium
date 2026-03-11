package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class TimerPage {
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Timer\"]")
    private WebElement timerButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.google.android.deskclock:id/timer_setup_digit_3\"]")
    private WebElement button3;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.google.android.deskclock:id/timer_setup_digit_1\"]")
    private WebElement button1;
    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_time")
    private WebElement text;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Start\"]")
    private WebElement start;
    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_text")
    private WebElement timeRemained;


    public TimerPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickTimerButton() {
        timerButton.click();
    }
    public boolean checkTimerExist(){
        return button1.isDisplayed();
    }
    public void setTimer() {
        button3.click();
        button1.click();
    }
    public String getTimerText() {
        return text.getText();
    }
    public void clickStart() {
        start.click();
    }
    public String getTimeRemained() {
        return timeRemained.getText();
    }
}
