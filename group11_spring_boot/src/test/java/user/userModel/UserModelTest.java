package user.userModel;

import com.csci3130_group11.group11_spring_boot.user.model.userModel;
import com.csci3130_group11.group11_spring_boot.workspace.model.WorkspaceModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class userModelTest {
    @Test
    public void getName_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        assertEquals("Name1", user.getName(), "getName() returns incorrect name.");
    }

    @Test
    public void setName_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        user.setName("Name1Change");
        assertEquals("Name1Change", user.getName(), "setName() did not set the correct name");
    }

    @Test
    public void getEmail_Test() {
        userModel user = new userModel("Name1", "ms582520@dal.ca", "Password1", "Security1", "Security2");
        assertEquals("ms582520@dal.ca", user.getEmail(), "getEmail() returns incorrect email.");
    }

    @Test
    public void setEmail_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        user.setEmail("dal.ca");
        assertEquals("dal.ca", user.getEmail(), "setEmail() did not set the correct email");
    }

    @Test
    public void getPassword_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        assertEquals("Password1", user.getPassword(), "getPassword() did not return the correct password");
    }

    @Test
    public void setPassword_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        user.setPassword("Password1Change");
        assertEquals("Password1Change", user.getPassword(), "setPassword() did not set the correct password");
    }

    @Test
    public void getAndSetId_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        user.setId(875982);
        assertEquals(875982, user.getId(), "setId() did not set the correct Id");
    }

    @Test
    public void getSecurityQuestion1_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        assertEquals("Security1", user.getSecurityQuestion1(), "getSecurityQuestion1() did not return the correct security question");
    }

    @Test
    public void setSecurityQuestion1_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        user.setSecurityQuestion1("Security1Change");
        assertEquals("Security1Change", user.getSecurityQuestion1(), "setSecurityQuestion1() did not set the correct security question");
    }

    @Test
    public void getSecurityQuestion2_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        assertEquals("Security2", user.getSecurityQuestion2(), "getSecurityQuestion2() did not return the correct security question");
    }

    @Test
    public void setSecurityQuestion2_Test() {
        userModel user = new userModel("Name1", "Email1", "Password1", "Security1", "Security2");
        user.setSecurityQuestion2("Security2Change");
        assertEquals("Security2Change", user.getSecurityQuestion2(), "setSecurityQuestion2() did not set the correct security question");
    }
}
