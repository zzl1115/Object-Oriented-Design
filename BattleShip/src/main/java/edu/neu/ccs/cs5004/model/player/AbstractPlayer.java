package edu.neu.ccs.cs5004.model.player;

import java.util.Observable;

import edu.neu.ccs.cs5004.model.cell.AttackResult;
import edu.neu.ccs.cs5004.model.player.board.BattleMap;
import edu.neu.ccs.cs5004.model.player.board.FleetMap;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

public class AbstractPlayer extends Observable implements Player{
  private FleetMap fleetMap;
  private BattleMap battleMap;
  private boolean randPlace;

  AbstractPlayer(FleetMap fleetMap, BattleMap battleMap, boolean randPlace) {
    this.fleetMap = fleetMap;
    this.battleMap = battleMap;
    this.randPlace = randPlace;
    fleetMap.setMap(randPlace);
  }

  //@Override
//  public BattleMap getBattleMap() {
//    return battleMap;
//  }

  @Override
  public AttackResult randomAttack() {
    return battleMap.randomAttack();
  }

  @Override
  public AttackResult userAttack() {
    return battleMap.userAttack();
  }

  @Override
  public AttackResult smartAttack() {
    return battleMap.smartAttack();
  }

  @Override
  public boolean winGame() {
    return battleMap.endGame();
  }

  @Override
  public void printFleet() {
    ConsolePrinter printer = new ConsolePrinter();
    printer.toConsole(fleetMap.getMap());
  }

  @Override
  public void printBattle() {
    ConsolePrinter printer = new ConsolePrinter();
    printer.toEnemyMap(fleetMap.getMap());
  }
}
