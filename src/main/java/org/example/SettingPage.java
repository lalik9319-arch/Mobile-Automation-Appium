package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class SettingPage {
    @AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"System\"]")
    private WebElement titleSystem;
    @AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Keyboard\"]")
    private WebElement titleKeyboard;
    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.android.settings:id/recycler_view\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")
    private WebElement buttonKeyboard;

    private AndroidDriver driver;
    public SettingPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }


    public void scrollToAndClickSystem() {
        String uiSelector = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().text(\""+Setting.SYSTEM.getDisplayName()+"\"));";
        WebElement systemItem = driver.findElement(AppiumBy.androidUIAutomator(uiSelector));
        systemItem.click();
    }

    public boolean isSystem() {
        return titleSystem.isDisplayed();
    }
    public void clickKeyboard(){
        buttonKeyboard.click();
    }
    public boolean isKeyboard() {
        return titleKeyboard.isDisplayed();
    }





}
