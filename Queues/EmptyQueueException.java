public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Empty Queue");
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}