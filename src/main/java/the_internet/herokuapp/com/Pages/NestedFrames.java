package the_internet.herokuapp.com.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.herokuapp.com.core.BasePage;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

public class NestedFrames extends BasePage {

    public NestedFrames(WebDriver driver) {
        super(driver);
    }

@FindBy(css = "frame[name='frame-top']")
WebElement frameTop;

@FindBy(css="frame[name='frame-middle']")
WebElement frameMiddle;

@FindBy(css="frame[name='frame-right']")
WebElement frameRight;

@FindBy(css="frame[name='frame-left']")
WebElement frameLeft;

@FindBy(css ="frame[name='frame-bottom']")
WebElement frameBottom;

@FindBy(tagName = "body")
private WebElement body;

    public NestedFrames verifiButtonFtame (String text) {
        driver.switchTo().frame(frameBottom);
        Assertions.assertTrue(isContainsText("BOTTOM", body));
         return this;

    }
    public NestedFrames verifiLeftFtame(String text) {
        driver.switchTo().defaultContent();// Вернуться на главную страницу
        driver.switchTo().frame(frameTop);
        driver.switchTo().frame(frameLeft);
        Assertions.assertTrue(isContainsText("LEFT", body));
        driver.switchTo().defaultContent();
        return this;
    }
    public NestedFrames verifiMiddleFtame(String text) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameTop);
        driver.switchTo().frame(frameMiddle);
        Assertions.assertTrue(isContainsText("MIDDLE", body));
        driver.switchTo().defaultContent();
        return this;
    }
    public NestedFrames verifiRightFtame(String text) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameTop);
        driver.switchTo().frame(frameRight);
        Assertions.assertTrue(isContainsText("RIGHT", body));
        driver.switchTo().defaultContent();
        return this;
    }
}
