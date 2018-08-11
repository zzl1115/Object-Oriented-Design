package edu.neu.ccs.cs5004.model.ship;

public class Cruiser extends AbstractShip {
  private static final Integer CELL_OCCUPY = 3;
  private static final Integer UNHIT_SHIP_CELL = 0;

  /**
   * Constructor.
   */
  public Cruiser() {
    super(CELL_OCCUPY, UNHIT_SHIP_CELL);
  }

  @Override
  public String toString() {
    return "Cruiser{"
            + "size=" + this.getSize()
            + ", hitCell=" + this.getHitCells()
            + '}';
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode() * 3;
  }

  @Override
  public String getName() {
    return "Cruiser";
  }
}
