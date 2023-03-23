package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

//    @Autowired
//    BlogService blogService;

    public void createUser(String username,String password){
        User user=new User();
        user.setFirstname("test");
        user.setLastname("test");
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);
    }

    public void deleteUser(int userId){

        userRepository.deleteById(userId);
    }

    public void updateUser(int id,String password){
        User user=userRepository.findById(id).get();
        user.setPassword(password);
        userRepository.save(user);
    }

    public User findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
