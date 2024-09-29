package org.example;

public class Eagle implements Flying, Predator{
  @Override
  public void fly() {
    System.out.println("Орел летит");
  }

  @Override
  public void eat(String food) {
    if (food.equals("рыба")) {
      System.out.println("Орел ест рыбу");
    } else if (food.equals("говядина")){
      System.out.println("Орел ест говядину");
    } else {
      System.out.println("Орел не ест " + food);
    }
  }
}
