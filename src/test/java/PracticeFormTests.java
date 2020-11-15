import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @Test
    void registrationFormTests() {
        String firstName = "Kate",
                lastName = "Eremeeva",
                userEmail = "test.test.ru",
                gender = "Female",
                userNumber = "1234567890",
                pictureName = "photo_2020-04-30_18-23-07.jpg",
                currentAddress = "St.Petersburg";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);

        $("#lastName").setValue(lastName);

        $("#userEmail").setValue(userEmail);

        $(by("for", "gender-radio-2")).click();

        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--021").click();

        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $(by("for", "hobbies-checkbox-1")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/" + pictureName));

        $("#currentAddress").scrollTo().setValue(currentAddress);

        $(byText("Select State")).click();
        $(byText("Rajasthan")).click();

        $(byText("Select City")).click();
        $(byText("Jaipur")).click();

        $("#submit").click();

        $("#firstName").shouldHave(value(firstName));
        $("#lastName").shouldHave(value(lastName));
        $("#userEmail").shouldHave(value(userEmail));
        $(by("for", "gender-radio-2")).shouldHave(text(gender));
        $("#userNumber").shouldHave(value(userNumber));
        $(".react-datepicker__day--021").exists();
        $(".react-datepicker__month-select").exists();
        $(".react-datepicker__year-select").exists();
        $("#subjectsInput").exists();
        $(by("for", "hobbies-checkbox-1")).shouldHave(text("Sports"));
        $("#uploadPicture").shouldHave(value(pictureName));
        $("#currentAddress").shouldHave(value(currentAddress));
        $(byText("Rajasthan")).exists();
        $(byText("Jaipur")).exists();
    }
}
