package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import lombok.Getter;
import lombok.Setter;

public class Food {
  @Getter private int FoodID;
  @Getter private String FoodName;
  @Getter private String FoodType;
  @Getter private int FoodPrepTime;
  @Getter private String FoodCuisine;
  @Getter @Setter private double FoodPrice;
  @Getter @Setter private String FoodDescription;
  @Getter private int quantity;
  @Setter private boolean isSoldOut;
  @Getter @Setter private String image;

  // FoodImage

  public Food(int fid, String fn, String ft, int fpt, String fc, double fp, String fd, int q) {
    FoodID = fid;
    FoodName = fn;
    FoodType = ft;
    FoodPrepTime = fpt;
    FoodCuisine = fc;
    FoodPrice = fp;
    FoodDescription = fd;
    quantity = q;
    isSoldOut = false;
  }

  public boolean isSoldOut() {
    return isSoldOut;
  }

  @Override
  public String toString() {
    String theFood;

    theFood =
        "ID: "
            + FoodID
            + "\nName: "
            + FoodName
            + "\nType: "
            + FoodType
            + "\nPrep Time: "
            + FoodPrepTime
            + "\nCuisine: "
            + FoodCuisine
            + "\nPrice: "
            + FoodPrice
            + "\nDescription: "
            + FoodDescription
            + "\nAmount in Stock: "
            + quantity;

    if (isSoldOut) theFood = theFood + "\nSOLD OUT!";
    else theFood = theFood + "\nIN STOCK";

    return theFood;
  }
}
