package com.csci3130_group11.group11_spring_boot.user.service;
import com.csci3130_group11.group11_spring_boot.task.model.TaskModel;
import com.csci3130_group11.group11_spring_boot.task.serviceImpl.TaskServiceImp;
import com.csci3130_group11.group11_spring_boot.user.model.userModel;
import com.csci3130_group11.group11_spring_boot.user.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    userRepository userrepository;

    @Autowired
    TaskServiceImp taskService; //it is responsibility of the task service to provide task module
    //it is not a goof practice to call other repositories and the service must be provided using service module

    public List<userModel> getAllUsers() {
        return userrepository.findAll();
    }

    public userModel getUserByEmail(String email) {
        return userrepository.findByEmail(email);
    }

    public userModel getUserById(int id) {
        return userrepository.findById(id).get();
    }

    public userModel signUpUser (userModel usermodel) {
        return userrepository.save(usermodel);
    }

    public userModel updateTast(Integer userID, int taskId){
        userModel updatedUser = null;//assuming user not getting updated

        Optional<userModel> user = null;//assume no user is passed
        //trying to get a user

        try{
            user = userrepository.findById(userID);
            if (user.isPresent()){
                userModel usermodel = user.get();
                TaskModel taskModel = taskService.findTaskById(taskId);

                List<TaskModel> tasks = usermodel.getTasks();//there is a chance that a user does not have any tasks

                if (tasks != null) {
                    tasks = new ArrayList<>();//is the user does not have any tasks, initializing the list
                }

                tasks.add(taskModel);
                usermodel.setTasks(tasks);
                //save the user model back
                updatedUser = userrepository.save(usermodel);//if the user updates
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return updatedUser;
    }

    public userModel updatePassword(String email, String newPassword) {
        userModel updatedUser = null;//assuming user not getting updated

        userModel user = null;//assume no user is passed
        //trying to get a user

        try{
            user = userrepository.findByEmail(email);
            if (user != null){
                user.setPassword(newPassword);
                //save the user model back
                updatedUser = userrepository.save(user);//if the user updates
                return updatedUser;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
    }
        return null;
    }
}
