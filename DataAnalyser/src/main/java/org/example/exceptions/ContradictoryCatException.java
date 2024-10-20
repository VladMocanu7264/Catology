package org.example.exceptions;

public class ContradictoryCatException extends Exception {
    public ContradictoryCatException(int rowA, int rowB) {
        super("Contradictory cat breeds on rows " + rowA + " and " + rowB);
    }
}
