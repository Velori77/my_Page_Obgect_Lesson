package pages;

import org.openqa.selenium.By;

public class IPhonePage extends BasePage {

  private final By priceIPhoneInUSD = By.xpath("//h2[text()='$101.00']");
  private final By elementCurrencyButton = By.xpath("//span[text()='Currency']");
  private final By elementSubMenuEuroButton = By.xpath("//button[text()='€ Euro']");
  private final By priceIPhoneInEuro = By.xpath("//h2[text()='86.93€']");
  private final By elementSubMenuPoundButton = By.xpath("//button[text()='£ Pound Sterling']");
  private final By priceIPhoneInPound = By.xpath("//button[text()='£ Pound Sterling']");

  public String actualPriceIPhoneInUSD() {
    return find(priceIPhoneInUSD).getText();
  }

  public IPhonePage clickOnTheElementCurrencyButton() {
    find(elementCurrencyButton).click();
    return this;
  }

  public IPhonePage clickOnTheElementSubMenuEuroButton() {
    find(elementSubMenuEuroButton).click();
    return this;
  }

  public String actualPriceIPhoneInEuro() {
    return find(priceIPhoneInEuro).getText();
  }

  public IPhonePage clickOnTheElementSubMenuPoundButton() {
    find(elementSubMenuPoundButton).click();
    return this;
  }

  public String  actualPriceIPhoneInPound() {
    return find(priceIPhoneInPound).getText();
  }

}
