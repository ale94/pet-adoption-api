package ar.com.ale94.pet_adoption_api.exceptions;

public class IdNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Record does not exist in %s";

    public IdNotFoundException(String message) {
        super(String.format(ERROR_MESSAGE, message));
    }
}
