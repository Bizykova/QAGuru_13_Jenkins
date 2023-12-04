import io.qameta.allure.*;
import lesson_eight.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestJenkins extends TestBase {
    @Test
    @Feature("Jenkins")
    @Story("Создание Jenkins")
    @Owner("bizyukova")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание jenkins автоматизированного тестирования")
    public void testJenkins() {

    }
}