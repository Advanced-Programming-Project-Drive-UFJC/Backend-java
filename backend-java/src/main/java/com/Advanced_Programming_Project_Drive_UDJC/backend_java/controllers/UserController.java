package com.Advanced_Programming_Project_Drive_UDJC.backend_java.controllers;

/*
 * This is a class to handle web services
 * related to user functionalities.
 * 
 * Author: Carlos Andres Sierra <casierrav@udistrital.edu.co>
 */

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Advanced_Programming_Project_Drive_UDJC.backend_java.dataObjects.UserData;
import com.Advanced_Programming_Project_Drive_UDJC.backend_java.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userServices;


    @GetMapping("/get_user/{username}")
    public Optional<UserData> getUserByName(@PathVariable("username") String username) {
        return userServices.getUserByName(username);
    }

    @PostMapping("/auth")
    public Optional<UserData> authUser(@RequestParam String username, @RequestParam String password) {
        return userServices.authUser(username, password);
    }

    @PostMapping("/add_user")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createUser(@RequestParam String username, @RequestParam String password) {
        return userServices.addUser(username, password);
    }

    @PatchMapping("/update_password")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean updatePassword(@RequestParam String username, @RequestParam String password) {
        return userServices.updatePassword(username, password);
    }

    @DeleteMapping("/delete_user/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteUser(@RequestParam String username, @RequestParam String password) {
        return userServices.deleteUser(username, password);
    }
}
