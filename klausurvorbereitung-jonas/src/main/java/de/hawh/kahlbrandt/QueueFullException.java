package de.hawh.kahlbrandt;

public class QueueFullException extends RuntimeException {

    private static final long serialVersionUID = -4103978192693704203L;

    public QueueFullException(String message) {
        super(message);
    }
}
