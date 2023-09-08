package com.csci3130_group11.group11_spring_boot.task.serviceImpl;
import com.csci3130_group11.group11_spring_boot.task.model.TaskModel;
import com.csci3130_group11.group11_spring_boot.task.repository.TaskRepository;
import com.csci3130_group11.group11_spring_boot.user.model.userModel;
import com.csci3130_group11.group11_spring_boot.user.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private userRepository userrepository;


    public TaskModel assignToUser(int task_id, Optional<Integer> user_id, Optional<String> user_email) {
        Optional<TaskModel> findTask = taskRepository.findById(task_id);
        userModel findUser = null;
        if(user_id.isPresent()) {
            if(userrepository.findById(user_id.get()).isPresent()) {
                findUser = userrepository.findById(user_id.get()).get();
            }
        } else if (user_email.isPresent()) {
            if(userrepository.findByEmail(user_email.get()) != null) {
                findUser = userrepository.findByEmail(user_email.get());
            }
        }

        if(findTask.isPresent() & findUser != null) {
            findTask.get().setUser(findUser);
            return taskRepository.save(findTask.get());
        }
        return new TaskModel();
    }
    public Integer postTaskStatus(int taskId, String status) {
        TaskModel taskModel = findTaskById(taskId);
        taskModel.setTaskStatus(status);
        return taskRepository.save(taskModel).getId();
    }

    public String getTaskStatus(int taskId){
        TaskModel taskModel = findTaskById(taskId);
        return taskModel.getTaskStatus();
    }

    public TaskModel setDueDate(TaskModel task, Integer id) {
        Optional<TaskModel> findTask = taskRepository.findById(id);
        if(findTask.isPresent()) {
            findTask.get().setTaskDueDate(task.getTaskDueDate());
            return taskRepository.save(findTask.get());
        }
        return new TaskModel();
    }

    public TaskModel updateTaskStatus(TaskModel taskModel, int id) {
        Optional<TaskModel> findTask = taskRepository.findById(id);
        if(findTask.isPresent()) {
            findTask.get().setTaskStatus(taskModel.getTaskStatus());
            taskRepository.save(findTask.get());
            return findTask.get();
        }
        return null;
    }

    public Integer createTask(TaskModel task){
        return taskRepository.save(task).getId();
    }
    public TaskModel saveTask(TaskModel task){
        task.setTaskName(task.getTaskName());
        return taskRepository.save(task);
    }
    public List<TaskModel> getTasks() {
        return taskRepository.findAll();
    }
    public TaskModel deleteTaskById(int id){
        Optional<TaskModel> task = taskRepository.findById(id);
        if(task.isPresent()){
            taskRepository.deleteById(id);
            return task.get();
        }
        return new TaskModel();
    }
    public TaskModel getTaskById(int id) {
        return taskRepository.findById(id).get();
    }

    public TaskModel updateTask(TaskModel task, int id) {
        task.setId(id);
        task.setTaskName(task.getTaskName());
        return taskRepository.save(task);
    }

    public TaskModel findTaskById (int taskId) {
        TaskModel taskModel = null;
        //assuming taskmodel not present by making it null
        Optional<TaskModel> optionalTaskModel = taskRepository.findById(taskId);
        if (optionalTaskModel.isPresent()) {
            taskModel = optionalTaskModel.get();
            // if optionalTaskModel is present, we are changing the value with the actual model present in the db
        }
        return taskModel;
    }
    public List<TaskModel> searchTask(String query){
        List<TaskModel> task = taskRepository.searchTask(query);
        return task;
    }
}
