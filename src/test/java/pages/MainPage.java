package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

@Log4j2
public class MainPage{

    private static final String URL = "https://my.monkkee.com/#/entries";
    private static final By SEARCH_INPUT = id("appendedInputButton");
    private static final By CREATE_ENTRY_BUTTON = By.id("create-entry");
    private static final String ENTRY_LOCATOR = ".entry";
    private static final String ENTRY_HEADER_TEXT = ".title ";
    private static final String ENTRY_BODY_TEXT = ".body ";

    public void openPage() {
        log.info("Opening Main page");
        sleep(1000);
        isPageOpened();
    }

    public void isPageOpened() {
        log.info("Main page is opened");
        $(SEARCH_INPUT).waitUntil(Condition.visible, 10000);
    }

    public void clickNewEntry() {
        log.info("Opening the 'Create a new Entry'");
        $(CREATE_ENTRY_BUTTON).click();
        sleep(1000);
    }

    public MainPage checkEntryByHeader(String header) {
        log.info("Create list of headers from Entries");
        List<String> listOfEntries = $$(byCssSelector(ENTRY_HEADER_TEXT)).texts();
        sleep(1000);
        log.info("Looking for a match of the entry header with the header:" + header);
        listOfEntries.contains(exactValue(header));
        return this;
    }

    public MainPage checkEntryByBodyText(String text) {
        log.info("Create list of body texts from Entries");
        List<String> listOfEntries = $$(byCssSelector(ENTRY_BODY_TEXT)).texts();
        sleep(1000);
        log.info("Looking for a match of the entry body with the body text:" + text);
        listOfEntries.contains(exactValue(text));
        return this;
    }
}
