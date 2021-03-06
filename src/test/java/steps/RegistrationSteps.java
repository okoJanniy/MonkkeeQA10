package steps;

import io.qameta.allure.Step;
import pages.RegistrationPage;

public class RegistrationSteps {

    RegistrationPage page;

    public RegistrationSteps() {
        page = new RegistrationPage();
    }

    @Step("Open monkkee.com registration page")
    public RegistrationSteps openRegistrationPage() {
        page.openPage();
        return this;
    }

    @Step("Заполните регистрационные данные в полях электронной почты = '{email}', password = '{password}'")
    public RegistrationSteps fillInRegistrationData(String email, String password) {
        page.fillInRegistrationData(email, password);
        return this;
    }

    @Step("Проверить результат регистрации")
    public RegistrationSteps checkRegResult() {
        page.checkRegistrationResult();
        return this;
    }
}
