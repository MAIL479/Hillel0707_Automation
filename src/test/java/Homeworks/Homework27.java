package Homeworks;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Homework27 {

    private WebDriver driver;
    final String EXPECTED_NUMBER = " 1 ";

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        /*wait = new WebDriverWait(driver, Duration.ofSeconds(10));*/
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTestHomeWork() throws InterruptedException {

        List<WebElement> saleProducts = driver.findElements(By.xpath("(//ul[contains(@class, 'main-goods')])[1]/li"));
        int countOfGoods = saleProducts.size();
        Assert.assertEquals(countOfGoods, 6, "The number of goods is not equal to 6");

        WebElement valuePrice = driver.findElement(By.xpath("(//ul[contains(@class, 'main-goods')])[1]/li[1]//div[contains(@class, 'price_color_red')]"));
        String itemPriceValue = valuePrice.getAttribute("innerText").replaceAll(" ", "");

        WebElement firstProduct = driver.findElement(By.xpath("(//ul[contains(@class, 'main-goods')])[1]/li[1]"));
        firstProduct.click();

        WebElement priceOfProductPage = driver.findElement(By.xpath("//p[contains(@class, 'prices__big')]"));
        String priceOfProductPageValue = priceOfProductPage.getAttribute("innerText").trim();

        Assert.assertEquals(itemPriceValue, priceOfProductPageValue, "Prices on the main and product pages do not match");

        WebElement logo = driver.findElement(By.xpath("//a[@class='header__logo']"));
        String logUrl = logo.getAttribute("href");

        Assert.assertEquals(logUrl, "https://rozetka.com.ua/ua/", "URL does not match");

        logo.click();

        List<WebElement> saleGoodsItemsNew = driver.findElements(By.xpath("(//ul[contains(@class, 'main-goods')])[4]/li"));
        int countOfGoodsNew = saleGoodsItemsNew.size();
        Thread.sleep(5000); // вручную нужно свайпнуть вниз ( так как элемент не находится на странице и сместился ниже )
        Assert.assertEquals(countOfGoodsNew, 6, "The number of promotional items is not equal to 6 after returning to the main page");


    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}