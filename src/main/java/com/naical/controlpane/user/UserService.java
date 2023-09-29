package com.naical.controlpane.user;

import com.naical.controlpane.role.Role;

import java.util.List;

public interface UserService {
    List<User> findAllByRole(Role role);

    void delete(Long id);

    User findById(Long id);

    User save(User user);

    User findByEmail(String email);

    User findByName(String firstName, String lastName);
}
