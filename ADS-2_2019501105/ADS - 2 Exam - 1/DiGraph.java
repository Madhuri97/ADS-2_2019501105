/**
 * @author Madhuri
 * @reference Robert Sedgewick
 */
public class DiGraph {
    int V;
    public Bag<Integer>[] adj; // array of datatype bag

        public DiGraph(int i) {
        this.V = i;
        adj = (Bag<Integer>[]) new Bag[i];
        for(int v = 0; v < i; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    
	/**
     * tis method is used to add the edge between two vertices v and w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    /**
     * this is used to display particular bag elements
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

	public int size() {
		return adj.length;
	}

	public int V() {
		return V;
	}
}
