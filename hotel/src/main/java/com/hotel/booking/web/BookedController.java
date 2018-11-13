package com.hotel.booking.web;

import com.hotel.booking.domain.Room;
import com.hotel.booking.domain.User;
import com.hotel.booking.filter.Datefilter;
import com.hotel.booking.price.Breakfast;
import com.hotel.booking.price.Cleaning;
import com.hotel.booking.price.PriceForDay;
import com.hotel.booking.price.RoomPrice;
import com.hotel.booking.repos.BookedRepo;
import com.hotel.booking.repos.RoomRepo;
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
@RequestMapping("booked")
public class BookedController {

    private List<Room> rooms;
    private PriceForDay priceForDay;
    private Date dateCheckIn = null;
    private Date dateCheckOut = null;
    private Integer total;

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookedRepo bookedRepo;

    @GetMapping
    public String form(){
        return "booked";
    }

    @PostMapping("datefilter")
    public String dateFilter(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date check_in,
                             @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date check_out,
                             Map<String, Object> model) {
        Datefilter datefilter = new Datefilter(roomRepo);
        rooms = datefilter.filtrate(check_in, check_out);
        dateCheckIn = check_in;
        dateCheckOut = check_out;
        model.put("r", true);
        model.put("rooms", rooms);

        return "booked";
    }

    @PostMapping("filtercategory")
    public String filterCategory(@RequestParam String category,
                                 @RequestParam Integer price,
                                 Map<String, Object> model) {
        if (rooms == null || rooms.isEmpty())
            model.put("error", true);
        else{
            rooms.removeIf(r -> !r.getCategory().equals(category) ||
                    (price != null && r.getPrice() > price));
            model.put("r", true);
            model.put("rooms", rooms);
        }
        return "booked";
    }

    @PostMapping("total")
    public String total(@RequestParam("numb") Integer number,
                         @RequestParam(value = "breakfast", required = false) String breakfast,
                        @RequestParam(value = "cleaning", required = false) String cleaning,
                         Map<String, Object> model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        totalPrice(breakfast, cleaning, number);
        List<User> users = (List<User>)userRepo.findAll();


        model.put("users", users);
        model.put("check_in", dateFormat.format(dateCheckIn));
        model.put("check_out", dateFormat.format(dateCheckOut));
        model.put("number_room", number);
        model.put("totalprice", total);
        model.put("total", true);
        model.put("r", true);
        model.put("rooms", rooms);


        return "booked";
    }

    @PostMapping("book")
    public String book(@RequestParam("numb") Integer number,
                       @RequestParam("nickname") String nickname,
                       Map<String, Object> model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if (nickname != null) {
            bookedRepo.insertBooked(number, dateCheckIn, dateCheckOut, priceForDay.getAdditionalOptions(), total, nickname);
            model.put("booked", true);
            model.put("number_room", number);
            model.put("check_in", dateFormat.format(dateCheckIn));
            model.put("check_out", dateFormat.format(dateCheckOut));
            model.put("addopt", priceForDay.getAdditionalOptions());
            model.put("user", nickname);
            model.put("totalprice", total);
        }

        return "booked";
    }

    private void totalPrice(String breakfast, String cleaning, Integer number){
        int cost = roomRepo.findPriceByNumb(number);
        priceForDay = new RoomPrice(cost);
        if (breakfast != null)
            priceForDay = new Breakfast(priceForDay);
        if (cleaning != null)
            priceForDay = new Cleaning(priceForDay);

        total = (int) (dateCheckOut.getTime() - dateCheckIn.getTime()) / 86400000 + 1;
        total *= priceForDay.getCost();
    }
}