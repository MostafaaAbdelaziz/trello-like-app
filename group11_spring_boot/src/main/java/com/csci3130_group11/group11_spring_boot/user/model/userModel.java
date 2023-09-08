package com.csci3130_group11.group11_spring_boot.user.model;

import com.csci3130_group11.group11_spring_boot.task.model.TaskModel;
import com.csci3130_group11.group11_spring_boot.workspace.model.WorkspaceModel;

import javax.persistence.*;
import java.util.List;

@Entity
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//auto generated every time id executes
    private int id;

    private String name;

    private String email;

    private String password;

    private String securityQuestion1;

    private String securityQuestion2;

    private String newPassword;
    public List<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    @OneToMany(targetEntity = TaskModel.class)
    @JoinColumn(name = "task_mapping")
    private List<TaskModel> tasks;

    public List<WorkspaceModel> getWorkspaces(){ return workspaceModels;}

    public void setWorkspace(List<WorkspaceModel> Workspace) { this.workspaceModels = Workspace; }

    @OneToMany(targetEntity = WorkspaceModel.class)
    @JoinColumn(name = "workspace_mapping")
    private List<WorkspaceModel> workspaceModels;

    public userModel(String name, String email, String password,String security1,String security2) {//why no constructor for id?
        this.name = name;
        this.email = email;
        this.password = password;
        this.securityQuestion1 = security1;
        this.securityQuestion2 = security2;
    }

    public userModel() {//why do we need this?
    }

    public String getName() {
        return name;
    }
    public String getSecurityQuestion1() {
        return securityQuestion1;
    }
    public String getSecurityQuestion2() {
        return securityQuestion2;
    }
    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }
    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
