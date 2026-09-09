package the_internet.herokuapp.com.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_internet.herokuapp.com.core.TestBase;
import the_internet.herokuapp.com.pages.DropdownPage;
import the_internet.herokuapp.com.pages.HomePage;

public class DropdownTest extends TestBase {

    HomePage homePage;
    DropdownPage dropdownPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
        dropdownPage = new DropdownPage(driver);
    }

    @Test
    public void selectOption1Test() {
        homePage.clickDropdown();
        dropdownPage.selectOption("Option 1")
                .verifySelectedOption("Option 1");
    }

    @Test
    public void selectOption2Test() {
        homePage.clickDropdown();
        dropdownPage.selectOption("Option 2")
                .verifySelectedOption("Option 2");
    }
}
