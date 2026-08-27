package the_internet.herokuapp.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.herokuapp.com.core.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement AlertsLink;


    public AlertsPage clickAlerts() {
        click(AlertsLink);
        return new AlertsPage(driver);
    }

    @FindBy(css = "a[href='/windows']")
    WebElement multipleWindowsLink;

    public MultipleWindows clickMultipleWindows() {
        click(multipleWindowsLink);
        return new MultipleWindows(driver);
    }

}
