package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import java.util.HashMap;
import java.util.List;

public class FoodDeliveryDAOImp implements FoodDeliveryDAO_I {
  HashMap<Integer, FoodDelivery> requests = new HashMap<>();
  static FoodDeliveryDAOImp single_instance;

  private FoodDeliveryDAOImp() {}

  public static synchronized FoodDeliveryDAOImp getInstance() {

    if (single_instance == null) single_instance = new FoodDeliveryDAOImp();

    return single_instance;
  }

  @Override
  public List<FoodDelivery> getAllRequests() {
    return null;
  }

  @Override
  public FoodDelivery getRequest(int requestID) {
    return null;
  }

  @Override
  public void addRequest(FoodDelivery request) {}

  @Override
  public void deleteRequest(FoodDelivery request) {}
}
