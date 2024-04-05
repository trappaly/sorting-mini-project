import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Arrays;

/**
 * Sort using merge sort.
 * @author Alyssa Trapp
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {

  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  /*
   * Merges the array together
   */
  public <T> void merge(T[] values, Comparator<? super T> order, int left, int right, int mid) {
    // creates copy of array into temporary array
    T[] temparr = Arrays.copyOf(values, values.length);
    // initializes lb to left
    int lb = left;
    // intializes the midpoint to be mid + 1
    int midpoint = mid + 1;
    // initializes pos to be lb
    int pos = lb;
    // loops while lb is less than mid and midpoint is less than right
    while ((lb <= mid) && (midpoint <= right)) {
      // if the value at the lower bound is less than or equal to the value at the midpoint
      if (order.compare(temparr[lb], temparr[midpoint]) <= 0) {
        // replace it in the original array and increment both pos and lb
        values[pos++] = temparr[lb++];
      } // if
      // otherwise, replace it in the original array and increment both pos and midpoint
      else {
        values[pos++] = temparr[midpoint++];
      } // else
    } // while

    // the while loops below loop for after the first while loop is finished running
    // while lb is less than mid, replace it in the original array and increment both pos and lb
    while (lb <= mid) {
      values[pos++] = temparr[lb++];
    } // while
    // while midpoint is less than right, replace it in the original array and increment both pos and midpoint
    while (midpoint <= right) {
      values[pos++] = temparr[midpoint++];
    } // while
  } // merge (T[], Comparator<? super T> order, int, int, int)

  /*
   * Recursively divides the array and merges them back together
   */

  public <T> void mergeSort(T[] values, Comparator<? super T> order, int left, int right) {
    // if the left is less than the right, recursively call mergeSort
    if (left < right) {
      // initialzes the index of the midpoint of the array
      int mid = (left + right) / 2;
      // recursively calls mergeSort on the left part of the array
      mergeSort(values, order, left, mid);
      // recursively calls mergeSort on the right part of the array
      mergeSort(values, order, mid + 1, right);
      // merges the arrays back to together
      merge(values, order, left, right, mid);
    } // if
  } // mergeSort(T[],Comparator<? super T>/, int, int)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // if there are no values or one value, return
    if ((values.length <= 1) || (values == null)) {
      return;
    } // if
    // otherwise call mergeSort
    mergeSort(values, order, 0, values.length - 1);
  } // sort(T[], Comparator<? super T>
} // class MergeSort
