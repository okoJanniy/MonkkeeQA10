package steps;

import io.qameta.allure.Step;
import pages.EntryPage;

public class EntrySteps {

    EntryPage page;

    public EntrySteps() {
        page = new EntryPage();
    }

    @Step("Открыта страница проверки входа")
    public EntrySteps checkOpened() {
        page.isPageOpened();
        return this;
    }

    @Step("Редактировать текст записи, Header='{headerText}' Text='{bodyText}'")
    public EntrySteps editEntryText(String headerText, String bodyText) {
        page.changeEntryText(headerText, bodyText);
        return this;
    }

    @Step("Добавить новый тег - '{newTag}' in entry")
    public EntrySteps addNewTag(String newTag) {
        page.addNewTagInEntry(newTag);
        return this;
    }

    @Step("Добавить существующий тег в запись")
    public EntrySteps addTag(String existTag) {
        page.addExistTagInEntry(existTag);
        return this;
    }

    @Step("Переход на главную страницу")
    public void goMain() {
        page.goMain();
    }

    @Step("Удалить запись кнопкой внутри")
    public void deleteEntryInside() {
        page.deleteEntry();
    }

    @Step("Удалить тэг - '{tagName}' in entry")
    public EntrySteps deleteTag(String tagName) {
        page.deleteTag(tagName);
        return this;
    }
}