package org.natera.task.search;

import org.natera.task.model.Graph;
import org.natera.task.model.Path;

public interface SearchStrategy<T> {

    Path<T> getPath(Graph<T> graph, T from, T to);

}
