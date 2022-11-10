package HomeWork28;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CartElement {

    SelenideElement cartItemTitle = $(byXpath("//a[@class='cart-product__title']"));
}
