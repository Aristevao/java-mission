package models.exceptions;

/*
 * Specific class to treat custom exceptions.
 * This class can extends "Exception" or "RuntimeException".
 * The difference between then is that Exception forces you
 * to treat the error with catch clause and RuntimeException
 * does not, instead allows you to just propagate the error.
 * But, even without obligation, is safer to catch the error
 * somewhere. */
public class DomainException extends RuntimeException {

    // Constructor that allows pass a custom message as argument.
    public DomainException(String msg) {
        super(msg);
    }
}
