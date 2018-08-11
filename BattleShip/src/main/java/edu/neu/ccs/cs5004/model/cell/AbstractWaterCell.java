package edu.neu.ccs.cs5004.model.cell;

public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {
  /**
   * Constructor.
   */
  public AbstractWaterCell() {
    super(false);
  }

  @Override
  public Cell attackCell() {
    setHit(true);
    return this;
  }

  @Override
  public AttackResult attackResult() {
    return new Miss();
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
