package com.thehutgroup.accelerator.connectn.player;

public class Board {
  private Counter[][] counterPlacements;
  private GameConfig config;

  //for tests
  public Board(Counter[][] counterPlacements, GameConfig config) {
    this.counterPlacements = counterPlacements;
    this.config = config;
  }

  public Board(Board board, int x, Counter counter) throws InvalidMoveException {
    this.counterPlacements = deepCopy(board.counterPlacements);
    this.config = board.getConfig();
    placeCounterAtPosition(counter, x);
  }

  public Board(GameConfig config) {
    this.config = config;
    this.counterPlacements = new Counter[config.getWidth()][config.getHeight()];
  }

  public GameConfig getConfig() {
    return config;
  }

  private void placeCounterAtPosition(Counter counter, int x) throws InvalidMoveException {
    if (!isWithinBoard(new Position(x, 0))) {
      throw new InvalidMoveException("Outside the bounds of the board");
    }
    Position position = new Position(x, getMinVacantY(x));
    if (hasCounterAtPosition(position)) {
      throw new InvalidMoveException("Column is full");
    } else {
      this.counterPlacements[position.getX()][getMinVacantY(position.getX())] = counter;
    }
  }

  public Counter[][] getCounterPlacements() {
    return counterPlacements;
  }

  private int getMinVacantY(int x) {
    for (int i = config.getHeight() - 1; i >= 0; i--) {
      if (i == 0 || counterPlacements[x][i - 1] != null) {
        return i;
      }
    }
    throw new RuntimeException("no y is vacant");
  }

  public Counter getCounterAtPosition(Position position) {
    if (isWithinBoard(position)) {
      return counterPlacements[position.getX()][position.getY()];
    } else {
      return null;
    }
  }

  public boolean hasCounterAtPosition(Position position) {
    return isWithinBoard(position) &&
        counterPlacements[position.getX()][position.getY()] != null;
  }

  public boolean isWithinBoard(Position position) {
    return position.getX() >= 0 && position.getX() < config.getWidth()
        && position.getY() >= 0 && position.getY() < config.getHeight();
  }

  private <T> T[][] deepCopy(T[][] matrix) {
    return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
  }
}
