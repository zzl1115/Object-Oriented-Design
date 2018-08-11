package edu.neu.ccs.cs5004.model.game;

import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.model.player.board.BattleMap;
import edu.neu.ccs.cs5004.model.player.board.FleetMap;

public class RegularGame extends MyGame {
  public RegularGame(boolean randPlace) {
    FleetMap userFleet = new FleetMap(1, 2, 3, 4);
    FleetMap robotFleet = new FleetMap(1,2,3,4);
    BattleMap userBattle = new BattleMap(robotFleet);
    BattleMap robotBattle = new BattleMap(userFleet);
    user = Player.createUserPlayer(randPlace, userFleet, userBattle);
    robot = Player.createRobotPlayer(robotFleet, robotBattle);
  }
}
