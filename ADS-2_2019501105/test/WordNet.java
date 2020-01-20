import java.util.HashMap;
import java.util.ArrayList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;

public class WordNet {

    private final HashMap<Integer, String> synsetss;
    private final HashMap<String, ArrayList<Integer>> hypernymss;
    private final Digraph graph;
    private final SAP sap;
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException();
        }
        synsetss = new HashMap<Integer, String>();
        hypernymss = new HashMap<String, ArrayList<Integer>>();
        this.parseSynsets(synsets);
        graph = new Digraph(synsetss.size());
        this.parseHypernyms(hypernyms);
        this.sap = new SAP(graph);
    }

    private void parseSynsets(String synsets) {
        if (synsets == null) {
            throw new IllegalArgumentException();
        }
        In in = new In(synsets);
        while (in.hasNextLine()) {
            String[] syn = in.readLine().split(",");
            String[] words = syn[1].split("\\s++");
            for (String s : words) {
                synsetss.put(Integer.parseInt(syn[0]), syn[1]);
                if (!hypernymss.containsKey(s)) {
                    hypernymss.put(s, new ArrayList<Integer>());
                }
            }
        }
        in.close();
    }

    private void parseHypernyms(String hypernyms) {
        if (hypernyms == null) {
            throw new IllegalArgumentException();
        }
        In in = new In(hypernyms);
        while (in.hasNextLine()) {
            String[] hyn = in.readLine().split(",");
            for (int i = 1; i < hyn.length; i++) {
                graph.addEdge(Integer.parseInt(hyn[0]), Integer.parseInt(hyn[i]));
            }
        }
        in.close();
        if (hasCycle()) {
            throw new IllegalArgumentException("Given graph is not a DAG.");
        }
    }

    private boolean hasCycle() {
        ArrayList<Integer> cycle = new ArrayList<Integer>();
        for (int i = 0; i < graph.V(); i++) {
            if (!graph.adj(i).iterator().hasNext()) {
                cycle.add(i);
            }
        }
        if (cycle.isEmpty() || cycle.size() > 1) {
            return true;
        }
        DirectedCycle dCycle = new DirectedCycle(graph);
        return dCycle.hasCycle();        
    }

    public Iterable<String> nouns() {
        return hypernymss.keySet();
    }

    public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }
        return hypernymss.containsKey(word);
    }

    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("Not WordNet Noun");
        }
        return sap.length(hypernymss.get(nounA), hypernymss.get(nounB));
    }
    public String sap(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("Noun is not in WordNet");
        }
        return synsetss.get(sap.ancestor(hypernymss.get(nounA), hypernymss.get(nounB)));
    }
    public static void main(String[] args) {
        /* WordNet obj = new WordNet("synsets", "hypernyms");
          System.out.println(sap.ancestor(22, 102));
          System.out.println(sap.ancestor(21, 23450)); */
  } 
} 
