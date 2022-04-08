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

        Assertions.assertThat(actualResultText)
                .as("Expected text " + expectedResultMessage + " not exist on the Page")
                .isEqualTo(expectedResultMessage);
    }

    @Test(priority = 2)
    public void warningFirstNameTest() {
        String expectedResultWarningMessageText = "First Name must be between 1 and 32 characters!";

        MainPage mainPage = new MainPage();
        String actualUnSuccessText = mainPage.clickOnMyAccountButton()
                .clickOnRegisterSubMenuButton()
                .enterLastNameField("Golovco")
                .enterMailField("NataGolovco+5@ua.com")
                .enterTelephoneField("+38-096-777-88-99")
                .enterPasswordField("Asdfghjkl;'")
                .enterConfirm("Asdfghjkl;'")
                .clickOnPrivacyPolicyButton()
                .clickOnContinueButton()
                .getUnSuccessText();

        Assertions.assertThat(actualUnSuccessText)
                .as("Expected text " + expectedResultWarningMessageText + " not exist on the Page")
                .isEqualTo(expectedResultWarningMessageText);
    }

    @Test(priority = 3)
    public void checkAppearanceMyAccountMenuOnTheLeftSideTest() {
        String expectedMyAccountOnTheLeftSideText = "My Account";

        MainPage mainPage = new MainPage();
        String actualMyAccountOnTheLeftSideText = mainPage.clickOnMyAccountButton()
                .clickOnLoginSubMenuButton()
                .inputEmailValue("NataGolovco+5@ua.com")
                .inputPasswordValue("Asdfghjkl;'")
                .clickOnLoginButton()
                .expectedMyAccountText();

        Assertions.assertThat(actualMyAccountOnTheLeftSideText)
                .as("Expected text " + expectedMyAccountOnTheLeftSideText + " not exist on the Page")
                .isEqualTo(expectedMyAccountOnTheLeftSideText);
    }

    @Test(priority = 4)
    public void checkExistingTwoGoodsInWishListTest() {


    }

}

