package pages;

import org.openqa.selenium.By;

public class LoginToMyAccountPage extends BasePage {

    private final By inputEmail = By.id("input-email");
    private final By inputPassword = By.id("input-password");
    private final By loginButton = By.xpath("//input[@value='Login']");

    public LoginToMyAccountPage inputEmailValue(String email) {
        find(inputEmail).sendKeys(email);
        return this;
    }
    public LoginToMyAccountPage inputPasswordValue(String password) {
        find(inputPassword).sendKeys(password);
        return this;
    }
    public MyOwnCabinetPage clickOnLoginButton() {
        find(loginButton).click();
        return new MyOwnCabinetPage();
    }
}
