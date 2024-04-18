package com.alaa.employee.services;

import com.alaa.employee.entity.User;

import java.util.List;

public interface UserServices {


   User createUser(User user) ;
    User  getUserById(Long userId);
    List<User>getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);


}
