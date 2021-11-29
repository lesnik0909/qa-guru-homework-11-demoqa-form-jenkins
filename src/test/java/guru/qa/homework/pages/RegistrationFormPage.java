package guru.qa.homework.pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import guru.qa.homework.tests.BaseTest;
import java.time.LocalDate;

public class RegistrationFormPage extends BaseTest {

  public RegistrationFormPage openPage() {
    open("https://demoqa.com/automation-practice-form");
    return this;
  }

  public RegistrationFormPage typeFirstName(String firstName) {
    $("#firstName").setValue(firstName);
    return this;
  }

  public RegistrationFormPage typeLastName(String lastName) {
    $("#lastName").setValue(lastName);
    return this;
  }

  public RegistrationFormPage typeEmailName(String email) {
    $("#userEmail").setValue(email);
    return this;
  }

  public RegistrationFormPage selectGender(Gender gender) {
    $(gender.getSelector()).click();
    return this;
  }

  public RegistrationFormPage typePhoneNumber(String phoneNumber) {
    $("#userNumber").setValue(phoneNumber);
    return this;
  }

  public RegistrationFormPage selectBirthDate(LocalDate date) {
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").click();
    $("option[value='" + (date.getMonth().getValue() - 1) + "']").click();
    $(".react-datepicker__year-select").click();
    $("option[value='" + date.getYear() + "']").click();
    $x("//div[text()='" + date.getDayOfMonth() + "']").click();
    return this;
  }

  public RegistrationFormPage typeSubject(String subject) {
    $("#subjectsInput").setValue(subject).pressEnter();
    return this;
  }

  public RegistrationFormPage selectHobbies(Hobbies hobbies) {
    $(hobbies.getSelector()).click();
    return this;
  }

  public RegistrationFormPage uploadFile(String imageName) {
    $("#uploadPicture").uploadFromClasspath(imageName);
    return this;
  }

  public RegistrationFormPage typeAddress(String address) {
    $("#currentAddress").setValue(address);
    return this;
  }

  public RegistrationFormPage selectStateAndCity(String state, String City) {
    $("#react-select-3-input").setValue(state).pressEnter();
    $("#react-select-4-input").setValue(City).pressEnter();
    return this;
  }

  public RegistrationFormPage clickSubmit() {
    $("#submit").scrollTo().click();
    return this;
  }

  public RegistrationFormPage assertField(String label, String value) {
    $x(("//td[text()='" + label + "']/following-sibling::td")).shouldHave(exactText(value));
    return this;
  }

}
