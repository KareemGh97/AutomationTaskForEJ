package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage {

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    public CompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getCompleteMessage() {
        return completeHeader.getText();
    }
}