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

  /**
   * Swaps the values stored at index i and index j within an array
   */

  public static <T> T[] swap(T[] arr, int i, int j) {
    // stores the value at index i in temp
    T temp = arr[i];
    // sets the value at index i to the value at index j
    arr[i] = arr[j];
    // sets the value of index j to temp which is the original value stored at index
    // i
    arr[j] = temp;
    // returns the new array after it's been swapped
    return arr;
  } // swap (T[], int, int)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // initializes change value to be a boolean
    boolean change;
    // do while loop
    do {
      // initializes change to false
      change = false;
      // for loop starting at 1 and
      for (int i = 1; i < values.length; i++) {
        // checks if the value stored before is greater than the value at i
        if (order.compare(values[i - 1], values[i]) == 1) {
          // if it is true, swap the values at the index and intialize change to true
          swap(values, i - 1, i);
          change = true;
        }
      }
      // continue the do while loop until change is equal to false
    } while (change);
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
