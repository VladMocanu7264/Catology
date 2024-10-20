package org.example.exceptions;

import lombok.Getter;
import org.example.models.Attributes;

@Getter
public class IllegalDataException extends Exception {
    private final Attributes attribute;
    public IllegalDataException(String message, Attributes attribute) {
        super("Illegal data: " + message);
        this.attribute = attribute;
    }
}
