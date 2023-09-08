package com.csci3130_group11.group11_spring_boot.workspace.model;

import com.csci3130_group11.group11_spring_boot.task.model.TaskModel;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "workspace")
public class WorkspaceModel {

    public WorkspaceModel(String workspaceName, String description) {
        this.workspaceName = workspaceName;
        this.description = description;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String workspaceName;

    private String description;


    public WorkspaceModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkspaceName() {
        return workspaceName;
    }

    public void setWorkspaceName(String name) {
        this.workspaceName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String emailId) {
        this.description = emailId;
    }

}
