package docker;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import resources.DockerOperation;

import java.io.File;
import java.io.IOException;

public class StartStopDocker {
    @BeforeSuite
    public void startDocker() throws IOException, InterruptedException {
        DockerOperation.docker("start", "Started Selenium Hub");
    }

    @AfterSuite
    public void stopDocker() throws IOException, InterruptedException {
        File file = new File("output.txt");
        DockerOperation.docker("stop", "Removing selenium-hub");
        file.delete();
    }
}
