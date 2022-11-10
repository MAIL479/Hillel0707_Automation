package HomeWork28;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class PCAndLaptopsLogic extends PCAndLaptopElement {
    public LaptopsLogic clickOnLaptops(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(LaptopsLogic.class);
    }
}
