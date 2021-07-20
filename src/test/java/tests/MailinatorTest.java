package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;


public class MailinatorTest extends BaseTest {

    @Test(description = "Подтверждение сообщение о регистрации")
    public void confirmRegistrationMessage() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        mailinator
                .openMailinatorPage()
                .goToEmailBox(properties.getProperty("userEmail"))
                .confirmRegistration();
    }
}
