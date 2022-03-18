package kms;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;


public class ThankYouForSignUpPage {

    public static final String THANK_YOU_FOR_SIGN_UP_PAGE_URL
            = "https://www.kmslh.com/saleforce-promotion-june-2020-thank-you/";

    @FindBy(how = How.CSS, using = "h1.elementor-heading-title")
    private SelenideElement greetingMessage;

    public boolean isGreetingMessageDisplayed() {
        return greetingMessage.shouldBe(visible).isDisplayed();
    }

    public String getThankYouForSignUpPageURL() {
        return url();
    }

}
