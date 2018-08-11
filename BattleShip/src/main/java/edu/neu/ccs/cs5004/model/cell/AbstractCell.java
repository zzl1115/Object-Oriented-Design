package edu.neu.ccs.cs5004.model.cell;

import java.util.Objects;

public abstract class AbstractCell implements Cell {
  protected Boolean isHit;

  /**
   * Constructor.
   *
   * @param isHit Boolean
   */
  public AbstractCell(Boolean isHit) {
    this.isHit = isHit;
  }

  /**
   * Set the hit of the cell.
   *
   * @param hit Boolean
   */
  public void setHit(Boolean hit) {
    isHit = hit;
  }

  @Override
  public Boolean isCellHit() {
    return isHit;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractCell that = (AbstractCell) object;
    return Objects.equals(isHit, that.isHit);
  }

  @Override
  public int hashCode() {

    return Objects.hash(isHit);
  }
}
