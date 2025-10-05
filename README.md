#  Assignment 2 – Design and Analysis of Algorithms

**Pair 2 – Advanced Sorting Algorithms**  
**Student B:** Heap Sort (in-place, bottom-up heapify)  
**Partner (Student A):** Shell Sort (multi-gap sequence implementation)

---

##  Overview

This project is about implementation and analysing of **Heap Sort** algorithm.  
The goal of work was to understand algorithm complexity, make performance tests and write peer code review.

Experiments was made using class `PerformanceTracker` that counts comparisons and swaps.  
Results was written in CSV file and then visualized with JFreeChart.

---

## Project Structure
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

##  Features

**HeapSort Implementation** — in-place sorting using heapify  
**Performance Tracking** — counting number of comparisons and swaps
**Benchmark Runner** — run algorithm on different input size  
**CSV Logger** — save runtime result automatic  
**Plot Generator** — create charts using JFreeChart  
**Analysis Report** — contain both theory and experiment part

---

## How to Run

###  Compile project
```bash
mvn clean compile
Run Benchmarks
mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"
Generate Performance Plots
mvn exec:java -Dexec.mainClass="cli.PlotGenerator"
Output Example
n = 10000 | time = 7.02 ms | comparisons = 235472 | swaps = 124323
Plots saved to docs/performance-plots/
Generated Files
• results.csv – benchmark data
• time_vs_n.png, comparisons_vs_n.png – performance graphs
• analysis-report.md / analysis-report.pdf – report with results

Partner Collaboration

Pair 2 – Advanced Sorting Algorithms
• Student A: Shell Sort (with multiple gap sequences)
• Student B (Me): Heap Sort (bottom-up heapify)

I also check my partner code and write some analysis about ShellSort algorithm in file docs/analysis-report.md.