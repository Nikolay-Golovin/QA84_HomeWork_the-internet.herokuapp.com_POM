package the_internet.herokuapp.com.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //  а тут сколько мы будешь ждать
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
    public void scrollWithJS(int x,int y){
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void clickWithJS(WebElement element, int x, int y) {
        scrollWithJS(x,y);
        js.executeScript("arguments[0].click();", element);// решение со скроллом независимо от разрегения экрана
    }

    public void typeWithJS(WebElement element,String text,int x,int y){
        scrollWithJS(x,y);
        type(element,text);
    }

    public Alert waitAlert() {
                return wait.until(ExpectedConditions.alertIsPresent());// как жмякнули на кнопку вызова алерта ждем как он появиться потом работаем с ним )
    }

    public void acceptAlert() {
        waitAlert().accept();// жмяк окей
    }
    public void dismissAlert() {
        waitAlert().dismiss();// жмяк кенсел
    }

    public void sendTextToAlert(String text) {
        Alert alert = waitAlert();
        if (text != null) { // просто проверка равен ли текст NULL
            alert.sendKeys(text);// если какой то текст а алерте в поле промт есть уже он просто допишит типо его после этого текста и выдаст результат , но в нашем случае текста нет ))))
        }
        alert.accept();// Жмякаем на кнопочку ОКЕЙ
    }

    public boolean isContainsText(String text, WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText().contains(text);
    }
}
