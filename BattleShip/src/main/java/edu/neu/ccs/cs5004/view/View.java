package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.model.game.Game;

public class View implements GameObserver {
  @Override
  public void update(Game observable) {
    observable.printGame();
  }
}
