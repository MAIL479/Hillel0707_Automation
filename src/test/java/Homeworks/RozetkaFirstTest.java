package Homeworks;

import java.time.Duration;
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

public class RozetkaFirstTest {

    private WebDriver driver;
    final String EXPECTED_TITTLE = "ТОП ПРОДАЖІВ";
    /* private WebDriverWait wait;*/


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
        WebElement checkboxSellerRozetka = driver.findElement(By.xpath("//a[@class='checkbox-filter__link' and @data-id='Rozetka']"));
        checkboxSellerRozetka.click();
        Thread.sleep(1000); // явное ожидание, понимаю ( но без этого тест не работает ) элемент виден на странице но всеравно нужно ждать -_-
        WebElement filterMaxPrice = driver.findElement(By.xpath("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid' and @formcontrolname='max']"));
        filterMaxPrice.clear();
        filterMaxPrice.sendKeys("100000");
        WebElement buttonOkInPriceFilter = driver.findElement(By.xpath("//button[@class='button button_color_gray button_size_small slider-filter__button']"));
        buttonOkInPriceFilter.click();
        Thread.sleep(5000); // вручную нужно свайпнуть вверх ( так как элемент не находит на странице )
       /* WebElement theFirstProductWithTopSelling = driver.findElement(By.xpath("//a[@class='goods-tile__heading ng-star-inserted' and @title='Ноутбук Lenovo V14 G2 ITL (Intel i3-1115G4/8/128F/int/W10Pro) Black']"));
        theFirstProductWithTopSelling.click();
        WebElement topPriceInFirstProduct = driver.findElement(By.xpath("//span[@class='promo-label_type_popularity promo-label promo-label--large ng-star-inserted' and contains(text(),'ТОП ПРОДАЖІВ')]"));
        String titleOfSearchTopPrice = topPriceInFirstProduct.getText().trim();

        Assert.assertEquals(titleOfSearchTopPrice, EXPECTED_TITTLE, "tittle equals 'ТОП ПРОДАЖІВ'");
        Assert.assertTrue(true);*/
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}


/*


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
        submitButton.click();*/




