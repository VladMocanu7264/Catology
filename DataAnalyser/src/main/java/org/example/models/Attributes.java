package org.example.models;

public enum Attributes {
     breed,
     sex,
     age,
     numberOfCatsInHouse,
     houseType,
     zone,
     timeOutside,
     timeWithOwner,
     shy,
     calm,
     afraid,
     clever,
     vigilant,
     persevering,
     affectionate,
     friendly,
     lonely,
     brutal,
     dominant,
     aggressive,
     impulsive,
     predictable,
     distracted,
     greeneryInArea,
     birdCatcher,
     mammalCatcher;

     static public int nrOfValidValues(Attributes attribute) {
          switch (attribute) {
              case breed:
                  return 13;
              case sex:
                  return 2;
              case age:
              case houseType:
              case timeWithOwner:
                  return 4;
              case numberOfCatsInHouse:
                  return 6;
              case zone:
              case greeneryInArea:
                  return 3;
              case timeOutside:
              case distracted:
              case predictable:
              case impulsive:
              case aggressive:
              case dominant:
              case brutal:
              case lonely:
              case friendly:
              case affectionate:
              case persevering:
              case vigilant:
              case clever:
              case afraid:
              case calm:
              case shy:
              case birdCatcher:
              case mammalCatcher:
                  return 5;
          }
          return -1;
     }
}
