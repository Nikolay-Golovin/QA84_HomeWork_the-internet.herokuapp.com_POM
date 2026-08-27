package the_internet.herokuapp.com.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_internet.herokuapp.com.core.TestBase;
import the_internet.herokuapp.com.pages.HomePage;
import the_internet.herokuapp.com.pages.AlertsPage;

public class AlertsTests extends TestBase {

    private AlertsPage alertsPage;

    @BeforeEach
    public void setUp() {
        alertsPage = new HomePage(driver).clickAlerts();
    }
    @Test
    public void jsAlertTest() {
        alertsPage.clickJsAlert()
                .verifyResult("You successfully clicked an alert");
    }
    @Test
    public void jsConfirmOkTest() {
        alertsPage.clickJsConfirm("Ok")
                .verifyResult("You clicked: Ok");
    }
    @Test
    public void jsConfirmCancelTest() {
        alertsPage.clickJsConfirm("Cancel")
                .verifyResult("You clicked: Cancel");
    }
    @Test
    public void jsPromptTest() {
        alertsPage.clickJsPrompt("QA84 AutoTest")
                .verifyResult("You entered: QA84 AutoTest");
    }
}

