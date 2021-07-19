package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.*;
import utils.Generator;

public class BaseTest {

    RegistrationSteps registrationSteps;
    Generator generator;
    MailinatorSteps mailinatorSteps;
    LoginSteps loginSteps;
    EntrySteps entrySteps;
    MainSteps mainSteps;
    String email;
    String password;
    String header;
    String text;
    String tag;

    @BeforeClass
    public void openBrowser() {
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
        generator = new Generator();
        email = generator.generateRandomEmail();
        password = generator.generateRandomPassword();
        header = generator.generateRandomHeader();
        text = generator.generateRandomText();
        tag = generator.generateRandomTag();
        registrationSteps = new RegistrationSteps();
        mailinatorSteps = new MailinatorSteps();
        loginSteps = new LoginSteps();
        entrySteps = new EntrySteps();
        mainSteps = new MainSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
