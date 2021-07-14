package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.id;

@Log4j2
public class LoginPage {

    private static final String URL = "https://my.monkkee.com/#/";
    private static final String LOGIN_BUTTON = ".btn";
    private static final By EMAIL_INPUT = id("login");
    private static final By PASSWORD_INPUT = id("password");
    private static final String NEW_PAGE_HEADER = ".modal-header";
    private static final String CANCEL_BUTTON = "Cancel";

    public LoginPage openPage() {
        log.info("Opening Login page");
        open(URL);
        isPageOpened();
        return this;
    }

    public void isPageOpened() {
        log.info("Page is opened");
        $(LOGIN_BUTTON).waitUntil(Condition.visible, 10000);
    }

    public LoginPage proceedLogin(String email, String password) {
        log.info("Fill email field:" + email);
        $(EMAIL_INPUT).sendKeys(email);
        log.info("Fill password field:" + password);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return this;
    }

    public void checkThatNewUserIsAuthorized(){
        try {
            log.info("Waiting until modal page is opened");
            $(NEW_PAGE_HEADER).waitUntil(Condition.visible, 1000);
            log.info("Closing modal and login");
            $(byText(CANCEL_BUTTON)).waitUntil(Condition.visible, 7000).click();
        } catch (AssertionError e) {
        }
    }
}
