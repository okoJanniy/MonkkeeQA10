package steps;

import io.qameta.allure.Step;
import pages.EditTagPage;

public class EditTagSteps {

    EditTagPage page;


    public EditTagSteps() {
        page = new EditTagPage();
    }

    @Step("Убедитесь, что открыта страница редактирования тега")
    public EditTagSteps checkOpened() {
        page.isPageOpened();
        return this;
    }

    @Step("Выбрать новый цвет тега - '{colorName}'")
    public EditTagSteps chooseNewTagColor(String colorName) {
        page.chooseTagColor(colorName);
        return this;
    }

    @Step("Сохранить изменения")
    public void saveChanges() {
        page.saveEditions();
    }

    @Step("Выбрать имя тега '{newTagName}'")
    public EditTagSteps changeTagName(String newTagName) {
        page.changeTagName(newTagName);
        return this;
    }
}