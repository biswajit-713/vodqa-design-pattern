package utilities;

import exception.SpreeTestException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Utilities {
    public static int getRandomNumber(int range) {
        return new Random().nextInt(range);
    }

    public static String getProperty(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/application_test.properties"));
            return properties.getProperty(key.toLowerCase());
        } catch (IOException e) {
            throw new SpreeTestException(e.getLocalizedMessage());
        }

    }
}
