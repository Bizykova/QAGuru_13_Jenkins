package lesson_eight.method;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormPage {
    private SelenideElement firstName = $("#firstName");
    private SelenideElement lastName = $("#lastName");
    private SelenideElement userEmail = $("#userEmail");
    private SelenideElement gender = $("#genterWrapper");
    private SelenideElement userNumber = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjects = $("#subjectsInput");
    private SelenideElement hobbi = $("#hobbiesWrapper");
    private SelenideElement pictures = $("#uploadPicture");
    private SelenideElement currentAddress = $("#currentAddress");
    private SelenideElement states = $("#state");
    private SelenideElement city = $("#city");
    private SelenideElement submit = $("#submit");

    public FormPage setFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    public FormPage setLastName(String lastNam) {
        lastName.setValue(lastNam);
        return this;
    }

    public FormPage setUserEmail(String userEm) {
        userEmail.setValue(userEm);
        return this;
    }

    public FormPage clickGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public FormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public FormPage clickDateOfBirthInput() {
        dateOfBirthInput.click();
        return this;
    }

    public FormPage setSubjects(String value) {
        subjects.click();
        subjects.setValue(value).hover().pressEnter();
        return this;
    }

    public FormPage setHobbies(String value) {
        hobbi.$(byText(value)).click();
        return this;
    }

    public FormPage setPictures(String fileName) {
        pictures.uploadFromClasspath(fileName);
        return this;
    }

    public FormPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public FormPage clickState(String value) {
        states.click();
        $(byText(value)).click();
        return this;
    }


    public FormPage clickCity(String value) {
        city.click();
        $(byText(value)).click();
        return this;
    }

    public FormPage clickSubmit() {
        submit.click();
        return this;
    }
    public FormPage execute(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


}
