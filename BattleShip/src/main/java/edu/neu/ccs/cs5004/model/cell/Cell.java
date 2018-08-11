package edu.neu.ccs.cs5004.model.cell;

public interface Cell {
  /**
   * Return true if can place ship in this cell, otherwise return false.
   *
   * @return Boolean
   */
  Boolean placeShipOnCell();

  /**
   * Attack the cell then return the cell after being attacked.
   *
   * @return Cell
   */
  Cell attackCell();

  /**
   * Return the attack result after being attacked.
   *
   * @return AttackResult
   */
  AttackResult attackResult();

  /**
   * Return true if the cell had been attacked, otherwise return false.
   *
   * @return Boolean
   */
  Boolean isCellHit();
}
