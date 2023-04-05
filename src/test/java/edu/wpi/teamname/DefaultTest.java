/*-------------------------*/
/* DO NOT DELETE THIS TEST */
/*-------------------------*/

package edu.wpi.teamname;

import static org.junit.jupiter.api.Assertions.*;

import edu.wpi.teamname.Database.ServiceRequests.FoodService.Food;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.OrderItem;
import org.junit.jupiter.api.Test;

public class DefaultTest {

  public void testFood() {

    // FoodDAOImpl
    // retrieveFood()

    // FoodDAOImpl FDaoI = FoodDAOImpl.getInstance();
    // Food food = FDaoI.retrieveFood(7);
    // System.out.println(food);
    // Make Food object and check to see if they are equal
    // Food foodTest = new Food(
    //         7,"Bagel","Hello",10,"String fc",13,"String fd",false,
    //        "image",10,false,false,false,false,false,false,false,false,false
    // );
    // assertEquals(food, foodTest);

    // isWalletFriendlyFood()
    // make array list from database and remake functions or test a few

    // isQuick()

    // Food
    Food food =
        new Food(
            100,
            "Something",
            "Bye",
            30,
            "idk",
            113,
            "fd",
            true,
            "image",
            500,
            true,
            false,
            false,
            false,
            false,
            false,
            true,
            false,
            true);
    Food food2 =
        new Food(
            101,
            "Something",
            "Bye",
            5,
            "american",
            5,
            "Hot and sexy",
            false,
            "image",
            1,
            false,
            true,
            true,
            true,
            true,
            true,
            false,
            true,
            false);
    assertTrue(food.isSoldOut());
    assertFalse(food2.isSoldOut());

    assertFalse(food.isWalletFriendly());
    assertTrue(food2.isWalletFriendly());

    assertFalse(food.isItalian());
    assertTrue(food2.isItalian());

    assertTrue(food.isHalal());
    assertFalse(food2.isHalal());

    assertFalse(food.isQuickDelivery());
    assertTrue(food2.isQuickDelivery());

    // OrderItem
    OrderItem OI = new OrderItem(13, food, 10);
    System.out.println(food.getFoodPrice());
    assertEquals(OI.calculateCost(), 1130);

    // OrderItem

    // FoodDelivery
    // FoodDelivery fd = new FoodDelivery();

  }

  @Test
  public void test() {
    testFood();
  }
}
