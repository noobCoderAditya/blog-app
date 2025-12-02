package com.noobCoder.blog.controller;

import com.noobCoder.blog.entity.User;
import com.noobCoder.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user){
       return userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return userService.fetchAllUser();
    }

    @PutMapping("/update-user/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName){
        return userService.updateUser(user, userName);
    }
}
