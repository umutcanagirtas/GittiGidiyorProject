package pages;

import helpers.CustomElementWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasketPage {
    private final WebDriver driver;
    Select select;
    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='total-price']")
    private WebElement itemPrice;
    @FindBy(xpath = "//select[@class='amount']")
    private WebElement itemCount;
    @FindBy(xpath = "//div[@class='text-box']//a[@title='Sil']")
    private WebElement deleteItem;

    public WebElement getItemPrice() {
        CustomElementWaits.waitUntilElementFind(driver,itemPrice);
        return itemPrice;
    }

    public void setItemPrice(WebElement itemPrice) {
        this.itemPrice = itemPrice;
    }

    public WebElement getItemCount() {
        CustomElementWaits.waitUntilElementToClickable(driver,itemCount);
        return itemCount;
    }

    public void setItemCount(WebElement itemCount) {
        this.itemCount = itemCount;
    }

    public WebElement getDeleteItem() {
        CustomElementWaits.waitUntilElementToClickable(driver,deleteItem);
        return deleteItem;
    }

    public void setDeleteItem(WebElement deleteItem) {
        this.deleteItem = deleteItem;
    }
    public void addItem(){
        select = new Select(getItemCount());
        CustomElementWaits.waitUntilElementToClickable(driver,select.getOptions().get(0));
        select.selectByIndex(1);
    }
    public String getSelectOption(){
        WebElement option=select.getFirstSelectedOption();
        return option.getText();
    }
    public void delete(){
        getDeleteItem().click();
    }
}
