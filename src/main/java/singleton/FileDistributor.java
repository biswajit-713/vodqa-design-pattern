package singleton;

import java.io.*;
import java.util.Properties;

public class FileDistributor {
    private static FileDistributor fileInstance;
    private Properties properties;

    private FileDistributor () throws FileNotFoundException {
        properties = new Properties();
    }

    public static FileDistributor getFileInstance() throws FileNotFoundException {
        if (fileInstance == null){
            fileInstance = new FileDistributor();
            return fileInstance;
        }
        return fileInstance;
    }

    public BufferedReader getFileForRead(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }

    public File getFile(String filePath){
        return new File(filePath);
    }

    public Properties getPropertyFile() throws IOException {
        properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/application_test.properties"));
        return properties;
    }
}
