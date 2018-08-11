package edu.neu.ccs.cs5004.model.player;

import edu.neu.ccs.cs5004.model.cell.AttackResult;
import edu.neu.ccs.cs5004.model.player.board.BattleMap;
import edu.neu.ccs.cs5004.model.player.board.FleetMap;

public interface Player {


//  BattleMap getBattleMap();

  AttackResult randomAttack();

  AttackResult userAttack();

  AttackResult smartAttack();

  boolean winGame();

  void printFleet();
  void printBattle();

  static Player createUserPlayer(boolean randPlace, FleetMap fleetMap, BattleMap battleMap) {
    return new AbstractPlayer(fleetMap, battleMap, randPlace);
  }

  static Player createRobotPlayer(FleetMap fleetMap, BattleMap battleMap) {
    return new AbstractPlayer(fleetMap, battleMap, true);
  }
}
