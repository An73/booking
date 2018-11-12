package com.hotel.booking.web;

import com.hotel.booking.domain.Booked;
import com.hotel.booking.domain.Room;
import com.hotel.booking.filter.Datefilter;
import com.hotel.booking.repos.BookedRepo;
import com.hotel.booking.repos.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class HotelController {
    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private BookedRepo bookedRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Room> rooms = roomRepo.findAll();
        model.put("rooms", rooms);
        return "main";
    }

    @GetMapping("toCreateUser")
    public String toCreateUser() {
        return "createuser";
    }
    /*@GetMapping("/listrooms")
    public String listrooms(Map<String, Object> model) {
        Iterable<RoomPrice> rooms = roomRepo.findAll();
        model.put("rooms", rooms);

        return "main";
    }*/

    @PostMapping("datefilter")
    public String dateFilter(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date check_in,
                             @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date check_out,
                             Map<String, Object> model) {
        /*Date today = new Date();
        if (check_in != null && check_out != null &&
                check_in.after(today) && check_out.after(today) &&
                check_out.after(check_in)) {
            System.out.println(check_in.toString());
            Iterable<RoomPrice> roomsBooked = roomRepo.findC(check_in, check_out);
            List<RoomPrice> rooms = (List<RoomPrice>) roomRepo.findAll();

            for (RoomPrice roomB : roomsBooked) {
                for (RoomPrice room : rooms) {
                    if (roomB.getNumb() == room.getNumb())
                        rooms.remove(room);
                }
            }
            model.put("rooms", rooms);
        }*/
        Datefilter datefilter = new Datefilter(roomRepo);
        List<Room> rooms = datefilter.filtrate(check_in, check_out);

        model.put("rooms", rooms);

        return "main";
    }

    @PostMapping("filter")
    public String categoryFilter(@RequestParam String category,
                                 @RequestParam Integer price,
                                 Map<String, Object> model) {
        Iterable<Room> rooms;
        if (price == null)
            rooms = roomRepo.findByCategory(category);
        else
            rooms = roomRepo.findByCategoryAndPriceLessThanEqual(category, price);
        model.put("rooms", rooms);
        return "main";
    }
}
