package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class ContextMenuTest extends BaseTest {

    @Test
    public void validatingTextOnTheAlert() {
        contextMenuPage.openContextMenu();
        contextMenuPage.rightСlickOnHotSpot();
        String alertText = contextMenuPage.getText();
        Assert.assertEquals(alertText, "You selected a context menu", "Текст алерта не совпадает");
        contextMenuPage.alertClose();

    }
}