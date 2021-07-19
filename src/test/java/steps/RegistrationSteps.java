package steps;

import io.qameta.allure.Step;
import pages.RegistrationPage;

public class RegistrationSteps {
    RegistrationPage registrationPage;

    public RegistrationSteps() {
        registrationPage = new RegistrationPage();
    }

    @Step("Открыть monkkee.com страницу регистрации")
    public RegistrationSteps openRegistrationPage() {
        registrationPage.openPage();
        return this;
    }

    @Step("Заполнить форму регистрации")
    public RegistrationSteps fillFormForRegistrationANewUser(String email, String password) {
        registrationPage.proceedRegistration(email, password);
        return this;
    }

    @Step("Подтвердить регистрацию, получив сообщение о регистрации")
    public RegistrationSteps confirmMessageOfRegistration() {
        registrationPage.confirmRegistration();
        return this;
    }
}
