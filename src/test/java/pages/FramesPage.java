package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    public static final By IFRAME = By.id("mce_0_ifr");
    public static final By IFRAME_TEXT = By.xpath("//body[@id='tinymce']/p");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void openIframes() {
        driver.get(URL + "iframe");
    }

    public String getTextByIframerame() {
        WebDriver frame = driver.switchTo().frame(driver.findElement(IFRAME));
        return frame.findElement(IFRAME_TEXT).getText();


    }
}