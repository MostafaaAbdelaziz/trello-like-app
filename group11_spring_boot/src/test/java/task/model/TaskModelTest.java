package task.model;
import com.csci3130_group11.group11_spring_boot.task.model.TaskModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TaskModelTest {

    @Test
    public void getTaskName_Test(){
        TaskModel task = new TaskModel("Model1", "Status1", "DueDate1","MostafaaAbdelaziz@dal.ca");
        assertEquals("Model1",task.getTaskName(), "getTaskName() returns incorrect name.");
    }
    @Test
    public void setTaskName_Test(){
        TaskModel task = new TaskModel("Model1", "Status1", "DueDate1","MostafaaAbdelaziz@dal.ca");
        task.setTaskName("Model1Change");
        assertEquals("Model1Change",task.getTaskName(),"setTaskName() did not set the correct name");
    }
    @Test
    public void getId_Test(){
        TaskModel task = new TaskModel("Model1", "Status1", "DueDate1","MostafaaAbdelaziz@dal.ca");
        task.setId(875982);
        assertEquals(875982,task.getId(),"getId() did not return the correct Id");
    }
    @Test
    public void getStatus_Test(){
        TaskModel task = new TaskModel("Model1", "Status1", "DueDate1","MostafaaAbdelaziz@dal.ca");

        assertEquals("Status1",task.getTaskStatus(),"getTaskStatus() did not return the correct status");
    }
    @Test
    public void setStatus_Test(){
        TaskModel task = new TaskModel("Model1", "Status1", "DueDate1","MostafaaAbdelaziz@dal.ca");

        task.setTaskStatus("Status1Change");
        assertEquals("Status1Change",task.getTaskStatus(),"setTaskStatus() did not set the correct status");
    }
    @Test
    public void getDueDate_Test(){
        TaskModel task = new TaskModel("Model1", "Status1", "DueDate1","MostafaaAbdelaziz@dal.ca");

        assertEquals("DueDate1",task.getTaskDueDate(),"getTaskDueDate() did not return the correct due date");
    }
    @Test
    public void setDueDate_Test(){
        TaskModel task = new TaskModel("Model1", "Status1", "DueDate1","MostafaaAbdelaziz@dal.ca");

        task.setTaskDueDate("DueDate1Change");
        assertEquals("DueDate1Change",task.getTaskDueDate(),"setTaskDueDate() did not set the correct due date");
    }
    @Test
    public void getAssignedTo_Test(){
        TaskModel task = new TaskModel("Model1", "Status1", "DueDate1","MostafaaAbdelaziz@dal.ca");
        assertEquals("MostafaaAbdelaziz@dal.ca",task.getAssignedTo(),"getTaskAssignedTo() did not return the correct assigned to");
    }
    @Test
    public void setAssignedTo_Test() {
        TaskModel task = new TaskModel("Model1", "Status1", "DueDate1", "MostafaaAbdelaziz@dal.ca");
        task.setAssignedTo("ms582520@dal.ca");
        assertEquals("ms582520@dal.ca", task.getAssignedTo(), "getTaskAssignedTo() did not return the correct assigned to");
    }
}
