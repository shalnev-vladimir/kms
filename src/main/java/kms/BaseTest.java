package kms;

import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.webdriver;

public class BaseTest {

    @Before
    public void setUp() {
        Configuration.browserSize = "1920x1080";
    }
    @After
    public void tearDown() {
        webdriver().driver().close();
    }
}
