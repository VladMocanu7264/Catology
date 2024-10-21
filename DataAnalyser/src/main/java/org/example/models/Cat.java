package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    private Integer id;

    private Integer breed;

    private Integer sex;
    private Integer age;
    private Integer numberOfCatsInHouse;
    private Integer houseType;
    private Integer zone;
    private Integer timeOutside;
    private Integer timeWithOwner;
    private Integer shy;
    private Integer calm;
    private Integer afraid;
    private Integer clever;
    private Integer vigilant;
    private Integer persevering;
    private Integer affectionate;
    private Integer friendly;
    private Integer lonely;
    private Integer brutal;
    private Integer dominant;
    private Integer aggressive;
    private Integer impulsive;
    private Integer predictable;
    private Integer distracted;
    private Integer greeneryInArea;
    private Integer birdCatcher;
    private Integer mammalCatcher;
    private String bonus;

    public String[] putIntoCSV() {
        return new String[] {
                id.toString(),
                breed.toString(),
                sex.toString(),
                age.toString(),
                numberOfCatsInHouse.toString(),
                houseType.toString(),
                zone.toString(),
                timeOutside.toString(),
                timeWithOwner.toString(),
                shy.toString(),
                calm.toString(),
                afraid.toString(),
                clever.toString(),
                vigilant.toString(),
                persevering.toString(),
                affectionate.toString(),
                friendly.toString(),
                lonely.toString(),
                brutal.toString(),
                dominant.toString(),
                aggressive.toString(),
                impulsive.toString(),
                predictable.toString(),
                distracted.toString(),
                greeneryInArea.toString(),
                birdCatcher.toString(),
                mammalCatcher.toString(),
                bonus
        };
    }

    public int getAttribute(Attributes attribute) {
        switch (attribute) {
            case breed:
                return breed;
            case sex:
                return sex;
            case age:
                return age;
            case numberOfCatsInHouse:
                return numberOfCatsInHouse;
            case houseType:
                return houseType;
            case zone:
                return zone;
            case timeOutside:
                return timeOutside;
            case timeWithOwner:
                return timeWithOwner;
            case shy:
                return shy;
            case calm:
                return calm;
            case afraid:
                return afraid;
            case clever:
                return clever;
            case vigilant:
                return vigilant;
            case persevering:
                return persevering;
            case affectionate:
                return affectionate;
            case friendly:
                return friendly;
            case lonely:
                return lonely;
            case brutal:
                return brutal;
            case dominant:
                return dominant;
            case aggressive:
                return aggressive;
            case impulsive:
                return impulsive;
            case predictable:
                return predictable;
            case distracted:
                return distracted;
            case greeneryInArea:
                return greeneryInArea;
            case birdCatcher:
                return birdCatcher;
            case mammalCatcher:
                return mammalCatcher;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(breed, cat.breed) && Objects.equals(sex, cat.sex) && Objects.equals(age, cat.age) && Objects.equals(numberOfCatsInHouse, cat.numberOfCatsInHouse) && Objects.equals(houseType, cat.houseType) && Objects.equals(zone, cat.zone) && Objects.equals(timeOutside, cat.timeOutside) && Objects.equals(timeWithOwner, cat.timeWithOwner) && Objects.equals(shy, cat.shy) && Objects.equals(calm, cat.calm) && Objects.equals(afraid, cat.afraid) && Objects.equals(clever, cat.clever) && Objects.equals(vigilant, cat.vigilant) && Objects.equals(persevering, cat.persevering) && Objects.equals(affectionate, cat.affectionate) && Objects.equals(friendly, cat.friendly) && Objects.equals(lonely, cat.lonely) && Objects.equals(brutal, cat.brutal) && Objects.equals(dominant, cat.dominant) && Objects.equals(aggressive, cat.aggressive) && Objects.equals(impulsive, cat.impulsive) && Objects.equals(predictable, cat.predictable) && Objects.equals(distracted, cat.distracted) && Objects.equals(greeneryInArea, cat.greeneryInArea) && Objects.equals(birdCatcher, cat.birdCatcher) && Objects.equals(mammalCatcher, cat.mammalCatcher);
    }

    public boolean contradicts(Cat cat) {
        return !Objects.equals(breed, cat.breed) && Objects.equals(sex, cat.sex) && Objects.equals(age, cat.age) && Objects.equals(numberOfCatsInHouse, cat.numberOfCatsInHouse) && Objects.equals(houseType, cat.houseType) && Objects.equals(zone, cat.zone) && Objects.equals(timeOutside, cat.timeOutside) && Objects.equals(timeWithOwner, cat.timeWithOwner) && Objects.equals(shy, cat.shy) && Objects.equals(calm, cat.calm) && Objects.equals(afraid, cat.afraid) && Objects.equals(clever, cat.clever) && Objects.equals(vigilant, cat.vigilant) && Objects.equals(persevering, cat.persevering) && Objects.equals(affectionate, cat.affectionate) && Objects.equals(friendly, cat.friendly) && Objects.equals(lonely, cat.lonely) && Objects.equals(brutal, cat.brutal) && Objects.equals(dominant, cat.dominant) && Objects.equals(aggressive, cat.aggressive) && Objects.equals(impulsive, cat.impulsive) && Objects.equals(predictable, cat.predictable) && Objects.equals(distracted, cat.distracted) && Objects.equals(greeneryInArea, cat.greeneryInArea) && Objects.equals(birdCatcher, cat.birdCatcher) && Objects.equals(mammalCatcher, cat.mammalCatcher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, sex, age, numberOfCatsInHouse, houseType, zone, timeOutside, timeWithOwner, shy, calm, afraid, clever, vigilant, persevering, affectionate, friendly, lonely, brutal, dominant, aggressive, impulsive, predictable, distracted, greeneryInArea, birdCatcher, mammalCatcher, bonus);
    }
}
