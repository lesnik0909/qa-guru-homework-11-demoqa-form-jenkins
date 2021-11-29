package guru.qa.homework.helpers;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.util.Locale;

public class TestDate {

  public static final String SUBJECT = "Maths";
  public static final String IMAGE_NAME = "image.png";
  public static final String STATE = "NCR";
  public static final String CITY = "Delhi";

  Faker faker = new Faker(new Locale("en"));

  private final String firstName = faker.name().firstName();
  private final String lastName = faker.name().lastName();
  private final String email = faker.internet().emailAddress();
  private final String phoneNumber = faker.phoneNumber().subscriberNumber(10);
  private final LocalDate birthDate = LocalDate.parse("1990-08-07");
  private final String address = faker.address().streetAddress();

  public Faker getFaker() {
    return faker;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public String getAddress() {
    return address;
  }

}
