package com.naical.controlpane.controller;

import com.naical.controlpane.role.Role;
import com.naical.controlpane.user.User;
import com.naical.controlpane.user.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImp userServiceImp;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userServiceImp.findAllByRole(Role.USER);
    }



}
