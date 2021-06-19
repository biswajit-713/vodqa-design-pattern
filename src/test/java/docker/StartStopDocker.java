package docker;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import page.BootStrap;
import singleton.SeleniumGrid;
import singleton.FileDistributor;

import java.io.IOException;

public class StartStopDocker {
    @BeforeSuite
    public void startDocker() throws IOException, InterruptedException {
        SeleniumGrid.getSeleniumGrid().startStopGrid("start", "Started Selenium Hub");
    }

    @AfterSuite
    public void stopDocker() throws IOException, InterruptedException {
        SeleniumGrid.getSeleniumGrid().startStopGrid("stop", "Removing selenium-hub");
        FileDistributor.getFileInstance().getFile(System.getProperty("user.dir")+"/output.txt").delete();
    }
}
