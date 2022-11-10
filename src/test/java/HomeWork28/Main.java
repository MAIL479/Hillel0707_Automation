package HomeWork28;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Main {

    LaptopsLogic laptopsPageLogic = new LaptopsLogic();
    CartLogic cartPageLogic = new CartLogic();
    private final MainLogic MAIN_PAGE_LOGIC = new MainLogic();

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest2() {
        MAIN_PAGE_LOGIC
                .clickCompANDLaptops(MAIN_PAGE_LOGIC.pcAndLaptops)
                .clickOnLaptops(new PCAndLaptopsLogic().laptops)
                .clickOnBuyBtn(new LaptopsLogic().addToCartBtn);

        Assert.assertEquals(laptopsPageLogic.cartProductsNumber(), "1", "Number of goods in the cart is displayed incorrect");

        laptopsPageLogic.clickOnCartBtn(laptopsPageLogic.cartBtn);

        Assert.assertEquals(laptopsPageLogic.itemTitleText(), cartPageLogic.cartItemTitleText(), "Product titles don't equals");
    }

}
