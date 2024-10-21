package org.example.processors;

import org.example.models.Attributes;
import org.example.models.Cat;
import org.example.models.Stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatsMaker {
    public static List<Stats> getStats(List<Cat> cats) {
        List<Stats> statsEveryBreed = new ArrayList<>();

        statsEveryBreed.add(getStatsForAListOfCats(true, cats));

        for (int i = 1; i <= Attributes.nrOfValidValues(Attributes.breed); ++i) {
            List<Cat> catsOfACertainBreed = new ArrayList<>();
            for(Cat cat : cats) {
                if(cat.getBreed() == i) {
                    catsOfACertainBreed.add(cat);
                }
            }
            statsEveryBreed.add(getStatsForAListOfCats(false, catsOfACertainBreed));
        }

        return statsEveryBreed;
    }

    static private Stats getStatsForAListOfCats(boolean areAll, List<Cat> cats) {
        Stats stats = new Stats();
        stats.setCount(cats.size());
        if (areAll) {
            stats.setBreedNr(0);
        } else {
            stats.setBreedNr(cats.get(0).getBreed());
        }

        HashMap<Attributes, List<Integer>> mapOfAttributes = new HashMap<>();
        for (Attributes attribute : Attributes.values()) {
            if (!areAll && attribute == Attributes.breed) {
                continue;
            }

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < Attributes.nrOfValidValues(attribute); ++i) {
                list.add(0);
            }
            for (Cat cat : cats) {
                int index = cat.getAttribute(attribute) - 1;
                list.set(index, list.get(index) + 1);
            }

            mapOfAttributes.put(attribute, list);
        }

        stats.setMapOfAttributes(mapOfAttributes);

        return stats;
    }
}
