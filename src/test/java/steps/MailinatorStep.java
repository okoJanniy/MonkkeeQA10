package steps;

import io.qameta.allure.Step;
import pages.MailinatorPage;

public class MailinatorStep {

    MailinatorPage mailinatorPage;

    public MailinatorStep() {
        mailinatorPage = new MailinatorPage();
    }

    @Step("Открыть страницу Mailinator")
    public MailinatorStep openMailinatorPage() {
        mailinatorPage.openPage();
        return this;
    }

    @Step("Перейти на нужный нам email")
    public MailinatorStep goToEmailBox(String email) {
        mailinatorPage.lookingForOurEmail(email);
        return this;
    }

    @Step("Подтвердить регистрацию и проверить результат")
    public MailinatorStep confirmRegistration() {
        mailinatorPage
                .confirmEmail()
                .checkRegistrationConfirmResult();
        return this;
    }
}


