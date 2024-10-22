package org.example;

import org.example.Graphs.*;

import javax.swing.*;
import java.io.FileNotFoundException;


public class Graphics {

    public static void main(String[] args) throws FileNotFoundException {
//        for breeds the total number
//        BarChartBreeds bar = new BarChartBreeds("Number of breeds");
//        bar.setSize(800,600);
//        bar.setLocationRelativeTo(null);
//        bar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        bar.setVisible(true);
//
////         A pie chart of the overall traits
//        PieChartOverAllTraits chart = new PieChartOverAllTraits("Pie Chart for Overall Traits");
//        chart.setSize(800, 600);
//        chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        chart.setVisible(true);

        // Histogram selected traits

        String selectedTrait = "shy";

        HistogramForTrait histogram = new HistogramForTrait("Trait Histogram Example", selectedTrait, args[0]);
        histogram.setSize(800, 600);
        histogram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        histogram.setVisible(true);

        // box plot

        SwingUtilities.invokeLater(() -> {
            BoxPlotForTrait example = new BoxPlotForTrait("Box plot for:", selectedTrait, args[0]);
            example.setSize(800, 600);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }

    public static void showHistogram(String selectedTrait, String fileName) {
        HistogramForTrait histogram = new HistogramForTrait("Trait Histogram Example", selectedTrait, fileName);
        histogram.setSize(800, 600);
        histogram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        histogram.setVisible(true);
    }

    public static void showBoxPlot(String selectedTrait, String fileName) {
        BoxPlotForTrait example = new BoxPlotForTrait("Box plot for:", selectedTrait, fileName);
        example.setSize(800, 600);
        example.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        example.setVisible(true);
    }
}