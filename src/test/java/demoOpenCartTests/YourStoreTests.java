package demoOpenCartTests;

import blocks.ProductBlock;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.CameraPage;
import pages.IPhonePage;
import pages.MainPage;
import pages.WishListPage;

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
    String expectedAppleMonitorText = "Apple Cinema 30\"";
    String expectedSamsungMonitorText = "Samsung SyncMaster 941BW";

    MainPage mainPage = new MainPage();
    String actualElementInWishList = mainPage.clickOnMyAccountButton()
        .clickOnLoginSubMenuButton()
        .inputEmailValue("NataGolovco+5@ua.com")
        .inputPasswordValue("Asdfghjkl;'")
        .clickOnLoginButton()
        .hoverMouseOverComponentsMenuButton()
        .clickOnMonitorsMenuButton()
        .addToWishList(expectedAppleMonitorText)
        .addToWishList(expectedSamsungMonitorText)
        .clickOnWishListButton()
        .getElementSamsungMonitorText();
    Assertions.assertThat(actualElementInWishList)
        .as("Expected text" + expectedSamsungMonitorText + "not exist on the Page")
        .isEqualTo(expectedSamsungMonitorText);
    actualElementInWishList = new WishListPage()
        .getElementAppleMonitorText();
    Assertions.assertThat(actualElementInWishList)
        .as("Expected text" + actualElementInWishList + "not exist on the Page")
        .isEqualTo(expectedAppleMonitorText);
  }

  @Test(priority = 5)
  public void checkThePriceTest() {
    String expectedCurrencySingh = "$";
    String expectedIPhonePriceInUSD = "$123.20";
    String expectedIPhonePriceInEuro = "€106.04";
    String expectedIPhonePriceInPound = "£95.32";

    MainPage mainPage = new MainPage();
    String actualCurrencySingh = mainPage.checkTheCurrentCurrencySingh();
    Assertions.assertThat(actualCurrencySingh)
        .as("Expected means of current currency " + expectedCurrencySingh
            + "is not exist on this Page")
        .isEqualTo(expectedCurrencySingh);
    String actualIPhonePriceInUSD = new MainPage().clickOnIPhoneProductButton()
        .actualPriceIPhoneInUSD();
    Assertions.assertThat(actualIPhonePriceInUSD)
        .as("Current price have to be: " + expectedIPhonePriceInUSD)
        .isEqualTo(expectedIPhonePriceInUSD);
    String actualIPhonePriceInEuro = new IPhonePage().clickOnTheElementCurrencyButton()
        .clickOnTheElementSubMenuEuroButton()
        .actualPriceIPhoneInEuro();
    Assertions.assertThat(actualIPhonePriceInEuro)
        .as("Current price have to be: " + expectedIPhonePriceInEuro)
        .isEqualTo(expectedIPhonePriceInEuro);
    String actualIPhonePriceInPound = new IPhonePage().clickOnTheElementCurrencyButton()
        .clickOnTheElementSubMenuPoundButton()
        .actualPriceIPhoneInPound();
    Assertions.assertThat(actualIPhonePriceInPound)
        .as("Current price have to be: " + expectedIPhonePriceInPound)
        .isEqualTo(expectedIPhonePriceInPound);
  }

  @Test(priority = 6)
  public void checkThePriceOfTheCamerasTest() {
    String cannonCamera = "Canon EOS 5D";
    String nikonCamera = "Nikon D300";

    MainPage mainPage = new MainPage();
    mainPage.clickCameraMenuButton();

    CameraPage cameraPage = new CameraPage();
    Assertions.assertThat(cameraPage.getAllProduct().size()).isEqualTo(2);

    ProductBlock cannon = cameraPage.findProduct(cannonCamera);
    ProductBlock nikon = cameraPage.findProduct(nikonCamera);

    Assertions.assertThat(cannon.getNewPrice()).isEqualTo(Double.valueOf(98.00));
    Assertions.assertThat(cannon.getOldPrice()).isEqualTo(Double.valueOf(122.00));
    Assertions.assertThat(nikon.getExRatePrice()).isEqualTo(Double.valueOf(80.00));

  }

}

