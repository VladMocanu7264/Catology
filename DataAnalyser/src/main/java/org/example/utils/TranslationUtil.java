package org.example.utils;

import org.example.exceptions.IllegalDataException;
import org.example.models.Attributes;

import javax.print.attribute.Attribute;

public class TranslationUtil {
    static public int trAges(String ageStr) throws IllegalDataException {
        switch (ageStr) {
            case "Less than 1":
                return 1;
            case "1a2":
                return 2;
            case "2a10":
                return 3;
            case "More than 10":
                return 4;
            default:
                throw new IllegalDataException("Illegal age entry: " + ageStr, Attributes.age);
        }
    }

    static public int trSexes(String sexStr) throws IllegalDataException {
        switch (sexStr) {
            case "F":
                return 1;
            case "M":
                return 2;
            default:
                throw new IllegalDataException("Illegal sex entry: " + sexStr, Attributes.sex);
        }
    }

    static public int trBreed(String breedStr) throws IllegalDataException {
        switch (breedStr) {
            case "BEN"://""Bengal":
                return 1;
            case "SBI"://"Birman":
                return 2;
            case "BRI"://"British Shorthair":
                return 3;
            case "CHA"://"Chartreux":
                return 4;
            case "EUR"://"European":
                return 5;
            case "MCO"://Maine coon":
                return 6;
            case "PER"://"Persian":
                return 7;
            case "RAG"://Ragdoll":
                return 8;
            case "SPH"://"Savannah":
                return 9;
            case "ORI"://"Sphynx":
                return 10;
            case "SAV"://"Siamese";
                return 11;
            case "TUV"://"Turkish angora":
                return 12;
            case "NR"://"No breed":
            case "Other":
                return 13;
            default:
                throw new IllegalDataException("Illegal breed entry: " + breedStr, Attributes.breed);
        }
    }

    static public int trNumber(String numberOfCats) throws IllegalDataException {
        switch (numberOfCats) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "More than 5":
                return 6;
            default:
                throw new IllegalDataException("Illegal number of cats: " + numberOfCats, Attributes.numberOfCatsInHouse);
        }
    }

    static public int trAccommodation(String accommodation) throws IllegalDataException {
        switch (accommodation) {
            case "ASB":
                return 1;
            case "AAB":
                return 2;
            case "ML":
                return 3;
            case "MI":
                return 4;
            default:
                throw new IllegalDataException("Illegal accommodation entry: " + accommodation, Attributes.houseType);
        }
    }

    static public int trZone(String zone) throws IllegalDataException {
        switch (zone) {
            case "U":
                return 1;
            case "PU":
                return 2;
            case "R":
                return 3;
            default:
                throw new IllegalDataException("Illegal zone entry: " + zone, Attributes.zone);
        }
    }

    static public int trTimeOutside(String timeOutside) throws IllegalDataException {
        switch (timeOutside) {
            case "0":
                return 1;
            case "1":
                return 2;
            case "2":
                return 3;
            case "3":
                return 4;
            case "4":
                return 5;
            default:
                throw new IllegalDataException("Illegal time outside: " + timeOutside, Attributes.timeOutside);
        }
    }

    static public int trTimeWithOwner(String timeWithOwner) throws IllegalDataException {
        switch (timeWithOwner) {
            case "0":
                return 1;
            case "1":
                return 2;
            case "2":
                return 3;
            case "3":
                return 4;
            default:
                throw new IllegalDataException("Illegal time with owner: " + timeWithOwner, Attributes.timeWithOwner);
        }
    }

    static public int trGreeneryInArea(String greeneryInArea) throws IllegalDataException {
        switch (greeneryInArea) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            default:
                throw new IllegalDataException("Illegal abundance: " + greeneryInArea, Attributes.greeneryInArea);
        }
    }

    static public int trBirdCatcher(String birdCatcher) throws IllegalDataException {
        switch (birdCatcher) {
            case "0":
                return 1;
            case "1":
                return 2;
            case "2":
                return 3;
            case "3":
                return 4;
            case "4":
                return 5;
            default:
                throw new IllegalDataException("Illegal bird catcher: " + birdCatcher, Attributes.birdCatcher);
        }
    }

    static public int trMammalCather(String mammalCatcher) throws IllegalDataException {
        switch (mammalCatcher) {
            case "0":
                return 1;
            case "1":
                return 2;
            case "2":
                return 3;
            case "3":
                return 4;
            case "4":
                return 5;
            default:
                throw new IllegalDataException("Illegal mammal catcher: " + mammalCatcher, Attributes.mammalCatcher);
        }
    }

    static public int trBasic(Attributes attribute, String number) throws IllegalDataException {
        int nr = Integer.parseInt(number);
        if (nr > 5) {
            throw new IllegalDataException("Illegal " + attribute.toString() + " entry: " + number, attribute);
        }
        return nr;
    }

    static public String trBreed(int breed) {
        switch (breed) {
            case 1:
                return "Bengal";
            case 2:
                return "Birman";
            case 3:
                return "British Shorthair";
            case 4:
                return "Chartreux";
            case 5:
                return "European";
            case 6:
                return "Maine coon";
            case 7:
                return "Persian";
            case 8:
                return "Ragdoll";
            case 9:
                return "Savannah";
            case 10:
                return "Sphynx";
            case 11:
                return "Siamese";
            case 12:
                return "Turkish Angora";
            case 13:
                return "Hybrid";
        }
        return "ERROR";
    }
}
