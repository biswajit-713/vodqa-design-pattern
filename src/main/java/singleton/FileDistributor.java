package singleton;

import java.io.*;
import java.util.Properties;

public class FileDistributor {
    private static FileDistributor fileInstance;
    private BufferedReader outputFileBR;
    private Properties properties;

    private FileDistributor () throws IOException {
        outputFileBR = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/output.txt"));
        properties = new Properties();
    }

    public static FileDistributor getFileInstance() throws IOException {
        if (fileInstance == null){
            fileInstance = new FileDistributor();
            return fileInstance;
        }
        return fileInstance;
    }

    public BufferedReader getOutputFileForRead(){
        return outputFileBR;
    }

    public File getFile(String filePath){
        return new File(filePath);
    }

    public Properties getPropertyFile() throws IOException {
        properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/application_test.properties"));
        return properties;
    }
}
