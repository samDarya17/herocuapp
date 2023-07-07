package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ContextMenuPage;
import pages.FileDownloaderPage;
import pages.FileUploaderPage;
import pages.FramesPage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    String BASE_URL = "https://the-internet.herokuapp.com/";
    String pathToDownload = System.getProperty("user.dir") + "\\src\\test\\downloads";
    String nameDownloaderFile;

    int wait = 15000;
    boolean fileIsNotReady = true;

    ContextMenuPage contextMenuPage;

    FileUploaderPage fileUploaderPage;

    FramesPage framesPage;

    FileDownloaderPage fileDownloaderPage;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        HashMap<String, Object> chromePrefs=new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory",pathToDownload);
        options.setExperimentalOption("prefs",chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        contextMenuPage = new ContextMenuPage(driver);
        fileUploaderPage = new FileUploaderPage(driver);
        framesPage = new FramesPage(driver);
        fileDownloaderPage=new FileDownloaderPage(driver);

    }

    public void downloader(String fileLocator, String nameDownloaderFile) throws IOException, InterruptedException {

        WebElement ourFile= driver.findElement(By.xpath(fileLocator));
        FileUtils.cleanDirectory(new File(pathToDownload));
        File folder=new File(pathToDownload);
        File[] listOfFiles=folder.listFiles();

        ourFile.click();

        while (wait !=0 && fileIsNotReady){
            listOfFiles=folder.listFiles();
            Thread.sleep(100);
            wait-=100;
            if (listOfFiles.length !=0 && listOfFiles[0].getName().equals(nameDownloaderFile)){
                fileIsNotReady=false;
            }
        }
        Assert.assertEquals(listOfFiles[0].getName(),nameDownloaderFile);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
