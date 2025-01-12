package dev.aerolinea.springaerolinea.countries.exceptions;

public class CountryException extends RuntimeException {

    public CountryException(String message) {
        super(message);
    }

    public CountryException(String message, Throwable cause) {
        super(message, cause);
    }
    
}