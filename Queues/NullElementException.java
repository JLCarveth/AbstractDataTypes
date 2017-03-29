public class NullElementException extends RuntimeException {
    public NullElementException() {
        super("Element cannot be null.");
    }

    public NullElementException(String message) {
        super(message);
    }
}