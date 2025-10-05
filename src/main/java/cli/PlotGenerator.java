package cli;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlotGenerator {

    public static void main(String[] args) {
        String csvFile = "results.csv";
        String outputDir = "docs/performance-plots";

        try {
            Files.createDirectories(Paths.get(outputDir));

            DefaultCategoryDataset timeDataset = new DefaultCategoryDataset();
            DefaultCategoryDataset comparisonsDataset = new DefaultCategoryDataset();

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length == 4) {
                        int n = Integer.parseInt(values[0]);
                        double timeMs = Double.parseDouble(values[1]);
                        long comparisons = Long.parseLong(values[2]);

                        timeDataset.addValue(timeMs, "Time (ms)", String.valueOf(n));
                        comparisonsDataset.addValue(comparisons, "Comparisons", String.valueOf(n));
                    }
                }
            }

            // Time vs n
            JFreeChart timeChart = ChartFactory.createLineChart(
                    "HeapSort Runtime",
                    "Input size (n)",
                    "Time (ms)",
                    timeDataset
            );
            ChartUtils.saveChartAsPNG(new File(outputDir + "/time_vs_n.png"), timeChart, 800, 600);

            // Comparisons vs n
            JFreeChart compChart = ChartFactory.createLineChart(
                    "HeapSort Comparisons",
                    "Input size (n)",
                    "Comparisons",
                    comparisonsDataset
            );
            ChartUtils.saveChartAsPNG(new File(outputDir + "/comparisons_vs_n.png"), compChart, 800, 600);

            System.out.println("✅ Plots saved to " + outputDir);

        } catch (Exception e) {
            System.err.println("❌ Error generating plots: " + e.getMessage());
        }
    }
}