package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  private static WebDriver driver;

  public static WebDriver getDriver() {
    return driver;
  }

  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }

  public void hoverMouseOverComponentsMenuButton(By locator) {
      WebElement element = find(locator);
      Actions actions = new Actions(getDriver());
      actions.moveToElement(element).build().perform();
  }

  public WebElement find(By locator) {
      return getDriver().findElement(locator);
  }

  public WebElement waitUntilVisible(By locator, int seconds) {
      return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
          .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }



}

