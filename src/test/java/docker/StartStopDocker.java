package docker;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import singleton.DockerSingleton;
import singleton.FileDistributor;

import java.io.File;
import java.io.IOException;

public class StartStopDocker {
    @BeforeSuite
    public void startDocker() throws IOException, InterruptedException {
        DockerSingleton.getSeleniumGrid().startStopDocker("start", "Started Selenium Hub");
    }

    @AfterSuite
    public void stopDocker() throws IOException, InterruptedException {
        DockerSingleton.getSeleniumGrid().startStopDocker("stop", "Removing selenium-hub");
        FileDistributor.getFileInstance().getFile(System.getProperty("user.dir")+"/output.txt").delete();
    }
}
