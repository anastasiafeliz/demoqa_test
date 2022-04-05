package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920х1080";
    }
    @Test
    void fillFormTest(){
        Selenide.open("/automation-practice-form");

        Selenide.$("[id=FirstName]").setValue("Anastasia");
        Selenide.$("[id=LastName]").setValue("Piganova");
        Selenide.$("[id=userEmail]").setValue("piganova@io.com");
        Selenide.$("[byText=Male]").click();
        Selenide.$("[id=userNumber]").setValue("5555555");
        Selenide.$("[id=dateOfBirthInput]").setValue("25 Jan 1988");
        Selenide.$("[id=subjects-label]").setValue("Chemistry");
        Selenide.$("[byText=Reading]").click();
        Selenide.$("[id=uploadPicture]").uploadFromClasspath("photo");
        Selenide.$("[id=currentAddress]").setValue("XOXOXO");
        Selenide.$("[id=state]").click("Utar Pradesh");
        Selenide.$("[id=city]").click("Agra");
        Selenide.$("[id=submit]").click();

    }
}


