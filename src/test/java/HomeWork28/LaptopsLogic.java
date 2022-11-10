package HomeWork28;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class LaptopsLogic extends LaptopElement {

    public LaptopsLogic clickOnBuyBtn(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return this;
    }

    public String cartProductsNumber() {
        return itemsInCart.text().trim();
    }

    public String itemTitleText() {
        return itemTitle.text().trim();
    }

    public CartLogic clickOnCartBtn(SelenideElement button) {
        button.shouldBe(Condition.visible);
        button.click();
        return page(CartLogic.class);
    }

}
