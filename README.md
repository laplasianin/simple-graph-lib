This is a simple graph lib providing API to find path between two edges (does not have to be optimal).

Undirected and directed graphs are supported.

Edges are parametrized type so you can use any (but it should be comparable because it's used in algorythm).

Usage example:

<b>Create undirected:</b><br>
Graph<String> graph = new BasicGraph<>();

<b>Create directed:</b><br>
Graph<String> graph = new BasicGraph<>(Direction.Directed);

<b>Add vertex:</b><br>
graph.addVertex("vertex1");<br>
graph.addVertex("vertex2");

<b>Add edge between two vertices:</b><br>
graph.addEdge("vertex1", "vertex2");<br>
Beware that if graph is undirected you don't need to add vers edge (vertex2 -> vertex1), it's added internally.<br>
Can throw NoSuchVertexException if you try to add invalid vertex.<br>
Null vertices are not supported<br><br>

<b>Search path between two vertices:</b><br>
Path<String> path = GraphPathSearcher.getPath(graph, "vertex1", "vertex2");
