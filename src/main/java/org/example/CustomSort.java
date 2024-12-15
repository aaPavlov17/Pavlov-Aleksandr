package org.example;

import java.util.List;

public class CustomSort {
  private final Types sortType;

  public CustomSort(Types sortType) {
    this.sortType = sortType;
  }

  public List<Integer> sorting(List<Integer> list) {
    if (sortType == Types.MERGESORT) {
      MergeSort goSort = new MergeSort();
      return goSort.sort(list, list.size());
    } else if (sortType == Types.BUBBLESORT) {
      BubbleSort goSort = new BubbleSort();
      return goSort.sort(list, list.size());
    } else {
      return list;
    }
  }
}
