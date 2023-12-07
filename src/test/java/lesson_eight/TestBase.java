package lesson_eight;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.nio.file.Files;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;

public class TestBase {
    @BeforeEach
    void setUp(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotest.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://demoqa.com/automation-practice-form");
    }
}
//    @Attachment(value = "scrin", fileExtension = "png")
//    public byte[] doScreenshot(SelenideElement element) throws IOException {
//        return Files.readAllBytes(element.screenshot().toPath());
//    }
//    doScreenshot(checkResult.checkResult();