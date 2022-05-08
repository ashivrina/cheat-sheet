package tests.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void setUp() {
        //uncomment if you want to keep browser closed after test run
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String name = "Joe Black";
        String email = "joeblack@gmail.com";
        String currentAddress = "CR, Prague 2, Green St.";
        String permanentAddress = "Georgia, Yellow St.";

        open("/text-box");
        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").scrollTo().click();

        $("[id=output] [id = name]").shouldHave(text(name));
        $("[id=output]").$("[id = email]").shouldHave(text(email));
        $("p[id=currentAddress]").shouldHave(text(currentAddress));
        $("p[id=permanentAddress]").shouldHave(text(permanentAddress));
    }
}
