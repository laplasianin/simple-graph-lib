package org.natera.task.search.factory;

import org.natera.task.search.AvailableSearchStrategy;
import org.natera.task.search.strategy.basic.BasicSearch;
import org.natera.task.search.SearchStrategy;

public class SearchStrategyFactory {

    public static SearchStrategy getStrategy(AvailableSearchStrategy type) {
        if (type == null) {
            return getDefault();
        }

        switch (type) {
            case Basic:
            default: {
                return getDefault();
            }
        }
    }

    private static SearchStrategy getDefault() {
        return new BasicSearch<>();
    }

    public static SearchStrategy getStrategy() {
        return getDefault();
    }

}
