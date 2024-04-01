package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.bo.HeaderMain;
import org.example.framework.logger.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends BasePage {

    public static final String HEADER_TOURS = "ТУРЫ";
    public static final String HEADER_REGIONS = "РЕГИОНЫ";
    public static final String HEADER_AIR_TICKETS = "АВИАБИЛЕТЫ";
    public static final String HEADER_CORPORATE_TOURS = "КОРПОРАТИВНЫЕ ТУРЫ";
    public static final String HEADER_ABOUT_US = "О НАС";
    public static final String HEADER_CONTACTS = "КОНТАКТЫ";
    public static final String HEADER_BUTTON_REQUEST_CALL = "Заказать звонок";

    @FindBy(xpath = "//input[@placeholder='Введите регион, место или тур' and @name='search']")
    private WebElement textBarRegion;

    @FindBy(xpath = "//div[@class='search-filters-dropdown']//a[@href='/kareliya']")
    private WebElement searchResultRegion;

    @FindBy(xpath = "//input[@placeholder='Любой']")
    private WebElement textBarVieRecreation;

    @FindBy(xpath = "//li[@data-id='15' and @data-type='rest_kinds']")
    private WebElement viewRecreation;

    @FindBy(xpath = "//input[@placeholder='Любые']")
    private WebElement textBarDate;

    @FindBy(xpath = ".//button[contains(., 'Майские праздники')]")
    private WebElement tourDates;

    @FindBy(xpath = ".//button[contains(., 'Найти туры')]")
    private WebElement buttonSearch;

    @FindBy(xpath = ".//div[@class='dayContainer']/span[@aria-label='Март 22, 2024']")
    private WebElement firstDateTour;

    @FindBy(xpath = ".//div[@class='dayContainer']/span[@aria-label='Март 25, 2024']")
    private WebElement secondDateTour;

    @FindBy(css = ".app-header #tours-link")
    private WebElement headerTours;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/regiony']")
    private WebElement headerRegions;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/aviabilety']")
    private WebElement headerAirTickets;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/korporativnye-tury-po-rossii']")
    private WebElement headerCorporateTours;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/o-kompanii']")
    private WebElement headerAboutUs;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/kontakty']")
    private WebElement headerContacts;

    @FindBy(css = "#header-call-request .as-button__body")
    private WebElement headerButtonRequestCall;


    @Step("Проверка Title")
    public MainPage checkTitle() {
        AllureLogger.debug("Check title");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Большая Страна — Все туры по России"));
        return this;
    }

    @Step("Выбор региона для поиска")
    public MainPage selectingRegion(String value) {
        AllureLogger.debug("Input value: " + value);
        textBarRegion.click();
        textBarRegion.sendKeys(value);
        searchResultRegion.click();
        return this;
    }

    @Step("Выбор вида отдыха")
    public MainPage selectingViewRecreation() {
        AllureLogger.debug("Selecting view recreation");
        textBarVieRecreation.click();
        waitElementIsVisible(viewRecreation).click();
        return this;
    }

    @Step("Выбор даты для тура")
    public MainPage selectingDate() {
        AllureLogger.debug("Selecting date of tour");
        textBarDate.click();
        waitElementIsVisible(tourDates).click();
        return this;
    }

    @Step("Нажатие кнопки поиска")
    public MainPage clickButtonOfSearch() {
        AllureLogger.debug("Clicking button for search of tours");
        waitElementIsVisible(buttonSearch).click();
        return this;
    }

    @Step("Проверка названий элементов в шапке")
    public MainPage validateElementsNames(HeaderMain headerMain){
        AllureLogger.debug("Проверка названий элементов в шапке");
        //SoftAssert, метод в Asserts, чтобы выводил инфу по зафейленнному элементу
        Assert.assertEquals(headerTours.getText().trim(), headerMain.getHeaderTours(), "Element name is not correct!");
        Assert.assertEquals(headerRegions.getText().trim(), headerMain.getHeaderRegions(), "Element name is not correct!");
        Assert.assertEquals(headerAirTickets.getText().trim(), headerMain.getHeaderAirTickets(), "Element name is not correct!");
        Assert.assertEquals(headerCorporateTours.getText().trim(), headerMain.getHeaderCorporateTours(), "Element name is not correct!");
        Assert.assertEquals(headerAboutUs.getText().trim(), headerMain.getHeaderAboutUs(), "Element name is not correct!");
        Assert.assertEquals(headerContacts.getText().trim(), headerMain.getHeaderContacts(), "Element name is not correct!");
        Assert.assertEquals(headerButtonRequestCall.getText().trim(), headerMain.getHeaderButtonRequestCall(), "Element name is not correct!");
        return this;
    }

//    @Step("Выбор дат на март для тура")
//    public MainPage selectingDatesOfMarch() {
//        AllureLogger.debug("Selecting date of march");
//        textBarDate.click();
//        waitElementIsVisible(firstDateTour);
//        Assert.assertTrue(firstDateTour.isDisplayed(), "Element is not displayed");
//        firstDateTour.click();
//        waitElementIsVisible(secondDateTour);
//        Assert.assertTrue(secondDateTour.isDisplayed(), "Element is not displayed");
//        secondDateTour.click();
//        return this;
//    }

}
