package drivermanagement.factory;

import drivermanagement.manager.ChromeDriverManager;
import drivermanagement.manager.DriverManager;
import drivermanagement.manager.FirefoxDriverManager;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.openqa.selenium.remote.BrowserType.*;

public class DriverManagerFactoryImpl implements DriverManagerFactory{

    private static final Supplier<DriverManager> chromeDriverSupplier = ChromeDriverManager::new;
    private static final Supplier<DriverManager> firefoxDriverSupplier = FirefoxDriverManager::new;

    private static final Map<String, Supplier<DriverManager>> driverManagerSupplierMap = new HashMap<>();

    static {
        driverManagerSupplierMap.put(CHROME, chromeDriverSupplier);
        driverManagerSupplierMap.put(FIREFOX, firefoxDriverSupplier);
    }

    @Override
    public DriverManager getManager(String browser) {
        return driverManagerSupplierMap.getOrDefault(browser, chromeDriverSupplier).get();

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
