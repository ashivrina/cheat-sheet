package docs;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("123");
        $(by("data-testid", "email]")).setValue("123");

        $("[id=email]").setValue("123");
        //то же самое но по-другому, с шорткатом для id
        $("#email").setValue("123");

        //xPath селекторы
        $x("//*[@id='email']").setValue("123");
        $(byXpath("//*[@id='email']")).setValue("123");

        $("[name=email]").setValue("123");
        $(byName("email")).setValue("123");

        $("[class=login_form_input_box]").setValue("123");
        //точка - это сокращение для обращения к классу
        $(".login_form_input_box").setValue("123");
        $(".inputtext.login_form_input_box").setValue("123");
        $("input.inputtext.login_form_input_box").setValue("123");
        $x("//input[@class='login_form_input_box']").setValue("123");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("123");

        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box" name="email">
        // </div>
        $(".inputtext .login_form_input_box").setValue("123");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        //самый стабильный локатор, где используются все атрибуты
        $("input.inputtext.login_form_input_box#email[name=email][data-testid=email]").setValue("123");

        // <div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']");
        $x("//div[contains(text(), 'ello qa.gur')]");
        $x("//div[text()[contains(.,'ello qa.gur')]]");
        $(byText("Hello qa.guru"));
        $(withText("ello qa.gur"));
    }
}
