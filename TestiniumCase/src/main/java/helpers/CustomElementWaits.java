package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomElementWaits {
    public static void waitUntilElementFind(WebDriver driver, WebElement element) {
        (new WebDriverWait(driver, TimeOut.MIDDLE.value))
                .until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitUntilElementToClickable(WebDriver driver, WebElement element) {
        (new WebDriverWait(driver, TimeOut.MIDDLE.value))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void visibilityOfAllElements(WebDriver driver, List<WebElement> elements){
        (new WebDriverWait(driver, TimeOut.MIDDLE.value)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

//    public static void deneme(WebDriver driver){
//        Wait<WebDriver> wait = new OpenQA.Selenium.Support.UI.WebDriverWait(driver, TimeSpan.FromSeconds(30.00));
//
//        wait.Until(driver1 => ((IJavaScriptExecutor)driver).ExecuteScript("return document.readyState").Equals("complete"));
//    }

    public enum TimeOut {
        LOW(5),
        MIDDLE(10),
        HIGH(15),
        CUSTOM_MAX(60);
        private final int value;
        TimeOut(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
}