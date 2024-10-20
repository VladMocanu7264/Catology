package org.example.processors;

import com.opencsv.CSVWriter;
import org.example.models.Cat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteCSV {
    public static void writeCSV(List<Cat> cats, String[] header, String fileName) {
        String filePath = "src/Database/" + fileName + ".csv";
        File outputCSV = new File(filePath);

        try {
            FileWriter outputCSVWriter = new FileWriter(outputCSV);

            CSVWriter csvWriter = new CSVWriter(outputCSVWriter);

            csvWriter.writeNext(header);

            List<String[]> data = new ArrayList<>();
            for(Cat cat : cats) {
                data.add(cat.putIntoCSV());
            }
            csvWriter.writeAll(data);

            csvWriter.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
