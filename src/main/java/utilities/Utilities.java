package utilities;

import exception.SpreeTestException;
import singleton.FileDistributor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Utilities {
    public static int getRandomNumber(int range) {
        return new Random().nextInt(range);
    }

    public static String getProperty(String key) {
        try {
            return FileDistributor
                    .getFileInstance()
                    .getPropertyFile()
                    .getProperty(key.toLowerCase());
        } catch (IOException e) {
            throw new SpreeTestException(e.getLocalizedMessage());
        }
    }
}
