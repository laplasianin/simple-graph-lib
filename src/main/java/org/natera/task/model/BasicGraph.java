package org.natera.task.model;

import org.natera.task.exception.NoSuchVertexException;

import java.util.*;

public class BasicGraph<T> implements Graph<T> {

    private Map<T, Collection<Edge<T>>> vertices = new HashMap<>();

    private Direction direction = Direction.Undirected;

    public BasicGraph(Direction direction) {
        this.direction = direction;
    }

    public BasicGraph() {
    }

    public boolean addVertex(T vertex) {
        if (vertex == null) {
            return false;
        }
        if (vertices.containsKey(vertex)) {
            return false;
        }
        vertices.put(vertex, new ArrayList<>());
        return true;
    }

    @Override
    public boolean hasVertex(T vertex) {
        return vertices.containsKey(vertex);
    }

    public void addEdge(T from, T to) {

        if (!hasVertex(from)) {
            throw new NoSuchVertexException(from);
        }
        if (!hasVertex(to)) {
            throw new NoSuchVertexException(to);
        }

        Edge<T> edge = new Edge<>(to);
        vertices.get(from).add(edge);

        if (!isDirected()) {
            vertices.get(to).add(new Edge<>(from));
        }
    }

    private boolean isDirected() {
        return direction == Direction.Directed;
    }

    public Collection<Edge<T>> findEdgesOf(T from) {
        Collection<Edge<T>> edges = this.vertices.getOrDefault(from, Collections.emptyList());

        return Collections.unmodifiableCollection(edges);
    }
}
