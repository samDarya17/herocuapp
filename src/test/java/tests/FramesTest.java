package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void checkTextWithinParagraph() {
        framesPage.openIframes();
        String textBYInframe = framesPage.getTextByIframerame();
        Assert.assertEquals(textBYInframe, "Your content goes here.", "Текст сообщения не совпадает");


    }
}