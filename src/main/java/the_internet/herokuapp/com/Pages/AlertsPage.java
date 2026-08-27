package the_internet.herokuapp.com.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.herokuapp.com.core.BasePage;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
         super(driver);
    }
    @FindBy(css = "button[onclick='jsAlert()']")
    WebElement AlertButton;
    @FindBy(css = "button[onclick='jsConfirm()']")
    WebElement jsConfirmButton;
    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement jsPromptButton;
    @FindBy(id = "result")
    WebElement textResult;

    public AlertsPage clickJsAlert() {
        click(AlertButton);
        acceptAlert();
        return this;
    }
    public AlertsPage clickJsConfirm(String result) {
        click(jsConfirmButton);
        if (result != null && result.equals("Ok")){
            driver.switchTo().alert().accept();// accept ->OK
        }else if (result != null && result.equals("Cancel")){
            driver.switchTo().alert().dismiss();//dismiss ->same cancel
        }
        return this;
    }

    public AlertsPage clickJsPrompt(String text) {
        click(jsPromptButton);
        sendTextToAlert(text);
        return this;
    }

    public AlertsPage verifyResult(String expectedText) {
        Assertions.assertTrue(isContainsText(expectedText, textResult));
        return this;
    }
}
