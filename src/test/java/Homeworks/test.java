package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class test {


    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/notebooks/c80004");
    }

    @Test
    public void rozetkaTest() throws InterruptedException {
        WebElement rozetkaSellerCheckbox = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//a[@data-id='Rozetka']")));
        rozetkaSellerCheckbox.click();

        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@class='catalog-selection__link']")));

//    sleep(10000);

        WebElement maxCost = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@class='slider-filter__inner']/input[2]")));
        maxCost.clear();
        maxCost.sendKeys("100000");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@class='slider-filter__inner']/button")));
        submitButton.click();
    }

//    @AfterMethod
//    public void after() {
//        driver.quit();
//    }
}
