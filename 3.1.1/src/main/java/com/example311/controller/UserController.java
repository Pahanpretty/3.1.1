package com.example311.controller;

import com.example311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example311.service.UserService;


@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @PostMapping(value = "/add")
    public String addUser(@RequestParam String name, @RequestParam String lastname) {
        User user = new User(name, lastname);
        userService.addUser(user);
        return "redirect:/";
    }


    @PostMapping(value = "/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String lastname) {
        User user = new User(name, lastname);
        user.setId(id);
        userService.editUser(user);
        return "redirect:/";
    }


    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
