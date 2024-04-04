import java.util.Arrays;
import java.util.Comparator;

public class QuickSortExperiments {
  /**
   * Run some experiments.
   */
  public static void main(String[] args) {
    Integer[] vals0 = new Integer[] { 3, 9, 2, 8, 6, 4, 1, 7, 5 };
    Comparator<Integer> compareInts = (x,y) -> x.compareTo(y);

    partitionExperiment(vals0, compareInts);
  } // main(String[])

  /**
   * A partition experiment.
   */
  public static <T> void partitionExperiment(T[] vals, Comparator<? super T> order) {
    System.err.println("Original:    " + Arrays.toString(vals));
    int pivotLoc = Quicksort.partition(vals, order, 0, vals.length);
    System.err.println("Pivot is " + vals[pivotLoc] + " at position " + pivotLoc);
    //Quicksort.sort(vals, order);
    System.err.println("Partitioned: " + Arrays.toString(vals));
  } // partitionExperiment
} // class PartitionExperiments