package org.natera.task.model;

import org.natera.task.exception.NoSuchVertexException;

import java.util.Collection;

public interface Graph<T> {

    /**
     * Add specified vertex to graph
     *
     * @param vertex vertex which should be added
     * @return <tt>true</tt> if this vertex was added, <tt>false</tt> otherwise
     */
    boolean addVertex(T vertex);

    boolean hasVertex(T vertex);

    /**
     * Add edge between two specified vertices
     *
     * @param from first vertex of relation
     * @param to second vertex of relation
     *
     * Order of parameters is not important in the case of undirected graph
     * @throws NoSuchVertexException if elements are null or not specified as vertices in graph
     */
    void addEdge(T from, T to);

    Collection<Edge<T>> findEdgesOf(T from);
}
