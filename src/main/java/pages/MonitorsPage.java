package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MonitorsPage extends BasePage {

  private final By productsMonitorsWishListButton = By.xpath("//i[@class ='fa fa-heart']");
  private final By wishListButton = By.id("wishlist-total");


  public MonitorsPage addToWishList(String productName) {
    String xpath = String.format(
        "//img[@title='%s']/../../..//button[@data-original-title='Add to Wish List']",
        productName);
    find(By.xpath(xpath)).click();
    return this;
  }

  public MonitorsPage clickOnMonitorSamsungWishListButton() {
    List<WebElement> products = getDriver().findElements(productsMonitorsWishListButton);
    products.get(1).click();
    return this;
  }

  public WishListPage clickOnWishListButton() {
    find(wishListButton).click();
    return new WishListPage();
  }
}
