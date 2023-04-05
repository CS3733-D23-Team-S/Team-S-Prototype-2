package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import lombok.Getter;
import lombok.Setter;

public class Food {
  @Getter private int FoodID;
  @Getter @Setter private String FoodName;
  @Getter private String FoodType;
  @Getter @Setter private int FoodPrepTime;
  @Getter private String FoodCuisine;
  @Getter @Setter private double FoodPrice;
  @Getter @Setter private String FoodDescription;
  @Setter private boolean isSoldOut;
  @Getter @Setter private String image;
  @Getter @Setter private int calories;

  @Getter @Setter private boolean isItalian;
  @Getter @Setter private boolean isAmerican;
  @Getter @Setter private boolean isMexican;
  @Getter @Setter private boolean isIndian;
  @Getter @Setter private boolean isVegetarian;
  @Getter @Setter private boolean isHalal;
  @Getter @Setter private boolean isVegan;
  @Getter @Setter private boolean isGlutFree;
  @Getter @Setter private boolean isKosher;

  public Food(
      int fid,
      String fn,
      String ft,
      int fpt,
      String fc,
      double fp,
      String fd,
      boolean so,
      String i,
      int c,
      boolean am,
      boolean it,
      boolean mex,
      boolean in,
      boolean vege,
      boolean veg,
      boolean hal,
      boolean g,
      boolean k) {
    FoodID = fid;
    FoodName = fn;
    FoodType = ft;
    FoodPrepTime = fpt;
    FoodCuisine = fc;
    FoodPrice = fp;
    FoodDescription = fd;
    isSoldOut = so;
    image = i;
    calories = c;

    isAmerican = am;
    isItalian = it;
    isMexican = mex;
    isIndian = in;
    isVegetarian = vege;
    isVegan = veg;
    isHalal = hal;
    isGlutFree = g;
    isKosher = k;
  }

  public boolean isSoldOut() {
    return isSoldOut;
  }

  public boolean isWalletFriendly() {
    if (FoodPrice < 15) {
      return true;
    }

    return false;
  }

  public boolean isQuickDelivery() {
    if ((FoodPrepTime + 10) < 30) {
      return true;
    }

    return false;
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
            + "\nImage Path: "
            + image
            + "\nCalories: "
            + calories;

    if (isSoldOut) theFood = theFood + "\nSOLD OUT!";
    else theFood = theFood + "\nIN STOCK";

    return theFood;
  }
}