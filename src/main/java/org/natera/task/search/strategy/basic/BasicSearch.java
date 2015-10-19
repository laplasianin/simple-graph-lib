package org.natera.task.search.strategy.basic;

import org.natera.task.model.Graph;
import org.natera.task.model.Path;
import org.natera.task.search.SearchStrategy;

public class BasicSearch<T> implements SearchStrategy<T> {

    @Override
    /**
     * Default search strategy
     *
     * It uses basic recursive path search algorithm, return path is not optimal
     *
     */
    public Path<T> getPath(Graph<T> graph, T from, T to) {
        return BasicSearchUtils.getPath(graph, from, to);
    }
}
