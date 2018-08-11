package edu.neu.ccs.cs5004.model.player.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import edu.neu.ccs.cs5004.model.battlefield.Column;
import edu.neu.ccs.cs5004.model.battlefield.Direction;
import edu.neu.ccs.cs5004.model.battlefield.Map;
import edu.neu.ccs.cs5004.model.battlefield.Row;
import edu.neu.ccs.cs5004.model.cell.AttackResult;
import edu.neu.ccs.cs5004.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.model.ship.Ship;

public class BattleMap {
  private FleetMap map;
  private int numBattle;
  private int numCruiser;
  private int numSubmarine;
  private int numDestroyer;
 // private boolean debug;

  public BattleMap(FleetMap map) {
    this.map = map;
    this.numBattle = 0;
    this.numCruiser = 0;
    this.numSubmarine = 0;
    this.numDestroyer = 0;
  //  this.debug = debug;
  }

  public void attack(Row row, Column column) {
    if(map.getMap().getCell(row, column).attackCell().attackResult().toString().equals("Sunk")) {
      SpecificShipCell cell = (SpecificShipCell)map.getMap().getCell(row, column);
      sunkSet(cell.getShip(), map.getMap());
    }
  }

  public AttackResult randomAttack() {
    Random index = new Random();
    Row row = Row.values()[index.nextInt(10)];
    Column column = Column.values()[index.nextInt(10)];
    while (map.getMap().getCell(row, column).isCellHit()) {
      row = Row.values()[index.nextInt(10)];
      column = Column.values()[index.nextInt(10)];
    }
    attack(row, column);
    return map.getMap().getCell(row, column).attackResult();
  }

  public AttackResult smartAttack() {
    for(int i = 0; i < 10; i++) {
      for(int j = 0; j < 10; j++) {
        Row row = Row.values()[i];
        Column column = Column.values()[j];
        if(map.getMap().getCell(row, column).isCellHit()
        && map.getMap().getCell(row, column).attackResult().toString().equals("Hit")){
          if(j + 1 < 10 && map.getMap().getCell(row, Column.values()[j+1]).isCellHit()
          && map.getMap().getCell(row, Column.values()[j+1]).attackResult().toString().equals("Hit")){
            int index = j-1 >= 0? -1 : 2;
            while (j+index < 10 && map.getMap().getCell(row, column).isCellHit()) {
              column = Column.values()[j+index];
              index++;
            }
          } else if(i + 1 < 10 && map.getMap().getCell(Row.values()[i+1], column).isCellHit()
                  && map.getMap().getCell(Row.values()[i+1], column).attackResult().toString().equals("Hit")){
            int index = i-1 >= 0? -1 : 2;
            while (i +index < 10 && map.getMap().getCell(row, column).isCellHit()) {
              row = Row.values()[i+index];
              index++;
            }
          } else if(i - 1 >= 0 && !map.getMap().getCell(Row.values()[i-1], column).isCellHit()) {
            row = Row.values()[i-1];
          } else if(i + 1 < 10 && !map.getMap().getCell(Row.values()[i+1], column).isCellHit()) {
            row = Row.values()[i+1];
          } else if(j - 1 >= 0 && !map.getMap().getCell(row, Column.values()[j-1]).isCellHit()) {
            column = Column.values()[j-1];
          } else if(j + 1 < 10 && !map.getMap().getCell(row, Column.values()[j+1]).isCellHit()){
            column = Column.values()[j+1];
          } else {
            break;
          }
          attack(row, column);
          return map.getMap().getCell(row, column).attackResult();
        }
      }
    }
    return randomAttack();
  }

  public void sunkSet(Ship ship, Map map) {
    Row row = ship.getTopleftRow();
    Column column = ship.getTopleftColumn();
    Direction direction = ship.getDirection();
    switch (direction) {
      case Horizontal:
        for(int i = 0; i < ship.getSize(); i++) {
          if(row.ordinal() - 1 >= 0) {
            map.getCell(Row.values()[row.ordinal() - 1], Column.values()[column.ordinal() + i]).attackCell();
          }
          if(row.ordinal() + 1 < Map.ROW) {
            map.getCell(Row.values()[row.ordinal() + 1], Column.values()[column.ordinal() + i]).attackCell();
          }
        //  map.setCell(new SpecificShipCell(ship), row, Column.values()[column.ordinal() + i]);
        }
        for(int i = -1; i < 2; i++) {
          if (row.ordinal() + i >= 0 && row.ordinal() + i < Map.ROW) {
            if (column.ordinal() - 1 >= 0) {
              map.getCell(Row.values()[row.ordinal() + i], Column.values()[column.ordinal() - 1]).attackCell();
            }
            if (column.ordinal() + ship.getSize() < Map.COLUMN) {
              map.getCell(Row.values()[row.ordinal() + i], Column.values()[column.ordinal() + ship.getSize()]).attackCell();
            }
          }
        }
        break;
      case Vertical:
        for(int i = 0; i < ship.getSize(); i++) {
          if(column.ordinal() - 1 >= 0) {
            map.getCell(Row.values()[row.ordinal() + i], Column.values()[column.ordinal() - 1]).attackCell();
          }
          if(column.ordinal() + 1 < Map.COLUMN) {
            map.getCell(Row.values()[row.ordinal() + i], Column.values()[column.ordinal() + 1]).attackCell();
          }
         // map.setCell(new SpecificShipCell(ship), Row.values()[row.ordinal() + i], column);
        }
        for(int i = -1; i < 2; i++) {
          if (column.ordinal() + i >= 0 && column.ordinal() + i < Map.COLUMN) {
            if (row.ordinal() - 1 >= 0) {
              map.getCell(Row.values()[row.ordinal() - 1], Column.values()[column.ordinal() + i]).attackCell();
            }
            if (row.ordinal() + ship.getSize() < Map.ROW) {
              map.getCell(Row.values()[row.ordinal() + ship.getSize()], Column.values()[column.ordinal() + i]).attackCell();
            }
          }
        }
        break;
    }
    switch (ship.getName()) {
      case "BattleShip":
        numBattle++;
        break;
      case "Cruiser":
        numCruiser++;
        break;
      case "Submarine":
        numSubmarine++;
        break;
      case "Destroyer":
        numDestroyer++;
        break;
    }
  }

  /**
   * Users attack the cell.
   * @return AttackResult
   */
  public AttackResult userAttack() {
    BufferedReader br = null;
    System.out.println("Please attack a cell");
    Row row;
    Column column;
    AttackResult result = null;
    try {
      br = new BufferedReader(new InputStreamReader(System.in));
      while (true) {
        System.out.print("Row(1 - 10) : ");
        String str1 = br.readLine();
        try {
          if ((str1.length() != 1 && str1.length() != 2) || !(Integer.parseInt(str1) > 0 && Integer.parseInt(str1) <= 10)) {
            System.out.println("Invalid Input");
            continue;
          }
        } catch (NumberFormatException e){
          System.out.println("Invalid Input");
          continue;
        }
        row = Row.values()[Integer.parseInt(str1) - 1];
        System.out.print("Column(A - J) : ");
        String str2 = br.readLine();
        if(str2.length() != 1 || !(str2.charAt(0) >= 'A'&& str2.charAt(0) <= 'J')){
          System.out.println("Invalid Input");
          continue;
        }
        column = Column.values()[str2.charAt(0) - 'A'];

        if(!map.getMap().getCell(row, column).isCellHit()) {
          attack(row, column);
          result = map.getMap().getCell(row, column).attackResult();
          break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  public boolean endGame(){
    return numBattle == map.getNumBattle()
            && numCruiser == map.getNumCruiser()
            && numSubmarine == map.getNumSubmarine()
            && numDestroyer == map.getNumDestroyer();
  }
}
