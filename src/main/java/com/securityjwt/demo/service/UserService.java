package com.securityjwt.demo.service;

import com.securityjwt.demo.model.Role;
import com.securityjwt.demo.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName );
    User getUser(String username);
    List<User> getUsers();
}
