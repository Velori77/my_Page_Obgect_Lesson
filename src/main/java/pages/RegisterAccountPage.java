package pages;

import org.openqa.selenium.By;

public class RegisterAccountPage extends BasePage {

    private final By firstNameField = By.id("input-firstname");
    private final By lastNameField = By.id("input-lastname");
    private final By inputMailField = By.id("input-email");
    private final By inputTelephoneField = By.id("input-telephone");
    private final By inputPasswordField = By.id("input-password");
    private final By inputConfirm = By.id("input-confirm");
    private final By clickOnPrivacyPolicyButton = By.xpath("//input[@name='agree']");
    private final By clickOnContinueButton = By.xpath("//input[@value='Continue']");



    public RegisterAccountPage enterFirstNameField(String firstName) {
        find(firstNameField).sendKeys(firstName);
        return this;
    }

    public RegisterAccountPage enterLastNameField(String lastName) {
        find(lastNameField).sendKeys(lastName);
        return this;
    }
    
    public RegisterAccountPage enterMailField(String mail) {
        find(inputMailField).sendKeys(mail);
        return this;
    }

    public RegisterAccountPage enterTelephoneField(String telephoneField) {
        find(inputTelephoneField).sendKeys(telephoneField);
        return this;
    }

    public RegisterAccountPage enterPasswordField(String passwordField) {
        find(inputPasswordField).sendKeys(passwordField);
        return this;
    }

    public RegisterAccountPage enterConfirm(String confirm) {
        find(inputConfirm).sendKeys(confirm);
        return this;
    }

    public RegisterAccountPage clickOnPrivacyPolicyButton() {
        find(clickOnPrivacyPolicyButton).click();
        return this;
    }

    public SuccessAndUnSuccessCreationPage clickOnContinueButton() {
        find(clickOnContinueButton).click();
        return new SuccessAndUnSuccessCreationPage();
    }

}
