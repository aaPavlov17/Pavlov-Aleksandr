package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Realizing {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    System.out.println("Введите количество элементов");
    int size = scan.nextInt();
    System.out.println("Введите элементы списка");
    for (int i = 0; i < size; i++) {
      list.add(scan.nextInt());
    }
    System.out.println("Выберите тип сортировки :");
    System.out.println("1 - MergeSort");
    System.out.println("2 - BubbleSort");
    int type = scan.nextInt();
    Types sortType;
    if (type == 1) {
      sortType = Types.MERGESORT;
    } else if (type == 2) {
      sortType = Types.BUBBLESORT;
    } else {
      sortType = Types.OTHER;
    }
    CustomSort sortList = new CustomSort(sortType);
    System.out.println(sortList.sorting(list));
  }
}
