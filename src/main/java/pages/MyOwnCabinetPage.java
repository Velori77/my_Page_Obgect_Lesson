package pages;

import org.openqa.selenium.By;

public class MyOwnCabinetPage extends BasePage {

    private final By myAccountText = By.xpath("//h2[text()='My Account']");

    public MyOwnCabinetPage expectedMyAccountText(String myAccountString) {
        getDriver().findElement(myAccountText).getText();
        return this;
    }
}
/*     //Checking appearance actual My Account Text
       WebElement myAccountText = driver.findElement(By.xpath("//h2[text()='My Account']"));
       String actualMyAccountText = myAccountText.getText();*/
