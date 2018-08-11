package edu.neu.ccs.cs5004.controller;

import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.model.cell.AttackResult;
import edu.neu.ccs.cs5004.model.game.Game;
import edu.neu.ccs.cs5004.view.GameObserver;
import edu.neu.ccs.cs5004.view.View;

public class Controller {
  private GameObserver console;
  private Game game;
  private boolean smartAttack;

  /**
   * Set the game with mode choose, place strategy choose and attack strategy choose.
   */
  private void setGame() {
    boolean debug = ConsolePrinter.mode();
    boolean randPlace = ConsolePrinter.randPlace();
    smartAttack = ConsolePrinter.smartAttack();
    if(debug) {
      setDebugGame(randPlace);
    } else {
      setRegularGame(randPlace);
    }
  }

  /**
   * Set a game with debug mode.
   * @param randPlace boolean
   */
  private void setDebugGame(boolean randPlace) {
    int numBattle = ConsolePrinter.numOfShip("BattleShip");
    int numCruiser = ConsolePrinter.numOfShip("Cruiser");
    int numSubmarine = ConsolePrinter.numOfShip("Submarine");
    int numDestroyer = ConsolePrinter.numOfShip("Destroyer");
    game = Game.createDebugGame(numBattle,numCruiser,numSubmarine,numDestroyer, randPlace);
  }

  /**
   * Set a game with game mode and the placement.
   * @param randPlace boolean
   */
  private void setRegularGame(boolean randPlace) {
    game = Game.createRegularGame(randPlace);
  }

  /**
   * Connect view and model.
   */
  private void gamePrepare() {
    ConsolePrinter.printName();
    setGame();
    console = new View();
    game.registerObserver(console);
    console.update(game);
    ConsolePrinter.gameStart();
  }

  /**
   * Game continue with round.
   */
  private void gameLoop() {
    robotFire();
  }

  /**
   * Robot fire round.
   */
  private void robotFire() {
    if(game.endGame()) {
      console.update(game);
      System.out.println("Robot Win!");//
//      System.exit(0);
      return;
  //    end();
    } else {
      AttackResult result = smartAttack ? game.robotSmartFire() : game.robotFire();
      if (result.toString().equals("Miss")) {
        userFire();
      } else {
        robotFire();
      }
    }
    return;
  }

  /**
   * User fire round.
   */
  private void userFire() {
    if(game.endGame()) {
      System.out.println("You Win!");
   //   System.exit(0);
      return;
  //    end();
    } else {
      AttackResult result = game.userFire();
      ConsolePrinter.attackMessage(result);
      if (result.toString().equals("Miss")) {
        robotFire();
      } else {
        userFire();
      }
    }
    return;
  }


  /**
   * Game start.
   */
  public void gameStart() {
    gamePrepare();
    gameLoop();
  }
}
