/*-------------------------*/
/* DO NOT DELETE THIS TEST */
/*-------------------------*/

package edu.wpi.teamname;

import edu.wpi.teamname.Database.Login.LoginDAOImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultTest {

  public void testLogin() {
    String username = "aaa", password = "bbb";
    LoginDAOImpl LDaoI = new LoginDAOImpl(null);
    assertFalse(LDaoI.login(username, password));


  }

  @Test
  public void test() {
    testLogin();
  }
}
