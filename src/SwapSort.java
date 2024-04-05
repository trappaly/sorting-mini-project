
/*
 * Swaps two values within an array
 */
public class SwapSort {

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
} // SwapSort
