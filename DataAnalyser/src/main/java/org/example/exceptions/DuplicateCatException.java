package org.example.exceptions;

public class DuplicateCatException extends Exception {

    public DuplicateCatException(int rowA, int rowB) {
        super("Duplicate cats on " + rowA + " and " + rowB);
    }
}
