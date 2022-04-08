package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsExecutor {
    private JavascriptExecutor executor;

    public JsExecutor(WebDriver driver) {
        this.executor = (JavascriptExecutor) driver;
    }


    public void scrollIntoView(WebElement element) {
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
