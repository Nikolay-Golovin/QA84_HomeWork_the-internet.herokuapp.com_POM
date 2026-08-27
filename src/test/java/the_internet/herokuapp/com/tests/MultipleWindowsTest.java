package the_internet.herokuapp.com.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_internet.herokuapp.com.core.TestBase;
import the_internet.herokuapp.com.pages.HomePage;
import the_internet.herokuapp.com.pages.MultipleWindows;


public class MultipleWindowsTest extends TestBase {


   MultipleWindows multipleWindows;
   HomePage homePage;


    @BeforeEach
    public void setUp() {
        multipleWindows = new MultipleWindows(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void newTabTest() {
        homePage.clickMultipleWindows();
        multipleWindows.openNewWindow()
                .switchToTab(1)
                .verifyNewWindowHeader("New Window");
    }
}