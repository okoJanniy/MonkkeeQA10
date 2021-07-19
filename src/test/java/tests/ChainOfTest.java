package tests;

import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class ChainOfTest extends BaseTest {

    @Test(priority = 1, description = "Регистрация нового пользователя на сайте")
    @Link("https://my.monkkee.com/#/")
    public void registrationANewUser (){
        registrationStep
                .openRegistrationPage()
                .fillFormForRegistrationANewUser(email, password)
                .confirmMessageOfRegistration();
    }

    @Test(priority = 2, description = "Подтверждение регистрации по email")
    public void confirmMessageOnEmail (){
        mailinatorStep
                .openMailinatorPage()
                .goToEmailBox(email)
                .confirmRegistration();
    }

    @Test(priority = 3, description = "Авторизация пользователя на сайте")
    public void loginUser (){
        loginStep
                .openLoginPage()
                .fillFormForLogin(email, password)
                .confirmAuthorization();
    }

    @Test(priority = 4, description = "Добавление записи")
    public void checkAddingEntry() {
        loginStep
                .openLoginPage()
                .fillFormForLogin(email, password);
        mainStep.clickCreateNewEntry();
        entryStep.writeTextAndHeaderInToEntry(header, text)
                .goToMainPage();
        mainStep.checkEntryByData(header, text);
    }
}
