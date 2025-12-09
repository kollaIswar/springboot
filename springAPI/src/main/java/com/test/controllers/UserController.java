package com.test.controllers;

import com.test.model.User;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * user controller
 */
@RestController
@RequestMapping("/api/UseApi")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(){
      return userRepository.findAll();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
         return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public User editUser(@RequestBody User user){
        return userRepository.save(user);
    }

}
