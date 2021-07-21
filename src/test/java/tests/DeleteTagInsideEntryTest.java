package tests;

import models.RandomEntryData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;


public class DeleteTagInsideEntryTest extends BaseTest {

    RandomEntryData entryData = new RandomEntryData();
    String newTag = entryData.generateRandomTag();

    @Test(description = "Удалить тег внутри записи")
    public void deleteTagInsideEntry() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn(properties.getProperty("userEmail"), properties.getProperty("userPassword"));
        mainsteps
                .checkOpened()
                .clickCreateEntry();
        entrysteps
                .checkOpened()
                .addNewTag(newTag)
                .goMain();
        mainsteps
                .checkOpened()
                .searchEntryByTag(newTag)
                .goInEntry(1);
        entrysteps
                .checkOpened()
                .deleteTag(newTag)
                .goMain();
        mainsteps
                .checkOpened()
                .searchEntryByTag(newTag)
                .checkLackOfEntries();
        headersteps.logOut();
    }
}