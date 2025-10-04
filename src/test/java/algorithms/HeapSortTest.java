package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeapSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        HeapSort sorter = new HeapSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        HeapSort sorter = new HeapSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testUnsortedArray() {
        int[] arr = {5, 1, 4, 2, 8};
        HeapSort sorter = new HeapSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 4, 5, 8}, arr);
    }

    @Test
    void testReverseArray() {
        int[] arr = {9, 8, 7, 6, 5};
        HeapSort sorter = new HeapSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{5, 6, 7, 8, 9}, arr);
    }
}