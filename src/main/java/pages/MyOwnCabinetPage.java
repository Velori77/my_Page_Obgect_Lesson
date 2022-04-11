package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyOwnCabinetPage extends BasePage {

    private final By myAccountText = By.xpath("//h2[text()='My Account']");
    private final By elementComponentsMenu = By.xpath("//a[text()='Components']");
    private final By elementMonitorsMenu = By.xpath("//a[text()='Monitors (2)']");

    public String expectedMyAccountText() {
        return find(myAccountText).getText();
    }

    public MyOwnCabinetPage hoverMouseOverComponentsMenuButton() {
        find(elementComponentsMenu).click();
        return this;
    }

    public MonitorsPage clickOnMonitorsMenuButton() {
        find(elementMonitorsMenu).click();
        return new MonitorsPage();
    }


}

