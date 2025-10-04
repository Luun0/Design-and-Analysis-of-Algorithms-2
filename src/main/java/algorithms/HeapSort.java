package algorithms;

import metrics.PerformanceTracker;

public class HeapSort {
    private final PerformanceTracker tracker;

    public HeapSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            tracker.countSwap();
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && tracker.compare(arr[left], arr[largest]) > 0)
            largest = left;

        if (right < n && tracker.compare(arr[right], arr[largest]) > 0)
            largest = right;

        if (largest != i) {
            tracker.countSwap();
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}