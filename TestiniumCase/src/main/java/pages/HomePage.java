package pages;

import helpers.ActionClass;
import helpers.CustomElementWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(xpath = "//div[@data-cy='header-user-menu']//div[@title]")
    private WebElement user;
    @FindBy(xpath = "//input[@name='k']")
    private WebElement searchArea;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    public WebElement getUser() {
        CustomElementWaits.waitUntilElementFind(driver,user);
        return user;
    }

    public void setUser(WebElement user) {
        this.user = user;
    }

    public WebElement getSearchArea() {
        CustomElementWaits.waitUntilElementToClickable(driver,searchArea);
        return searchArea;
    }

    public void setSearchArea(WebElement searchArea) {
        this.searchArea = searchArea;
    }

    public WebElement getSubmit() {
        CustomElementWaits.waitUntilElementToClickable(driver,submit);
        return submit;
    }

    public void setSubmit(WebElement submit) {
        this.submit = submit;
    }

    public void searchItem(String item){
        getSearchArea().sendKeys(item);
        getSubmit().click();
    }
    public void clickLoginArea() throws InterruptedException {
        ActionClass.moveTo(driver,getUser());
        Thread.sleep(1000);
        CustomElementWaits.waitUntilElementToClickable(driver,driver.findElement(By.xpath("//a[@href='https://www.gittigidiyor.com/uye-girisi?s=1']/span")));
        driver.findElement(By.xpath("//a[@href='https://www.gittigidiyor.com/uye-girisi?s=1']/span")).click();
    }
}
