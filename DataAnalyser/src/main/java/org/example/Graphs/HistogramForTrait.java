package org.example.Graphs;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistogramForTrait extends JFrame {

    public HistogramForTrait(String title, String trait, String fileName) {
        super(title);

        HistogramDataset dataset = createDataSet(trait, fileName);
        JFreeChart histogram = createHistogram(dataset, trait);


        ChartPanel chartPanel = new ChartPanel(histogram);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private HistogramDataset createDataSet(String trait, String fileName) {
        HistogramDataset dataset = new HistogramDataset();
        List<Double> traitValues = new ArrayList<>();

        try (CSVParser csvParser = new CSVParser(new FileReader("src/Database/" + fileName + ".csv"), CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : csvParser) {
                double traitValue = Double.parseDouble(record.get(trait));
                traitValues.add(traitValue);
            }

            double[] valuesArray = traitValues.stream().mapToDouble(Double::doubleValue).toArray();
            dataset.addSeries(trait, valuesArray, 13);
            dataset.setType(HistogramType.FREQUENCY);
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing trait value: " + e.getMessage());
        }
        return dataset;
    }

    private JFreeChart createHistogram(HistogramDataset dataset, String trait) {
        return ChartFactory.createHistogram(
                "Distribution of " + trait,
                trait,
                "Frequency",
                dataset
        );
    }
}
