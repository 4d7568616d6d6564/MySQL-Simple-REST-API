package com.mkdevelopment.mysqlsimplerestapi.controller;

import com.mkdevelopment.mysqlsimplerestapi.model.User;
import com.mkdevelopment.mysqlsimplerestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById")
    public User getUserById(@RequestParam("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/insertUser")
    public User createUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return userService.createUser(user);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestParam("id") Long id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        if (userService.updateUser(id, user)) {
            return "Kullanıcı başarıyla güncellendi.";
        } else {
            return "Belirtilen ID'ye sahip kullanıcı bulunamadı.";
        }
    }

    @DeleteMapping("/deleteUserById")
    public String deleteUser(@RequestParam("id") Long id) {
        if (userService.deleteUser(id)) {
            return "Kullanıcı başarıyla silindi.";
        } else {
            return "Belirtilen ID'ye sahip kullanıcı bulunamadı.";
        }
    }
}
