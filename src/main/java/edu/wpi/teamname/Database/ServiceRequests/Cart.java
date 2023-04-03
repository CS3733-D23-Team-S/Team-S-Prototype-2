package edu.wpi.teamname.Database.ServiceRequests;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class Cart {
    @Getter private int CartId;
    private HashMap<Integer, Integer > foodItems;

    private FoodDAOImpl foodDAO = FoodDAOImpl.getInstance();

    private int TotalPrice;

    public Cart(int cid) {
        CartId = cid;
    }

    public int calculateTotalPrice(){
        int totalPrice;
        return 0;
    }






}
