package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Aprilnew {
    @BeforeAll
static void beforeAll() {
    Configuration.holdBrowserOpen = true;
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1024x768";
}
    @Test
    void fillFormTest() {
        Selenide.open("/automation-practice-form");
        Selenide.executeJavaScript("document.querySelector(\"footer\")." +
                "hidden = 'true';document.querySelector(\"#fixedban\").hidden = 'true'");

        $("[id=firstName]").setValue("Anastasia");
        $("[id=lastName]").setValue("Piganova");
        $("[id=userEmail]").setValue("piganova@io.com");

        $("[id=genterWrapper]").$(byText("Female")).click();
        $("[id=userNumber]").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").scrollIntoView(true).selectOption("January");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--005").click();


        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $(byText("Reading")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/123.jpg"));

        $("[id=currentAddress]").setValue("Ulitsa 34");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();

        $("[id=submit]").shouldBe(Condition.visible).click();

        $(".modal-open").shouldHave(new Text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(new Text("Anastasia Piganova"));
        $(".table-responsive").shouldHave(new Text("piganova@io.com"));
        $(".table-responsive").shouldHave(new Text("Female"));
        $(".table-responsive").shouldHave(new Text("1234567890"));
        $(".table-responsive").shouldHave(new Text("05 January,1988"));
        $(".table-responsive").shouldHave(new Text("Chemistry"));
        $(".table-responsive").shouldHave(new Text("Reading"));
        $(".table-responsive").shouldHave(new Text("Ulitsa 34"));
        $(".table-responsive").shouldHave(new Text("Uttar Pradesh Lucknow"));
    }
}
