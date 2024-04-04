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

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test 
  public void largestinFrontTest(){
    Integer [] original = {9, 2, 1, 6, 5, 8, 4, 2, 7, 3};
    Integer [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } //largestinFrontTest


  @Test 
  public void smallestinFrontTest(){
    String[] original = {"a", "z", "d", "l", "q"};
    String[] expected = {"a", "d", "l", "q", "z"};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } //smallestinFrontTest

  @Test
  public void emptyStringTest(){
    String[] original = {""};
    String[] expected = {""};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } //emptyStringTest

  @Test 
  public void oneElementTest(){
    Integer [] original = {0};
    Integer [] expected = {0};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } //oneElementTest

  @Test
  public void alreadySortedTest(){
    Integer [] original = {1, 2, 3, 4, 5};
    Integer [] expected = {1, 2, 3, 4, 5};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } //alreadySortedTest
} // class SortTester
