package singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;

public class SeleniumGrid {
    public static SeleniumGrid seleniumGrid;

    public static SeleniumGrid getSeleniumGrid(){
        if (seleniumGrid == null){
            seleniumGrid = new SeleniumGrid();
            return seleniumGrid;
        }
        return seleniumGrid;
    }

    public void startStopGrid(String op, String message) throws IOException, InterruptedException {
        if(op.equals("start"))
            Runtime.getRuntime().exec(System.getProperty("user.dir")+"/startDocker.sh");
        else
            Runtime.getRuntime().exec(System.getProperty("user.dir")+"/stopDocker.sh");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 30);
        boolean hubStarted = false;
        Thread.sleep(3000);

        while (System.currentTimeMillis() < calendar.getTimeInMillis()){
            if(hubStarted){
                break;
            }

            BufferedReader br = FileDistributor.getFileInstance().getOutputFileForRead();
            String line;
            while((line = br.readLine())!=null){
                if(line.contains(message)){
                    System.out.println("Selenium Hub started/stopped successfully");
                    hubStarted = true;
                    br.close();
                    break;
                }
            }
        }
    }
}
