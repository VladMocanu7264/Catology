package org.example.processors;

import org.example.models.Attributes;
import org.example.models.Cat;
import org.example.models.Stats;

import java.util.*;

public class Balancer {
    public static List<Cat> balanceDatabase(List<Cat> cats, List<Stats> databaseStats, int perBreedPopulationSize) {
        List<Cat> balancedCats = new ArrayList<>(cats);

        for (int i = 1; i <= Attributes.nrOfValidValues(Attributes.breed); ++i) {
            Stats stats = getStatsForBreed(databaseStats, i);

            int count = stats.getCount();

            if (count == perBreedPopulationSize) {
                continue;
            }

            if (count > perBreedPopulationSize) {
                balancedCats = removeEntries(balancedCats, i, count - perBreedPopulationSize);
            } else {
                balancedCats = addEntries(balancedCats, i, stats, perBreedPopulationSize - count);
            }
        }

        return balancedCats;
    }

    private static Stats getStatsForBreed(List<Stats> databaseStats, int i) {
        for (Stats s : databaseStats) {
            if (s.getBreedNr() == i) {
                return s;
            }
        }
        return databaseStats.get(0);
    }

    private static List<Cat> removeEntries(List<Cat> cats, int breed, int diff) {
        List<Cat> processedCats = new ArrayList<>(cats);

        //get all the cat indexes
        List<Integer> thisBreedsCats = new ArrayList<>();
        int index = 0;
        for (Cat cat : processedCats) {
            if (cat.getBreed() == breed) {
                thisBreedsCats.add(index);
            }
            index++;
        }

        //generate random indexes to remove
        List<Integer> indexesToRemove = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < diff; i++) {
            int id = random.nextInt(thisBreedsCats.size());
            while (indexesToRemove.contains(id)) {
                id = random.nextInt(thisBreedsCats.size());
            }
            indexesToRemove.add(id);
        }
        Collections.sort(indexesToRemove);

        //remove them from the main list
        for (int i = indexesToRemove.size() - 1; i >= 0; i--) {
            processedCats.remove((int) thisBreedsCats.get(indexesToRemove.get(i)));
        }

        return processedCats;
    }

    private static List<Cat> addEntries(List<Cat> cats, int breed, Stats stats, int diff) {
        List<Cat> processedCats = new ArrayList<>(cats);

        for (int i = 0; i < diff; ++i) {
            processedCats.add(addEntry(stats, breed));
        }

        return processedCats;
    }

    private static Cat addEntry(Stats stats, int breed) {
        int max = stats.getCount();
        int[] attributes = new int[Attributes.values().length];

        for(Attributes attribute : Attributes.values()) {
            if(attribute == Attributes.breed) {
                continue;
            }
            List<Integer> frequencies = stats.getMapOfAttributes().get(attribute);

            attributes[getAttributeInt(attribute)] = generateValue(frequencies, max);
        }

        return new Cat(0, breed, attributes[1], attributes[2],
                attributes[3], attributes[4], attributes[5], attributes[6],
                attributes[7], attributes[8], attributes[9], attributes[10],
                attributes[11], attributes[12], attributes[13], attributes[14],
                attributes[15], attributes[16], attributes[17], attributes[18],
                attributes[19], attributes[20], attributes[21], attributes[22],
                attributes[23], attributes[24], attributes[25], "");
    }

    private static int generateValue(List<Integer> frequencies, int max) {
        Random random = new Random();
        int number = random.nextInt(max);
        int value = 1;
        for(int count : frequencies) {
            if(number - count < 0) {
                return value;
            }
            number -= count;
            value++;
        }
        return value;
    }

    private static int getAttributeInt(Attributes attribute) {
        switch (attribute) {
            case breed:
                return 0;
            case sex:
                return 1;
            case age:
                return 2;
            case numberOfCatsInHouse:
                return 3;
            case houseType:
                return 4;
            case zone:
                return 5;
            case timeOutside:
                return 6;
            case timeWithOwner:
                return 7;
            case shy:
                return 8;
            case calm:
                return 9;
            case afraid:
                return 10;
            case clever:
                return 11;
            case vigilant:
                return 12;
            case persevering:
                return 13;
            case affectionate:
                return 14;
            case friendly:
                return 15;
            case lonely:
                return 16;
            case brutal:
                return 17;
            case dominant:
                return 18;
            case aggressive:
                return 19;
            case impulsive:
                return 20;
            case predictable:
                return 21;
            case distracted:
                return 22;
            case greeneryInArea:
                return 23;
            case birdCatcher:
                return 24;
            case mammalCatcher:
                return 25;
        }
        return 0;
    }
}
