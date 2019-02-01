package com.thehutgroup.accelerator.connectn.player;

import java.util.Objects;

public class GameConfig {
  private int width;
  private int height;
  private int nInARowForWin;

  public GameConfig(int width, int height, int nInARowForWin) {
    this.width = width;
    this.height = height;
    this.nInARowForWin = nInARowForWin;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getnInARowForWin() {
    return nInARowForWin;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameConfig that = (GameConfig) o;
    return width == that.width &&
        height == that.height &&
        nInARowForWin == that.nInARowForWin;
  }

  @Override
  public int hashCode() {
    return Objects.hash(width, height, nInARowForWin);
  }
}
