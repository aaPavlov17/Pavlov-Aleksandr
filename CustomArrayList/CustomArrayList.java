package CustomArrayList;

public class CustomArrayList<T> implements CustomArrayListMethods<T>{
  private static int capacity;
  private Object[] list;
  private int currentIndex = 0;

  /*
   * Создается массив размера capacity
   */

  public CustomArrayList(int capacity) {
    CustomArrayList.capacity = capacity;
    list = new Object[capacity];
  }

  /*
   * Если размер не указан, то он автоматически становится 3
   */

  public CustomArrayList() {
    capacity = 3;
    list = new Object[capacity];
  }

  /*
   * Динамическое расширение размера массива
   * Размер увеличивается в 2 раза
   */

  private void expandCapacity(Object[] list) {
    int newCapacity = capacity * 2;
    Object[] newList = new Object[newCapacity];
    System.arraycopy(list, 0, newList, 0, capacity);
    capacity = newCapacity;
  }

  /*
   * Добавление элемента в массив
   * @param element - добавляемый элемент
   */

  @Override
  public void add(T element) {
    if (element == null) {
      throw new IllegalArgumentException();
    }
    if (currentIndex < capacity) {
      list[currentIndex] = element;
      currentIndex++;
    } else {
      expandCapacity(list);
      list[currentIndex] = element;
      currentIndex++;
    }
  }

  /*
   * Получение элемента масива по индексу
   * @param index - индекс возвращаемого элемента
   * @return элемент массива
   */

  @Override
  public Object get(Integer index) {
    if (index < 0 || index >= capacity) {
      throw new IndexOutOfBoundsException();
    } else {
      return list[index];
    }
  }

  /*
   * Удаление элемента массива по индексу
   * @param index - индекс удаляемого элемента
   */

  @Override
  public void remove(Integer index) {
    if (index >= 0 && index <= currentIndex) {
      Object[] newList = new Object[list.length - 1];
      System.arraycopy(list, 0, newList, 0, index);
      System.arraycopy(list, index + 1, newList, index, list.length - index - 1);
      list = newList;
      currentIndex--;
    } else {
      throw new IndexOutOfBoundsException();
    }
  }
}
