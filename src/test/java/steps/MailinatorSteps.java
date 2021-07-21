package steps;

import io.qameta.allure.Step;
import pages.MailinatorPage;

public class MailinatorSteps {

    MailinatorPage page;

    public MailinatorSteps() {
        page = new MailinatorPage();
    }

    @Step("Открыть страницу редактирования профиля")
    public MailinatorSteps openMailinatorPage() {
        page.openPage();
        return this;
    }

    @Step("Перейти к emailBox '{email}'")
    public MailinatorSteps goToEmailBox(String email) {
        page.goToEmailBox(email);
        return this;
    }

    @Step("Подтвердить регистрацию")
    public MailinatorSteps confirmRegistration() {
        page
                .goToMailAndConfirm()
                .checkRegistrationConfirmResult();
        return this;
    }
}

