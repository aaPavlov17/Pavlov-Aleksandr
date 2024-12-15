package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class BubbleSortTest {
  private final SortStrategy sortStrategy = new BubbleSort();
  private final Random random = new Random();

  @Test
  public void testSortRandomList() {
    int size = 1000;
    List<Integer> randomList = new ArrayList<>(size);

    for (int i = 0; i < size; i++) {
      randomList.add(random.nextInt(1000));
    }

    List<Integer> expectedList = new ArrayList<>(randomList);
    expectedList.sort(Integer::compareTo);

    List<Integer> sortedList = sortStrategy.sort(randomList, randomList.size());
    assertEquals(expectedList, sortedList);
  }

  @Test
  public void testSortLargeRandomList() {
    int size = 1_000;
    List<Integer> randomList = new ArrayList<>(size);

    for (int i = 0; i < size; i++) {
      randomList.add(random.nextInt(1000));
    }

    List<Integer> expectedList = new ArrayList<>(randomList);
    expectedList.sort(Integer::compareTo);

    List<Integer> sortedList = sortStrategy.sort(randomList, randomList.size());
    assertEquals(expectedList, sortedList);
  }
}