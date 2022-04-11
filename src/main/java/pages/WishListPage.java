package pages;

import org.openqa.selenium.By;

public class WishListPage extends BasePage {

  private final By elementSamsungMonitor = By.xpath("//a[text()='Samsung SyncMaster 941BW']");
  private final By elementAppleMonitor = By.xpath("//a[text()='Apple Cinema 30\"']");

  public String getElementSamsungMonitorText() {
    return find(elementSamsungMonitor).getText();
  }

  public String getElementAppleMonitorText() {
    return find(elementAppleMonitor).getText();
  }
}
