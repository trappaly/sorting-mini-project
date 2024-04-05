import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using TrappAlyssaSort. It is mainly inspired by mergge sort. It's inspired by merge sort because it creates a copy of the original array
 * to store it in the new array. Instead of comparing the left, middle, and right like in mergesort, it compares the value at the current index
 * to the value stored at the midpoint to determine if the value should be sorted in the front or the back of the array. 
 *
 * @author Alyssa Trapp
 */

public class TrappAlyssaSort implements Sorter {

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
  TrappAlyssaSort() {
  } // TrappAlyssaSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // creates a copy of the original array and stores it in newarr
      T[] newarr = Arrays.copyOf(values, values.length);
    // determines the middle index of the array  
    int midpoint = values.length / 2;
    for (int i = 0; i < values.length; i++){
      // if values[i] is less than values[pivot], store it at index i in the new array and increment i
      if (order.compare(values[midpoint], values[i]) < 0){
        newarr[i] = values[i];
        i++;
      } // if
      // if values[i] is greater than values[pivot], store it in index midpoint in the new array and increment midpoint
      else if (order.compare(values[midpoint], values[i]) > 0){
        newarr[midpoint] = values[midpoint];
        midpoint++;
      } // if
      // if values[i] is equal to values[midpoint], store both elements in i at the new array and incremented i in the new array
      else if (order.compare(values[midpoint], values[i]) == 0){
        newarr[i] = values[i];
        newarr[i++] = values[i++];
      } // else if      
    } // for
  } // sort (T[], Comparator<? super T>)
} // class InsertionSort

