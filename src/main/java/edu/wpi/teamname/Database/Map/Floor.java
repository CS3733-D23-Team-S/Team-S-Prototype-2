package edu.wpi.teamname.Database.Map;

public enum Floor {
  Floor1("Floor1"),
  Floor2("Floor2"),
  Floor3("Floor3"),
  FloorL1("FloorL1"),
  FloorL2("FloorL2");

  final String name;

  private Floor(String name) {
    this.name = name;
  }
}
