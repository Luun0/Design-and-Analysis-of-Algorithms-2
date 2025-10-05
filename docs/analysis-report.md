
## Overview

This project focuses on the implementation and analysis of the **Heap Sort** algorithm.  
The goal of the work was to understand algorithmic complexity, perform empirical benchmarking,  
and conduct a professional peer code review.

All experiments were conducted using the `PerformanceTracker` class,  
which counts comparisons and swaps during sorting.  
The results were saved to a CSV file and visualized using JFreeChart.

---

##  Project Structure

src/
main/java/
algorithms/
HeapSort.java
cli/
BenchmarkRunner.java
PlotGenerator.java
metrics/
PerformanceTracker.java
PerformanceLogger.java
test/java/
algorithms/
HeapSortTest.java
docs/
analysis-report.md
performance-plots/
time_vs_n.png
comparisons_vs_n.png
results.csv
pom.xml
README.md

---

## Features

- **HeapSort Implementation** — in-place sorting using heapify.
- **Performance Tracking** — counts comparisons and swaps.
- **Benchmark Runner** — runs the algorithm on different input sizes.
- **CSV Logger** — automatically saves runtime statistics.
- **Plot Generator** — builds charts using JFreeChart.
- **Analysis Report** — contains both theoretical and empirical analysis.

---

# Peer Code Review — Partner’s Algorithm: Shell Sort

**Partner:** Aitynbek Nurdaulet 
**Algorithm:** Shell Sort (multi-gap sequence implementation)  
**Repository:** [https://github.com/A1LENT1337/assignment2-shellsort/tree/feature/algorithm](https://github.com/A1LENT1337/assignment2-shellsort/tree/feature/algorithm)

---

## Algorithm Overview

The partner’s implementation of **Shell Sort** is a generic and flexible version of the algorithm  
that supports three different **gap sequences**:
- Shell’s (n/2, n/4, …)
- Knuth’s (1, 4, 13, 40, …)
- Sedgewick’s (complex polynomial sequence)

The algorithm uses a **generic array type (`T extends Comparable<T>`)**,  
making it reusable for various data types.  
It integrates performance tracking through the `PerformanceTracker` class,  
which counts comparisons, assignments, and swaps — a clean and modular design choice.

---

## Complexity Analysis

| Case | Time Complexity | Space | Stable |
|------|------------------|--------|--------|
| **Best** | Ω(n log n) | O(1) | ❌ |
| **Average** | Θ(n^(3/2)) – Θ(n^(4/3)) | O(1) | ❌ |
| **Worst** | O(n²) | O(1) | ❌ |

### Analysis Summary
- The runtime efficiency strongly depends on the chosen **gap sequence**.
- **Knuth’s** and **Sedgewick’s** gaps generally produce better performance  
  (closer to Θ(n^(4/3))) than the basic Shell sequence (O(n²)).
- The algorithm is **in-place**, using constant memory.
- However, it is **not stable**, since long-distance swaps can reorder equal elements.

---

## Code Review

### Strengths
- **Clean, generic implementation** — works for any comparable type (not just integers).
- **Modular structure** — clear separation between sorting logic and gap generation.
- **Multiple gap sequence support** — fully meets assignment requirements.
- **Metrics integration** — all key operations (comparisons, assignments, swaps) are tracked.
- **Comprehensive unit tests** — covers edge cases like empty, reversed, and duplicate arrays.
- **CLI benchmark tool** — supports various input types and gap configurations.

### Weaknesses
- Missing **early termination condition** — algorithm continues even if already sorted.
- **Gap sequences** are regenerated for each run instead of being cached.
- **Assignment counter** slightly inflates results (counts temporary reassignments).
- No **adaptive sequence selection** for different input sizes.

---

## Suggested Improvements

1. Add early termination check to exit when no swaps occur.
2. Cache gap sequences instead of regenerating every execution.
3. Implement adaptive gap selection (Shell, Knuth, or Sedgewick) depending on input size.
4. Integrate CSV logging and plotting for consistent performance tracking.
5. Reduce redundant assignments for cleaner performance measurement.

---

## Comparison with Heap Sort

| Property | ShellSort | HeapSort |
|-----------|------------|-----------|
| **Best** | Ω(n log n) | Ω(n log n) |
| **Average** | Θ(n^(4/3)) | Θ(n log n) |
| **Worst** | O(n²) | O(n log n) |
| **Space** | O(1) | O(1) |
| **Stable** | ❌ | ❌ |

**Summary:**
- Shell Sort can outperform Heap Sort on **small or nearly sorted arrays**  
  due to lower constant factors.
- Heap Sort provides **consistent O(n log n)** performance on all datasets.
- Both algorithms are **in-place** and **unstable**.

---

## Conclusion

The Shell Sort implementation by **Nurdaulet** is well-structured, efficient, and modular.  
It demonstrates good algorithmic understanding and meets all assignment criteria.  
With minor improvements such as adaptive gap tuning and early termination,  
it could achieve near-optimal performance.

*Reviewed by: Zhuparbay Erkebulan (Pair 2, Student B)*  
*October 2025*


