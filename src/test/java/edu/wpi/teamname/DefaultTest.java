/*-------------------------*/
/* DO NOT DELETE THIS TEST */
/*-------------------------*/

package edu.wpi.teamname;

import edu.wpi.teamname.Database.ServiceRequests.FoodService.Food;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.FoodDAOImpl;
import org.junit.jupiter.api.Test;

public class DefaultTest {

  public void testFood() {
    FoodDAOImpl FDaoI = FoodDAOImpl.getInstance();
    Food food = FDaoI.retrieveFood(7);
    System.out.println(food);
    // System.out.println(food.toString());
  }

  @Test
  public void test() {
    testFood();
  }
}
