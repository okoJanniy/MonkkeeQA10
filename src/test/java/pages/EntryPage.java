package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

@Log4j2
public class EntryPage {

    private static final By HOME_BUTTON = id("back-to-overview");
    private static final By EDIT_ENTRY_AREA = id("editable");
    private static final By PANEL = id("cke_editable");
    private static final String BOLD_BUTTON = (".cke_button__bold_icon");
    private static final String CLOSE_BUTTON = (".cke_button__close_icon");

    public void openPage() {
        log.info("Opening Entry page");
        isPageOpened();
    }

    public void isPageOpened() {
        log.info("Entry page is opened");
        $(HOME_BUTTON).waitUntil(Condition.visible, 10000);
    }

    public void backToMainPage() {
        log.info("Back to Main/Home page");
        $(HOME_BUTTON).click();

    }

    public EntryPage fillEntry(String header, String text) {
        log.info("Click edit entry area");
        $(EDIT_ENTRY_AREA).click();
        log.info("Waiting for visibility panel");
        $(PANEL).shouldBe(Condition.visible);
        $(BOLD_BUTTON).click();
        log.info("Fill header field:" + header);
        $(EDIT_ENTRY_AREA).sendKeys(header);
        $(EDIT_ENTRY_AREA).sendKeys(Keys.RETURN);
        $(BOLD_BUTTON).click();
        log.info("Fill text field:" + text);
        $(EDIT_ENTRY_AREA).sendKeys(text);
        $(CLOSE_BUTTON).click();
        return this;
    }
}
