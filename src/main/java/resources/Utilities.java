package resources;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Utilities extends Base{
    private static By successAlert = By.cssSelector(".alert-success");
    private static By dangerAlert = By.cssSelector(".alert-danger");
    private static By modalClose = By.xpath("//button[@class='close']/span");

    public static WebElement getSuccessAlert(){
        return driver.findElement(successAlert);
    }

    public static WebElement getErrorAlert(){
        return driver.findElement(dangerAlert);
    }

    public static int randomNumber(int upperbound){
        return (new Random().nextInt(upperbound));
    }

    public static void closeModal(WebDriver driver){
        driver.findElement(modalClose).click();
    }

    public static void explicitlyWaitForClickable(WebElement webElement){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static Object[][] getDataFromExcel(String filePath) throws IOException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        int rowCount=sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colCount=row.getLastCellNum();
        Object data[][]=new Object[rowCount-1][colCount];
        for(int i=0;i<rowCount-1;i++) {
            row=sheet.getRow(i+1);
            for(int j=0;j<colCount;j++) {
                XSSFCell cell=row.getCell(j);
                data[i][j]=formatter.formatCellValue(cell);
            }
        }
        return data;
    }
}
