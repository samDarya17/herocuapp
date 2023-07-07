package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    String URL = "https://the-internet.herokuapp.com/";

    public BasePage(WebDriver driver) {

        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
    }
}