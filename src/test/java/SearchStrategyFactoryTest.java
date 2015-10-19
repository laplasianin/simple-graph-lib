import org.junit.Assert;
import org.junit.Test;
import org.natera.task.search.factory.SearchStrategyFactory;
import org.natera.task.search.strategy.basic.BasicSearch;

import static org.natera.task.search.AvailableSearchStrategy.Basic;

public class SearchStrategyFactoryTest {

    @Test
    public void testDefaultStrategy() {
        Assert.assertEquals(SearchStrategyFactory.getStrategy().getClass(), BasicSearch.class);
    }

    @Test
    public void testBasicStrategy() {
        Assert.assertEquals(SearchStrategyFactory.getStrategy(Basic).getClass(), BasicSearch.class);
    }

    @Test
    public void testNullStrategy() {
        Assert.assertEquals(SearchStrategyFactory.getStrategy(null).getClass(), BasicSearch.class);
    }


}
