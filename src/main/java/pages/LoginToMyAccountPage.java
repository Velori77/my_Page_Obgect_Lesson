package pages;

import org.openqa.selenium.By;

public class LoginToMyAccountPage extends BasePage {

    private final By inputEmail = By.id("input-email");
    private final By inputPassword = By.id("input-password");
    private final By loginButton = By.xpath("//input[@value='Login']");

    public LoginToMyAccountPage inputEmailValue(String email) {
        getDriver().findElement(inputEmail).sendKeys(email);
        return this;
    }
    public LoginToMyAccountPage inputPasswordValue(String password) {
        getDriver().findElement(inputPassword).sendKeys(password);
        return this;
    }
    public MyOwnCabinetPage clickOnLoginButton() {
        getDriver().findElement(loginButton).click();
        return new MyOwnCabinetPage();
    }
}
