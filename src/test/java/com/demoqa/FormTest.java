package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920х1080";
    }
    @Test
    void fillFormTest(){
        open("/automation-practice-form");

        $("[id=FirstName]").setValue("Anastasia");
        $("[id=LastName]").setValue("Piganova");
        $("[id=userEmail]").setValue("piganova@io.com");
        $("[byText=Male]").click();
        $("[id=userNumber]").setValue("5555555");
        $("[id=dateOfBirthInput]").setValue("25 Jan 1988");


    }
}


