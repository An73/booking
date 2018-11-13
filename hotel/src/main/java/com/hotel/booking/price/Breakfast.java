package com.hotel.booking.price;

/**
 * Created by dkotenko on 11/12/18.
 */
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
