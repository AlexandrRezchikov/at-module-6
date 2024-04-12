package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.asserts.AssertsElements;
import org.example.framework.common.CustomActions;
import org.example.framework.logger.AllureLogger;
import org.example.framework.utils.DataGeneration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ApplicationForTourPage extends BasePage {

    @FindBy(css = ".as-input__append")
    private WebElement barOfSelectingTourDate;

    @FindBy(xpath = "//li[@class='as-select__list-item']//strong[text()='3—5 мая']")
    private WebElement dateOfTour;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement textBarName;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement textBarPhoneNumber;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement textBarEmail;

    @FindBy(xpath = "//button[@name='submit']")
    private WebElement buttonSendRequest;

    @FindBy(xpath = "//span[contains(., 'Введите корректный номер телефона')]")
    private WebElement errorMessageValidatingPhoneNumber;

    @FindBy(xpath = ".//span[contains(., 'Вернуться')]")
    private WebElement buttonGoToBack;

    @Step("Проверка Title страницы бронирования тура")
    public ApplicationForTourPage checkTitle() {
        AllureLogger.debug("Checking title page");
        waitElementIsVisible(buttonGoToBack);
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Заявка на тур | Большая Страна"));
        return this;
    }

    @Step("Выбор дат в форме брони")
    public ApplicationForTourPage selectingDate() {
        AllureLogger.debug("Selecting date");
        AssertsElements.checkVisible(barOfSelectingTourDate);
        barOfSelectingTourDate.click();
        dateOfTour.click();
        return this;
    }

    @Step("Заполнение поля ФИО в форме брони")
    public ApplicationForTourPage enteringName() {
        String fullName = DataGeneration.generateFullName();
        AllureLogger.debug("Input Name: " + fullName);
        CustomActions.checkAndClick(textBarName);
        textBarName.sendKeys(fullName);
        return this;
    }

    @Step("Заполнение поля номера телефона в форме брони")
    public ApplicationForTourPage enteringPhoneNumber() {
        String phoneNumber = DataGeneration.generatePhoneNumber();
        AllureLogger.debug("Input phone number: " + phoneNumber);
        CustomActions.checkAndClick(textBarPhoneNumber);
        textBarPhoneNumber.sendKeys(phoneNumber);
        return this;
    }

    @Step("Заполнение поля email в форме брони")
    public ApplicationForTourPage enteringEmail() {
        String email = DataGeneration.generateEmail();
        AllureLogger.debug("Input email: " + email);
        CustomActions.checkAndClick(textBarEmail);
        textBarEmail.sendKeys(email);
        return this;
    }

    @Step("Отправка заполненной формы брони")
    public ApplicationForTourPage sendApplication() {
        AllureLogger.debug("Clicking to button send");
        CustomActions.checkAndClick(buttonSendRequest);
        return this;
    }

    @Step("Проверка ошибки")
    public ApplicationForTourPage checkingErrorMessage() {
        AllureLogger.info("Checking message");
        AssertsElements.checkVisible(errorMessageValidatingPhoneNumber);
        System.out.println("Текст ошибки: " + errorMessageValidatingPhoneNumber.getText());
        return this;
    }
}
