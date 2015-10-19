import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.natera.task.model.Graph;
import org.natera.task.model.BasicGraph;
import org.natera.task.model.Path;
import org.natera.task.GraphPathSearcher;

import java.util.ArrayList;
import java.util.List;

import static org.natera.task.model.Direction.Directed;

public class BasicSearchDirectedTest {

    private Graph<String> graph;

    @Before
    public void before() {
        graph = new BasicGraph<>(Directed);

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
    }

    @Test
    public void testDirected() {
        List<String> answers = new ArrayList<String>() {{
            add("1-2-3-4-5");
        }};

        Path<String> path = GraphPathSearcher.getPath(graph, "1", "6");
        Assert.assertNull(path);

        path = GraphPathSearcher.getPath(graph, "1", "5");
        Assert.assertTrue(answers.contains(path.toString()));

        path = GraphPathSearcher.getPath(graph, "5", "6");
        Assert.assertNull(path);

    }


}
