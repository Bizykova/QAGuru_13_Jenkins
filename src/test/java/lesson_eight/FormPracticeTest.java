package lesson_eight;

import lesson_eight.component.CalendarComponent;
import lesson_eight.component.CheckResult;
import lesson_eight.faker.FakerBox;
import lesson_eight.method.FormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//@Tag("simple")
public class FormPracticeTest extends TestBase {
    FormPage pageForm = new FormPage();
    CalendarComponent component = new CalendarComponent();
    CheckResult checkResult = new CheckResult();
    FakerBox fakerBox = new FakerBox();
    String fileName = "cupcake.png";


    @Test
    public void formTest() {
        //act
        pageForm.setFirstName(fakerBox.firstName)
                .setLastName(fakerBox.lastName)
                .setUserEmail(fakerBox.userEmai)
                .clickGender(fakerBox.gender)
                .setUserNumber(fakerBox.phone)
                .clickDateOfBirthInput();
        component.setCalendarComponent(fakerBox.month,fakerBox.year);
        pageForm.setSubjects(fakerBox.subjects)
                .setHobbies(fakerBox.hobbies)
                .setPictures(fileName)
                .setCurrentAddress(fakerBox.streetAddress)
                .execute()
                .clickState(fakerBox.state)
                .clickCity(fakerBox.city)
                .clickSubmit();
        //assert
        checkResult.checkResult("Student Name", fakerBox.firstName+" "+fakerBox.lastName)
                .checkResult("Student Email", fakerBox.userEmai)
                .checkResult("Gender", fakerBox.gender)
                .checkResult("Mobile", fakerBox.phone)
                .checkResult("Date of Birth", "01 "+fakerBox.month+ ","+fakerBox.year)
                .checkResult("Subjects",fakerBox.subjects)
                .checkResult("Hobbies",fakerBox.hobbies)
                .checkResult("Picture", fileName)
                .checkResult("Address", fakerBox.streetAddress)
                .checkResult("State and City",fakerBox.state+ " "+fakerBox.city);
    }

    @Test
    public void formWithEmptyFieldsTest() {
        pageForm.setFirstName(fakerBox.firstName)
                .setLastName(fakerBox.lastName)
                .clickGender(fakerBox.gender)
                .setUserNumber(fakerBox.phone)
                .clickDateOfBirthInput();
        component.setCalendarComponent(fakerBox.month,fakerBox.year);
        pageForm.execute()
                .clickSubmit();
        //assert
        checkResult.checkResult("Student Name", fakerBox.firstName+" "+fakerBox.lastName)
                .checkResult("Gender", fakerBox.gender)
                .checkResult("Mobile", fakerBox.phone)
                .checkResult("Date of Birth","01 "+ fakerBox.month+ ","+fakerBox.year);

    }
    @Test
    public void formPhoneBorderRedTest() {
        String phoneNumberIsIncorrect = "3456789";
        pageForm.setFirstName(fakerBox.firstName)
                .setLastName(fakerBox.lastName)
                .clickGender(fakerBox.gender)
                .setUserNumber(phoneNumberIsIncorrect)
                .clickDateOfBirthInput();
        component.setCalendarComponent(fakerBox.month,fakerBox.year);
        pageForm.execute()
                .clickSubmit();
        //assert
        $("#userNumber").shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
    }
}
