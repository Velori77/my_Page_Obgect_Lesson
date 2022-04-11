package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductBlock {

  private WebElement webElement;

  public ProductBlock(WebElement webElement) {
    this.webElement = webElement;

  }

  public double getNewPrice() {
    return Double.parseDouble(
        webElement.findElement(By.className("price-new")).getText().replace("$", ""));
  }

  public double getOldPrice() {
    return Double.parseDouble(
        webElement.findElement(By.className("price-old")).getText().replace("$", ""));
  }

  public double getExRatePrice() {
    return Double.parseDouble(
        webElement.findElement(By.className("price-tax")).getText().split("\\$")[1]);
  }
}
