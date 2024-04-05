import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Alyssa Trapp
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // initializes change value to be a boolean
    boolean change;
    // do while loop
    do {
      // initializes change to false
      change = false;
      // for loop starting at 1 for the entire length of the array
      for (int i = 1; i < values.length; i++) {
        // checks if the value stored at the index before i is greater than the value at i
        if (order.compare(values[i - 1], values[i]) > 0) {
          // if it is true, swap the values at the index - 1 and index and intialize change to true
          SwapSort.swap(values, i - 1, i);
          change = true;
        } // if
      } // for
    } while (change); // continue the do while loop until change is equal to false
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
