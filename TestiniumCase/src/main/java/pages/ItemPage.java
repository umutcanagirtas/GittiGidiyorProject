package pages;

import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    private final WebDriver driver;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='sp-price-lowPrice']")
    private WebElement itemPriceLow;
    @FindBy(xpath = "//span[@id='sp-price-highPrice']")
    private WebElement itemPriceHigh;
    @FindBy(xpath = "//button[@id='add-to-basket']")
    private WebElement addBasket;

    public WebElement getItemPriceHigh() {
        CustomElementWaits.waitUntilElementFind(driver, itemPriceHigh);
        return itemPriceHigh;
    }

    public void setItemPriceHigh(WebElement itemPriceHigh) {
        this.itemPriceHigh = itemPriceHigh;
    }

    public WebElement getItemPriceLow() {
        return itemPriceLow;
    }

    public void setItemPriceLow(WebElement itemPriceLow) {
        this.itemPriceLow = itemPriceLow;
    }

    public WebElement getAddBasket() {
        CustomElementWaits.waitUntilElementFind(driver, addBasket);
        return addBasket;
    }

    public void setAddBasket(WebElement addBasket) {
        this.addBasket = addBasket;
    }

    public String getPrice() {
        if (getItemPriceLow().getText() == "") {

            return getItemPriceHigh().getText();
        }
        else {
            return getItemPriceLow().getText();
        }


    }
}
