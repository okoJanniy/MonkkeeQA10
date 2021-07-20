package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    MainPage page;

    public MainSteps() {
        page = new MainPage();
    }

    @Step("Проверить открытую главную страницу")
    public MainSteps checkOpened() {
        page.isPageOpened();
        return this;
    }

    @Step("Удалить все записи")
    public MainSteps deleteAllEntries() {
        page.deleteAllEntries();
        return this;
    }

    @Step("Удалить одну запись по номеру '{elementNumber}'")
    public MainSteps deleteOneEntry(int elementNumber) {
        page.deleteOneEntry(elementNumber);
        return this;
    }

    @Step("Зайти в запись по номеру '{elementNumber}'")
    public MainSteps goInEntry(int elementNumber) {
        page.goInEntry(elementNumber);
        return this;
    }

    @Step("Нажмите кнопку создания записи")
    public MainSteps clickCreateEntry() {
        page.clickCreateEntryButton();
        return this;
    }

    @Step("Перейти на страницу управления тегами")
    public MainSteps clickManageTagsLink() {
        page.clickManageTagsLink();
        return this;
    }

    @Step("Искать запись по тексту заголовка '{text}'")
    public MainSteps searchEntryByHeaderText(String text) {
        page.searchEntryByHeaderText(text);
        return this;
    }

    @Step("Искать запись по основному тексту '{text}'")
    public MainSteps searchEntryByBodyText(String text) {
        page.searchEntryByBodyText(text);
        return this;
    }


    @Step("Искать запись по тегу '{text}'")
    public MainSteps searchEntryByTag(String text) {
        page
                .searchEntryByTag(text)
                .checkEntryCountWithTag(text);
        return this;
    }

    @Step("Проверить созданную запись по заголовку - '{headerText}', text - '{bodyText}' and tag - '{tagName}'")
    public MainSteps checkAddedEntryByData(String headerText, String bodyText, String tagName) {
        page.checkEntryAdded(headerText, bodyText, tagName);
        return this;
    }

    @Step("Количество возвращаемых записей")
    public int entriesCount() {
        return page.checkEntriesCount();
    }

    @Step("Сравнить количество записей до и после удаления")
    public MainSteps entriesCount(int entriesBeforeDeleting) {
        page.checkEntriesCount(entriesBeforeDeleting);
        return this;
    }

    @Step("Проверить отсутствие записей с помощью удаляющего тега")
    public MainSteps checkLackOfEntries() {
        page.checkLackOfEntries();
        return this;
    }

    @Step("Открыть главную страницу")
    public MainSteps openPage() {
        page.openPage();
        return this;
    }
}