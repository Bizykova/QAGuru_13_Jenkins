package lesson_eight.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement datepickerMonth = $(".react-datepicker__month-select");
    private SelenideElement datepickerDey = $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)");
    private SelenideElement datepickerYear = $(".react-datepicker__year-select");

    public CalendarComponent setCalendarComponent(String month, String year){
        datepickerMonth.click();
        datepickerMonth.selectOption(month);
        datepickerYear.click();
        datepickerYear.selectOption(year);
        datepickerDey.hover().click();
        return this;

    }




}
