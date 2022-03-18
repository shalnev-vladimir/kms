package kms;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class YouTubeLighthousePage {

    @FindBy(how = How.CSS, using = "#info-contents .title")
    private SelenideElement videoTitle;

    public String getVideoTitle() {
        return videoTitle.shouldBe(visible).getText();
    }
}
