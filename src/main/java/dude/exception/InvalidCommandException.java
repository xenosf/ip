package dude.exception;

/**
 * Exception for unknown command input.
 */
public class InvalidCommandException extends DudeException {
    /**
     * Constructs new InvalidCommandException.
     */
    public InvalidCommandException() {
        super(
                "I don't know what that means.\n"
                        + "Try checking if you've typed the command correctly."
        );
    }
}
