package Lesson28;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFirstTest {

    @BeforeMethod
    public void before() {

        Configuration.browserSize = "3024x1964";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest() {
        $(By.name("search"))
                .setValue("Mac");
        $(By.xpath("//button[coontains(@class, 'button_color_green')]"))
                .shouldHave(text("Найти"))
                .click();

    }

}
