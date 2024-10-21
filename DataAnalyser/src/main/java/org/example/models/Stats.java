package org.example.models;

import lombok.Data;
import org.example.utils.TranslationUtil;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

@Data
public class Stats {
    int breedNr; // 0 for all
    int count;
    HashMap<Attributes, List<Integer>> mapOfAttributes;

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("0.00");
        StringBuilder toReturn = new StringBuilder();
        if(breedNr == 0) {
            toReturn.append("Stats for all breeds: \n\n");
        } else {
            toReturn.append(TranslationUtil.trBreed(breedNr)).append(" (").append(count).append(" cats):\n\n");
        }

        for(Attributes attribute : Attributes.values()) {
            if(breedNr != 0 && attribute == Attributes.breed) {
                continue;
            }

            toReturn.append(attribute.toString()).append("\n");
            for(int i =  1; i <= Attributes.nrOfValidValues(attribute); ++i) {
                toReturn.append("   ")
                        .append(attribute == Attributes.breed ? TranslationUtil.trBreed(i) : i)
                        .append(": ")
                        .append(mapOfAttributes.get(attribute).get(i - 1))
                        .append(" ")
                        .append(numberFormat.format((double)mapOfAttributes.get(attribute).get(i - 1) / count * 100))
                        .append("%\n");
            }
        }

        return toReturn.toString();
    }
}
