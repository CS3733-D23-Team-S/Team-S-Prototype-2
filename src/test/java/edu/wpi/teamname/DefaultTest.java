/*-------------------------*/
/* DO NOT DELETE THIS TEST */
/*-------------------------*/

package edu.wpi.teamname;

import static org.junit.jupiter.api.Assertions.*;

import edu.wpi.teamname.Database.LoaderDAO;
import edu.wpi.teamname.Database.Login.LoginDAOImpl;
import edu.wpi.teamname.algorithms.AStar;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DefaultTest {

  public void testAlgos() {
    AStar a = new AStar();
    List<Integer> res = new ArrayList<>();
    res.add(1805);
    res.add(1810);

    assertEquals(a.findPath("75 Lobby", "75 Lobby Information Desk"), res);
  }

  public void testLogin() throws Exception {
    LoginDAOImpl LDaoI = LoginDAOImpl.getInstance();
    Exception exception = assertThrows(Exception.class, () -> LDaoI.login("aaaa", "bbbb"));
    assertEquals("User does not exist", exception.getMessage());
    assertTrue(LDaoI.login("admin", "admin"));
  }

  @Test
  public void test() throws Exception {
    LoaderDAO loader = new LoaderDAO();
    loader.load();

    testLogin();
    testAlgos();
  }
}
