package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileDownloaderPage extends BasePage {

    public static final By FILE_LOCATOR = By.xpath("//div[@class=\"example\"]/a[@href=\"download/sample.pdf\"]");

    public FileDownloaderPage(WebDriver driver) {
        super(driver);
    }

    public void openFileDownloader(){
        driver.get("http://the-internet.herokuapp.com/download");
    }
}