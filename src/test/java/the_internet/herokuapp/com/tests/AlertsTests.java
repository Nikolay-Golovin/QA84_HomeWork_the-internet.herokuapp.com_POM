package the_internet.herokuapp.com.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_internet.herokuapp.com.core.TestBase;
import the_internet.herokuapp.com.pages.HomePage;
import the_internet.herokuapp.com.pages.AlertsPage;

public class AlertsTests extends TestBase {

   AlertsPage alertsPage;
   HomePage homePage;

    @BeforeEach
    public void setUp() {
       alertsPage = new AlertsPage(driver);
       homePage = new HomePage(driver);
    }
    @Test
    public void jsAlertTest() {
        homePage.clickAlerts();
        alertsPage.clickJsAlert()
                .verifyResult("You successfully clicked an alert");
    }
    @Test
    public void jsConfirmOkTest() {
        homePage.clickAlerts();
        alertsPage.clickJsConfirm("Ok")
                .verifyResult("You clicked: Ok");
    }
    @Test
    public void jsConfirmCancelTest() {
        homePage.clickAlerts();
        alertsPage.clickJsConfirm("Cancel")
                .verifyResult("You clicked: Cancel");
    }
    @Test
    public void jsPromptTest() {
        homePage.clickAlerts();
        alertsPage.clickJsPrompt("QA84 AutoTest")
                .verifyResult("You entered: QA84 AutoTest");
    }
}

