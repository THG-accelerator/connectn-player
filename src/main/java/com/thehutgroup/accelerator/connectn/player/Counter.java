package com.thehutgroup.accelerator.connectn.player;

public enum Counter {
  X("X"),
  O("O");

  private String stringRepresentation;

  Counter(String stringRepresentation) {
    this.stringRepresentation = stringRepresentation;
  }

  public String getStringRepresentation() {
    return stringRepresentation;
  }

  public Counter getOther() {
    if(this == X) {
      return O;
    } else {
      return X;
    }
  }
}
