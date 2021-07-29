package tests;

import models.RandomEntryData;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;


public class SearchEntryByTagTest extends BaseTest {

    RandomEntryData entryData = new RandomEntryData();
    String headerText = entryData.generateRandomHeader();
    String bodyText = entryData.generateRandomBody();
    String newTag = entryData.generateRandomTag();

    @Ignore("Тест нашел баг: При создании тега, не всегда ему присваивается значение в скобках, что дает невозможным включить его в счетчик")
    @Test(description = "Поиск записей по тегу")
    public void searchEntriesByTag() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn(properties.getProperty("userEmail"), properties.getProperty("userPassword"));
        mainsteps
                .checkOpened()
                .clickCreateEntry();
        entrysteps
                .checkOpened()
                .editEntryText(headerText, bodyText)
                .addNewTag(newTag)
                .goMain();
        mainsteps
                .checkOpened()
                .searchEntryByTag(newTag);
        headersteps.logOut();
    }
}