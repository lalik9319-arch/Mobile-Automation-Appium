package org.example;

public enum DeviceCategory {
    NET_CONNECTIVITY("Network & internet"),
    LINKED_HARDWARE("Connected devices"),
    APP_MANAGEMENT("Apps"),
    PUSH_ALERTS("Notifications"),
    POWER_STATUS("Battery"),
    DISK_USAGE("Storage"),
    AUDIO_CONTROL("Sound & vibration"),
    SCREEN_SETTINGS("Display & touch"),
    THEME_STYLE("Wallpaper & style"),
    EASE_OF_USE("Accessibility"),
    PRIVACY_LOCK("Security & privacy"),
    GPS_DATA("Location"),
    SOS_ALERTS("Safety & emergency"),
    ACCOUNT_CREDENTIALS("Passwords, passkeys & accounts"),
    USAGE_LIMITS("Digital Wellbeing & parental controls"),
    GOOGLE_PREFS("Google"),
    CORE_SYSTEM("System"),
    EMULATOR_INFO("About emulated device"),
    SUPPORT_DESK("Tips & support");

    private final String label;
    DeviceCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}