import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;

/**
 * @author Madhuri
 */
public class SAP {
    private Digraph g;

    /**
     * @param g A digraph, not necessarily a DAG.
     */
    public SAP(Digraph g) {
        this.g = new Digraph(g);
    }

    /**
     * Calculate the length of the shortest ancestral path between v
     * and w.
     * @return the length, or -1 if there is no ancestral path.
     */
    public int length(int v, int w) {
        BreadthFirstDirectedPaths searchV = new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths searchW = new BreadthFirstDirectedPaths(g, w);

        int shortest = -1;
        for (int s = 0; s < g.V(); ++s) {
            if (searchV.hasPathTo(s) && searchW.hasPathTo(s)) {
                int dist = searchV.distTo(s) + searchW.distTo(s);
                if (shortest == -1 || dist < shortest) {
                    shortest = dist;
                }
            }
        }

        return shortest;
    }

    /**
     * Find the common ancestor of v and w that participates
     * in a shortest ancestral path.
     * @return the ID of the vertex, or -1 if there is no ancestral path.
     */
    public int ancestor(int v, int w) {
        BreadthFirstDirectedPaths searchV = new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths searchW = new BreadthFirstDirectedPaths(g, w);

        int shortest = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int s = 0; s < g.V(); ++s) {
            if (searchV.hasPathTo(s) && searchW.hasPathTo(s)) {
                int dist = searchV.distTo(s) + searchW.distTo(s);
                if (dist < shortest) {
                    shortest = dist;
                    ancestor = s;
                }
            }
        }

        return ancestor;
    }

    /**
     * Calculate the length of the shortest ancestral path between any vertex
     * in v and any vertex in w.
     * @return the length, or -1 if there is no ancestral path.
     */
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths searchV = new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths searchW = new BreadthFirstDirectedPaths(g, w);

        int shortest = -1;
        for (int s = 0; s < g.V(); ++s) {
            if (searchV.hasPathTo(s) && searchW.hasPathTo(s)) {
                int dist = searchV.distTo(s) + searchW.distTo(s);
                if (shortest == -1 || dist < shortest) {
                    shortest = dist;
                }
            }
        }

        return shortest;
    }

    /**
     * Find a common ancestor that participates in the shortest ancestral path.
     * @return the vertex ID, or -1 if there is no ancestral path.
     */
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths searchV = new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths searchW = new BreadthFirstDirectedPaths(g, w);

        int shortest = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int s = 0; s < g.V(); ++s) {
            if (searchV.hasPathTo(s) && searchW.hasPathTo(s)) {
                int dist = searchV.distTo(s) + searchW.distTo(s);
                if (dist < shortest) {
                    shortest = dist;
                    ancestor = s;
                }
            }
        }

        return ancestor;
    }
}