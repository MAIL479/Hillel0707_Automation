package Homeworks;


import java.time.Duration;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import static org.testng.Assert.assertEquals;


public class RozetkaSecondTest {

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
    public void rozetkaTest() throws InterruptedException {

        WebElement sectionLaptopsAndComputers = driver.findElement(By.xpath("//a[@class='menu-categories__link' and contains(text(),'Ноутбуки')]"));
        sectionLaptopsAndComputers.click();

        WebElement categoryLaptops = driver.findElement(By.xpath("//a[contains(@class, 'heading') and contains(text(),'Ноутбуки')]"));
        categoryLaptops.click();

        WebElement theFirstProductWithTopSelling = driver.findElement(By.xpath("//span[contains(@class, 'goods-tile') and contains(text(),' Ноутбук Lenovo IdeaPad 3 15ALC6 (82KU01C4RA) ')]"));
        theFirstProductWithTopSelling.click();

        WebElement buttonBuy = driver.findElement(By.xpath("//button[contains(@class, 'buy-button button button--w') and @type='button']"));
        buttonBuy.click();

        List<WebElement> cartListItem = driver.findElements(By.xpath("//li[@class='cart-list__item ng-star-inserted']"));
        int countsOfListItem = cartListItem.size();
        assertEquals(countsOfListItem, 1);

        WebElement buttonClose = driver.findElement(By.xpath("//button[@class='modal__close']"));
        buttonClose.click();

        List<WebElement> cartListItem2 = driver.findElements(By.xpath("//span[@class='counter counter--green ng-star-inserted']"));
        int countsOfListItem2 = cartListItem2.size();
        assertEquals(countsOfListItem2, 1);


    }

    @AfterMethod
    public void after() {
        driver.quit();
    }


}
