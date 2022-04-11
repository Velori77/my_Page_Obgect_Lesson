package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private final By yourStoreRegistrationMyAccountButton = By.xpath("//span[text()='My Account']");
    private final By myAccountRegisterSubMenuButton = By.xpath("//a[text()='Register']");
    private final By myAccountLoginSubMenuButton = By.xpath("//a[text()='Login']");
    private final By currentCurrencySingh = By.xpath("//strong[text()='$']");
    private final By iPhoneButton = By.xpath("//img[@alt='iPhone']");
    private final By cameraMenuButton = By.xpath("//a[text()='Cameras']");

    public MainPage clickOnMyAccountButton() {
        find(yourStoreRegistrationMyAccountButton).click();
        return this;
    }
    public RegisterAccountPage clickOnRegisterSubMenuButton() {
        find(myAccountRegisterSubMenuButton).click();
        return new RegisterAccountPage();
    }
    public LoginToMyAccountPage clickOnLoginSubMenuButton() {
        find(myAccountLoginSubMenuButton).click();
        return new LoginToMyAccountPage();
    }

    public String checkTheCurrentCurrencySingh(){
        return find(currentCurrencySingh).getText();
    }

    public IPhonePage clickOnIPhoneProductButton() {
        find(iPhoneButton).click();
        return new IPhonePage();
    }

    public CameraPage clickCameraMenuButton() {
        find(cameraMenuButton).click();
        return new CameraPage();
    }

}
