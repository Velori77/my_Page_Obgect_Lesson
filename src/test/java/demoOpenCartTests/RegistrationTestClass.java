package demoOpenCartTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.JsExecutor;

public class RegistrationTestClass {
    private WebDriver driver;
    private JsExecutor jsExecutor;
    private WebDriverWait waiter;


    @Test(priority = 1)
    public void checkCreationMyAccountTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

        String expectedResultFirstName = "Nataliya";
        String expectedResultLastName = "Golovco";
        String expectedResultEMail = "NataGolovco+2@ua.com";
        String expectedResultTelephone = "+38-096-777-88-99";
        String expectedResultPassword = "Asdfghjkl;'";
        String expectedResultPasswordConfirm = "Asdfghjkl;'";

        String expectedResultMessage = "Your Account Has Been Created!";

        //Click on icon My Account and Register
        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        //Filling the fields
        driver.findElement(By.id("input-firstname")).sendKeys(expectedResultFirstName);
        driver.findElement(By.id("input-lastname")).sendKeys(expectedResultLastName);
        driver.findElement(By.id("input-email")).sendKeys(expectedResultEMail);
        driver.findElement(By.id("input-telephone")).sendKeys(expectedResultTelephone);
        driver.findElement(By.id("input-password")).sendKeys(expectedResultPassword);
        driver.findElement(By.id("input-confirm")).sendKeys(expectedResultPasswordConfirm);
        //Click the agreement
        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicy.click();
        //Click the Continue
        WebElement elementContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
        elementContinue.click();
        //Appearance success registration
        WebElement elementResultMessage = driver.findElement(By.xpath("//div[@id='content']/h1"));
        String actualResultMessage = elementResultMessage.getText();

        Assertions.assertThat(actualResultMessage).as("Expected text " + expectedResultMessage + " not exist on the Page")
                .isEqualTo(expectedResultMessage);

        driver.quit();

    }

    @Test(priority = 2)
    public void checkAppearanceMessageLengthFirstNameTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

        String expectedResultLastName = "Golovco";
        String expectedResultEMail = "NataGolovco+2@ua.com";
        String expectedResultTelephone = "+38-096-777-88-99";
        String expectedResultPassword = "Asdfghjkl;'";
        String expectedResultPasswordConfirm = "Asdfghjkl;'";

        String expectedResultWarningMessageText = "First Name must be between 1 and 32 characters!";

        //Click on icon My Account and Register
        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        //Filling the fields excepted First name
        driver.findElement(By.id("input-lastname")).sendKeys(expectedResultLastName);
        driver.findElement(By.id("input-email")).sendKeys(expectedResultEMail);
        driver.findElement(By.id("input-telephone")).sendKeys(expectedResultTelephone);
        driver.findElement(By.id("input-password")).sendKeys(expectedResultPassword);
        driver.findElement(By.id("input-confirm")).sendKeys(expectedResultPasswordConfirm);
        //Click the agreement
        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicy.click();
        //Click the Continue
        WebElement elementContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
        elementContinue.click();
        //Appearance warning text
        WebElement elementWarningMessageText = driver.findElement(By.xpath(
                "//div[text()='First Name must be between 1 and 32 characters!']"));
        String actualResultWarningMessageText = elementWarningMessageText.getText();

        Assertions.assertThat(actualResultWarningMessageText).as("Expected text " + expectedResultWarningMessageText + " not exist on the Page")
                .isEqualTo(expectedResultWarningMessageText);

        driver.quit();
    }

    @Test(priority = 3)
    public void checkAppearanceMyAccountMenuOnTheLeftSideTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

        String inputEMail = "NataGolovco+2@ua.com";
        String inputPassword = "Asdfghjkl;'";
        String expectedMyAccountOnTheLeftSideText = "My Account";

        //Click on icon My Account and Login
        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();
        WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
        login.click();
        //Login to the own cabinet
        driver.findElement(By.id("input-email")).sendKeys(inputEMail);
        driver.findElement(By.id("input-password")).sendKeys(inputPassword);
        //Click on the Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        //Looking for My Account Text
        WebElement myAccountText = driver.findElement(By.xpath("//h2[text()='My Account']"));
        String actualMyAccountText = myAccountText.getText();
        //Checking appearance actual My Account Text
        Assertions.assertThat(actualMyAccountText)
                .as("Expected text " + expectedMyAccountOnTheLeftSideText + " not exist on the Page")
                .isEqualTo(expectedMyAccountOnTheLeftSideText);

    }
    @Test(priority = 4)
    public void checkExistingTwoGoodsInWishListTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

        String inputEMail = "NataGolovco+2@ua.com";
        String inputPassword = "Asdfghjkl;'";
        //Click on icon My Account and Login
        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();
        WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
        login.click();
        //Login to the own cabinet
        driver.findElement(By.id("input-email")).sendKeys(inputEMail);
        driver.findElement(By.id("input-password")).sendKeys(inputPassword);
        //Click on the Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();


    }

}
