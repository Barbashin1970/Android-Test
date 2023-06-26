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
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    @DisplayName("Проверяем, что заголовок отображен на главном экране")
    public void checkTitleScreenPageObject() {
        RegPage regPage = new RegPage(driver);
        Assert.assertTrue("Название не отображается на экране", regPage.checkScreenTitle());
    }

    @Test
    @DisplayName("Вводим валидные данные логин и пароль при авторизации")
    public void validRegistrationTest() {
        RegPage regPage = new RegPage(driver);
        regPage.setEmailInput("admin@admin.ru");
        regPage.setPassInput("1234");
        regPage.signInClick();
        Assert.assertTrue("Текст успеха не отображается на экране", regPage.successText());

    }

    @Test
    @DisplayName("Вводим неверный пароль при авторизации - ожидаем текст ошибки")
    public void invalidRegistrationTest() {
        RegPage regPage = new RegPage(driver);
        regPage.setEmailInput("admin@admin.ru");
        regPage.setPassInput("1111");
        regPage.signInClick();
        Assert.assertTrue("Текст ошибки не отображается на экране", regPage.unSuccessText());
    }

}
