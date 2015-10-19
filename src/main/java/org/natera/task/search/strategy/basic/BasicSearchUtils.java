package org.natera.task.search.strategy.basic;

import org.natera.task.model.Graph;
import org.natera.task.model.Edge;
import org.natera.task.model.Path;

import java.util.Collection;

class BasicSearchUtils {

    public static <T> Path<T> getPath(Graph<T> graph, T from, T to) {

        Path<T> startPath = new Path<>();
        startPath.add(from);
        return getPath(graph, from, to, startPath);

    }

    private static <T> Path<T> getPath(Graph<T> graph, T from, T to, Path<T> oldPath) {

        Collection<Edge<T>> edges = findEdgesOf(graph, from);

        for (Edge<T> edge : edges) {
            T edgeTo = edge.getTo();

            if (isDestination(to, edgeTo)) {
                oldPath.add(edgeTo);
                return oldPath;
            } else if (!checkedVertex(oldPath, edgeTo)) {
                Path<T> newPath = new Path<>(oldPath);
                newPath.add(edgeTo);
                Path<T> path = getPath(graph, edgeTo, to, newPath);
                if (path != null) {
                    return path;
                }
            }
        }
        return null;
    }

    private static <T> Collection<Edge<T>> findEdgesOf(Graph<T> graph, T from) {
        return graph.findEdgesOf(from);
    }

    private static <T> boolean checkedVertex(Path checked, T vertex) {
        return checked.contains(vertex);
    }

    private static <T> boolean isDestination(T to, T vertex) {
        return vertex.equals(to);
    }

}
