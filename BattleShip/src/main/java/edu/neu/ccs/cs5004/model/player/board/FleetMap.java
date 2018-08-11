package edu.neu.ccs.cs5004.model.player.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.model.battlefield.Column;
import edu.neu.ccs.cs5004.model.battlefield.Direction;
import edu.neu.ccs.cs5004.model.battlefield.Map;
import edu.neu.ccs.cs5004.model.battlefield.Row;
import edu.neu.ccs.cs5004.model.cell.GapWaterCell;
import edu.neu.ccs.cs5004.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.model.ship.Battleship;
import edu.neu.ccs.cs5004.model.ship.Cruiser;
import edu.neu.ccs.cs5004.model.ship.Destroyer;
import edu.neu.ccs.cs5004.model.ship.Ship;
import edu.neu.ccs.cs5004.model.ship.Submarine;

public class FleetMap {
  private Map map;
  private int numBattle;
  private int numCruiser;
  private int numSubmarine;
  private int numDestroyer;
//  private boolean debug;

  /**
   * Constructor.
   * @param numBattle The number of BattleShip
   * @param numCruiser The number of Cruiser
   * @param numSubmarine The number of Submarine
   * @param numDestroyer The number of Destroyer
   */
  public FleetMap(int numBattle, int numCruiser, int numSubmarine, int numDestroyer) {
    map = new Map();
    this.numBattle = numBattle;
    this.numCruiser = numCruiser;
    this.numSubmarine = numSubmarine;
    this.numDestroyer = numDestroyer;
//    this.debug = debug;
  }

  /**
   * Return the map of this fleet map.
   * @return Map
   */
  public Map getMap() {
    return map;
  }

  /**
   * Place a ship in the map with given top left cell and the direction.
   * @param row The row of the top left cell
   * @param column The column of the top left cell
   * @param direction The direction of the ship
   * @param ship The kind of the ship
   */
  public void placeShip(Row row, Column column, Direction direction, Ship ship){
    if(!isPlaceShip(row,column,direction,ship)) {
      throw new RuntimeException("Can't place ship here!");
    }
    ship.setShip(row, column, direction);
    switch (direction) {
      case Horizontal:
        for(int i = 0; i < ship.getSize(); i++) {
          if(row.ordinal() - 1 >= 0) {
            map.setCell(new GapWaterCell(), Row.values()[row.ordinal() - 1], Column.values()[column.ordinal() + i]);
          }
          if(row.ordinal() + 1 < Map.ROW) {
            map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + 1], Column.values()[column.ordinal() + i]);
          }
          map.setCell(new SpecificShipCell(ship), row, Column.values()[column.ordinal() + i]);
        }
        for(int i = -1; i < 2; i++) {
          if (row.ordinal() + i >= 0 && row.ordinal() + i < Map.ROW) {
            if (column.ordinal() - 1 >= 0) {
              map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + i], Column.values()[column.ordinal() - 1]);
            }
            if (column.ordinal() + ship.getSize() < Map.COLUMN) {
              map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + i], Column.values()[column.ordinal() + ship.getSize()]);
            }
          }
        }
      break;
      case Vertical:
        for(int i = 0; i < ship.getSize(); i++) {
          if(column.ordinal() - 1 >= 0) {
            map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + i], Column.values()[column.ordinal() - 1]);
          }
          if(column.ordinal() + 1 < Map.COLUMN) {
            map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + i], Column.values()[column.ordinal() + 1]);
          }
          map.setCell(new SpecificShipCell(ship), Row.values()[row.ordinal() + i], column);
        }
        for(int i = -1; i < 2; i++) {
          if (column.ordinal() + i >= 0 && column.ordinal() + i < Map.COLUMN) {
            if (row.ordinal() - 1 >= 0) {
              map.setCell(new GapWaterCell(), Row.values()[row.ordinal() - 1], Column.values()[column.ordinal() + i]);
            }
            if (row.ordinal() + ship.getSize() < Map.ROW) {
              map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + ship.getSize()], Column.values()[column.ordinal() + i]);
            }
          }
        }
      break;
    }
  }

  /**
   * Return true if can place the ship in this top left cell with given direction, otherwise return
   * false.
   * @param row The row of the top left cell
   * @param column The column of the top left cell
   * @param direction The direction of the ship
   * @param ship The kind of the ship
   * @return
   */
  public boolean isPlaceShip(Row row, Column column,Direction direction, Ship ship) {
    switch (direction) {
      case Horizontal:
        if(column.ordinal() + ship.getSize() > Map.COLUMN) {
          return false;
        }
        for(int i = 0; i < ship.getSize(); i++) {
          if(!map.getCell(row,Column.values()[column.ordinal() + i]).placeShipOnCell()) {
            return false;
          }
        }
        return true;
      case Vertical:
        if(row.ordinal() + ship.getSize() > Map.ROW) {
          return false;
        }
        for(int i = 0; i < ship.getSize(); i++) {
          if(!map.getCell(Row.values()[row.ordinal() + i], column).placeShipOnCell()) {
            return false;
          }
        }
        return true;
    }
    return false;
  }

  /**
   * Randomly place the ship on the map.
   */
  public void randomPlacement(){
    Random index = new Random();
    Row row = Row.values()[index.nextInt(10)];
    Column column = Column.values()[index.nextInt(10)];
    Direction direction = Direction.values()[index.nextInt(2)];
    for(int i = 0; i < numBattle; i++) {
      Ship ship = new Battleship();
      while(!isPlaceShip(row, column, direction, ship)) {
        row = Row.values()[index.nextInt(10)];
        column = Column.values()[index.nextInt(10)];
        direction = Direction.values()[index.nextInt(2)];
      }
      placeShip(row,column,direction,ship);
    }
    for(int i = 0; i < numCruiser; i++) {
      Ship ship = new Cruiser();
      while(!isPlaceShip(row, column, direction, ship)) {
        row = Row.values()[index.nextInt(10)];
        column = Column.values()[index.nextInt(10)];
        direction = Direction.values()[index.nextInt(2)];
      }
      placeShip(row,column,direction,ship);
    }
    for(int i = 0; i < numSubmarine; i++) {
      Ship ship = new Submarine();
      while(!isPlaceShip(row, column, direction, ship)) {
        row = Row.values()[index.nextInt(10)];
        column = Column.values()[index.nextInt(10)];
        direction = Direction.values()[index.nextInt(2)];
      }
      placeShip(row,column,direction,ship);
    }
    for(int i = 0; i < numDestroyer; i++) {
      Ship ship = new Destroyer();
      while(!isPlaceShip(row, column, direction, ship)) {
        row = Row.values()[index.nextInt(10)];
        column = Column.values()[index.nextInt(10)];
        direction = Direction.values()[index.nextInt(2)];
      }
      placeShip(row,column,direction,ship);
    }
  }

  public void playerPlace(Ship ship, int num){
    BufferedReader br = null;
    System.out.println("Place " + num + " " + ship.getName());
    try {
      br = new BufferedReader(new InputStreamReader(System.in));
      int i = 1;
      while (i <= num) {
        System.out.println("Place the " + i + " " + ship.getName());
        System.out.print("Row(1 - 10) : ");
        String str1 = br.readLine();
        try {
          if (!(Integer.parseInt(str1) > 0 && Integer.parseInt(str1) <= 10)) {
            System.out.println("Invalid Input!");
            continue;
          }
        } catch (NumberFormatException e){
          System.out.println("Invalid Input");
          continue;
        }

        Row row = Row.values()[Integer.parseInt(str1) - 1];
        System.out.print("Column(A - J) : ");
        String str2 = br.readLine();
        if(!(str2.charAt(0) >= 'A'&& str2.charAt(0) <= 'J')){
          System.out.println("Invalid Input!");
          continue;
        }
        Column column = Column.values()[str2.charAt(0) - 'A'];

        System.out.print("Direction(Horizontal(0)/Vertical(1)) : ");
        String str3 = br.readLine();
        if(Integer.parseInt(str3) != 0 && Integer.parseInt(str3) != 1){
          System.out.println("Invalid Input!");
          continue;
        }
        Direction direction = Direction.values()[Integer.parseInt(str3)];

        if(isPlaceShip(row, column,direction, ship)) {
          placeShip(row, column, direction, ship);
          i++;
        }
        map.prettyPrint(new ConsolePrinter());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int getNumBattle() {
    return numBattle;
  }

  public int getNumCruiser() {
    return numCruiser;
  }

  public int getNumSubmarine() {
    return numSubmarine;
  }

  public int getNumDestroyer() {
    return numDestroyer;
  }

  /**
   * Set up the map with ship.
   */
  public void setMap(boolean randomSet){
    if(randomSet) {
      randomPlacement();
    } else {
      playerPlace(new Battleship(), numBattle);
      playerPlace(new Cruiser(), numCruiser);
      playerPlace(new Submarine(), numSubmarine);
      playerPlace(new Destroyer(), numDestroyer);
    }
  }
}
