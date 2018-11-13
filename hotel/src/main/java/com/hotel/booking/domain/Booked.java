package com.hotel.booking.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Booked")
public class Booked {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numb")
    private Integer numb;

    @Column(name = "addition_option")
    private String addition_option;

    @Column(name = "totalprice")
    private String totalprice;

    @Column(name = "check_in")
    private Date check_in;

    @Column(name = "check_out")
    private Date chech_out;

    @Column(name = "user")
    private String user;

    public Booked(){
    }

    public Integer getNumb() {
        return numb;
    }

    public void setNumb(Integer numb) {
        this.numb = numb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getChech_out() {
        return chech_out;
    }

    public void setChech_out(Date chech_out) {
        this.chech_out = chech_out;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddition_option() {
        return addition_option;
    }

    public void setAddition_option(String addition_option) {
        this.addition_option = addition_option;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }
}
