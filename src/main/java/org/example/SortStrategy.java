package org.example;

import java.util.List;

public interface SortStrategy {
  List<Integer> sort(List<Integer> list, int size);
  void checkSize(int size);
}
