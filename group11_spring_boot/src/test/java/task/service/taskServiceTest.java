package task.service;

import com.csci3130_group11.group11_spring_boot.task.model.TaskModel;
import com.csci3130_group11.group11_spring_boot.task.repository.TaskRepository;
import com.csci3130_group11.group11_spring_boot.task.serviceImpl.TaskServiceImp;
import com.csci3130_group11.group11_spring_boot.user.service.userService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class taskServiceTest {

    @MockBean
    private TaskServiceImp taskService;

    @MockBean
    private TaskRepository taskRepository;

    @MockBean
    private com.csci3130_group11.group11_spring_boot.user.service.userService userService;

    @Test
    public void testUpdateTask() {
        TaskModel task = new TaskModel("task1", "task1", "task1", "task1");
        task.setId(1);
        assertEquals(1, task.getId());
        TaskModel task1 = new TaskModel("task1", "task1", "task1", "task1");
        task1.setTaskName("task2");
        TaskModel task2 = new TaskModel("task2", "task2", "task2", "task2");
        assertEquals("task2", task2.getTaskName());
    }

    @Test
    public void testGetTaskById() {
        TaskModel task = new TaskModel("task1", "task1", "task1", "task1");
        task.setId(1);
        assertEquals(1, task.getId());
    }

}

