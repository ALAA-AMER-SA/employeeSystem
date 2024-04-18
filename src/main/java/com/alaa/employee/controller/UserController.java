package com.alaa.employee.controller;

import com.alaa.employee.entity.User;
import com.alaa.employee.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("api/users")
@RestController
public class UserController {

 private UserServices userServices;



 @PatchMapping("createUser")
 public ResponseEntity<User> createUser(@RequestBody User user) {
  User savedUser = userServices.createUser(user);
  return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

 }

  @GetMapping("id")
   public  ResponseEntity<User>getUserById(@PathVariable("id")Long userId){
      User user = UserServices.getUserById(userId);
      return new  ResponseEntity<>(user, HttpStatus.OK);
   }


   @GetMapping
   public ResponseEntity<List<User>>getAllUsers(){
  List<User>users=UserServices.getAllUsers();
    return new ResponseEntity<>(users,HttpStatus.OK);
    }

  @PatchMapping("id")
  public ResponseEntity<User> updateUser (@PathVariable("id") Long userId,
          @RequestBody User user){
   user.setId(userId);
   User updatedUser = userServices.updateUser(user);
   return new ResponseEntity<>(updatedUser, HttpStatus.OK);

  }
@DeleteMapping("{id}")
    public ResponseEntity<String>deleteUser(@PathVariable("id")Long userId){
       userServices.deleteUser(userId);
    return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);

  }
 }
