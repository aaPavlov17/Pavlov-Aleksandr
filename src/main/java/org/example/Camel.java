package org.example;

public class Camel implements Herbivore, Overland{
  @Override
  public void walk() {
    System.out.println("Верблюд ходит");
  }

  @Override
  public void eat(String food) {
    if (food.equals("трава")) {
      System.out.println("Верблюд ест траву");
    } else {
      System.out.println("Верблюд не ест " + food);
    }
  }
}
