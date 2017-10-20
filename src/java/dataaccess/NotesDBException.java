package dataaccess;

/**
 * Exception class to be thrown whenever any database related error has been
 * found
 *
 * @author Kevin
 */
public class NotesDBException extends Exception {

    /**
     * Default constructor, if you want to pass a custom message with the
     * exception use {@link #NotesDBException(java.lang.String)}
     *
     */
    public NotesDBException() {

    }

    /**
     * Constructor who takes a string containing a custom error message
     * @param message the custom error message repesenting the error that was thrown
     */
    public NotesDBException(String message) {

        super(message);
    }
}
