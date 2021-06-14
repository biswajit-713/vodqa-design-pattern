package drivermanagement.factory;

import drivermanagement.manager.DriverManager;

public interface DriverManagerFactory {

    DriverManager getManager(String browser);

}
