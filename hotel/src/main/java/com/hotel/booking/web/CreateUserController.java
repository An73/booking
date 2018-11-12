package com.hotel.booking.web;

import com.hotel.booking.domain.User;
import com.hotel.booking.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("create")
public class CreateUserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String form(){
        return "createuser";
    }

    @PostMapping("/created")
    public String createUser(@RequestParam String first_name,
                             @RequestParam String last_name,
                             @RequestParam String nickname,
                             Map<String, Object> model) {
        User user = userRepo.findByNickname(nickname);

        if (!first_name.isEmpty() && !last_name.isEmpty() && !nickname.isEmpty() &&
                user == null) {
            userRepo.insertUser(first_name, last_name, nickname);
            user = userRepo.findByNickname(nickname);
            model.put("users", user);
        }
        else
            model.put("error", true);

        return "createuser";
    }
}
