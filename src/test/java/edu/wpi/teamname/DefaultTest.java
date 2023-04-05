/*-------------------------*/
/* DO NOT DELETE THIS TEST */
/*-------------------------*/

package edu.wpi.teamname;

import static org.junit.jupiter.api.Assertions.*;

import edu.wpi.teamname.Database.ServiceRequests.FoodService.Food;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.FoodDelivery;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.OrderItem;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.OrderItemDAO;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DefaultTest {

  public void testFood() throws Exception {

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
    assertEquals(OI.calculateCost(), 1130);

    // OrderItemDAO
    OrderItemDAO OIDao = new OrderItemDAO(1000);
    OIDao.addOrderItem(food2, 10);
    OrderItem OITest = new OrderItem(1000, food2, 10);
    assertEquals(OIDao.getOrderItem(food2.getFoodName()), OITest);

    OrderItem OI2 = OIDao.getOrderItem(food2.getFoodName());

    OIDao.updateOrderQuantity(food2.getFoodName(), 20);
    assertEquals(OI2.getQuantity(), 20);

    OIDao.deleteOrderItem(food2.getFoodName());
    Exception exception = assertThrows(Exception.class, () -> OIDao.getOrderItem(food2.getFoodName()));
    assertEquals("Item Not Present", exception.getMessage());

    Exception exception2 = assertThrows(Exception.class, () -> OIDao.deleteOrderItem("WAAAAAAAA"));
    assertEquals("Item Not Present", exception2.getMessage());

    // FoodDelivery
    Date date = new Date();
    FoodDelivery fd = new FoodDelivery(56, OIDao, date, null, "Person");
    assertEquals(fd.orderTotal(), );

  }

  @Test
  public void test() throws Exception {
    testFood();
  }
}
