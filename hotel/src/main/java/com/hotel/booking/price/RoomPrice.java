package com.hotel.booking.price;

public class RoomPrice extends PriceForDay {

    int cost;

    public RoomPrice(int number, int cost){
        super.number = number;
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
