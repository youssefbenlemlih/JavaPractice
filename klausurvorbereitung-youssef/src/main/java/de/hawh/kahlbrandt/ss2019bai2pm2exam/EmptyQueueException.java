package de.hawh.kahlbrandt.ss2019bai2pm2exam;

public class EmptyQueueException extends Exception {
    private static final long serialVersionUID = 4895398245708128040L;

    public EmptyQueueException(String message) {
        super(message);
    }
}
