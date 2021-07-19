package steps;

import io.qameta.allure.Step;
import pages.EntryPage;

public class EntryStep {
    EntryPage entryPage;

    public EntryStep(){
        entryPage = new EntryPage();
    }

    @Step("Заполнить entry: Header = '{header}', bodyText='{text}'")
    public EntryStep writeTextAndHeaderInToEntry (String header, String text){
        entryPage.isPageOpened();
        entryPage.fillEntry(header, text);
        return this;
    }

    @Step("Вернуться на главную страницу")
    public EntryStep goToMainPage() {
        entryPage.backToMainPage();
        return this;
    }
}
