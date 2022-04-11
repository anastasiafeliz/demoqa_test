package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("1");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__day—005").click();
        $("[id=subjects-label]").click();
        $("[id=subjects-label]").selectOption("Chemistry");
        $("[id=hobbiesWrapper]").click();
        $("[id=hobbiesWrapper]").selectOption("Reading");
        $("[id=uploadPicture]").uploadFromClasspath("photo.jpg");

    }
}


