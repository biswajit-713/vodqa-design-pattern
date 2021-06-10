package drivermanagement.factory;

import drivermanagement.manager.ChromeDriverManager;
import drivermanagement.manager.DriverManager;
import drivermanagement.manager.FirefoxDriverManager;
import utilities.Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class DriverManagerFactoryImpl implements DriverManagerFactory{

    private static final Supplier<DriverManager> chromeDriverManager = ChromeDriverManager::new;
    private static final Supplier<DriverManager> firefoxDriverManager = FirefoxDriverManager::new;

    private static final Map<String, Supplier<DriverManager>> driverManagerMap = new HashMap<>();

    static {
        driverManagerMap.put(CHROME, chromeDriverManager);
        driverManagerMap.put(FIREFOX, firefoxDriverManager);
    }

    @Override
    public DriverManager getManager() {
        String browser = Utilities.getProperty("browser");

        return driverManagerMap.getOrDefault(browser, chromeDriverManager).get();

//        DriverManager driverManager;
//        switch (browser) {
//            case CHROME:
//                driverManager = new ChromeDriverManager();
//                break;
//            case FIREFOX:
//                driverManager = new FirefoxDriverManager();
//                break;
//            default:
//                driverManager = new ChromeDriverManager();
//                break;
//        }
//        return driverManager;
    }
}
