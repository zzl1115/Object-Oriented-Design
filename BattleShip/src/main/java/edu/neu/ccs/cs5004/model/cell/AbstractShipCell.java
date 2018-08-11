package edu.neu.ccs.cs5004.model.cell;

import java.util.Objects;

public abstract class AbstractShipCell extends AbstractCell implements ShipCell {
  protected Boolean isSunk;

  /**
   * Constructor.
   */
  public AbstractShipCell() {
    super(false);
    this.isSunk = false;
  }

  /**
   * Set the sunk statuc of cell.
   *
   * @param sunk Boolean
   */
  public void setSunk(Boolean sunk) {
    isSunk = sunk;
  }

  /**
   * Return true if the ship in this cell has been sunk.
   *
   * @return Boolean
   */
  public Boolean getSunk() {
    return isSunk;
  }

  @Override
  public Boolean placeShipOnCell() {
    return false;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    AbstractShipCell that = (AbstractShipCell) object;
    return Objects.equals(isSunk, that.isSunk);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), isSunk);
  }
}
