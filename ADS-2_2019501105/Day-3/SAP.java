/**
 * @author Madhuri
 */
public class SAP {
    private static final int INFINITY = Integer.MAX_VALUE;
    DiGraph G;
    int integer = Integer.MAX_VALUE;
    
    public SAP(DiGraph G) {
        this.G = G;
    }

    /**
     * this method is used to return the length between two vertices.
     * @param v
     * @param w
     * @return
     * @throws Exception
     */
    public int length(int v, int w) throws Exception {
        if(v > G.V() || v < 0 || w > G.V() || w < 0) throw new IndexOutOfBoundsException();
        return LA(v,w)[1];
    }

    /**
     * this method is used to return ancestor for vertices.
     * @param v
     * @param w
     * @return
     * @throws Exception
     */
    public int ancestor(int v, int w) throws Exception {
        if(v > G.V() || v < 0 || w > G.V() || w < 0) throw new IndexOutOfBoundsException();
        return LA(v,w)[0];
    }

    /**
     * this method is used to find out the shortest 
     * distance and ancestor for vertices using BFS.
     * @param v
     * @param w
     * @return
     * @throws Exception
     */
    private int[] LA(int v, int w) throws Exception {
        int[] LA = new int[2];
        int dis = INFINITY;
        int anc = -1;
        BreadthFirstDirectedPaths bfdp1 = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfdp2 = new BreadthFirstDirectedPaths(G, w);
        for (int ver = 0; ver < G.V(); ver++) {
            if(bfdp1.hasPathTo(ver) && bfdp2.hasPathTo(ver)) {
                if(bfdp1.distTo(ver) + bfdp2.distTo(ver) < dis) {
                    dis = bfdp1.distTo(ver) + bfdp2.distTo(ver);
                    anc = ver;
                }
            }
        }
        LA[0] = anc;
        LA[1] = (dis == INFINITY? -1: dis);
        return LA;
    }
    
    /**
     * this method is used find out length of the shortest ancestral 
     * path between any vertex in v and any vertex in w.
     * @param v
     * @param w
     * @return
     */
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if(v == null || w ==null) {
            throw new NullPointerException();
        } 
        return LA(v, w)[1];
    }

    /**
     * common ancestor that participates in shortest ancestral path.
     * @param v
     * @param w
     * @return
     */
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if(v == null || w == null) {
            throw new NullPointerException();
        }
        return integer;
    }
    int[] LA(Iterable<Integer> v, Iterable<Integer> w) {
        return null;
    }      
}
