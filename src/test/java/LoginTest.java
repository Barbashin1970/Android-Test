import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageobject.RegPage;
import java.net.URL;

import static data.AppData.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest {
    private static AppiumDriver<MobileElement> driver;
    public static RegPage regPage;

    @BeforeAll
    public static void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_4_API_29");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("app", app);

        driver = new AndroidDriver<>(new URL(URL), capabilities);
        regPage = new RegPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


    @Test
    @DisplayName("Проверяем, что заголовок отображен на главном экране")
    public void checkTitleScreen() {
        assertTrue(regPage.checkScreenTitle(), "Название не отображается на экране");
    }

    @Test
    @DisplayName("Вводим валидные данные логин и пароль при авторизации")
    public void validRegistrationTest() {
        regPage.setEmailInput("admin@admin.ru").setPassInput("1234").signInClick();
        assertTrue(regPage.successText(), "Текст успеха не отображается на экране");

    }

    @Test
    @DisplayName("Вводим неверный пароль при авторизации - ожидаем текст ошибки")
    public void invalidRegistrationTest() {
        regPage.setEmailInput("admin@admin.ru").setPassInput("1111").signInClick();
        assertTrue(regPage.unSuccessText(), "Текст ошибки не отображается на экране");
    }

}
