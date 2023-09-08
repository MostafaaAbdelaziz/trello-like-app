package workspace.model;

import com.csci3130_group11.group11_spring_boot.workspace.model.WorkspaceModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkspaceModelTest {
    @Test
    public void getWorkspaceName_Test() {
        WorkspaceModel workspace = new WorkspaceModel("WorkspaceName1", "Description test.");
        assertEquals("WorkspaceName1", workspace.getWorkspaceName(), "getWorkspaceName() returns incorrect workspace name.");
    }
    @Test
    public void setWorkspaceName_Test() {
        WorkspaceModel workspace = new WorkspaceModel("WorkspaceName1", "Description test.");
        workspace.setWorkspaceName("WorkspaceName1Change");
        assertEquals("WorkspaceName1Change", workspace.getWorkspaceName(), "setWorkspaceName() did not set the correct workspace name");
    }
    @Test
    public void getDescription_Test() {
        WorkspaceModel workspace = new WorkspaceModel("WorkspaceName1", "Description test.");
        assertEquals("Description test.", workspace.getDescription(), "getDescription() returns incorrect description.");
    }
    @Test
    public void setDescription_Test() {
        WorkspaceModel workspace = new WorkspaceModel("WorkspaceName1", "Description test.");
        workspace.setDescription("Description test change.");
        assertEquals("Description test change.", workspace.getDescription(), "setDescription() did not set the correct description");
    }
    @Test
    public void getId_Test() {
        WorkspaceModel workspace = new WorkspaceModel("WorkspaceName1", "Description test.");
        workspace.setId(123123);
        assertEquals(123123, workspace.getId(), "setId() did not set the correct Id");
    }
}
