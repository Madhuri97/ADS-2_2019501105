/**
 * @author Madhuri
 * @reference Robert Sedgewick
 */
public class Digraph {
    int V;
    public Bag<Integer>[] adj; // array of datatype bag

        public Digraph(int in) {
        this.V = in;
        adj = (Bag<Integer>[]) new Bag[in];
        for(int v = 0; v < in; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    
	public Digraph(Digraph g) {
		}

	public int Digraph(int size) {
        return size;
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
