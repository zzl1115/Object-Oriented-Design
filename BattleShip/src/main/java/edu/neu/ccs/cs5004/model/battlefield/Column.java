package edu.neu.ccs.cs5004.model.battlefield;

public enum Column {
  COLUMN_A('A'), COLUMN_B('B'), COLUMN_C('C'), COLUMN_D('D'), COLUMN_E('E'),
  COLUMN_F('F'), COLUMN_G('G'), COLUMN_H('H'), COLUMN_I('I'), COLUMN_J('J');
  private final char index;

  /**
   * Constructor.
   * @param index The index of the column
   */
  Column(char index) {
    this.index = index;
  }
}
