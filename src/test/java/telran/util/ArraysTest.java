package telran.util;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static telran.util.Arrays.add;
import static telran.util.Arrays.insert;
import static telran.util.Arrays.remove;
import static telran.util.Arrays.search;


public class ArraysTest {
int[] numbers = {10, 7, 12, -4, 13, 3, 14};
@Test
void searchTest(){
    assertEquals(0, search(numbers, 10));
    assertEquals(6, search(numbers, 14));
    assertEquals(3, search(numbers, -4));
    assertEquals(-1, search(numbers, 100));
}
@Test
void addTest(){
  int newNumber = 100;
  int [] expected = {10, 7, 12, -4, 13, 3, 14, 100};  
  assertArrayEquals(expected, add(numbers, newNumber));
}
@Test
void insertTest(){
  int number = 15;
  int index = 4;
  int [] expected = {10, 7, 12, -4, 15, 13, 3, 14};
  assertArrayEquals(expected, insert(numbers, index, number));
}
@Test
void removeTest(){
  int index = 3;
  int [] expected = {10, 7, 12, 13, 3, 14};
  assertArrayEquals(expected, remove(numbers, index));
}
}
