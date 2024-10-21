package org.example.Graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoxPlotForTrait extends  JFrame{

    public BoxPlotForTrait(String title, String trait){
        super(title);

        DefaultBoxAndWhiskerCategoryDataset  dataset = createDataSet(trait);

        JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(
                "Distribution of " + trait + " trait",
                "Trait",
                "Value",
                dataset,
                true
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultBoxAndWhiskerCategoryDataset createDataSet(String trait) {
        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
        List<Double> traitValues = new ArrayList<>();

        try (CSVParser csvParser = new CSVParser(new FileReader("src/Database/ProcessedCatData.csv"), CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : csvParser) {
                String traitValueStr = record.get(trait);
                if (traitValueStr != null && !traitValueStr.isEmpty()) {
                    double traitValue = Double.parseDouble(traitValueStr);
                    traitValues.add(traitValue);
                }
            }
            dataset.add(BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(traitValues), trait, "Trait");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }

        return dataset;
    }

}
