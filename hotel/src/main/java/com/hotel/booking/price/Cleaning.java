package com.hotel.booking.price;

public class Cleaning extends AdditionalOption {
    PriceForDay priceForDay;

    public Cleaning(PriceForDay priceForDay){
        this.priceForDay = priceForDay;
    }

    @Override
    public int getCost() {
        return priceForDay.getCost() + 1;
    }

    @Override
    public String getAdditionalOptions() {
        return priceForDay.getAdditionalOptions() + " Cleaning";
    }
}
