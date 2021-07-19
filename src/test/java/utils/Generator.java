package utils;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

@Log4j2
public class Generator {

    public String generateRandomEmail() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        log.info("Generating email");
      return fakeValuesService.bothify("????????##@mailinator.com");
    }

    public String generateRandomPassword() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        log.info("Generating password");
        return fakeValuesService.bothify("?????###??###");
    }

    public String generateRandomHeader() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        log.info("Generating text for header");
        return fakeValuesService.bothify("Header of entry is ??????");
    }

    public String generateRandomText() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        log.info("Generating text for body");
        return fakeValuesService.bothify("Text of entry is ?????? ## ? ????");
    }

    public String generateRandomTag() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        log.info("Generating tag");
        return fakeValuesService.bothify("TagIs???#?");
    }
}
