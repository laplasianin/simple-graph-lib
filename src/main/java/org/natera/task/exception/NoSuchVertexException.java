package org.natera.task.exception;

public class NoSuchVertexException extends RuntimeException {

    public NoSuchVertexException(Object vertex) {
        super("No vertex " + vertex + " found in graph");
    }
}
