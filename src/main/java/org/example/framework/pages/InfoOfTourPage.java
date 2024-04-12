package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.bo.TourInfo;
import org.example.framework.logger.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class InfoOfTourPage extends BasePage {

    @FindBy(xpath = "//div[@class='tour-sidebar']//button[contains(., 'Забронировать места')]")
    private WebElement buttonReserve;

    @FindBy(xpath = "//aside[@class='tour-content__aside']//strong[@class='sidebar-resume__price-value']")
    private WebElement price;

    @FindBy(xpath = "//section[@id='browse']//p")
    private WebElement description;

    @FindBy(xpath = "//div[@class='tour-header__content']/h1[@class='tour-header__title']")
    private WebElement tourName;

    @Step("Переход на страницу бронирования тура")
    public InfoOfTourPage switchingToPageBookYourPlace() {
        AllureLogger.debug("Go to page book your place");
        Assert.assertTrue(buttonReserve.isDisplayed(), "Button number of tours is not displayed");
        buttonReserve.click();
        return this;
    }

    @Step("Првоерка информации о туре на странице тура")
    public InfoOfTourPage validateInfoOfTour(TourInfo tour) {
        AllureLogger.debug("Проверка информации на странице тура");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(price.getText().trim(), tour.getPrice());
        softAssert.assertEquals(description.getText().trim(), tour.getDescription());
        softAssert.assertEquals(tourName.getText().trim(), tour.getTourName());
        softAssert.assertAll();
        return this;
    }
}
