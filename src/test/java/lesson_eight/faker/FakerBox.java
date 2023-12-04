package lesson_eight.faker;

import java.util.Locale;

public class FakerBox {
    com.github.javafaker.Faker faker = new com.github.javafaker.Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmai = faker.internet().emailAddress();
    public String streetAddress = faker.address().fullAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String phone = faker.phoneNumber().subscriberNumber(10);
    public String year = Integer.toString(faker.number().numberBetween(2000, 2024));
    public String month = faker.options().option("February", "March", "April", "May", "June", "July", "August", "September");
    public String subjects = faker.options().option("Computer Science", "Match", "History", "English");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana","Rajasthan");
    public String city = getCity(state);

    public String getCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;
        }
    }
}


