import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
public class SAP {
    private static final int INFINITY = Integer.MAX_VALUE;
    private final Digraph digraph;
    public SAP(Digraph G) {
        digraph = G;
    }
    public int length(int v, int w) {
        if (!((v >= 0 && v <= digraph.V()) && (w >= 0 && w <= digraph.V()))) {
            throw new IllegalArgumentException();
        }
        BreadthFirstDirectedPaths vpaths = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths wpaths = new BreadthFirstDirectedPaths(digraph, w);
        return sapHelper(vpaths, wpaths, true);
    }
    public int ancestor(int v, int w) {
        if (!((v >= 0 && v <= digraph.V()) && (w >= 0 && w <= digraph.V()))) {
            throw new IllegalArgumentException();
        }
        BreadthFirstDirectedPaths vpaths = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths wpaths = new BreadthFirstDirectedPaths(digraph, w);
        return sapHelper(vpaths, wpaths, false);
    }
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        requireNonNull(v);
		requireNonNull(w);
        BreadthFirstDirectedPaths vpaths = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths wpaths = new BreadthFirstDirectedPaths(digraph, w);
        return sapHelper(vpaths, wpaths, true);
    }
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        requireNonNull(v);
        requireNonNull(w);
        BreadthFirstDirectedPaths vpaths = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths wpaths = new BreadthFirstDirectedPaths(digraph, w);
        return sapHelper(vpaths, wpaths, false);
    }
    private static <Notnull> Iterable<Notnull> requireNonNull(Iterable<Notnull> vertex) {
		if (vertex == null)
			throw new IllegalArgumentException();
		for (Notnull object : vertex)
			if (object == null)
				throw new IllegalArgumentException();
		return vertex;
	}
    private int sapHelper(BreadthFirstDirectedPaths vpaths, BreadthFirstDirectedPaths wpaths, boolean length) {
        int minlen = INFINITY;
        int ancestor = -1;
        for (int i = 0; i < digraph.V(); i++) {
            if (vpaths.hasPathTo(i) && wpaths.hasPathTo(i)) {
                int vlen = vpaths.distTo(i);
                int wlen = wpaths.distTo(i);
                if (vlen + wlen < minlen) {
                    minlen = vlen + wlen;
                    ancestor = i;
                }
            }
        }
        if (length) return minlen < INFINITY ? minlen : -1;
        else return ancestor;
    }
}
