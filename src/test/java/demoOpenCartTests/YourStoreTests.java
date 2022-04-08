package demoOpenCartTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class YourStoreTests extends BaseTest {

    @Test(priority = 1)
    public void registrationMyOwnCabinetTest() {
        String expectedResultMessage = "Your Account Has Been Created!";

        MainPage mainPage = new MainPage();
        String actualResultText = mainPage.clickOnMyAccountButton()
                .clickOnRegisterSubMenuButton()
                .enterFirstNameField("Nataliya")
                .enterLastNameField("Golovco")
                .enterMailField("NataGolovco+5@ua.com")
                .enterTelephoneField("+38-096-777-88-99")
                .enterPasswordField("Asdfghjkl;'")
                .enterConfirm("Asdfghjkl;'")
                .clickOnPrivacyPolicyButton()
                .clickOnContinueButton()
                .getSuccessText();

        Assertions.assertThat(actualResultText).as("Expected text " + expectedResultMessage + " not exist on the Page")
                .isEqualTo(expectedResultMessage);
    }

    @Test(priority = 2)
    public void warningFirstNameTest() {

        MainPage mainPage = new MainPage();
        mainPage.clickOnMyAccountButton()
                .clickOnRegisterSubMenuButton()
                .enterLastNameField("Golovco")
                .enterMailField("NataGolovco+5@ua.com")
                .enterTelephoneField("+38-096-777-88-99")
                .enterPasswordField("Asdfghjkl;'")
                .enterConfirm("Asdfghjkl;'")
                .clickOnPrivacyPolicyButton()
                .clickOnContinueButton()
                .elementWarningMessage("First Name must be between 1 and 32 characters!");//A mistake?

        /*Assertions.assertThat().as("Expected text " + expectedWarningMessage + " not exist on the Page")
                .isEqualTo(expectedWarningMessage);*/
    }

    @Test(priority = 3)
    public void checkAppearanceMyAccountMenuOnTheLeftSideTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickOnMyAccountButton()
                .clickOnLoginSubMenuButton()
                .inputEmailValue("NataGolovco+5@ua.com")
                .inputPasswordValue("Asdfghjkl;'")
                .clickOnLoginButton()
                .expectedMyAccountText("My Account");//A mistake?

        /*Assertions.assertThat().as("Expected text " + expectedMyAccountText + " not exist on the Page")
                .isEqualTo(expectedMyAccountText);*/
    }

}

