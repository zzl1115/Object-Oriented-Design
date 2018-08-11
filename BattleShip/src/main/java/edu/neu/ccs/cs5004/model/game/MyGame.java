package edu.neu.ccs.cs5004.model.game;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.model.cell.AttackResult;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.GameObserver;

public abstract class MyGame implements Game {
  protected Player user;
  protected Player robot;
  protected List<GameObserver> observers;

  public MyGame() {
    observers = new ArrayList<>();
  }

  @Override
  public AttackResult userFire() {
    AttackResult result = user.userAttack();
    notifyObservers();
    return result;
  }

  @Override
  public AttackResult robotFire() {
    AttackResult result = robot.randomAttack();
    notifyObservers();
    return result;
  }

  @Override
  public AttackResult robotSmartFire() {
    AttackResult result = robot.smartAttack();
    notifyObservers();
    return result;
  }

  @Override
  public AttackResult userSmartFire() {
    AttackResult result = user.smartAttack();
    notifyObservers();
    return result;
  }

  @Override
  public void printGame() {
    System.out.println("My Fleet:");
    user.printFleet();
    System.out.println("My Battle:");
    robot.printBattle();
  }

  @Override
  public void registerObserver(GameObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(GameObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (GameObserver obs: observers) {
      obs.update(this);
    }
  }

  @Override
  public boolean endGame() {
    return user.winGame() || robot.winGame();
  }
}
