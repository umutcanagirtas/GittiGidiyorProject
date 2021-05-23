package pages;

import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='best-match-right']//div[@class='cell-border-css']")
    private List<WebElement> items;
    @FindBy(xpath = "//div[@id='best-match-right']/div[5]/ul/li")
    private List<WebElement> switcher;

    public List<WebElement> getItems() {
        CustomElementWaits.visibilityOfAllElements(driver,items);
        return items;
    }

    public void setItems(List<WebElement> items) {
        this.items = items;
    }

    public List<WebElement> getSwitcher() {
        CustomElementWaits.visibilityOfAllElements(driver,switcher);
        return switcher;
    }

    public void setSwitcher(List<WebElement> switcher) {
        this.switcher = switcher;
    }
}
