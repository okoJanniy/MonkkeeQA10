package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

@Log4j2
public class RegistrationPage {

    private static final String URL = "https://my.monkkee.com/account/registration";
    private static final String COMPLETE_REGISTRATION_BUTTON = ".btn";
    private static final By REGISTRATION_EMAIL = id("registration_email");
    private static final By REGISTRATION_PASSWORD = id("registration_password");
    private static final By CONFIRM_PASSWORD = id("registration_password_confirmation");
    private static final By TERMS_OF_USE_CHECKBOX = id("registration_terms_of_use");
    private static final By LOST_PASSWORD_WARNING_CHECKBOX = id("registration_lost_password_warning_registered");
    private static final String REGISTRATION_MESSAGE = "h1";

    public void openPage() {
        log.info("Opening Registration page");
        open(URL);
        sleep(1000);
        isPageOpened();
    }

    public void isPageOpened() {
        log.info("Registration page is opened");
        $(COMPLETE_REGISTRATION_BUTTON).waitUntil(Condition.visible, 10000);
    }

    public RegistrationPage proceedRegistration(String email, String password) {
        log.info("Fill email field:" + email);
        $(REGISTRATION_EMAIL).sendKeys(email);
        log.info("Fill password field:" + password);
        $(REGISTRATION_PASSWORD).sendKeys(password);
        log.info("Fill confirmation password field:" + password);
        $(CONFIRM_PASSWORD).sendKeys(password);
        log.info("Click terms of use checkbox");
        $(TERMS_OF_USE_CHECKBOX).click();
        log.info("Click lost password warning checkbox");
        $(LOST_PASSWORD_WARNING_CHECKBOX).click();
        $(COMPLETE_REGISTRATION_BUTTON).click();
        return this;
    }

    public RegistrationPage confirmRegistration (){
        log.info("Confirm registration message");
        $(REGISTRATION_MESSAGE).shouldBe(Condition.text("User registered"));
        return this;
    }
}
