import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Arrays;


/**
 * Sort using merge sort.
 *
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



  public static <T> T[] recursivehelper(T[] values, Comparator<? super T> order,  int left, int right) {
     //(T[]) Array.newInstance(values[0].getClass(), 1);
    //while (left < right){}
    if (left == right){
      //newarr = new T[]{arr[i]};
      //arr with one value
      //@SuppressWarnings("unchecked")
      @SuppressWarnings("unchecked")
      T[] newarr = (T[]) Array.newInstance(values[0].getClass(), 1);
      newarr[0] = values[left];
      return newarr;
    }
    else if (left - right == 2 ){
      if ((order.compare(values[left], values[right])) == 1){
        swap(values, left, right);
      }
      else {
        recursivehelper(values, order, left, right);
      }
      //use comparator and compare 2 values
    }
    return values;
  }


  // lo is equal to first index, mid is equal to length/2, hi is equal to last index (values.length - 1)
/*public <T> void split (T[] values, Comparator<? super T> order, int left, int right){  
  left = 0;
  right = values.length;
  //splitting  
  while (left < right){
    int mid = left + right / 2;
    //System.out.println ("mid" + mid);
    //System.out.println ("left" + left);
    //System.out.println ("right" + right);
    split (values, order, left, mid);
    split (values, order, mid, right);
  }
} */
//for (int i = 0; i < values.length; i++) 


 /*  public <T> void merge (T[] values, Comparator<? super T> order, int left, int right){ 
    if ((order.compare(values[left], values[right])) == 1){
      swap(values, left, right);
    }
    int mid = left + right * 2;
    merge(values, order, left, mid);
    merge(values, order, mid, right);
  }
  */
  



    //int mid = lb + ub / 2;
    //int hi = values.length - 1;
    //T left = values[mid - lo];
    //T right = values [hi - mid];
    /*if ((order.compare(values[lb], values[i])) == 1 ){
      swap(values, lb, i);
      lb++;
    }
    else if ((order.compare(values[i], values[ub])) == 1){
      swap(values, i, ub);
      ub--;
    }
  }*/
  



  private static <T> void merge (T[] values, Comparator<? super T> order, int left, int right, int mid){
    //@SuppressWarnings("unchecked")
    T[] temparr = Arrays.copyOf(values, values.length);
    //(T[]) Array.newInstance(values.getClass(), values.length); 
    //for (int i = left; i < right; i++){
      //temparr[i] = values[i];
    //}
    //temparr = Arrays.copyOfRange(values, left, right);
    //int lb = 0;
    //int mid = left + (right - left) / 2;
    //int midtracker = mid - left;
    //int pos = 0;
    int lb = left;
    int midpoint = mid + 1;
    int pos = lb;
    while((lb <= mid) && (midpoint <= right)){
      if(order.compare(temparr[lb], temparr[midpoint]) <= 0){
        values[pos++] = temparr[lb++];
      } 
      else {
        values[pos++] = temparr[lb++];
      }
    }

    while(lb <= mid){
      values[pos++] = temparr[lb++];
    }
    while(midpoint <= right){
      values[pos++] = temparr[midpoint++];
    }
  }
    


/*while ((lb < mid - left) && (midtracker < right - left)){
      if(order.compare (temparr[lb], temparr[midtracker]) > 0) {
        values[pos + left] = temparr[midtracker];
        midtracker++;
        pos++;
        //(values, lb, midtracker);
      }
      else if ((order.compare (temparr[lb], temparr[midtracker]) == 0)){
        values[pos + left] = temparr[lb];
        values[pos++ + left] = temparr[midtracker];
        lb++;
        midtracker++;
        pos++;

      }

      else if (order.compare (temparr[lb], temparr[midtracker]) < 0){
        values[pos + left] = temparr[lb];
        lb++;
        pos++;
      }

      //else if (pos <= mid){
        //values[pos] = temparr[lb];
      //}
      //else{
        //values[pos] = temparr[midtracker];
      //}
      //(values[lb] > values[midtracker]){
        //swap(values, lb, midtracker);
      //}
      //lb++;
      //midtracker++;
      System.out.println("values" + Arrays.toString(values));
    }
    while (lb < mid - left){
      values[pos + left] = temparr[lb];
      lb++;
      pos++;
    }
    while (midtracker < right - left){
      values[pos + left] = temparr[midtracker];
      midtracker++;
      pos++;
    }
    
    //left){
      //values[pos] = temparr[left];
    //}
    
    //else if (midtracker == right)){

    //}

  }
  */


  private static <T> void mergeSort(T[] values, Comparator<? super T> order, int left, int right){
    //T[] newarr = (T[]) Array.newInstance(values.getClass(), values.length);
    //if (left == right){
      //return;
    //}
    if (left < right) {
      int mid = (left + right) / 2;
     // T[] leftarr = (T[]) Array.newInstance(values.getClass(), mid - left);
     // T[] rightarr = (T[]) Array.newInstance(values.getClass(), right - mid + 1);
      mergeSort(values, order, left, mid);
      mergeSort(values, order, mid + 1, right);
      merge(values, order, left, right, mid);
    }
   // return newarr;
  } 

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if ((values.length <= 1) || (values == null)){
      return;
    }
    mergeSort(values, order, 0, values.length - 1);
    }
    //recursivehelper(values, order, 0, values.length);
    //swap();
    //merge(values, order, 0, values.length);


    // STUB
  } // sort(T[], Comparator<? super T>/
  // class MergeSort
