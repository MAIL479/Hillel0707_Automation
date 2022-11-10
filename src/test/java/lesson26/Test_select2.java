package lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Test_select2 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://autodoc.de/");
    }


    @Test
    public void selectTest2() throws InterruptedException {

        selectOption(driver, "5");

        TimeUnit.SECONDS.sleep(5);
    }


    public void selectOption(WebDriver driver, String option) {

        WebElement makerList = driver.findElement(By.id("form_maker_id"));
        String makerListOption = String.format("//select[@id='form_maker_id']/optgroup[2]/option[@value='2']");

        makerList.click();

        driver.findElement(By.xpath(makerListOption)).click();
    }



    @AfterMethod
    public void after() {
        driver.quit();
    }

}



