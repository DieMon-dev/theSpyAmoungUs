package com.diemoon.thespyamoungus.controllers;

import com.diemoon.thespyamoungus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create/{userLogin}")
    private void createUser(@PathVariable String userLogin) {
        userService.createUser(userLogin);
    }

    @GetMapping("/get/{userId}")
    private void getUserById(@PathVariable Integer userId) {
        userService.getUserById(userId);
    }
}
