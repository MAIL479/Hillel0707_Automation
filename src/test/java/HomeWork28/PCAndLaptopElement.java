package HomeWork28;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PCAndLaptopElement {

    SelenideElement laptops = $(byXpath("//*[contains(@href, 'c80004')]"));
}
