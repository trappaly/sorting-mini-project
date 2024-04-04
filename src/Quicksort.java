import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Alyssa Trapp
 * I also modified code from the QuickSort lab which I worked on with Medhashree Adhikari
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

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
    arr[j] = temp;
    // returns the new array after it's been swapped
    return arr;
  } // swap (T[], int, int)


  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length - 1);
  } // sort (T[], Comparator<? super T>)


  /*
   * Sort the subarray of T given by [lb..ub) in place using the Quicksort algorithm.
   */
    static <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {

      /*
       * base case: 
       *   when lb == ub
       *   when arr.length == 0
       * recursive:
       *   find pivot
       *   sort less than/greater than pivot
       *   1. sort left side (less than pivot until lb)
       *       --> unless smallest value
       *   2. sort right side (greater than pivot until ub) 
       *      --> unless greatest value
       */
      // base case: if lb == ub or if there is only one value in the array, return
      if((lb == ub) || (values.length == 0)) {
        return;
      }
      //intializes left to be lb, right to be up, and pivot to be partition
          int left = lb;
          int right = ub;
          int pivot = partition(values, order, left, right);
          //stores the swapped value array in a newValues array
          T[] newValues = swap(values, left, pivot);
          //increments left
          left++; 
          // loops while left is less than right
          while(left < right){
            // if element in index i is less than element in pivot,
            // then comparator will return 1
            // if 1 is returned,
            
            if(order.compare(newValues[left], newValues[lb]) == 1) {
              // swap end value and cur value
              swap(newValues, left, right);
              right--; // shift right towards left
            } else {
              left++;
            }
          }
  
          // put pivot in correct place
          if(order.compare(newValues[lb], newValues[left]) == 1) {
            pivot = left;
            swap(newValues, pivot, lb);
          } else {
            pivot = left - 1;
            swap(newValues, pivot, lb);
          }
  
          // left section of the array
          if(pivot != lb) {
            quicksort(newValues, order, lb, pivot - 1);
          }
  
          if(pivot != ub) {
            quicksort(newValues, order, pivot + 1, ub);
          }
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
      //finds the midpoint for the pivot's index
      int pivotLoc = (lb + ub) / 2;
      //returns the pivot's index
      return pivotLoc;
    } // partition(T[], Comparator<? super T>, lb, ub)
  } // class Quicksort
