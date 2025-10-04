package org.example;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 3, 17, 10, 84, 19, 6, 22, 9};
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);

        System.out.println("Before: " + Arrays.toString(arr));
        sorter.sort(arr);
        System.out.println("After:  " + Arrays.toString(arr));
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Swaps: " + tracker.getSwaps());

        System.out.println("\n--- Benchmark Results ---");

        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        Random random = new Random();

        for (int n : sizes) {
            int[] testArray = random.ints(n, 0, 1_000_000).toArray();
            tracker.reset();
            sorter = new HeapSort(tracker);

            long start = System.nanoTime();
            sorter.sort(testArray);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1e6;

            System.out.printf("n = %d | time = %.2f ms | comparisons = %d | swaps = %d%n",
                    n, timeMs, tracker.getComparisons(), tracker.getSwaps());
        }
    }
}