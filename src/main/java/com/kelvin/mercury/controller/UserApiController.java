package com.kelvin.mercury.controller;

import com.kelvin.mercury.dto.UserDTO;
import com.kelvin.mercury.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserApiController {
    @Autowired
    UserServiceImpl userService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "users/{id}", produces = {"application/json"})
    public UserDTO getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "users", produces = {"application/json"})
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "users", produces = {"application/json"})
    public UserDTO addUser(@RequestBody @Valid UserDTO newUser) {
        return userService.addUser(newUser);
    }
}