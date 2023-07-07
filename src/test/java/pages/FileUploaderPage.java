package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileUploaderPage extends BasePage {

    public static final By SELECT_FILE= By.id("file-upload");
    public static final By UPLOAD_FILE= By.id("file-submit");

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    public void openFileUploader() {
        driver.get(URL + "upload");
    }

    public void downloadFile() {
        File file = new File("src/test/resources/1.jpg");
        driver.findElement(SELECT_FILE).sendKeys(file.getAbsolutePath());
        driver.findElement(UPLOAD_FILE).click();
    }

    public  void equalsNames(){
        driver.findElement(By.id("uploaded-files")).getText();
    }
}