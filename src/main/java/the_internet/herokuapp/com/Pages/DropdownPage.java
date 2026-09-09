package the_internet.herokuapp.com.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import the_internet.herokuapp.com.core.BasePage;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdownSelect;

    public DropdownPage selectOption(String optionText) {
        new Select(dropdownSelect).selectByVisibleText(optionText);
        return this;
    }
    public DropdownPage verifySelectedOption(String expectedOption) {
        String selected = new Select(dropdownSelect).getFirstSelectedOption().getText();
        Assertions.assertEquals(expectedOption, selected);
        return this;
    }
}
