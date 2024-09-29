package org.example;

public  class Main {

  public static void main(String[] args) {
    Horse horse = new Horse();
    horse.eat("трава");
    horse.walk();
    Eagle eagle = new Eagle();
    eagle.fly();
    eagle.eat("трава");
    eagle.eat("рыба");
  }
}