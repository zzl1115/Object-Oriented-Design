package edu.neu.ccs.cs5004.model.ship;

import edu.neu.ccs.cs5004.model.battlefield.Column;
import edu.neu.ccs.cs5004.model.battlefield.Direction;
import edu.neu.ccs.cs5004.model.battlefield.Row;

public interface Ship {
  /**
   * Attack the ship then return the new ship.
   *
   * @return Ship
   */
  Ship hitShip();

  /**
   * Return true if the ship has been sunk, otherwise return false.
   *
   * @return Boolean
   */
  Boolean isSunk();

  /**
   * Return the size of cells of this ship.
   *
   * @return Integer
   */
  Integer getSize();

  /**
   * Return the number of cells that are attacked of ship.
   *
   * @return Integer
   */
  Integer getHitCells();

  /**
   * Get the name of the ship.
   * @return String
   */
  String getName();

  /**
   * Set the top left position and the direction of the ship.
   */
  void setShip(Row row, Column column, Direction direction);
  Direction getDirection();
  Row getTopleftRow();
  Column getTopleftColumn();
}
