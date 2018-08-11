package edu.neu.ccs.cs5004.model.ship;

import java.util.Objects;

import edu.neu.ccs.cs5004.model.battlefield.Column;
import edu.neu.ccs.cs5004.model.battlefield.Direction;
import edu.neu.ccs.cs5004.model.battlefield.Row;

public abstract class AbstractShip implements Ship {
  private Integer size;
  private Integer hitCell;
  private Direction direction;
  private Row topleftRow;
  private Column topleftColumn;

  @Override
  public Direction getDirection() {
    return direction;
  }

  @Override
  public Row getTopleftRow() {
    return topleftRow;
  }

  @Override
  public Column getTopleftColumn() {
    return topleftColumn;
  }

  /**
   * Constructor.
   */
  public AbstractShip(Integer size, Integer hitCell) {
    this.size = size;
    this.hitCell = hitCell;
    direction = null;
    topleftColumn = null;
    topleftRow = null;
  }

  /**
   * Return the size of the ship.
   *
   * @return Integer
   */
  @Override
  public Integer getSize() {
    return size;
  }

  /**
   * Return the number of cells that are attacked  of ship.
   *
   * @return Integer
   */

  @Override
  public Integer getHitCells() {
    return hitCell;
  }

  /**
   * Return the Abstractship which has been attacked.
   *
   * @return Ship
   */
  @Override
  public Ship hitShip() {
    hitCell++;
    return this;
  }


  /**
   * Return true if the ship has been sunk, otherwise return false.
   *
   * @return Boolean
   */
  @Override
  public Boolean isSunk() {
    return hitCell.equals(size);
  }

  public void setShip(Row row, Column column, Direction direction) {
    topleftRow = row;
    topleftColumn = column;
    this.direction = direction;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractShip abstractship = (AbstractShip) object;
    return Objects.equals(getSize(), abstractship.getSize())
            && Objects.equals(hitCell, abstractship.hitCell);
  }

  @Override
  public int hashCode() {

    return Objects.hash(getSize(), hitCell);
  }

}
