package org.example;

import org.example.models.Cat;
import org.example.models.Console;
import org.example.models.Stats;
import org.example.processors.EntryReader;
import org.example.processors.StatsMaker;
import org.example.processors.Validator;
import org.example.processors.WriteCSV;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App extends EntryReader {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Checking for illegal entries:\n");
        List<Cat> readCats, cats;
        readCats = EntryReader.readNaturalCSV("src/Database/DataCatPersonality.csv");
        System.out.println("\nChecking for duplicate and contradictory entries:\n");
        cats = Validator.validateCats(readCats);

        System.out.println("\n" + cats.size() + " valid cats remaining!\n");

        List<Stats> stats = StatsMaker.getStats(cats);

        Console console = new Console(stats, cats);
        console.start();
    }
}
