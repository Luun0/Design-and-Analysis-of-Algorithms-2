package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;
import metrics.PerformanceLogger;

import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        int maxValue = 1_000_000;
        Random random = new Random();

        for (int n : sizes) {
            int[] array = random.ints(n, 0, maxValue).toArray();

            PerformanceTracker tracker = new PerformanceTracker();
            HeapSort sorter = new HeapSort(tracker);

            System.out.println("Running HeapSort with n = " + n);

            long start = System.nanoTime();
            sorter.sort(array);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1e6;

            System.out.printf("n = %d | Time: %.2f ms | Comparisons: %d | Swaps: %d%n",
                    n, timeMs, tracker.getComparisons(), tracker.getSwaps());

            PerformanceLogger.log("results.csv", n, timeMs, tracker.getComparisons(), tracker.getSwaps());
        }

        System.out.println("\n Benchmark complete. Results saved to results.csv");
    }
}