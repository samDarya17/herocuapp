package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage{

    public static final By HOT_SPOT = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void openContextMenu(){
        driver.get(BASE_URL+ "context_menu");
    }

    public void rightСlickOnHotSpot(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(HOT_SPOT)).build().perform();
    }

    public String getText(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    public void alertClose(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}