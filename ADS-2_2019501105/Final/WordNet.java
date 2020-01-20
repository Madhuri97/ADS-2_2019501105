import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * @author Madhuri
 */
public class WordNet {

    private final HashMap<Integer, String> id; 
    private final HashMap<String, ArrayList<Integer>> word;
    private final Digraph ver;                                            //vertex is type od Digraph
    private final SAP s;                                           //object of SAP as s
    public WordNet(String synsets, String hypernyms) {
        id = new HashMap<Integer, String>();
        word = new HashMap<String, ArrayList<Integer>>();
        this.parseSynsets(synsets);
        ver = new Digraph(id.size());
        this.parseHypernyms(hypernyms);
        s = new SAP(ver);
    }
    
    /**
     * this method is used to get the count of hypernyms.
     */
    private void parseHypernyms(String hypernyms) {
        In sc = new In(hypernyms);
        while (sc.hasNextLine()) {       // to read next line
            String[] hypnym = sc.readLine().split(",");
            // System.out.println(arr[0]);
            
            for (int i = 1; i < hypnym.length; i++) {
                ver.addEdge(Integer.parseInt(hypnym[0]), Integer.parseInt(hypnym[i]));
            }
        } 
        sc.close();
    }

    /**
     * this method is used to get the count of synsets.
     */
    private void parseSynsets(String synsets)  {
        In sc = new In(synsets);
        while (sc.hasNextLine()) {      // to read next line
            String[] synsts = sc.readLine().split(",");
            String[] synsw = synsts[1].split(" ");
            for (String string : synsw) {
                id.put(Integer.parseInt(synsts[0]), synsts[1]);
                if(!word.containsKey(string)) {
                    word.put(string, new ArrayList<Integer>());
                }
            } 
            // System.out.println(arr[0]);
        } 
        // System.out.println(synsetid.size());
        sc.close();
    }

    public Iterable<String> nouns() {
        return word.keySet();
    }

    public boolean isNoun(String wrd) {
        return word.containsKey(wrd);
    }

    public int distance(String nounA, String nounB) {
        if(!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        return s.length(word.get(nounA), word.get(nounB));
    }

    public String sap(String nounA, String nounB) {
        if(!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        return id.get(s.ancestor(word.get(nounA), word.get(nounB)));
    }
    public static void main(String[] args) {
        /*(lkh)
        */
    }
}
