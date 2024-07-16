package telran.util;
//package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static telran.util.Arrays.*;

import java.util.Random;
import java.util.random.RandomGenerator;
public class ArraysTest {
private static final int N_ELEMENTS = 1_000;
int[] numbers = {10, 7, 12, -4, 13, 3, 14};
@Test
void searchTest() {
    assertEquals(0, search(numbers, 10));
    assertEquals(6, search(numbers, 14));
    assertEquals(3, search(numbers, -4));
    assertEquals(-1, search(numbers,100));
}
@Test
void addTest() {
    int newNumber = 100;
    int [] expected = {10, 7, 12, -4, 13, 3, 14, newNumber};
    assertArrayEquals(expected, add(numbers, newNumber));
}
@Test
void insertTest(){
    //{10, 7, 12, -4, 13, 3, 14} - all numbers
    int newNumber = 30;
    int[] expected_0 ={newNumber, 10, 7, 12, -4, 13, 3, 14};
    int[] expected_3 = {10, 7, 12, newNumber, -4, 13, 3, 14};
    int[] expected_last = {10, 7, 12,  -4, 13, 3, 14, newNumber};
    assertArrayEquals(expected_0, insert(numbers, 0, newNumber));
    assertArrayEquals(expected_3, insert(numbers, 3, newNumber));
    assertArrayEquals(expected_last, insert(numbers, numbers.length, newNumber));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->insert(numbers, numbers.length + 1, newNumber));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->insert(numbers, -1, newNumber));
}
@Test
void removeTest(){
    //{10, 7, 12, -4, 13, 3, 14} - all numbers
    int[] expected_0 ={ 7, 12, -4, 13, 3, 14};
    int[] expected_3 = {10, 7, 12, 13, 3, 14};
    int[] expected_last = {10, 7, 12, -4, 13, 3};
    assertArrayEquals(expected_0, remove(numbers,0));
    assertArrayEquals(expected_3, remove(numbers, 3));
    assertArrayEquals(expected_last, remove(numbers, numbers.length-1));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->remove(numbers, numbers.length));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->remove(numbers, -1));
}

@Test
void sortTest() {
    int [] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length);
    int[] expected = {-4, 3, 7, 10,  12,  13,  14};
    sort(testNumbers);
    assertArrayEquals(expected, testNumbers);
}
@Test
void sortTestRandomArray() {
    int[] array = getRandomArray(N_ELEMENTS);
    int limit = array.length - 1;
    sort(array);
    for(int i = 0; i < limit; i++) {
        assertTrue(array[i] <= array[i + 1]);
    }
}
private int[] getRandomArray(int nElements) {
    int[] res = new int[nElements];
    Random random = new Random();
    for(int i = 0; i < nElements; i++) {
        res[i] = random.nextInt();
    }
    return res;
}

@Test
void binarySearchTest(){
  int [] ar = getRandomArray(N_ELEMENTS);
  sort(ar);

  assertEquals(N_ELEMENTS / 2, binarySearch(ar, ar[N_ELEMENTS / 2]));
  assertEquals(N_ELEMENTS / 4, binarySearch(ar, ar[N_ELEMENTS / 4]));
  assertEquals(-1, binarySearch(new int[] {-5, 0, 5, 10, 15}, -10));
  assertEquals(-2, binarySearch(new int[] {-5, 0, 5, 10, 15}, -1));
  assertEquals(2, binarySearch(new int[] {-5, 0, 5, 10, 15}, 5));
  assertEquals(-6, binarySearch(new int[] {-5, 0, 5, 10, 15}, 20));
}

@Test
void insertSortedTest(){
  int[] ar = {0, 2, 8};
  int[] expected_1 ={ 0, 2, 4, 8};
  int[] expected_2 ={ 0, 1, 2, 8};
  int[] expected_3 ={ -1, 0, 2, 8};
  int[] expected_4 ={ 0, 2, 2, 8};
    assertArrayEquals(expected_1, insertSorted(ar, 4));
    assertArrayEquals(expected_2, insertSorted(ar, 1));
    assertArrayEquals(expected_3, insertSorted(ar, -1));
    assertArrayEquals(expected_4, insertSorted(ar, 2));
}

@Test
void isOneSwapTest(){
  int [] ar1 = {1, 2, 4, 8, 16};
  assertFalse(isOneSwap(ar1));

  int [] ar2 = {1, 2, 16, 8, 4};
  assertTrue(isOneSwap(ar2));

  int [] ar3 = {1, 16, 8, 2, 4};
  assertFalse(isOneSwap(ar3));

  int [] ar4 = {16, 2, 4, 8, 1};
  assertTrue(isOneSwap(ar4));



}
@Test
void isSortedArrayTest(){
  int [] expected_0 = getRandomArray(N_ELEMENTS);
  sort(expected_0);

  assertTrue(isSortedArray(expected_0));
  assertFalse(isSortedArray(new int[] {0, 1, 2, 3, 5, 4}));
}

/*package telran.util;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.ClassOrderer.Random;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static telran.util.Arrays.*;
/*
import static telran.util.Arrays.add;
import static telran.util.Arrays.insert;
import static telran.util.Arrays.pushMaxAtEnd;
import static telran.util.Arrays.remove;
import static telran.util.Arrays.search;
import static telran.util.Arrays.sort;

public class ArraysTest {
private static final int N_ELEMENTS = 1000;
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
/*
@Test
void pushMaxAtEndTest(){
  int [] testNumbers =java.util.Arrays.copyOf(numbers, numbers.length);
  pushMaxAtEnd(testNumbers);
  assertEquals(14, testNumbers[testNumbers.length-1]);
  assertEquals(13, testNumbers[testNumbers.length-2]);
  testNumbers = new int[]{20, -10, 10, -17};
  pushMaxAtEnd(testNumbers);
  assertEquals(20, testNumbers[testNumbers.length-1]);
  
}

@Test
void sortTest() {
    int [] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length);
    int[] expected = {-4, 3, 7, 10,  12,  13,  14};
    sort(testNumbers);
    assertArrayEquals(expected, testNumbers);
}
@Test
void sortTestRandomArray() {
    int[] array = getRandomArray(N_ELEMENTS);
    int limit = array.length - 1;
    sort(array);
    for(int i = 0; i < limit; i++) {
        assertTrue(array[i] <= array[i + 1]);
    }
}
private int[] getRandomArray(int nElements) {
    int[] res = new int[nElements];
    Random random = new Random();
    for(int i = 0; i < nElements; i++) {
        res[i] = random.nextInt();
    }
    return res;
}
}

}*/

   
}
