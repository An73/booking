package com.hotel.booking.domain;

import javax.persistence.*;

@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numb")
    private Integer numb;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Integer price;

    @Column(name = "addition_option")
    private String addition_option;


    public Room() {
    }

    public String getAddition_option() {
        return addition_option;
    }

    public void setAddition_option(String addition_option) {
        this.addition_option = addition_option;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
