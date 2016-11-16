import java.util.*;

/**
 * Created by nathan on 19/10/16.
 * http://codereview.stackexchange.com/questions/48518/depth-first-search-breadth-first-search-implementation
 */
public class Graph
{
	private Map<String, List<String>> edges = new HashMap<String, List<String>>();

	public void addEdge(String source, String dest)
	{
		List<String> sourceNeighbors = this.edges.get(source);
		if(sourceNeighbors == null)
		{
			this.edges.put(source, sourceNeighbors = new ArrayList<String>());
		}
		sourceNeighbors.add(dest);
	}

	public Iterable<String> getNeighbors(String vertex)
	{
		List<String> neighbors = this.edges.get(vertex);
		if(neighbors == null)
		{
			return Collections.emptyList();
		}
		else
		{
			return Collections.unmodifiableList(neighbors);
		}
	}
}
