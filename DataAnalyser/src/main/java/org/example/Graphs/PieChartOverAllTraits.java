package org.example.processors;

import org.apache.commons.csv.CSVFormat;
import java.io.FileReader;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PieChartOverAllTraits extends Jframe {
    public pieChart(String title){
        super(title);

        Map<String, Interger> traitCounter = createDataset("src/Database/ProcessedCatData.csv");
        JFreeChart pieChart = createPieChart(traitCounter);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private Map<String, Interger> createDataset(String filePath){
        Map<String, Interger> traitsCounterMap = new HashMap<>();
        String[] traits = {"shy", "calm", "afraid", "clever", "vigilant",
                "persevering", "affectionate", "friendly",
                "lonely", "brutal", "dominant", "aggressive",
                "impulsive", "predictable", "distracted"};
    }

     for (String trait : traits) {
        traitCounterMap.put(trait, 0);
    }

      try (CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withHeader())) {
        for (CSVRecord record : csvParser) {

            for (String trait : traits) {
                int value = Integer.parseInt(record.get(trait));
                traitCounterMap.put(trait, traitCounterMap.get(trait) + value);
            }
        }
    } catch (IOException e) {
        System.err.println("Error reading CSV file: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.err.println("Error parsing number: " + e.getMessage());
    }

      return traitCounterMap;

      private JfreeChart createPieChart(Map<String, Interger> traitCounter){
          DefaultPieDataset dataset = new DefaultPieDataset();


          for (Map.Entry<String, Integer> entry : traitCounts.entrySet()) {
              dataset.setValue(entry.getKey(), entry.getValue());
          }


          return ChartFactory.createPieChart(
                  "Overall Trait Distribution", /
                  dataset,
                  true,
                  true,
                  false
          );
      }
      }
}