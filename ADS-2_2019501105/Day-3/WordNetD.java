import java.io.*;
import java.util.*;
/**
 * @author Madhuri
 */
public class WordNetD {
    ArrayList<String> synsetid = new ArrayList<String>();   //synset id
    ArrayList<String> synsets = new ArrayList<String>();    //words of synset
    ArrayList<String> hypernyms = new ArrayList<String>();  //hypernyms
    ArrayList<String> hypnymsEdg = new ArrayList<String>(); //hypernyms edges
    DiGraph ver;                                            //vertex is type od digraph
    static SAP s;                                           //object of SAP as s
    public WordNetD() throws Exception {
        this.synsets();
        ver = new DiGraph(synsetid.size());
        this.hypernyms();
        System.out.println("vertices: " + ver.size());
        int count = 0;
        for (int i = 0; i < ver.size(); i++) {
            count = count + ver.adj[i].size();
        }
        System.out.println("edges:    " + count);
        s = new SAP(ver);
    }
    
    /**
     * this method is used to get the count of hypernyms.
     * @throws Exception
     */
    public void hypernyms() throws Exception {
        int count = 0;
        File file = new File("C:\\Users\\M. LAKSHMI MADHURI\\Desktop\\javaps\\ADS-2_2019501105\\hypernyms.txt"); 
        //load the data of the hypernyms file into program 
        //by passing the path as parameter
        Scanner sc = new Scanner(file);  //scanner object
        while (sc.hasNextLine()) {       // to read next line
            String[] hypnym = sc.nextLine().split(",");
            // System.out.println(arr[0]);
            hypernyms.add(hypnym[0]);
            
            for (int i = 1; i < hypnym.length; i++) {
                ver.addEdge(Integer.parseInt(hypnym[count]), Integer.parseInt(hypnym[i]));
            }
            for (int i = 1; i < hypnym.length; i++) {
                hypnymsEdg.add(hypnym[i]);
            }
        } 
        sc.close();
    }

    /**
     * this method is used to get the count of synsets.
     * @throws Exception
     */
    public void synsets() throws Exception {
        File file = new File("C:\\Users\\M. LAKSHMI MADHURI\\Desktop\\javaps\\ADS-2_2019501105\\synsets.txt"); 
        //load the data of the synsets file into program 
        //by passing the path as parameter
        Scanner sc = new Scanner(file); //scanner object
        while (sc.hasNextLine()) {      // to read next line
            String[] synsts = sc.nextLine().split(",");
            // System.out.println(arr[0]);
            synsetid.add(synsts[0]);
        } 
        // System.out.println(synsetid.size());
        sc.close();
    }

    public static void main(String[] args) throws Exception {
        WordNetD data = new WordNetD();
        data.hypernyms();
        System.out.println("length:   " + s.length(1, 81));
        System.out.println("ancestor: " + s.ancestor(7, 90));
    }
}
