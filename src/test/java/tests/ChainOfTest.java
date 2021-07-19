package tests;

import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class ChainOfTest extends BaseTest {

    @Test(description = "Регистрация нового пользователя на сайте")
    @Link("https://my.monkkee.com/#/")
    public void registrationANewUser() {
        registrationSteps
                .openRegistrationPage()
                .fillFormForRegistrationANewUser(email, password)
                .confirmMessageOfRegistration();
    }

    @Test(description = "Подтверждение регистрации по email")
    public void confirmMessageOnEmail() {
        mailinatorSteps
                .openMailinatorPage()
                .goToEmailBox(email)
                .confirmRegistration();
    }

    @Test(description = "Авторизация пользователя на сайте")
    public void loginUser() {
        loginSteps
                .openLoginPage()
                .fillFormForLogin(email, password)
                .confirmAuthorization();
    }

    @Test(description = "Добавление записи")
    public void checkAddingEntry() {
        loginSteps
                .openLoginPage()
                .fillFormForLogin(email, password);
        mainSteps.clickCreateNewEntry();
        entrySteps.writeTextAndHeaderInToEntry(header, text)
                .goToMainPage();
        mainSteps.checkEntryByData(header, text);
    }
}
