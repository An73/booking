package com.hotel.booking.web;

import com.hotel.booking.domain.Booked;
import com.hotel.booking.domain.Room;
import com.hotel.booking.domain.User;
import com.hotel.booking.filter.Datefilter;
import com.hotel.booking.repos.BookedRepo;
import com.hotel.booking.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("viewbook")
public class ViewBookingsController {

    private List<Booked> booked;
    private List<User> users;

    @Autowired
    private BookedRepo bookedRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String form(Map<String, Object> model){

        users = (List<User>)userRepo.findAll();
        model.put("users", users);
        //Iterable<RoomPrice> rooms = roomRepo.findAll();
        //model.put("rooms", rooms);
        //a++;
        return "viewbook";
    }

    @PostMapping("user")
    public String viewByUser(@RequestParam("nickname") String nickname,
                             Map<String, Object> model) {

        booked = bookedRepo.findByUser(nickname);
        model.put("users", users);
        model.put("booked", booked);
        return "viewbook";
    }

    @PostMapping("all")
    public String viewByAll(Map<String, Object> model) {

        booked = bookedRepo.findAll();
        if (!booked.isEmpty())
            model.put("booked", booked);
        model.put("users", users);
        return "viewbook";
    }

}
