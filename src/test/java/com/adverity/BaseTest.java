package com.adverity;

import com.adverity.config.TestConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class BaseTest extends AbstractTestNGSpringContextTests {

    @BeforeSuite
    public static void configureSelenide() {
        Configuration.startMaximized = true;

        // https://docs.qameta.io/allure/#_selenide
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

}
