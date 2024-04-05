import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Alyssa Trapp
 * I also modified code from the QuickSort lab which I worked on with Medhashree Adhikari
 */

public class QuickSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new QuickSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  QuickSort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length - 1);
  } // sort (T[], Comparator<? super T>)


  /*
   * Sort the subarray of T given by [lb..ub) in place using the Quicksort algorithm.
   */
    static <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
      // base case: if lb == ub or if there is only one value in the array, return
      if((lb == ub) || (values.length == 0)) {
        return;
      }
      //intializes left to be lb, right to be ub, and pivot to be partition
          int left = lb;
          int right = ub;
          int pivot = partition(values, order, left, right);
          // stores the swapped value array in a newValues array
          T[] newValues = SwapSort.swap(values, left, pivot);
          // if the value at left is not equal to the value at pivot, then increment the left
          if(values[left] != values[pivot]){
            left++;
          } // if
          // loops while left is less than right
          while(left < right){
            // if the element in the left index is greater than the element in the lb index, 
            //then swap the values at the indexes and decrement right
            if(order.compare(newValues[left], newValues[lb]) > 0) {
              SwapSort.swap(newValues, left, right);
              right--; 
            } // if
            // otherwise increment left 
            else {
              left++;
            } // else
          } // while
  
          // puts pivot in correct place
          if(order.compare(newValues[lb], newValues[left]) > 0) {
            pivot = left;
            SwapSort.swap(newValues, pivot, lb);
          } // if 
          else {
            pivot = left - 1;
            SwapSort.swap(newValues, pivot, lb);
          } // else
  
          // left section of the array
          if(pivot != lb) {
            quicksort(newValues, order, lb, pivot - 1);
          } // if
  
          if(pivot != ub) {
            quicksort(newValues, order, pivot + 1, ub);
          } // if
    } // quicksort(T[], Comparator<? super T>, lb, ub)
  
    /**
     * Select a pivot and partition the subarray from [lb .. ub) into
     * the following form.
     *
     * <pre>
     * ---+-----------------+-+----------------+---
     *    | values <= pivot |p| values > pivot |
     * ---+-----------------+-+----------------+---
     *    |                 |                  |
     *    lb                pivotLoc           ub
     * </pre>
     *
     * @return pivotLoc.
     */
  
    public static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
      // finds the midpoint for the pivot's index
      int pivotLoc = (lb + ub) / 2;
      // returns the pivot's index
      return pivotLoc;
    } // partition(T[], Comparator<? super T>, lb, ub)
  } // class Quicksort
