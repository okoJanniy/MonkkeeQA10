package steps;

import io.qameta.allure.Step;
import pages.MailinatorPage;

public class MailinatorSteps {

    MailinatorPage mailinatorPage;

    public MailinatorSteps() {
        mailinatorPage = new MailinatorPage();
    }

    @Step("Открыть страницу Mailinator")
    public MailinatorSteps openMailinatorPage() {
        mailinatorPage.openPage();
        return this;
    }

    @Step("Перейти на нужный нам email")
    public MailinatorSteps goToEmailBox(String email) {
        mailinatorPage.lookingForOurEmail(email);
        return this;
    }

    @Step("Подтвердить регистрацию и проверить результат")
    public MailinatorSteps confirmRegistration() {
        mailinatorPage
                .confirmEmail()
                .checkRegistrationConfirmResult();
        return this;
    }
}


