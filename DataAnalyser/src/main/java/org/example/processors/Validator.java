package org.example.processors;

import org.example.exceptions.ContradictoryCatException;
import org.example.exceptions.DuplicateCatException;
import org.example.models.Cat;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<Cat> validateCats(List<Cat> cats) {
        List<Integer> badCatIndexes = new ArrayList<>();

        for (int i = 0; i < cats.size() - 1; ++i) {
            try {
                for(int j = i+1; j<cats.size(); ++j) {
                    if(cats.get(i).equals(cats.get(j))) {
                        throw new DuplicateCatException(cats.get(i).getId(), cats.get(j).getId());
                    }
                    if(cats.get(i).contradicts(cats.get(j))) {
                        throw new ContradictoryCatException(cats.get(i).getId(), cats.get(j).getId());
                    }
                }
            } catch (DuplicateCatException | ContradictoryCatException e) {
                System.out.println(e.getMessage());
                badCatIndexes.add(i);
            }
        }

        for(int i = badCatIndexes.size() - 1; i>=0; --i) {
            cats.remove(cats.get(i));
        }



        return cats;
    }
}
