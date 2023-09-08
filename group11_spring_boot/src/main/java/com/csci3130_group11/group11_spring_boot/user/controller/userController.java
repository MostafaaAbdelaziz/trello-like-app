package com.csci3130_group11.group11_spring_boot.user.controller;

import com.csci3130_group11.group11_spring_boot.user.model.userModel;
import com.csci3130_group11.group11_spring_boot.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//for the user to sign in we need a constructor from user in front end with all the information to sign in.
//API
@RestController//for spring boot to know this is controller class
@RequestMapping("/user")//to uniquely identify APIs (since we have many APIs to handle back end ... )and to show path of request
@CrossOrigin(origins = "*", allowedHeaders = "*")//to allow cross origin requests
public class userController {

    @Autowired//we are not creating the object, and it is connected to the service
    userService userservice;

    @PostMapping("/save") // if the API has the path save, it will become in this class and method
    public userModel signUpUser(@RequestBody userModel usermodel){
        return userservice.signUpUser(usermodel);
        //controller gets the request and send back responses (no other code)
    }
    @PutMapping("/assignTask{userID}")
    public userModel updateTask(@PathVariable int userID, @RequestParam int taskId){
        return userservice.updateTast(userID, (taskId));
    }//to get userID we are going to provide path annotation
    // in the second para we need task ID

    @GetMapping("/getAll")
    public List<userModel> getAllUsers(){
        return userservice.getAllUsers();
    }

    @GetMapping("/getUserByEmail")
    @CrossOrigin(origins = "*", allowedHeaders = "*")//to allow cross origin requests
    public userModel getUserByEmail(@RequestParam String email){
        return userservice.getUserByEmail(email);
    }

    @GetMapping("/getUserById")
    public userModel getUserById(@RequestParam int id){
        return userservice.getUserById(id);
    }

    @PutMapping("/updatePassword")
    @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
    public userModel updatePassword(@RequestParam String email, @RequestParam String newPassword){
        return userservice.updatePassword(email, newPassword);
    }

    @PostMapping("/newPassControl")
    public userModel newPassControl(@RequestParam String email, @RequestParam String newPassword){
        return userservice.updatePassword(email, newPassword);
    }

}
