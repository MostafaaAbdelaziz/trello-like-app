package board;

import com.csci3130_group11.group11_spring_boot.boards.model.Boards;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardModelTest {

    @Test
    public void getId_Test() {
        Boards board = new Boards("Name1","Description1",1);
        assertEquals(0, board.getId(), "getId() did not return the correct id");
    }
    @Test
    public void setId_Test() {
        Boards board = new Boards("Name1","Description1",1);
        board.setId(875982);
        assertEquals(875982, board.getId(), "setId() did not set the correct id");
    }

    @Test
    public void getName_Test(){
        Boards board = new Boards("Name1","Description1",1);
        assertEquals("Name1", board.getName(), "getBoardTitle() returns incorrect title.");
    }

    @Test
    public void setName_Test(){

        Boards board = new Boards("Name1","Description1",1);
        board.setName("CSCIchange");
        assertEquals("CSCIchange",board.getName(),"setBoardTitle() returns incorrect title ");

    }

    @Test
    public void getDescription_Test(){

        Boards board = new Boards("Name1","Description1",1);
        assertEquals("Description1",board.getDescription(), "getWorkspaceName() returns incorrect name.");

    }

    @Test
    public void setDescription_Test(){

        Boards board = new Boards("Name1","Description1",1);
        board.setDescription("3130change");
        assertEquals("3130change",board.getDescription(),"setWorkspaceName() returns incorrect name.");

    }
    @Test
    public void getWorkspace_id_Test(){

        Boards board = new Boards("Name1","Description1",1);
        assertEquals(1,board.getWorkspace_id(), "getWorkspace_id() returns incorrect id.");

    }
    @Test
    public void setWorkspace_id_Test(){

        Boards board = new Boards("Name1","Description1",1);
        board.setWorkspace_id(2);
        assertEquals(2,board.getWorkspace_id(),"setWorkspace_id() returns incorrect id.");

    }


}