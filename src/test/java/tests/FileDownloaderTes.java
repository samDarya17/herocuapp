package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileDownloaderTest extends BaseTest{

    String myLocator ="//a[text()='sample.png']";

    @Test
    public void fileDownloader() throws IOException, InterruptedException {
        fileDownloaderPage.openFileDownloader();
        downloader(myLocator,"sample.png" );
    }
}