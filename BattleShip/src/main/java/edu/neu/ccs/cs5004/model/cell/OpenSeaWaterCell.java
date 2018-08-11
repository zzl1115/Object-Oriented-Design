package edu.neu.ccs.cs5004.model.cell;

public class OpenSeaWaterCell extends AbstractWaterCell {
  /**
   * Constructor.
   */
  public OpenSeaWaterCell() {
    super();
  }

  @Override
  public Boolean placeShipOnCell() {
    return true;
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode() * 6;
  }

  @Override
  public String toString() {
    return "OpenSeaWaterCell";
  }
}
