package org.natera.task.model;

public class Edge<T> {

    private T to;

    public Edge(T to) {
        this.to = to;
    }

    public T getTo() {
        return to;
    }
}
