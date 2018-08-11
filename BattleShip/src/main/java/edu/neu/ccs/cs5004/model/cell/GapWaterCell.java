package edu.neu.ccs.cs5004.model.cell;

public class GapWaterCell extends AbstractWaterCell {
  /**
   * Constructor.
   */
  public GapWaterCell() {
    super();
  }

  @Override
  public Boolean placeShipOnCell() {
    return false;
  }

  @Override
  public String toString() {
    return "GapWaterCell";
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode() * 2;
  }
}
