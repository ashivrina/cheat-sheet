package tests.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {
    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
    }
}
