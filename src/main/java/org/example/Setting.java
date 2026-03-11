package org.example;

public enum Setting {
    NETWORK_AND_INTERNET("Network & internet"),
    CONNECTED_DEVICES("Connected devices"),
    APPS("Apps"),
    NOTIFICATIONS("Notifications"),
    BATTERY("Battery"),
    STORAGE("Storage"),
    SOUND_AND_VIBRATION("Sound & vibration"),
    DISPLAY_AND_TOUCH("Display & touch"),
    WALLPAPER_AND_STYLE("Wallpaper & style"),
    ACCESSIBILITY("Accessibility"),
    SECURITY_AND_PRIVACY("Security & privacy"),
    LOCATION("Location"),
    SAFETY_AND_EMERGENCY("Safety & emergency"),
    PASSWORDS_PASSKEYS_ACCOUNTS("Passwords, passkeys & accounts"),
    DIGITAL_WELLBEING_PARENTAL_CONTROLS("Digital Wellbeing & parental controls"),
    GOOGLE("Google"),
    SYSTEM("System"),
    ABOUT_EMULATED_DEVICE("About emulated device"),
    TIPS_AND_SUPPORT("Tips & support");

    private final String displayName;

    Setting(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}