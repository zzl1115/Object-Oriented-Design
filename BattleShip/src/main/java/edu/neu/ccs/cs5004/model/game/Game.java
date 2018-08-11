package edu.neu.ccs.cs5004.model.game;

import edu.neu.ccs.cs5004.model.cell.AttackResult;

public interface Game extends Subject{
  AttackResult userFire();

  AttackResult userSmartFire();

  AttackResult robotFire();

  AttackResult robotSmartFire();

  void printGame();

  static Game createRegularGame(boolean randPlace) {
    return new RegularGame(randPlace);
  }

  static Game createDebugGame(int numBattle, int numCruiser, int numSubmarine, int numDestroyer, boolean randPlace) {
    return new DebugGame(numBattle, numCruiser, numSubmarine, numDestroyer, randPlace);
  }

  boolean endGame();
}
