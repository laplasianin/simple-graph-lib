import org.junit.Assert;
import org.junit.Test;
import org.natera.task.model.Graph;
import org.natera.task.exception.NoSuchVertexException;
import org.natera.task.model.BasicGraph;
import org.natera.task.model.Edge;

import java.util.Collection;

import static org.natera.task.model.Direction.Directed;

public class BasicGraphTest {

    @Test
    public void testAddVertex() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        boolean added = graph.addVertex(v1);
        Assert.assertTrue(added);
        Assert.assertTrue(graph.hasVertex(v1));

        added = graph.addVertex(v1);
        Assert.assertFalse(added);
        Assert.assertTrue(graph.hasVertex(v1));

        added = graph.addVertex(v2);
        Assert.assertTrue(added);
        Assert.assertTrue(graph.hasVertex(v2));

        added = graph.addVertex(null);
        Assert.assertFalse(added);
        Assert.assertTrue(graph.hasVertex(v1));
        Assert.assertTrue(graph.hasVertex(v2));
    }

    @Test
    public void testHasVertex() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        Assert.assertFalse(graph.hasVertex(v1));
        Assert.assertFalse(graph.hasVertex(v2));

        graph.addVertex(v1);
        Assert.assertTrue(graph.hasVertex(v1));
        Assert.assertFalse(graph.hasVertex(v2));

        graph.addVertex(v2);
        Assert.assertTrue(graph.hasVertex(v1));
        Assert.assertTrue(graph.hasVertex(v2));

    }

    @Test
    public void testAddEdgeUnDirected() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v1);
        graph.addVertex(v2);

        Assert.assertFalse(graph.findEdgesOf(v1).stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v2)));
        Assert.assertFalse(graph.findEdgesOf(v2).stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v1)));

        graph.addEdge(v1, v2);

        Assert.assertTrue(graph.findEdgesOf(v1).stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v2)));
        Assert.assertTrue(graph.findEdgesOf(v2).stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v1)));
    }

    @Test
    public void testAddEdgeDirected() {
        Graph<String> graph = new BasicGraph<>(Directed);

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v1);
        graph.addVertex(v2);

        Assert.assertFalse(graph.findEdgesOf(v1).stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v2)));
        Assert.assertFalse(graph.findEdgesOf(v2).stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v1)));

        graph.addEdge(v1, v2);

        Assert.assertTrue(graph.findEdgesOf(v1).stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v2)));
        Assert.assertFalse(graph.findEdgesOf(v2).stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v1)));

    }

    @Test(expected = NoSuchVertexException.class)
    public void testAddEdgeInvalidVertexFrom() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v2);

        graph.addEdge(v1, v2);
    }

    @Test(expected = NoSuchVertexException.class)
    public void testAddEdgeInvalidVertexTo() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v1);

        graph.addEdge(v1, v2);
    }

    @Test(expected = NoSuchVertexException.class)
    public void testAddEdgeNullVertexTo() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v1);
        graph.addVertex(v2);

        graph.addEdge(v1, null);
    }

    @Test(expected = NoSuchVertexException.class)
    public void testAddEdgeNullVertexFrom() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v1);
        graph.addVertex(v2);

        graph.addEdge(null, v2);
    }

    @Test
    public void testFindEdgesOfNull() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v1);
        graph.addVertex(v2);

        Collection<Edge<String>> edgesOf = graph.findEdgesOf(null);
        Assert.assertTrue(edgesOf.isEmpty());
    }

    @Test
    public void testFindEdgesOfUnexisted() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v1);
        graph.addVertex(v2);

        Collection<Edge<String>> edgesOf = graph.findEdgesOf("3");
        Assert.assertTrue(edgesOf.isEmpty());
    }

    @Test
    public void testFindEdgesOfUnDirected() {
        Graph<String> graph = new BasicGraph<>();

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v1);
        graph.addVertex(v2);

        Collection<Edge<String>> edgesOf = graph.findEdgesOf(v1);
        Assert.assertTrue(edgesOf.isEmpty());

        edgesOf = graph.findEdgesOf(v2);
        Assert.assertTrue(edgesOf.isEmpty());

        graph.addEdge(v1, v2);

        edgesOf = graph.findEdgesOf(v1);
        Assert.assertTrue(edgesOf.stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v2)));
        Assert.assertFalse(edgesOf.stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v1)));

        edgesOf = graph.findEdgesOf(v2);
        Assert.assertTrue(edgesOf.stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v1)));
        Assert.assertFalse(edgesOf.stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v2)));
    }

    @Test
    public void testFindEdgesOfDirected() {
        Graph<String> graph = new BasicGraph<>(Directed);

        String v1 = "1";
        String v2 = "2";

        graph.addVertex(v1);
        graph.addVertex(v2);

        Collection<Edge<String>> edgesOf = graph.findEdgesOf(v1);
        Assert.assertTrue(edgesOf.isEmpty());

        edgesOf = graph.findEdgesOf(v2);
        Assert.assertTrue(edgesOf.isEmpty());

        graph.addEdge(v1, v2);

        edgesOf = graph.findEdgesOf(v1);
        Assert.assertTrue(edgesOf.stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v2)));
        Assert.assertFalse(edgesOf.stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v1)));

        edgesOf = graph.findEdgesOf(v2);
        Assert.assertFalse(edgesOf.stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v1)));
        Assert.assertFalse(edgesOf.stream().anyMatch(stringEdge -> stringEdge.getTo().equals(v2)));
    }

}
