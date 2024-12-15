package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort implements SortStrategy {
  public static int maxSize;

  public MergeSort() {
    maxSize = 1_000_000;
  }
  @Override
  public void checkSize(int size){
    if (size > maxSize) {
      throw new RuntimeException("Unsupported size");
    }
  }

  @Override
  public List<Integer> sort(List<Integer> list, int size) {
    checkSize(size);
    List<Integer> list1 = new ArrayList<>(list);
    Collections.sort(list1);
    return list1;
  }
}
