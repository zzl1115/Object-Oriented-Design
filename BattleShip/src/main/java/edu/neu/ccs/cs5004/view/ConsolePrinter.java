package edu.neu.ccs.cs5004.view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.neu.ccs.cs5004.model.battlefield.Map;
import edu.neu.ccs.cs5004.model.cell.AttackResult;
import edu.neu.ccs.cs5004.model.cell.Cell;
import edu.neu.ccs.cs5004.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.model.ship.Ship;

public class ConsolePrinter {

  /**
   * Print the map: use " " represent the water cell, use "o" represent ship cell.
   *
   * @param map Map
   */
  public void toConsole(Map map) {
    Cell[][] cells = map.getCells();
 //   System.out.println("    A B C D E F G H I J");
    System.out.println("    A   B   C   D   E   F   G   H   I   J");
    System.out.println("  +---+---+---+---+---+---+---+---+---+---+");
//    System.out.println("   ---------------------");
    for (int i = 0; i < cells.length; i++) {
//      System.out.println("---------------------");
      System.out.format("%2d", i + 1);
      System.out.print("|");
      for (int j = 0; j < cells[0].length; j++) {

        if (cells[i][j].getClass() == SpecificShipCell.class) {
          if (cells[i][j].isCellHit()) {
            System.out.print(" X" + " " + '|');
          } else {
            System.out.print(" O" + " |");
          }
        } else {
          if (cells[i][j].isCellHit()) {
            System.out.print(" *" + " |");
          } else {
            System.out.print("   " + '|');
          }
        }
      }
      System.out.println();
    }
    System.out.println("  +---+---+---+---+---+---+---+---+---+---+");
    //System.out.println("   ---------------------");
  }

  public void toEnemyMap(Map map) {
    Cell[][] cells = map.getCells();
   // System.out.println("    A B C D E F G H I J");
    System.out.println("    A   B   C   D   E   F   G   H   I   J");
    //System.out.println("   ---------------------");
    System.out.println("  +---+---+---+---+---+---+---+---+---+---+");
    for (int i = 0; i < cells.length; i++) {
//      System.out.println("---------------------");
      System.out.format("%2d", i + 1);
      System.out.print("|");
      for (int j = 0; j < cells[0].length; j++) {
        if (cells[i][j].isCellHit()) {
          if (cells[i][j].getClass() == SpecificShipCell.class) {
            System.out.print(" X" + " |");
          } else {
            System.out.print(" * |");
          }
        } else {
          System.out.print("   |");
        }
      }
      System.out.println();
    }
    System.out.println("  +---+---+---+---+---+---+---+---+---+---+");
 //   System.out.println("   ---------------------");
  }

  public static boolean mode() {
    BufferedReader br;
    boolean result = false;
    System.out.print("Please Choose the Mode(G/D): ");
    try {
      while(true) {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.equals("G")) {
          result = false;
        }
        else if(str.equals("D")) {
          result = true;
        } else{
          System.out.println("Invalid Input!");
          continue;
        }
        break;
      }
    } catch (
            IOException e)

    {
      e.printStackTrace();
    }
    return result;
  }

  public static int numOfShip(String ship) {
    BufferedReader br;
    int result = 0;
    try {
      while(true) {
        System.out.print("The number of " + ship + ": ");
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        result = Integer.parseInt(str);
        if (result < 0 || result > 5) {
          System.out.println("Invalid Input!");
          continue;
        }
        break;
      }
    } catch (
            IOException e)

    {
      e.printStackTrace();
    }
    return result;
  }

  public static boolean randPlace() {
    BufferedReader br;
    boolean result = false;
    try {
      while(true) {
        System.out.print("Place Ships Randomly(Y/N): ");
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.equals("N")) {
          result = false;
        }
        else if(str.equals("Y")) {
          result = true;
        } else{
          System.out.println("Invalid Input!");
          continue;
        }
        break;
      }
    } catch (
            IOException e)

    {
      e.printStackTrace();
    }
    return result;
  }

  public static boolean smartAttack() {
    BufferedReader br;
    boolean result = false;
    try {
      while(true) {
        System.out.print("Robot Strategy?(S(Smart)/R(Random)): ");
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.equals("R")) {
          result = false;
        }
        else if(str.equals("S")) {
          result = true;
        } else{
          System.out.println("Invalid Input!");
          continue;
        }
        break;
      }
    } catch (
            IOException e)

    {
      e.printStackTrace();
    }
    return result;
  }

  public static void gameStart() {
    System.out.println("Game Start!");
  }

  public static void attackMessage(AttackResult attackResult) {
    System.out.println(attackResult.toString());
  }

  public static void printName() {
    System.out.println("  ____       _______ _______ _      ______  _____ _    _ _____ _____  \n" +
            " |  _ \\   /\\|__   __|__   __| |    |  ____|/ ____| |  | |_   _|  __ \\ \n" +
            " | |_) | /  \\  | |     | |  | |    | |__  | (___ | |__| | | | | |__) |\n" +
            " |  _ < / /\\ \\ | |     | |  | |    |  __|  \\___ \\|  __  | | | |  ___/ \n" +
            " | |_) / ____ \\| |     | |  | |____| |____ ____) | |  | |_| |_| |     \n" +
            " |____/_/    \\_\\_|     |_|  |______|______|_____/|_|  |_|_____|_|     ");
  }
}
