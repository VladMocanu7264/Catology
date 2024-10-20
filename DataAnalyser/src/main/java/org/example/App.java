package org.example;

import org.example.models.Cat;
import org.example.processors.EntryReader;
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

        System.out.print("Enter name of output file (without extension): ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        WriteCSV.writeCSV(
                cats,
                new String[]{"id",
                        "breed",
                        "sex",
                        "age",
                        "numberOfCatsInHouse",
                        "houseType",
                        "zone",
                        "timeOutside",
                        "timeWithOwner",
                        "shy",
                        "calm",
                        "afraid",
                        "clever",
                        "vigilant",
                        "persevering",
                        "affectionate",
                        "friendly",
                        "lonely",
                        "brutal",
                        "dominant",
                        "aggressive",
                        "impulsive",
                        "predictable",
                        "distracted",
                        "greeneryInArea",
                        "birdCatcher",
                        "mammalCatcher",
                        "bonus"},
                fileName);
    }
}
