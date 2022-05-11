package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTests {

    @BeforeEach
    void openDuckDuckGo() {
        open("https://duckduckgo.com/");
    }

    @Test
    void searchYandex() {
        $("[id=search_form_input_homepage]").setValue("Yandex").pressEnter();
        $("[id=links]").shouldHave(text("https://yandex.com"));
    }

    @AfterEach
    void close() {
        WebDriverRunner.closeWindow();
    }
}
