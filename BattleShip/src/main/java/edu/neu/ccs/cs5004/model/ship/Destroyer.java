package edu.neu.ccs.cs5004.model.ship;

public class Destroyer extends AbstractShip {
  private static final Integer CELL_OCCUPY = 1;
  private static final Integer UNHIT_SHIP_CELL = 0;

  /**
   * Constructor.
   */
  public Destroyer() {
    super(CELL_OCCUPY, UNHIT_SHIP_CELL);
  }

  @Override
  public String toString() {
    return "Destroyer{"
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
    return super.hashCode();
  }

  @Override
  public String getName() {
    return "Destroyer";
  }
}
