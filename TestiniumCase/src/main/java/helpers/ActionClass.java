package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
    public static void moveTo(WebDriver driver, WebElement element){
        new Actions(driver).moveToElement(element).perform();
    }
}
