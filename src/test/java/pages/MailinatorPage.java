package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

@Log4j2
public class MailinatorPage {

    private static final String URL = "https://www.mailinator.com/";
    private static final By ENTER_MAILINATOR_INBOX = id("addOverlay");
    private static final By GO_BUTTON = id("go-to-public");
    private static final By TRASH_ICON = cssSelector("Delete Button");
    private static final String REGISTRATION_MESSAGE = "Welcome to monkkee";
    private static final String MESSAGE_FRAME = "msg_body";
    private static final String CONFIRM_BUTTON = "//a[contains(text(),'Confirm')]";
    private static final String CONFIRMATION_MESSAGE = "h1";

    public void openPage() {
        log.info("Opening Mailinator page");
        open(URL);
        sleep(1000);
        isPageOpened();
    }

    public void isPageOpened() {
        log.info("Mailinator page is opened");
        $(ENTER_MAILINATOR_INBOX).waitUntil(Condition.visible, 10000);
    }

    public MailinatorPage lookingForOurEmail(String email) {
        log.info("Fill email field:" + email);
        $(ENTER_MAILINATOR_INBOX).sendKeys(email);
        log.info("Press Go button");
        $(GO_BUTTON).click();
        $(TRASH_ICON).shouldBe(Condition.visible);
        return this;
    }

    public MailinatorPage confirmEmail() {
        log.info("Looking for email by title and opening it");
        $(byText(REGISTRATION_MESSAGE)).click();
        switchTo().frame(MESSAGE_FRAME);
        log.info("Confirm Registration");
        $(By.xpath(CONFIRM_BUTTON)).click();
        return this;
    }

    public MailinatorPage checkRegistrationConfirmResult() {
        switchTo().window(1);
        sleep(2000);
        try {
            log.info("Checking registration message");
            $(CONFIRMATION_MESSAGE).shouldBe(Condition.text("Registration confirmed successfully"));
        } catch (ElementShould e) {
            log.info("Checking registration message");
            $(CONFIRMATION_MESSAGE).shouldBe(Condition.text("Confirmation failed"));
            Assert.fail("Probably this user is already registered");
        }
        return this;
    }
}
