package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private final By yourStoreRegistrationMyAccountButton = By.xpath("//span[text()='My Account']");
    private final By myAccountRegisterSubMenuButton = By.xpath("//a[text()='Register']");
    private final By myAccountLoginSubMenuButton = By.xpath("//a[text()='Login']");


    public MainPage clickOnMyAccountButton() {
        getDriver().findElement(yourStoreRegistrationMyAccountButton).click();
        return this;
    }
    public RegisterAccountPage clickOnRegisterSubMenuButton() {
        getDriver().findElement(myAccountRegisterSubMenuButton).click();
        return new RegisterAccountPage();
    }
    public LoginToMyAccountPage clickOnLoginSubMenuButton() {
        getDriver().findElement(myAccountLoginSubMenuButton).click();
        return new LoginToMyAccountPage();
    }

}
