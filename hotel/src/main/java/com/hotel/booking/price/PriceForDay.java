package com.hotel.booking.price;

public abstract class PriceForDay {
    String additionalOptions = "";

    public abstract int getCost();

    public String getAdditionalOptions() {
        return additionalOptions;
    }
}
