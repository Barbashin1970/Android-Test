package pageobject;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegPage {
    private static final By screenTitle = By.id("com.example.login:id/toolbar");
    private static final By emailInput = By.id("com.example.login:id/username");
    private static final By passInput = By.id("com.example.login:id/password");
    private static final By signInButton = By.id("com.example.login:id/login");
    private static final By successAuthText = By.xpath("//*[contains(@text, 'Welcome ! user')]");
    private static final By unSuccessAuthText = By.xpath("//*[contains(@text, 'Login failed')]");

    private final AppiumDriver driver;

    public RegPage(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Проверяем отображение названия Login на главном экране")
    public boolean checkScreenTitle() {
        return driver.findElement(screenTitle).isDisplayed();
    }

    @Step("Вводим в поле email тестовые данные")
    public void setEmailInput(String email) {
        //driver.findElement(emailInput).isDisplayed();
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Вводим в поле пароль тестовые данные")
    public void setPassInput(String pass) {
        driver.findElement(passInput).isDisplayed();
        driver.findElement(passInput).click();
        driver.findElement(passInput).sendKeys(pass);
    }

    @Step("Нажимаем на кнопку - Sign In / Register")
    public void signInClick() {
        driver.findElement(signInButton).isDisplayed();
        driver.findElement(signInButton).click();
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
