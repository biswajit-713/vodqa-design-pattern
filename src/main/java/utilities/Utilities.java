package utilities;

import java.util.Random;

public class Utilities {
    public static int getRandomNumber(int range) {
        return new Random().nextInt(range);
    }
}
