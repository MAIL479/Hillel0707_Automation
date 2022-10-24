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

        WebElement sectionLaptopsAndComputers = driver.findElement(By.xpath("//a[@class='menu-categories__link' and contains(text(),'Ноутбуки та комп’ютери')]"));
        sectionLaptopsAndComputers.click();
        WebElement categoryLaptops = driver.findElement(By.xpath("//a[@class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted' and contains(text(),'Ноутбуки')]"));
        categoryLaptops.click();
        WebElement theFirstProductWithTopSelling = driver.findElement(By.xpath("//span[@class='goods-tile__title' and contains(text(),' Ноутбук Lenovo IdeaPad 3 15ALC6 (82KU01C4RA) Arctic Grey ')]"));
        theFirstProductWithTopSelling.click();
        WebElement buttonBuy = driver.findElement(By.xpath("//button[@class='buy-button button button--with-icon button--green button--medium ng-star-inserted' and @type='button']"));
        buttonBuy.click();
        /*WebElement closeWindow = driver.findElement(By.xpath("//button[@type='button' and @class='modal__close']"));
        closeWindow.click();*/
        /*List<WebElement> cartListItem = driver.findElement(By.xpath("//li[@class='cart-list__item ng-star-inserted']"));
        int countsOfListItem = cartListItem.size();*/
        /*assertEquals(countsOfListItem,1);*/





        /*String verifyCartNumber = shoppingCartNumber.getText().trim();
        Assert.assertEquals(verifyCartNumber, EXPECTED_NUMBER, "tittle equals ' 1 '");*/






    }

    @AfterMethod
    public void after() {
        driver.quit();
    }





}
