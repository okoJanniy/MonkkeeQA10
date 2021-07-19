package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Открыть monkkee.com страницу авторизации")
    public LoginSteps openLoginPage() {
        loginPage.openPage();
        return this;
    }

    @Step("Заполнить форму: Email='{email}', Password='{password}'")
    public LoginSteps fillFormForLogin(String email, String password) {
        loginPage.proceedLogin(email, password);
        return this;
    }

    @Step("Подтвердить авторизацию")
    public LoginSteps confirmAuthorization() {
        loginPage.checkThatNewUserIsAuthorized();
        return this;
    }
}
