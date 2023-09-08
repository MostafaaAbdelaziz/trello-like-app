package com.csci3130_group11.group11_spring_boot.task.repository;

import com.csci3130_group11.group11_spring_boot.task.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Integer> { //primary key of Long

    @Query("SELECT a from TaskModel a WHERE "+
            "a.taskName LIKE CONCAT('%',:query,'%')")
    List<TaskModel> searchTask(String query);

    @Query(value = "SELECT a from TaskModel a WHERE "+
            "a.taskName LIKE CONCAT('%',:query,'%')",nativeQuery = true)
    List<TaskModel> searchTaskSQL(String query);
}


