package tests;

import base.BaseClass;
import helpers.ActionClass;
import helpers.CustomElementWaits;
import helpers.DataHelpers;
import helpers.Listeners;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;


@org.testng.annotations.Listeners(Listeners.class)
public class TestClass extends BaseClass {
    HomePage homePage;
    LoginPage loginPage;
    SearchPage searchPage;
    ItemPage itemPage;
    BasketPage basketPage;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
        super.beforeMethod(browser);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        itemPage = new ItemPage(driver);
        basketPage = new BasketPage(driver);
    }

    @AfterClass
    public void terminateWebDriver() {
        super.afterMethod();
    }

    @Test
    public void getHomePage() {
        String user = homePage.getUser().getText();
        Assert.assertEquals(user, "Giriş Yap\n" + "veya Üye Ol", "Page Not Found.");
    }

    @Parameters({"name", "password"})
    @Test(priority = 1)
    public void getLoginPage(String name, String password) throws InterruptedException {
        homePage.clickLoginArea();
        loginPage.userNameField(name);
        loginPage.userPasswordField(password);
        loginPage.login();
        String user = homePage.getUser().getText();
        Assert.assertEquals(user, "Hesabım\n" + "umutagrts", "Login Failed.");
    }

    @Parameters({"item", "count"})
    @Test(priority = 2)
    public void searchItem(String item, int count) {
        homePage.searchItem(item);
        ActionClass.moveTo(driver, driver.findElement(By.xpath("//div[@id='best-match-right']//div[@class='related-searches-wrapper']")));
        searchPage.getSwitcher().get(count - 1).click();
        String exceptedUrl = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
        Assert.assertEquals(exceptedUrl, driver.getCurrentUrl(), "Page 2 is Not Found.");
    }

    @Test(priority = 3)
    public void choseItemAndAddBasket() {
        DataHelpers.getRandomRowOfList(searchPage.getItems()).click();
        String itemPrice= itemPage.getPrice();
        ActionClass.moveTo(driver, driver.findElement(By.xpath("//div[@id='srs-band']")));
        itemPage.getAddBasket().click();
        CustomElementWaits.waitUntilElementToClickable(driver, driver.findElement(By.xpath("//div[@id='header_wrapper']//div[2]//a[@href='https://www.gittigidiyor.com/sepetim']")));
        ActionClass.moveTo(driver, driver.findElement(By.xpath("//div[@id='header_wrapper']//div[2]//a[@href='https://www.gittigidiyor.com/sepetim']")));
        driver.findElement(By.xpath("//div[@id='header_wrapper']//div[2]//a[@href='https://www.gittigidiyor.com/sepetim']")).click();
        Assert.assertEquals(itemPrice, basketPage.getItemPrice().getText(), "Item Price is Different.");
    }

    @Test(priority = 4)
    public void addItemCount() {
        basketPage.addItem();
        Assert.assertEquals("2", basketPage.getSelectOption(),"Item Count Not 2.");
    }

    @Test(priority = 5)
    public void deleteItemFromBasket() {
        basketPage.delete();
        String expectedTitle="Sepetinizde ürün bulunmamaktadır.";
        CustomElementWaits.waitUntilElementFind(driver,driver.findElement(By.xpath("//div[@id='empty-cart-container']//h2")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='empty-cart-container']//h2")).getText(),expectedTitle,"Basket is Not Empty");
    }
}
