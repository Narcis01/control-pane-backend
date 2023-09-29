package com.naical.controlpane.controller;

import com.naical.controlpane.role.Role;
import com.naical.controlpane.user.User;
import com.naical.controlpane.user.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final PasswordEncoder passwordEncoder;
    private final UserServiceImp userServiceImp;

    @GetMapping("/managers")
    public List<User> getManagers() {
        return userServiceImp.findAllByRole(Role.MANAGER);
    }

    @PostMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User userFromDb = userServiceImp.findByEmail(user.getEmail());

        if (user.getPassword() != null) {
            userFromDb.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        if (user.getFirstName() != null) {
            userFromDb.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            userFromDb.setLastName(user.getLastName());
        }
        if (user.getRole() != null) {
            userFromDb.setRole(user.getRole());
        }

        return ResponseEntity.ok(userServiceImp.save(userFromDb));
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return userServiceImp.findByName(firstName, lastName);
    }
}
