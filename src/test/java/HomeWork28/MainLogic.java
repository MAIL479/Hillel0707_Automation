package HomeWork28;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class MainLogic extends MainElement {

    public PCAndLaptopsLogic clickCompANDLaptops(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(PCAndLaptopsLogic.class);
    }


}
