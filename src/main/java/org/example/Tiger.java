package org.example;

public class Tiger implements Predator, Overland {

  @Override
  public void walk() {
    System.out.println("Тигр ходит");
  }

  @Override
  public void eat(String food) {
    if (food.equals("говядина")) {
      System.out.println("тигр ест говядину");
    } else {
      System.out.println("тигр не ест " + food);
    }
  }
}
