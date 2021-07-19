package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainStep {

    MainPage mainPage;

    public MainStep(){
        mainPage = new MainPage();
    }

    @Step("Перейти на страницу создания новой записи")
    public MainStep clickCreateNewEntry(){
        mainPage.clickNewEntry();
        return this;
    }

    @Step("Подтвердить созданную entry по введенным данным: header = '{header}'и text = '{text}'")
    public MainStep checkEntryByData(String header, String text){
        mainPage.isPageOpened();
        mainPage.checkEntryByHeader(header);
        mainPage.checkEntryByBodyText(text);
        return this;
    }
}
