package de.hawh.kahlbrandt;

public class QueueEmptyException extends RuntimeException {

    private static final long serialVersionUID = 8517488156814788516L;

    public QueueEmptyException(String message) {
        super(message);
    }
}
