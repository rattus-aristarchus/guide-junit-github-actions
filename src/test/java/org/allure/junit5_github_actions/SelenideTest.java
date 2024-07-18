package org.allure.junit5_github_actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {


    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    public void testMainPage() {
        Allure.step("Open main page", (step) -> {
            open("https://www.saucedemo.com");
        });

        Allure.step("The login logo should be visible", (step) -> {
            $(".login_logo").shouldBe(Condition.visible);
        });
    }

}