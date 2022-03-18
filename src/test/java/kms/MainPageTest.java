package kms;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static kms.ThankYouForSignUpPage.THANK_YOU_FOR_SIGN_UP_PAGE_URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPageTest extends BaseTest {
    public static final String EMAIL_POSTFIX = "@mycompany.com";
    public static final String PHONE_PREFIX = "+7";
    public static final String expectedYouTubeVideoTitle = "GE Healthcare: A KMS Lighthouse Success Story";

    String name = RandomStringUtils.randomAlphabetic(10);
    String lastName = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(7) + EMAIL_POSTFIX;
    String phoneNumber = PHONE_PREFIX + RandomStringUtils.randomNumeric(10);
    String companyName = RandomStringUtils.randomAlphabetic(10);

    @Test
    public void registrationPositiveTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .closeSubscribeNowModalWindow()
                .fillGetThreeMonthsFreeForm(name, lastName, email, phoneNumber, companyName);
        boolean isUserSignedUp = page(ThankYouForSignUpPage.class)
                .isGreetingMessageDisplayed();
        assertTrue("User registration failed", isUserSignedUp);

        String actualThankYouForSignUpPageUrl = page(ThankYouForSignUpPage.class)
                .getThankYouForSignUpPageURL();
        assertTrue("Actual URL does not match expected",
                actualThankYouForSignUpPageUrl.startsWith(THANK_YOU_FOR_SIGN_UP_PAGE_URL));
    }

    @Test
    public void checkSwitchToLighthouseYouTubeWorksPositiveTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .transitionToLighthouseYouTubePage();
        String actualYouTubeVideoTitle = page(YouTubeLighthousePage.class)
                .getVideoTitle();
        assertEquals("Expected YouTube video title is " + expectedYouTubeVideoTitle + ". But actual is "
                + actualYouTubeVideoTitle, expectedYouTubeVideoTitle, actualYouTubeVideoTitle);
    }
}
