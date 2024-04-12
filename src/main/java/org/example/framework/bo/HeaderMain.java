package org.example.framework.bo;

import org.example.framework.pages.BasePage;

public class HeaderMain extends BasePage {

    private final String headerTours;
    private final String headerRegions;
    private final String headerAirTickets;
    private final String headerCorporateTours;
    private final String headerAboutUs;
    private final String headerContacts;
    private final String headerButtonRequestCall;

    public HeaderMain(String headerTours, String headerRegions, String headerAirTickets, String headerCorporateTours
            , String headerAboutUs, String headerContacts, String headerButtonRequestCall) {
        this.headerTours = headerTours;
        this.headerRegions = headerRegions;
        this.headerAirTickets = headerAirTickets;
        this.headerCorporateTours = headerCorporateTours;
        this.headerAboutUs = headerAboutUs;
        this.headerContacts = headerContacts;
        this.headerButtonRequestCall = headerButtonRequestCall;
    }

    public String getHeaderTours() {
        return headerTours;
    }

    public String getHeaderRegions() {
        return headerRegions;
    }

    public String getHeaderAirTickets() {
        return headerAirTickets;
    }

    public String getHeaderCorporateTours() {
        return headerCorporateTours;
    }

    public String getHeaderAboutUs() {
        return headerAboutUs;
    }

    public String getHeaderContacts() {
        return headerContacts;
    }

    public String getHeaderButtonRequestCall() {
        return headerButtonRequestCall;
    }
}
