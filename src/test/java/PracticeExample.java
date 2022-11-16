import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeExample {

    @BeforeAll
    static void beforeAll() {
            Configuration.holdBrowserOpen = true;
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
        }

    @Test
    void fillFormTest() {
        String userName = "Egor";

        open("/text-box");

        $("#userName").setValue(userName);
        $("#userEmail").setValue("Egor@egor.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Other address 1");
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text("Egor@egor.com"));
    }
}
