package docker;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import singleton.DockerSingleton;

import java.io.File;
import java.io.IOException;

public class StartStopDocker {
    @BeforeSuite
    public void startDocker() throws IOException, InterruptedException {
        DockerSingleton.getSeleniumGrid().startStopDocker("start", "Started Selenium Hub");
    }

    @AfterSuite
    public void stopDocker() throws IOException, InterruptedException {
        File file = new File("output.txt");
        DockerSingleton.getSeleniumGrid().startStopDocker("stop", "Removing selenium-hub");
        file.delete();
    }
}
