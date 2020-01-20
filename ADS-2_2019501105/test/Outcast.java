public class Outcast {
    private final WordNet wordnet;
       public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
       }    
       public String outcast(String[] nouns) {
        int d = 0;
        String outcast = null;
        for (String i : nouns) {
            int distance = 0;
            for (String j : nouns) {
                int distLen = wordnet.distance(i, j);
                distance += distLen;
            }
            if (distance > d) {
                d = distance;
                outcast = i;
            }
        }
        return outcast;
       }
       public static void main(String[] args) {
    // Main method
    // unimportant
       }
    }
    