package com.hotel.booking.price;

public abstract class PriceForDay {
    int number = 0;
    String additionalOptions = "";

    public abstract int getCost();

    public int getNumber() {
        return number;
    }

    public String getAdditionalOptions() {
        return additionalOptions;
    }
}
