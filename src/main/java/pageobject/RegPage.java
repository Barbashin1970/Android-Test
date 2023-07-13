package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegPage {
    private static final By screenTitle = By.id("com.example.login:id/toolbar");
    public static By emailInput = By.id("com.example.login:id/username");
    private static final By passInput = By.id("com.example.login:id/password");
    private static final By signInButton = By.id("com.example.login:id/login");
    private static final By successAuthText = By.xpath("//*[contains(@text, 'Welcome ! user')]");
    private static final By unSuccessAuthText = By.xpath("//*[contains(@text, 'Login failed')]");

    private final AppiumDriver<MobileElement> driver;

    public RegPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    @Step("Проверяем отображение названия Login на главном экране")
    public boolean checkScreenTitle() {
        return driver.findElement(screenTitle).isDisplayed();
    }

    @Step("Вводим в поле email тестовые данные")
    public RegPage setEmailInput(String email) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.isDisplayed();
        emailField.click();
        emailField.sendKeys(email);
        return this;
    }

    @Step("Вводим в поле пароль тестовые данные")
    public RegPage setPassInput(String pass) {
        WebElement passField = driver.findElement(passInput);
        passField.isDisplayed();
        passField.click();
        passField.sendKeys(pass);
        return this;
    }

    @Step("Нажимаем на кнопку - Sign In / Register")
    public void signInClick() {
        WebElement loginButton = driver.findElement(signInButton);
        loginButton.isDisplayed();
        loginButton.click();
    }

    @Step("Отображается текст - Удачная авторизация")
    public boolean successText() {
        return driver.findElement(successAuthText).isDisplayed();
    }

    @Step("Отображается текст - Ошибка авторизации")
    public boolean unSuccessText() {
        return driver.findElement(unSuccessAuthText).isDisplayed();
    }

}
