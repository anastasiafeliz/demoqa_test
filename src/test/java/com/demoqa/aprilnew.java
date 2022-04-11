package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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

        $("[id=firstName]").setValue("Anastasia"); //имя
        $("[id=lastName]").setValue("Piganova");//фамилия
        $("[id=userEmail]").setValue("piganova@io.com");//почта

       // $("#gender-radio-3").parent().click();//пол
        $("[id=genterWrapper]").$(new ByText("Other")).click();
        $("[id=userNumber]").setValue("5555555");//телефон
        $("#dateOfBirthInput").click();//дата рождения
        $(".react-datepicker__month-select").selectOptionByValue("1");//месяц
        $(".react-datepicker__year-select").selectOptionByValue("1988");//год
        //$(".react-datepicker__day—025").click();//не срабатывает

        $("#subjectsInput").setValue("Chemistry").pressEnter();//не работает
        $("#hobbies-checkbox-3").parent().click(); //не работает

        $("#uploadPicture").uploadFromClasspath("123.jpg"); //моя фотка
        $("#currentAdress").setValue("Ulitsa 34");
        $("[id=stateCity-wrapper]").$(new ByText("NRC")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Delhi")).click();
        $("#city").click();

        $("[id=submit]").shouldBe(Condition.visible).click();

       // $(".modal-open").shouldHave(text("Thanks for submitting the form"));
       // $(".table-responsive").shouldHave(text("Anastasia Piganova"));


}
}
