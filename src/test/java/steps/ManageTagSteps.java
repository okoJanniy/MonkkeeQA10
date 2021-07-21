package steps;

import io.qameta.allure.Step;
import pages.ManageTagsPage;

public class ManageTagSteps {

    ManageTagsPage page;

    public ManageTagSteps() {
        page = new ManageTagsPage();
    }


    @Step("Проверить что страница управления тегами открыта")
    public ManageTagSteps checkOpened() {
        page.isPageOpened();
        return this;
    }

    @Step("Удалить первый тег в списке")
    public ManageTagSteps deleteTag() {
        page.deleteTag();
        return this;
    }

    @Step("Перейти на страницу редактора тегов")
    public void goToTagEdit() {
        page.goToTagEdit();
    }

    @Step("Проверить тег int color editions '{tagName}', ожидаемый цвет - '{colorName}'")
    public ManageTagSteps checkColor(String colorName, String tagName) {
        page.checkTagColor(colorName, tagName);
        return this;
    }

    @Step("Проверить имя нового тега - '{tagName}'")
    public ManageTagSteps checkTagName(String tagName) {
        page.checkTagName(tagName);
        return this;
    }
}