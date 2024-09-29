package org.example;

public class Dolphin implements Predator, Waterflowl {
  @Override
  public void swim() {
    System.out.println("Дельфин плывет");
  }

  @Override
  public void eat(String food) {
    if (food.equals("рыба")) {
      System.out.println("Дельфин ест рыбу");
    } else {
      System.out.println("Дельфин не ест " + food);
    }
  }
}
