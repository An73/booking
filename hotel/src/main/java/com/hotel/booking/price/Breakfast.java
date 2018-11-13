package com.hotel.booking.price;


public class Breakfast extends AdditionalOption {
    PriceForDay priceForDay;

    public Breakfast(PriceForDay priceForDay){
        this.priceForDay = priceForDay;
    }

    @Override
    public int getCost() {
        return priceForDay.getCost() + 3;
    }

    @Override
    public String getAdditionalOptions() {
        return priceForDay.getAdditionalOptions() + " Breakfast ";
    }
}
