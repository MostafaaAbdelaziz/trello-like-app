package com.csci3130_group11.group11_spring_boot.user.repository;

import com.csci3130_group11.group11_spring_boot.user.model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


//handel database interactions
@Repository//saving user model in database
public interface userRepository extends JpaRepository<userModel, Integer> {
    userModel findByEmail(String email);
    //needs 2 para to see what kind of data to store
    //storing userRepository and it needs data type of primary key
    //Jpa repo is in build repo that is provided by spring boot

}
