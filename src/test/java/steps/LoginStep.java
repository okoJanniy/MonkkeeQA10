package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginStep {

    LoginPage loginPage;

    public LoginStep(){
        loginPage = new LoginPage();
    }

    @Step("Открыть monkkee.com страницу авторизации")
    public LoginStep openLoginPage() {
        loginPage.openPage();
        return this;
    }

    @Step("Заполнить форму: Email='{email}', Password='{password}'")
    public LoginStep fillFormForLogin(String email, String password){
        loginPage.proceedLogin(email, password);
        return this;
    }

    @Step("Подтвердить авторизацию")
    public LoginStep confirmAuthorization() {
        loginPage.checkThatNewUserIsAuthorized();
        return this;
    }
}
