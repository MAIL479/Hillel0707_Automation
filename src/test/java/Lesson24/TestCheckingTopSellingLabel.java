package Lesson24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestCheckingTopSellingLabel {


        private WebDriver driver;
        private WebDriverWait wait;

        @BeforeMethod
        public void before() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://rozetka.com.ua/ua/");
        }

        @Test
        public void rozetkaTest() {
            WebElement laptopsAndComp = driver.findElement(By.xpath("//ul[contains(@class,'menu-categories_')]/li[1]/a"));
            laptopsAndComp.click();

            WebElement laptops = driver.findElement(By.xpath("//*[contains(@href, 'c80004')]"));
            laptops.click();

            List<WebElement> tittlesOgGoods = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
            int countsOfGoods = tittlesOgGoods.size();
            assertEquals(countsOfGoods, 60);



        }

        @AfterMethod
    public void after() {
            driver.quit();
    }

}
