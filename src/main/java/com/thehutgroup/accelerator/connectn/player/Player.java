package com.thehutgroup.accelerator.connectn.player;

public abstract class Player {
  private Counter counter;
  private String name;

  public Player(Counter counter, String name) {
    this.counter = counter;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Counter getCounter() {
    return counter;
  }

  public abstract int makeMove(Board board);
}
