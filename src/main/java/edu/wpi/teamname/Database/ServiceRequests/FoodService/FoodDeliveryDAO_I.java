package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import java.util.List;

public interface FoodDeliveryDAO_I {
  public List<FoodDelivery> getAllRequests();

  public FoodDelivery getRequest(int requestID);

  public void addRequest(FoodDelivery request);

  public void deleteRequest(FoodDelivery request);
}
