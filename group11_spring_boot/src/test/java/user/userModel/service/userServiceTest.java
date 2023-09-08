package user.userModel.service;

import com.csci3130_group11.group11_spring_boot.task.repository.TaskRepository;
import com.csci3130_group11.group11_spring_boot.task.serviceImpl.TaskServiceImp;
import com.csci3130_group11.group11_spring_boot.user.model.userModel;
import com.csci3130_group11.group11_spring_boot.user.repository.userRepository;
import com.csci3130_group11.group11_spring_boot.user.service.userService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class userServiceTest {

    @MockBean
    userService userService;

    @MockBean
    private userRepository userRepository;

    @Test
    public void testGetUserById() {
        userService.getUserById(1);
    }
    @Test
    public void testGetAllUsers() {
        userService.getAllUsers();
    }
    @Test
    public void testCreateUser() {
        userService.signUpUser(new userModel("user1", "user1", "user1", "user1", "user1"));
    }
    @Test
    public void testUpdateUser() {
        userService.updateTast( 1, 1);
    }
    @Test
    public void testGetUserByUsername() {
        userService.getUserById(1);
    }
    @Test
    public void testGetUserByEmail() {
        userService.getUserByEmail("user1@gmail.com");
    }

}
