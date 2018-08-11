package edu.neu.ccs.cs5004.model.cell;

import java.util.Objects;

import edu.neu.ccs.cs5004.model.ship.Ship;


public class SpecificShipCell extends AbstractShipCell {
  private Ship ship;

  /**
   * Constructor.
   *
   * @param ship Ship
   */
  public SpecificShipCell(Ship ship) {
    super();
    this.ship = ship;
  }

  /**
   * Set the ship of the ship cell.
   *
   * @param ship Ship
   */
  public void setShip(Ship ship) {
    this.ship = ship;
  }

  /**
   * Return the ship of the ship cell.
   *
   * @return Ship
   */
  public Ship getShip() {
    return ship;
  }

  @Override
  public Cell attackCell() {
    setHit(true);
    setShip(ship.hitShip());
    if (ship.isSunk()) {
      setSunk(true);
    }
    return this;
  }

  @Override
  public AttackResult attackResult() {
    if (ship.isSunk()) {
      return new Sunk();
    }
    return new Hit();
  }

  @Override
  public boolean equals(Object object) {
    super.equals(object);
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    SpecificShipCell that = (SpecificShipCell) object;
    return Objects.equals(getShip(), that.getShip());
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), getShip());
  }

  @Override
  public String toString() {
    return "SpecificShipCell{"
            + "ship=" + ship
            + ", isSunk=" + isSunk
            + ", isHit=" + isHit
            + '}';
  }
}
