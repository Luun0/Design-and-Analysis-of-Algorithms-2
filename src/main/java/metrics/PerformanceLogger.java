package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceLogger {
    public static void log(String filename, int n, double timeMs, long comparisons, long swaps) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(n + "," + timeMs + "," + comparisons + "," + swaps + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }
}