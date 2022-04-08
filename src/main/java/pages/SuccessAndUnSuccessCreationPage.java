package pages;

import org.openqa.selenium.By;

public class SuccessAndUnSuccessCreationPage extends BasePage {

    private final By elementResultMessage = By.xpath("//div[@id='content']/h1");
    private final By elementWarningMessage = By.xpath("//div[text()='First Name must be between 1 and 32 characters!']");

    public String getSuccessText() {
        return getDriver().findElement(elementResultMessage).getText();
    }
    public String getUnSuccessText() {
        return getDriver().findElement(elementWarningMessage).getText();
    }

}
