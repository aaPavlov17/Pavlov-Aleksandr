package org.example;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements SortStrategy{
  private static int maxSize;

  public BubbleSort() {
    maxSize = 1000;
  }

  public void checkSize(int size) {
    if (size > maxSize) {
      throw new RuntimeException("Unsupported size");
    }
  }

  @Override
  public List<Integer> sort(List<Integer> list, int size) {
    checkSize(size);
    List<Integer> list1 = new ArrayList<>(list);
    for (int i = 0; i < list1.size(); i++) {
      for (int j = i + 1; j < list1.size(); j++) {
        if (list1.get(i) > list1.get(j)) {
          int temp = list1.get(i);
          list1.set(i, list1.get(j));
          list1.set(j, temp);
        }
      }
    }
    return list1;
  }
}
