package drivermanagement.manager;

import org.openqa.selenium.WebDriver;

public interface DriverManager {
    void startService();
    void stopService();
    WebDriver getDriver();
    void quit();
}
