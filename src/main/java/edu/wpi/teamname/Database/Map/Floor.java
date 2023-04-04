package edu.wpi.teamname.Database.Map;

public enum Floor {
  Floor1("1"),
  Floor2("2"),
  Floor3("3"),
  L1("L1"),
  L2("L2");

  private final String label;

  private Floor(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }
}
