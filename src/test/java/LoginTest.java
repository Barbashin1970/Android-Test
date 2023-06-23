import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class LoginTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Pixel_4_API_29");
        capabilities.setCapability("platformVersion","10");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage", "com.example.login");
        capabilities.setCapability("appActivity", ".ui.login.LoginActivity");
        capabilities.setCapability("app","/Users/olegbarbashin/Downloads/login.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void checkTitleScreen()
    {
        WebElement screenTitle = driver.findElementById("com.example.login:id/toolbar");
        screenTitle.isDisplayed();
    }

    @Test
    public void validRegistrationTest()
    {
        WebElement emailInput = driver.findElementById("com.example.login:id/username");

        emailInput.isDisplayed();
        emailInput.click();
        emailInput.sendKeys("admin@admin.ru");

        WebElement passInput = driver.findElementById("com.example.login:id/password");

        passInput.isDisplayed();
        passInput.click();
        passInput.sendKeys("1234");

        WebElement signInButton = driver.findElementById("com.example.login:id/login");

        signInButton.isDisplayed();
        signInButton.click();

        WebElement successAuthText = driver.findElementByXPath("//*[contains(@text, 'Welcome ! user')]");
        successAuthText.isDisplayed();
    }

    @Test
    public void invalidRegistrationTest()
    {
        WebElement emailInput = driver.findElementById("com.example.login:id/username");

        emailInput.isDisplayed();
        emailInput.click();
        emailInput.sendKeys("user@user.ru");

        WebElement passInput = driver.findElementById("com.example.login:id/password");

        passInput.isDisplayed();
        passInput.click();
        passInput.sendKeys("1111");

        WebElement signInButton = driver.findElementById("com.example.login:id/login");

        signInButton.isDisplayed();
        signInButton.click();

        WebElement successAuthText = driver.findElementByXPath("//*[contains(@text, 'Login failed')]");
        successAuthText.isDisplayed();
    }

}
