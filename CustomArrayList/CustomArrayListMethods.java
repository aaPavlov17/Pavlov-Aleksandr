package CustomArrayList;
/*
 * Интерфейс для ArrayList
 */
public interface CustomArrayListMethods<T> {
  /*
   * Метод добавляет элемент в конец массива
   * @param element - добаляемый элемент
   */
  void add(T element);
  /*
   * Метод удаляет элемент по индексу
   * @param index - индекс удаляемого элемента
   */
  void remove(Integer index);
  /*
   * Метод возвращает элемент по индексу
   * @param index - индекс возвращаемого элемент
   * @return элемент
   */
  Object get(Integer index);
}
