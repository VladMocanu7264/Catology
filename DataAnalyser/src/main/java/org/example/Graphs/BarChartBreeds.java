package org.example.Graphs;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class BarChartBreeds extends JFrame{

    private static final Map<Integer, String> breedMap = new HashMap<>();
    static {
        breedMap.put(1, "Bengal");
        breedMap.put(2, "Birman");
        breedMap.put(3, "British Shorthair");
        breedMap.put(4, "Chartreux");
        breedMap.put(5, "European");
        breedMap.put(6, "Maine coon");
        breedMap.put(7, "Ragdoll");
        breedMap.put(8, "Ragdoll");
        breedMap.put(9, "Savannah");
        breedMap.put(10, "Sphynx");
        breedMap.put(11, "Siamese");
        breedMap.put(12, "Turkish angora");
        breedMap.put(13, "other");
    }

    public BarChartBreeds(String title) {
        super(title);

        DefaultCategoryDataset dataset = createDataset();
        JFreeChart barchat = ChartFactory.createBarChart(
                "Distribution of cat breeds",
                "Breed",
                "Number of cats",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barchat);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> breedCountMap = new HashMap<>();

        try (CSVParser csvParser = new CSVParser(new FileReader("src/Database/ProcessedCatData.csv"),
                CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : csvParser) {
                String breedNumberStr = record.get("breed");
                int breedNumber = Integer.parseInt(breedNumberStr);
                String breedName = breedMap.get(breedNumber);

                if (breedName != null) {
                    breedCountMap.put(breedName, breedCountMap.getOrDefault(breedName, 0) + 1);
                } else {
                    System.err.println("Warning: Unknown breed number " + breedNumber);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }

        for (Map.Entry<String, Integer> entry : breedCountMap.entrySet()) {
            dataset.addValue(entry.getValue(), "Count", entry.getKey());
        }

        return dataset;
    }

}
