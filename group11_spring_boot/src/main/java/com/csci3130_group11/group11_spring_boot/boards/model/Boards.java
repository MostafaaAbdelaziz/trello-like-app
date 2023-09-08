package com.csci3130_group11.group11_spring_boot.boards.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "boards")
public class Boards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String description;

//    public Board(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
    private int workspace_id;

    public Boards(String name, String description, int workspace_id) {
        this.name = name;
        this.description =description;
        this.workspace_id = workspace_id;

    }

    public Boards(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String boardTitle) {
        this.name = boardTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String workspaceName) {
        this.description = workspaceName;
    }

    public int getWorkspace_id() {
        return this.workspace_id;
    }
    public int setWorkspace_id(int workspace_id) {
        this.workspace_id = workspace_id;
        return this.workspace_id;
    }
}

