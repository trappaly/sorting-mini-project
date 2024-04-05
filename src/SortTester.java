import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Alyssa Trapp
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+
/*
 * Fake test
 */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

/*
 * Already ordered strings test
 */

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest



/*
 * Reversed strings test
 */

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reverseOrderedStringTest


/*
 * Multiple of the same element test
 */

  @Test 
  public void multipleofSameElementTest(){
    Integer [] original = {9, 2, 1, 4, 5, 8, 4, 2, 7, 3};
    Integer [] expected = {1, 2, 2, 3, 4, 4, 5, 7, 8, 9};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // multipleofSameElementTest


/*
 * Empty array test
 */
  @Test
  public void emptyStringTest(){
    String[] original = {};
    String[] expected = {};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyStringTest


/*
 * Smallest value in front test
 */
  @Test 
  public void smallestinFrontTest(){
    String[] original = {"a", "d", "e", "b", "c"};
    String[] expected = {"a", "b", "c", "d", "e"};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // smallestinFrontTest


/*
 * One element test
 */
  @Test 
  public void oneElementTest(){
    Integer [] original = {0};
    Integer [] expected = {0};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // oneElementTest

/*
 * Largest value in front test 
 */
  @Test
  public void largestinFrontTest(){
    Integer [] original = {5, 3, 1, 4, 2};
    Integer [] expected = {1, 2, 3, 4, 5};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // largestinFrontTest
} // class SortTester
