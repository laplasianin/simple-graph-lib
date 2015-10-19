import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.natera.task.model.Graph;
import org.natera.task.model.BasicGraph;
import org.natera.task.model.Path;
import org.natera.task.GraphPathSearcher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicSearchUndirectedTest {

    private Graph<String> graph;

    @Before
    public void before() {
        graph = new BasicGraph<>();

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");

        graph.addEdge("1", "2");
        graph.addEdge("2", "3");
        graph.addEdge("3", "4");
        graph.addEdge("4", "5");
        graph.addEdge("5", "1");
        graph.addEdge("5", "2");
        graph.addEdge("4", "6");
    }

    @Test
    public void testUnDirected() {
        List<String> answers = new ArrayList<String>() {{
            add("1-5-4-6");
            add("1-5-2-3-4-6");
            add("1-2-3-4-6");
            add("1-2-5-4-6");
        }};

        Path<String> path = GraphPathSearcher.getPath(graph, "1", "6");
        Assert.assertTrue(answers.contains(path.toString()));

        path = GraphPathSearcher.getPath(graph, "2", "6");
        Assert.assertFalse(answers.contains(path.toString()));

        path = GraphPathSearcher.getPath(graph, "6", "1");
        Assert.assertTrue(answers.stream()
                .map(StringUtils::reverse)
                .collect(Collectors.toList())
                .contains(path.toString()));

        path = GraphPathSearcher.getPath(graph, "6", "2");
        Assert.assertFalse(answers.contains(path.toString()));

    }


}
