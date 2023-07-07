package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploaderTest extends BaseTest {

    @Test
    public void fileUpload() {
        fileUploaderPage.openFileUploader();
        fileUploaderPage.downloadFile();
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),
                "1.jpg", "Файлы не совпадают");
    }
}