package org.natera.task;

import org.natera.task.model.Graph;
import org.natera.task.exception.NoSuchVertexException;
import org.natera.task.model.Path;
import org.natera.task.search.AvailableSearchStrategy;
import org.natera.task.search.SearchStrategy;
import org.natera.task.search.factory.SearchStrategyFactory;

public class GraphPathSearcher {

    /**
     * Find path between two vertices. Basic search strategy is applied by default
     *
     * @param graph graph to be searched
     * @param from vertex at which the path should start
     * @param to vertex at which the path should end
     *
     * @return List of Vertices, or null if no path exists
     */
    public static <T> Path<T> getPath(Graph<T> graph, T from, T to) {

        SearchStrategy strategy = SearchStrategyFactory.getStrategy();
        return strategy.getPath(graph, from, to);

    }

    /**
     * Find path between two vertices according chosen search strategy
     *
     * @param graph graph to be searched
     * @param from vertex at which the path should start
     * @param to vertex at which the path should end
     * @param searchStrategy search strategy to be applied
     *
     * @return List of Vertices or null if no path exists
     */
    public static <T> Path<T> getPath(Graph<T> graph, T from, T to, AvailableSearchStrategy searchStrategy) {

        if (graph == null) {
            throw new IllegalArgumentException("Graph should not be null");
        }
        if (!graph.hasVertex(from)) {
            throw new NoSuchVertexException(from);
        }
        if (!graph.hasVertex(to)) {
            throw new NoSuchVertexException(to);
        }

        SearchStrategy strategy = SearchStrategyFactory.getStrategy(searchStrategy);
        return strategy.getPath(graph, from, to);

    }

}
