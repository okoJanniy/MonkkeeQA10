package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    MainPage mainPage;

    public MainSteps() {
        mainPage = new MainPage();
    }

    @Step("Перейти на страницу создания новой записи")
    public MainSteps clickCreateNewEntry() {
        mainPage.clickNewEntry();
        return this;
    }

    @Step("Подтвердить созданную entry по введенным данным: header = '{header}'и text = '{text}'")
    public MainSteps checkEntryByData(String header, String text){
        mainPage.isPageOpened();
        mainPage.checkEntryByHeader(header);
        mainPage.checkEntryByBodyText(text);
        return this;
    }
}
