package com.csci3130_group11.group11_spring_boot.workspace.controller;



import com.csci3130_group11.group11_spring_boot.workspace.model.WorkspaceModel;
import com.csci3130_group11.group11_spring_boot.workspace.serviceImplementation.WorkspaceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import static com.csci3130_group11.group11_spring_boot.constant.ApplicationConstant.ID;

import static java.util.Collections.singletonMap;
import static java.util.Objects.isNull;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("workspace")
@CrossOrigin("*")
public class WorkspaceController {

    @Autowired
    private WorkspaceServiceImp workspaceService;

    @PostMapping("")
    public ResponseEntity<Map<String, Integer>> createWorkspace(@RequestBody WorkspaceModel workspace) {
        Integer id = workspaceService.createWorkspace(workspace);
        HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status).body(singletonMap(ID, id));
    }

    @PutMapping("")
    public ResponseEntity<Map<String, Integer>> updateWorkspace (@RequestBody WorkspaceModel workspace){
        Integer id = workspaceService.createWorkspace(workspace);
        HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status).body(singletonMap(ID, id));
    }

    @GetMapping("")
    public List<WorkspaceModel> getWorkspace() {
        return workspaceService.getWorkspaces();
    }
    @DeleteMapping("/delete")
    @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
    public ResponseEntity<WorkspaceModel> deleteWorkspaces(@RequestParam int id){
        return new ResponseEntity<WorkspaceModel>(workspaceService.deleteWorkspaceById(id), HttpStatus.OK);
    }
    @GetMapping("/getWorkspaceById")
    @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
    public ResponseEntity<WorkspaceModel> getWorkspaceById(@RequestParam int id){
        return new ResponseEntity<WorkspaceModel> (workspaceService.getWorkspaceById(id), HttpStatus.OK);
    }
    @PutMapping(value = "/updateWorkspace/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<WorkspaceModel> updateWorkspaces (@RequestBody WorkspaceModel workspace, @PathVariable("id") Integer id){
        return new ResponseEntity<WorkspaceModel>(workspaceService.updateWorkspace(workspace, id), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public List<WorkspaceModel> getWorkspaces () {
        return workspaceService.getWorkspaces();
    }
}
