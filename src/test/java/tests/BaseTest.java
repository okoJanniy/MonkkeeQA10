package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.*;
import utils.Generator;

public class BaseTest {

   RegistrationStep registrationStep;
   Generator generator;
   MailinatorStep mailinatorStep;
   LoginStep loginStep;
   EntryStep entryStep;
   MainStep mainStep;
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
        registrationStep = new RegistrationStep();
        mailinatorStep = new MailinatorStep();
        loginStep = new LoginStep();
        entryStep = new EntryStep();
        mainStep = new MainStep();
    }

    @AfterMethod
    public void closeBrowser()
    {
        Selenide.closeWebDriver();
    }
}
