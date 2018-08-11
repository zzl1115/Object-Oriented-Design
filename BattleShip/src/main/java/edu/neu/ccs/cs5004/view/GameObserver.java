package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.model.game.Game;

public interface GameObserver {

  /**
   * Update the print map.
   * @param observable Game
   */
  void update(Game observable);
}
