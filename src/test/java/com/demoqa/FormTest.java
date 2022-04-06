package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1024x768";

    }

    @Test
    void fillFormTest() {

        Selenide.open("/automation-practice-form");
        Selenide.executeJavaScript("document.querySelector(\"footer\").hidden = 'true';document.querySelector(\"#fixedban\").hidden = 'true'");
        $("[id=firstName]").setValue("Anastasia");
        $("[id=lastName]").setValue("Piganova");
        $("[id=userEmail]").setValue("piganova@io.com");
        $("[id=userNumber]").setValue("5555555");
        $("[id=subjects-label]").click();
        $("[id=subjects-label]").selectOption("Chemistry");
        $("[id=hobbiesWrapper]").click();
        $("[id=hobbiesWrapper]").selectOption("Reading");
        $("[id=uploadPicture]").uploadFromClasspath("photo.jpg");
        $("[id=currentAddress]").setValue("Ulitsa 34");
        $("[byText=state]").click();
        $("[byText=city]").click();
        $("[id=submit]").click();
        $("[id=submit]").shouldBe(Condition.visible).click();

    }
}


