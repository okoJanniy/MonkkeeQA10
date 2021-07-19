package steps;

import io.qameta.allure.Step;
import pages.EntryPage;

public class EntrySteps {
    EntryPage entryPage;

    public EntrySteps() {
        entryPage = new EntryPage();
    }

    @Step("Заполнить entry: Header = '{header}', bodyText='{text}'")
    public EntrySteps writeTextAndHeaderInToEntry(String header, String text) {
        entryPage.isPageOpened();
        entryPage.fillEntry(header, text);
        return this;
    }

    @Step("Вернуться на главную страницу")
    public EntrySteps goToMainPage() {
        entryPage.backToMainPage();
        return this;
    }
}
