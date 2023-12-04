package lesson_eight.component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResult {
    public CheckResult checkResult(String key, String value){
        $(".modal-body").$(byText(key)).parent().shouldHave(text(value));
        return this;

    }
}
