package org.example.tests;

import org.example.common.BaseTest;
import org.example.framework.bo.HeaderMain;
import org.example.framework.bo.TourInfo;
import org.example.framework.logger.AllureLogger;
import org.example.framework.pages.InfoOfTourPage;
import org.example.framework.pages.MainPage;
import org.testng.annotations.Test;

import static org.example.framework.config.Config.NAME_REGION;
import static org.example.framework.config.Config.URL;

public class SearchToursTest extends BaseTest {

    @Test
    public void test1() {

        AllureLogger.debug("Test 1");
        basePage.open(URL);
        mainPage
                .checkTitle()
                .selectingRegion(NAME_REGION)
                .selectingViewRecreation()
                .selectingDate()
                .clickButtonOfSearch();
        filtersForSearchPage
                .checkingCountTours()
                .selectFilters()
                .checkingCountTours();
    }

    @Test
    public void test2() {

        AllureLogger.debug("Test 2");
        basePage.open(URL);
        mainPage
                .checkTitle()
                .selectingRegion(NAME_REGION)
                .selectingViewRecreation()
                .selectingDate()
                .clickButtonOfSearch();
        filtersForSearchPage
                .checkingCountTours()
                .moveSliderPrice()
                .checkingCountTours();
    }

    @Test
    public void test3() {

        AllureLogger.debug("Test 3");
        basePage.open(URL);
        mainPage
                .checkTitle()
                .selectingRegion(NAME_REGION)
                .selectingViewRecreation()
                .selectingDate()
                .clickButtonOfSearch();
        filtersForSearchPage
                .watchInfoOfTour()
                .switchingFrame();
        infoOfTour.switchingToPageBookYourPlace();
        applicationForTourPage
                .checkTitle()
                .selectingDate()
                .enteringName()
                .enteringPhoneNumber()
                .enteringEmail()
                .sendApplication()
                .checkingErrorMessage();
    }

    @Test
    public void test4() {

        AllureLogger.debug("Test 4");
        basePage.open(URL);
        HeaderMain expectedHeaderMain = new HeaderMain(MainPage.HEADER_TOURS, MainPage.HEADER_REGIONS,
                MainPage.HEADER_AIR_TICKETS, MainPage.HEADER_CORPORATE_TOURS, MainPage.HEADER_ABOUT_US,
                MainPage.HEADER_CONTACTS, MainPage.HEADER_BUTTON_REQUEST_CALL);
        mainPage.validateElementsNames(expectedHeaderMain)
                .checkTitle()
                .selectingRegion(NAME_REGION)
                .selectingViewRecreation()
                .selectingDate()
                .clickButtonOfSearch();
        filtersForSearchPage
                .watchInfoOfTour()
                .switchingFrame();
        TourInfo expectedInfoOfTour = new TourInfo(InfoOfTourPage.PRICE, InfoOfTourPage.DESCRIPTION,
                InfoOfTourPage.TOUR_NAME);
        infoOfTour.validateInfoOfTour(expectedInfoOfTour);
    }

}
