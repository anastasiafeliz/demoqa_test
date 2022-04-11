package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class aprilnew {
    @BeforeAll
static void beforeAll() {
    Configuration.holdBrowserOpen = true;
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1024x768";
}
    @Test
    void fillFormTest() {

    }

    {
    Selenide.open("/automation-practice-form");
    Selenide.executeJavaScript("document.querySelector(\"footer\").hidden = 'true';document.querySelector(\"#fixedban\").hidden = 'true'");

        $("[id=firstName]").setValue("Anastasia");
        $("[id=lastName]").setValue("Piganova");
        $("[id=userEmail]").setValue("piganova@io.com");

       // $("#gender-radio-3").parent().click();//не срабатывает
        $("[id=genterWrapper]").$(new ByText("Other")).click();
        $("[id=userNumber]").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("1");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        //$(".react-datepicker__day—select").click();//не срабатывает

        $("#subjectsInput").setValue("Chemistry").pressEnter();//не срабатывает
        $("#hobbies-checkbox-3").parent().click(); //не срабатывает

        $("#uploadPicture").uploadFile(new File("src/test/resourses/123.jpg"));

        $("[id=currentAddress]").setValue("Ulitsa 34");
        $("#state").click();
        $(new ByText("Uttar Pradesh")).click();
        $("#city").click();
        $(new ByText("Lucknow")).click();

        $("[id=submit]").shouldBe(Condition.visible).click();

       $(".modal-open").shouldHave(new Text("Thanks for submitting the form"));
       $(".table-responsive").shouldHave(new Text("Anastasia Piganova"));



    }
}
