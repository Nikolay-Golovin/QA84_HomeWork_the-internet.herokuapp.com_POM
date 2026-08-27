package the_internet.herokuapp.com.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.herokuapp.com.core.BasePage;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindows extends BasePage {

    public MultipleWindows(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/windows/new']")
    WebElement newWindowLink;
      public MultipleWindows openNewWindow() {
        click(newWindowLink);
        return this;
    }
    public MultipleWindows switchToTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }
    @FindBy(xpath = "//h3[text()='New Window']")
    WebElement example;

    public MultipleWindows verifyNewWindowHeader(String expectedText) {
               Assertions.assertTrue(shouldHaveText(example,expectedText,5));
               return this;
    }
}