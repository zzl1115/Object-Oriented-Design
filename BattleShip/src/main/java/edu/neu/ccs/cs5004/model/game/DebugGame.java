package edu.neu.ccs.cs5004.model.game;

import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.model.player.board.BattleMap;
import edu.neu.ccs.cs5004.model.player.board.FleetMap;

public class DebugGame extends MyGame {

  public DebugGame(int numBattle, int numCruiser, int numSubmarine, int numDestroyer, boolean randPlace) {
    FleetMap userFleet = new FleetMap(numBattle, numCruiser, numSubmarine, numDestroyer);
    FleetMap robotFleet = new FleetMap(numBattle, numCruiser, numSubmarine, numDestroyer);
    BattleMap userBattle = new BattleMap(robotFleet);
    BattleMap robotBattle = new BattleMap(userFleet);
    user = Player.createUserPlayer(randPlace, userFleet, userBattle);
    robot = Player.createRobotPlayer(robotFleet, robotBattle);
  }

  @Override
  public void printGame() {
    super.printGame();
    System.out.println("Enemy Fleet:");
    robot.printFleet();
    System.out.println("Enemy Battle:");
    user.printBattle();
    System.out.println();
  }
}
