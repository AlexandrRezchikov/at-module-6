package org.example.framework.bo;

import org.example.framework.pages.BasePage;

public class TourInfo extends BasePage {

    private final String price;
    private final String description;
    private final String tourName;

    public TourInfo(String price, String description, String tourName) {
        this.price = price;
        this.description = description;
        this.tourName = tourName;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getTourName() {
        return tourName;
    }
}
