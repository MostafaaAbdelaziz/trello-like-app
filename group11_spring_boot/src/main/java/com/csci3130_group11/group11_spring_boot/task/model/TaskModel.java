package com.csci3130_group11.group11_spring_boot.task.model;

import com.csci3130_group11.group11_spring_boot.user.model.userModel;
import com.csci3130_group11.group11_spring_boot.user.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String taskName;

    private String taskStatus;
    private String assignedTo;
    private String taskDueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private userModel user;

    public TaskModel(String taskName, String taskStatus, String taskDueDate, String assignedTo) {
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.taskDueDate = taskDueDate;
        this.assignedTo = assignedTo;
    }

    public TaskModel() {
    }

    public userModel getUser() {
        return user;
    }

    public void setUser(userModel user) {
        this.user = user;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }
    public String getTaskDueDate() {
        return taskDueDate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignedTo() {
        return assignedTo;
    }
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

}
