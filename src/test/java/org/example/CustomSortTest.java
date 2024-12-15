package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CustomSortTest {

  @Test
  public void testMergeSort() {
    CustomSort customSort = new CustomSort(Types.MERGESORT);
    List<Integer> input = Arrays.asList(5, 2, 3, 1, 4);
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> sorted = customSort.sorting(input);
    assertEquals(expected, sorted);
  }

  @Test
  public void testBubbleSort() {
    CustomSort customSort = new CustomSort(Types.BUBBLESORT);
    List<Integer> input = Arrays.asList(5, 2, 3, 1, 4);
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> sorted = customSort.sorting(input);
    assertEquals(expected, sorted);
  }


}