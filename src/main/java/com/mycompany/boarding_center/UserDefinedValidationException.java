package com.mycompany.boarding_center;

/** User-defined validation exception used by the data-entry screens. */
public class UserDefinedValidationException extends Exception {
    public UserDefinedValidationException(String message) { super(message); }
}
