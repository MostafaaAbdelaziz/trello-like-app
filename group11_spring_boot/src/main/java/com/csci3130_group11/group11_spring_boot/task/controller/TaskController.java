package com.csci3130_group11.group11_spring_boot.task.controller;
import com.csci3130_group11.group11_spring_boot.task.model.TaskModel;
import com.csci3130_group11.group11_spring_boot.task.serviceImpl.TaskServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.csci3130_group11.group11_spring_boot.constant.ApplicationConstant.ID;

import static java.util.Collections.singletonMap;
import static java.util.Objects.isNull;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/task")//every request that starts with /task the API will direct to this path
@CrossOrigin("*")//to allow cross origin requests
public class TaskController {
    Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskServiceImp taskService;

    @PostMapping("")
    public ResponseEntity<Map<String, Integer>> createTask(@RequestBody TaskModel task) {
        LOGGER.info("[TaskController] - Inside CreateTask method");
        Integer id = taskService.createTask(task);
        HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status).body(singletonMap(ID, id));
    }
    @PostMapping("/postTaskStatus")
    @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
    public ResponseEntity<Map<String, Integer>> postTaskStatus(@RequestParam int taskId, @RequestParam String status) {
        LOGGER.info("[TaskController] - PostTaskStatus method");
        Integer id = taskService.postTaskStatus(taskId, status);
        HttpStatus status1 = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status1).body(singletonMap(ID, id));
    }
    @GetMapping("/getTaskStatus")
    @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
    public ResponseEntity<Map<String, String>> getTaskStatus(@RequestParam int taskId) {
        LOGGER.info("[TaskController] - Inside getTaskStatus method");
        String status = taskService.getTaskStatus(taskId);
        HttpStatus status1 = isNull(status) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status1).body(singletonMap("status", status));
    }



    @PutMapping(value = "/updateTaskStatus/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TaskModel> updateTaskStatus (@RequestBody TaskModel task, @PathVariable("id") Integer id){
        return new ResponseEntity<TaskModel>(taskService.updateTaskStatus(task, id), HttpStatus.OK);


    }

    @PutMapping(value = "/setDueDate/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TaskModel> setDueDate (@RequestBody TaskModel task, @PathVariable("id") Integer id) {
        return new ResponseEntity<TaskModel>(taskService.setDueDate(task, id), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Map<String, Integer>> updateTask (@RequestBody TaskModel task){
        LOGGER.info("[TaskController] - Inside updateTask method");
        Integer id = taskService.createTask(task);
        HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status).body(singletonMap(ID, id));
    }
    @GetMapping("")
    public List<TaskModel> getTask() {
        return taskService.getTasks();
    }
    @DeleteMapping("/delete")
    @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
    public ResponseEntity<TaskModel> deleteTasks(@RequestParam int id){
        LOGGER.info("[TaskController] - Inside DeleteTask method");
        return new ResponseEntity<TaskModel>(taskService.deleteTaskById(id), HttpStatus.OK);
    }
    @GetMapping("/getTaskById")
    @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
    public ResponseEntity<TaskModel> getTaskById(@RequestParam int id){
        LOGGER.info("[TaskController] - Inside getTaskById method");
        return new ResponseEntity<TaskModel> (taskService.getTaskById(id), HttpStatus.OK);
    }

    @PutMapping("/updateTask/{id}")
    @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
    public ResponseEntity<TaskModel> updateTask(@PathVariable int id, @RequestBody TaskModel task){
        LOGGER.info("[TaskController] - Inside updateTask method");
        return new ResponseEntity<TaskModel> (taskService.updateTask(task, id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<TaskModel> getTasks(){
        LOGGER.info("[TaskController] - Inside getTask method");
        return taskService.getTasks();
    }

    @PutMapping("/assign/{task_id}/user")
    @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
    public ResponseEntity<TaskModel> assignUserById(@PathVariable int task_id,
                                                    @RequestParam Optional<Integer> id,
                                                    @RequestParam Optional<String> email){
        LOGGER.info("[TaskController] - Inside assignUserById method");
        return new ResponseEntity<TaskModel> (taskService.assignToUser(task_id, id, email), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<TaskModel>> searchTask(@RequestParam("query") String query){
        return ResponseEntity.ok(taskService.searchTask(query));
    }
  
}
