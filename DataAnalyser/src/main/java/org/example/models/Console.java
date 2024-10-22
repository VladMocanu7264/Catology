package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.processors.Balancer;
import org.example.processors.StatsMaker;
import org.example.processors.WriteCSV;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Data
@AllArgsConstructor
public class Console {
    private List<Stats> stats;
    private List<Cat> cats;

    public void start() {
        String input;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Commands:");
            System.out.println("stats = Show stats of all breeds");
            System.out.println("stats 1-13 = Show stats for a certain breed");
            System.out.println("create = creates the output CSV file");
            System.out.println("balance x = balance the database (every breed will have x entries)");
            System.out.println("quit = quits console");
            System.out.print("\nEnter command: ");

            input = scanner.nextLine();
            System.out.println();
            if(input.equals("quit")) {
                break;
            }else if(input.equals("create")) {
                output();
            }else if(input.equals("stats")) {
                System.out.println(stats.get(0));
            }else if(input.startsWith("stats ")) {
                input = input.replaceAll("stats ", "");
                int breed = Integer.parseInt(input);
                if(breed > 13) {
                    throw new RuntimeException("Bad breed");
                }
                System.out.println(stats.get(breed));
            } else if(input.startsWith("balance")) {
                input = input.replaceAll("balance ", "");
                int populationSize = Integer.parseInt(input);
                cats = Balancer.balanceDatabase(cats, stats, populationSize);
                stats = StatsMaker.getStats(cats);
                System.out.println("Balanced all breeds!\n");
            }
        }
    }

    private void output() {
        System.out.print("\nEnter name of output file (without extension): ");
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
