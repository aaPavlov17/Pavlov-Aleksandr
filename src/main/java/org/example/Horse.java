package org.example;

public class Horse implements Herbivore, Overland{

  @Override
  public void walk() {
    System.out.println("Лошадь ходит");
  }
  @Override
  public void eat(String food) {
    if (food.equals("трава")) {
      System.out.println("Лошадь ест траву");
    } else {
      System.out.println("Лошадь не ест " + food);
    }
  }
}
