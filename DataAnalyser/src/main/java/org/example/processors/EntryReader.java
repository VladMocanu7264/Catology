package org.example.processors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.exceptions.IllegalDataException;
import org.example.models.Attributes;
import org.example.models.Cat;
import org.example.utils.TranslationUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EntryReader {

    static protected List<Cat> readNaturalCSV(String filePath) {
        List<Cat> cats = new ArrayList<>();
        try (Reader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            try (CSVParser csvParser = new CSVParser(reader, CSVFormat.Builder.create()
                    .setHeader("Row.names", "Time stamp", "Sex", "Age", "Breed", "Number", "Accommodation",
                            "Area", "Ext", "Obs", "Shy", "Calm", "Afraid", "Clever", "Vigilant", "Persevering",
                            "Affectionate", "Friendly", "Lonely", "Brutal", "Dominant", "Aggressive", "Impulsive",
                            "Predictable", "Distracted", "Abundance", "PredBird", "PredMamm", "More")
                    .setSkipHeaderRecord(true)
                    .setIgnoreHeaderCase(true)
                    .setTrim(true)
                    .build())) {

                int count = 0;
                HashMap<Attributes, List<Integer>>  map = new HashMap<>();

                for (CSVRecord record : csvParser) {
                    Cat cat = new Cat();
                    try {
                        cat.setId((int)record.getRecordNumber() + 1);

                        cat.setAge(TranslationUtil.trAges(record.get("Age")));
                        cat.setSex(TranslationUtil.trSexes(record.get("Sex")));
                        cat.setBreed(TranslationUtil.trBreed(record.get("Breed")));
                        cat.setNumberOfCatsInHouse(TranslationUtil.trNumber(record.get("Number")));
                        cat.setHouseType(TranslationUtil.trAccommodation(record.get("Accommodation")));
                        cat.setZone(TranslationUtil.trZone(record.get("Area")));
                        cat.setTimeOutside(TranslationUtil.trTimeOutside(record.get("Ext")));
                        cat.setTimeWithOwner(TranslationUtil.trTimeWithOwner(record.get("Obs")));
                        cat.setGreeneryInArea(TranslationUtil.trGreeneryInArea(record.get("Abundance")));
                        cat.setBirdCatcher(TranslationUtil.trBirdCatcher(record.get("PredBird")));
                        cat.setMammalCatcher(TranslationUtil.trMammalCather(record.get("PredMamm")));

                        cat.setShy(TranslationUtil.trBasic( Attributes.shy, record.get("Shy")));
                        cat.setCalm(TranslationUtil.trBasic( Attributes.calm, record.get("Calm")));
                        cat.setAfraid(TranslationUtil.trBasic( Attributes.afraid, record.get("Afraid")));
                        cat.setClever(TranslationUtil.trBasic( Attributes.clever, record.get("Clever")));
                        cat.setVigilant(TranslationUtil.trBasic( Attributes.vigilant, record.get("Vigilant")));
                        cat.setPersevering(TranslationUtil.trBasic( Attributes.persevering, record.get("Persevering")));
                        cat.setAffectionate(TranslationUtil.trBasic( Attributes.affectionate, record.get("Affectionate")));
                        cat.setFriendly(TranslationUtil.trBasic( Attributes.friendly, record.get("Friendly")));
                        cat.setLonely(TranslationUtil.trBasic( Attributes.lonely, record.get("Lonely")));
                        cat.setBrutal(TranslationUtil.trBasic( Attributes.brutal,record.get("Brutal")));
                        cat.setDominant(TranslationUtil.trBasic( Attributes.dominant,record.get("Dominant")));
                        cat.setAggressive(TranslationUtil.trBasic( Attributes.aggressive,record.get("Aggressive")));
                        cat.setImpulsive(TranslationUtil.trBasic( Attributes.impulsive,record.get("Impulsive")));
                        cat.setPredictable(TranslationUtil.trBasic( Attributes.predictable,record.get("Predictable")));
                        cat.setDistracted(TranslationUtil.trBasic( Attributes.distracted,record.get("Distracted")));
                        cat.setBonus(record.get("More"));

                        cats.add(cat);
                    } catch (IllegalDataException e) {
                        count++;
                        if(map.containsKey(e.getAttribute())) {
                            List<Integer> list = new ArrayList<>(map.get(e.getAttribute()));
                            list.add((int) record.getRecordNumber() + 1);
                            map.put(e.getAttribute(), list);
                        } else {
                            map.put(e.getAttribute(), List.of((int) record.getRecordNumber() + 1));
                        }
                    }
                }

                if(count == 0) {
                    System.out.println("All arguments are valid.");
                    return cats;
                }

                System.out.println(count + " invalid entries were found!");

                for(Attributes attribute : map.keySet()) {
                    List<Integer> list = map.get(attribute);
                    if(list.isEmpty()) {
                        continue;
                    }

                    System.out.println(attribute.toString() + ": " + list.size() + " illegal entries were found " + list);
                }
            }
        } catch (IOException e) {
            System.out.println("Couldn't read database. Cause: " + e.getMessage());
        }
        return cats;
    }
}
