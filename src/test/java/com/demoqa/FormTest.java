package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        Selenide.executeJavaScript("document.querySelector(\"footer\").hidden = 'true';" +
                "document.querySelector(\"#fixedban\").hidden = 'true'");
        Selenide.$("[id=firstName]").setValue("Anastasia");
        Selenide.$("[id=lastName]").setValue("Piganova");
        Selenide.$("[id=userEmail]").setValue("piganova@io.com");
        Selenide.$("[id=userNumber]").setValue("5555555");
        Selenide.$("[id=dateOfBirthInput]").click();
        Selenide.$("[id=react-datepicker__year-select]").selectOption("1998");
        Selenide.$("[id=react-datepicker__month-select]").selectOption("June");
        Selenide.$("[id=react-datepicker__day-select]").selectOption("15");
        Selenide.$("[id=subjects-label]").click();
        Selenide.$("[id=subjects-label]").selectOption("Chemistry");
        Selenide.$("[id=hobbiesWrapper]").click();
        Selenide.$("[id=hobbiesWrapper]").selectOption("Reading");
        Selenide.$("[id=uploadPicture]").uploadFromClasspath("photo.jpg");
        Selenide.$("[id=currentAddress]").setValue("Ulitsa 34");
        Selenide.$("[byText=state]").click();
        Selenide.$("[byText=city]").click();
        Selenide.$("[id=submit]").click();
        Selenide.$("[id=submit]").shouldBe(Condition.visible).click();

    }
}


