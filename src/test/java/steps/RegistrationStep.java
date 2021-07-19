package steps;

import io.qameta.allure.Step;
import pages.RegistrationPage;

public class RegistrationStep {
    RegistrationPage registrationPage;

    public RegistrationStep(){
        registrationPage = new RegistrationPage();
    }

    @Step("Открыть monkkee.com страницу регистрации")
    public RegistrationStep openRegistrationPage() {
        registrationPage.openPage();
        return this;
    }

    @Step("Заполнить форму регистрации")
    public RegistrationStep fillFormForRegistrationANewUser(String email, String password){
        registrationPage.proceedRegistration(email, password);
        return this;
    }

    @Step("Подтвердить регистрацию, получив сообщение о регистрации")
    public RegistrationStep confirmMessageOfRegistration() {
        registrationPage.confirmRegistration();
        return this;
    }
}
