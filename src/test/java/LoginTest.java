import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageobject.RegPage;
import java.net.URL;


public class LoginTest {
    private AppiumDriver<MobileElement> driver;
    public RegPage regPage;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_4_API_29");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.example.login");
        capabilities.setCapability("appActivity", ".ui.login.LoginActivity");
        capabilities.setCapability("app", "/Users/olegbarbashin/IdeaProjects/Android1/src/apks/login.apk");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        regPage = new RegPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    @DisplayName("Проверяем, что заголовок отображен на главном экране")
    public void checkTitleScreenPageObject() {
        Assert.assertTrue("Название не отображается на экране", regPage.checkScreenTitle());
    }

    @Test
    @DisplayName("Вводим валидные данные логин и пароль при авторизации")
    public void validRegistrationTest() {
        regPage.setEmailInput("admin@admin.ru").setPassInput("1234").signInClick();
        Assert.assertTrue("Текст успеха не отображается на экране", regPage.successText());

    }

    @Test
    @DisplayName("Вводим неверный пароль при авторизации - ожидаем текст ошибки")
    public void invalidRegistrationTest() {
        regPage.setEmailInput("admin@admin.ru").setPassInput("1111").signInClick();
        Assert.assertTrue("Текст ошибки не отображается на экране", regPage.unSuccessText());
    }

}
