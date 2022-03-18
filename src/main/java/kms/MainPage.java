package kms;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;

public class MainPage {

    public static final String MAIN_PAGE_URL = "https://www.kmslh.com/automation-test/";

    @FindBy(how = How.CSS, using = ".leadin-preview-wrapper:last-child")
    private SelenideElement subscribeNowModalWindow;

    // click X button to close modal window
    @FindBy(how = How.CSS, using = ".leadinModal-content:last-child > .leadinModal-close")
    private SelenideElement subscribeNowModalWindowXButton;

    @FindBy(how = How.CSS, using = ".initial-message-bubble")
    private SelenideElement messageBubble;

    // click to close message bubble .InitialMessageBubble__CloseButton-sc-1ioasks-2.elUvIe
    @FindBy(how = How.CSS, using = ".VizExIcon__IconWrapper-sc-1320isw-0.gsyupS")
    private SelenideElement messageBubbleXButton;

    @FindBy(how = How.CSS, using = "div.hs-cookie-notification-position-bottom")
    private SelenideElement cookiesNotification;

    @FindBy(how = How.CSS, using = "div #hs-eu-confirmation-button")
    private SelenideElement acceptCookiesButton;

    @FindBy(how = How.CSS, using = "#firstname-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private SelenideElement firstNameInput;

    @FindBy(how = How.CSS, using = "#lastname-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private SelenideElement lastNameInput;

    @FindBy(how = How.CSS, using = "#email-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private SelenideElement emailInput;

    @FindBy(how = How.CSS, using = "#phone-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private SelenideElement phoneInput;

    @FindBy(how = How.CSS, using = "#company-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private SelenideElement companyNameInput;

    @FindBy(how = How.CSS, using = ".hs-button.primary")
    private SelenideElement submitButton;

    @FindBy(how = How.CSS, using = "#leadinModal-content-wrapper-2379091 a")
    private SelenideElement watchTheVideoHref;

    public YouTubeLighthousePage transitionToLighthouseYouTubePage() {
        subscribeNowModalWindow.shouldBe(visible);
        watchTheVideoHref.click();
        switchTo().window(1);
        return page(YouTubeLighthousePage.class);
    }

    public MainPage closeSubscribeNowModalWindow() {
        if (subscribeNowModalWindow.scrollTo().shouldBe(visible).isDisplayed()) {
            subscribeNowModalWindowXButton.shouldBe(enabled).click();
        } else {
            return this;
        }
        return this;
    }

    public MainPage closeMessageBubble() {
        if (messageBubble.shouldBe(visible).isDisplayed()) {
            messageBubbleXButton.hover().click();
        } else {
            return this;
        }
        return this;
    }

    public MainPage acceptCookies() {
        if (cookiesNotification.isDisplayed()) {
            acceptCookiesButton.shouldBe(enabled).click();
        } else {
            return this;
        }
        return this;
    }

    public void setFirstNameInput(String firstName) {
        firstNameInput.scrollTo().sendKeys(firstName);
    }

    public void setLastNameInput(String lastName) {
        lastNameInput.scrollTo().sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailInput.scrollTo().sendKeys(email);
    }

    public void setPhone(String phone) {
        phoneInput.scrollTo().sendKeys(phone);
    }

    public void setCompanyName(String companyName) {
        companyNameInput.scrollTo().sendKeys(companyName);
    }

    public void clickSubmitButton() {
        submitButton.scrollTo().shouldBe(enabled).click();
    }

    public ThankYouForSignUpPage fillGetThreeMonthsFreeForm
            (String firstName, String lastName, String email, String phone, String companyName) {
        setFirstNameInput(firstName);
        setLastNameInput(lastName);
        setEmail(email);
        setPhone(phone);
        setCompanyName(companyName);
        clickSubmitButton();

        return page(ThankYouForSignUpPage.class);
    }
}
