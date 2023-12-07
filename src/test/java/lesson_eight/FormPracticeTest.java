package lesson_eight;

import io.qameta.allure.*;
import lesson_eight.component.CalendarComponent;
import lesson_eight.component.CheckResult;
import lesson_eight.faker.FakerBox;
import lesson_eight.method.FormPage;
import lesson_eight.screen.ScreenshotTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

@Tag("home")
public class FormPracticeTest extends TestBase {
    FormPage pageForm = new FormPage();
    CalendarComponent component = new CalendarComponent();
    CheckResult checkResult = new CheckResult();
    FakerBox fakerBox = new FakerBox();
    String fileName = "cupcake.png";

    @Test
    @Feature("Jenkins + allure")
    @Disabled
    public void formTest() {
        attachment("Source", webdriver().driver().source());
        //act
        step("fill form", () ->{
        pageForm.setFirstName(fakerBox.firstName)
                .setLastName(fakerBox.lastName)
                .setUserEmail(fakerBox.userEmai)
                .clickGender(fakerBox.gender)
                .setUserNumber(fakerBox.phone)
                .clickDateOfBirthInput();
        new ScreenshotTest().tScreenshot();
        component.setCalendarComponent(fakerBox.month, fakerBox.year);
        pageForm.setSubjects(fakerBox.subjects)
                .setHobbies(fakerBox.hobbies)
                .setPictures(fileName)
                .setCurrentAddress(fakerBox.streetAddress)
                .execute()
                .clickState(fakerBox.state)
                .clickCity(fakerBox.city)
                .clickSubmit();
        new ScreenshotTest().tScreenshot();
        });
        //assert
        step("assert form", () -> {
        checkResult.checkResult("Student Name", fakerBox.firstName + " " + fakerBox.lastName)
                .checkResult("Student Email", fakerBox.userEmai)
                .checkResult("Gender", fakerBox.gender)
                .checkResult("Mobile", fakerBox.phone)
                .checkResult("Date of Birth", "01 " + fakerBox.month + "," + fakerBox.year)
                .checkResult("Subjects", fakerBox.subjects)
                .checkResult("Hobbies", fakerBox.hobbies)
                .checkResult("Picture", fileName)
                .checkResult("Address", fakerBox.streetAddress)
                .checkResult("State and City", fakerBox.state + " " + fakerBox.city);
        new ScreenshotTest().tScreenshot();
        });
    }



    @Test
    @Feature("Jenkins + allure")
    @Story("Запустить Jenkins + видео + Screenshot")
    @Owner("bizyukova")
    public void formWithEmptyFieldsTest() {
        attachment("Source", webdriver().driver().source());
        step("fill form", () ->{
        pageForm.setFirstName(fakerBox.firstName)
                .setLastName(fakerBox.lastName)
                .clickGender(fakerBox.gender)
                .setUserNumber(fakerBox.phone)
                .clickDateOfBirthInput();
        component.setCalendarComponent(fakerBox.month, fakerBox.year);
        pageForm.execute()
                .clickSubmit();
        new ScreenshotTest().tScreenshot();
        });
        //assert
        step("assert form", () -> {
        checkResult.checkResult("Student Name", fakerBox.firstName + " " + fakerBox.lastName)
                .checkResult("Gender", fakerBox.gender)
                .checkResult("Mobile", fakerBox.phone)
                .checkResult("Date of Birth", "01 " + fakerBox.month + "," + fakerBox.year);
        new ScreenshotTest().tScreenshot();
        });
    }



    @Test
    @Feature("Jenkins + allure")
    @Story("Запустить Jenkins")
    @Owner("bizyukova")
    @Severity(SeverityLevel.NORMAL)
    @Story("Запустить Jenkins + Screenshot")
    public void formPhoneBorderRedTest() {
        attachment("Source", webdriver().driver().source());
        step("fill form", () ->{
        String phoneNumberIsIncorrect = "3456789";
        pageForm.setFirstName(fakerBox.firstName)
                .setLastName(fakerBox.lastName)
                .clickGender(fakerBox.gender)
                .setUserNumber(phoneNumberIsIncorrect)
                .clickDateOfBirthInput();
        component.setCalendarComponent(fakerBox.month, fakerBox.year);
        pageForm.execute()
                .clickSubmit();
        new ScreenshotTest().tScreenshot();
        });
        //assert
        step("assert form", () -> {
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        new ScreenshotTest().tScreenshot();
        });
    }

}

