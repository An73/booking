package com.hotel.booking.price;

public class RoomPrice extends PriceForDay {

    int cost;

    public RoomPrice(int cost){
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
