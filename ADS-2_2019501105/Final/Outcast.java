public class Outcast {
    private final WordNet wordnet;

    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    } 

    public String outcast(String[] nouns) {
        String outcast = null;
        int maxDist = 0;
        for (int i = 0; i < nouns.length; i++) {
            int dist = 0;
            for (int j = 0; j < nouns.length; j++) {
                
                    int distance = wordnet.distance(nouns[i], nouns[j]);
                    dist += distance;
                }
            
            if (dist > maxDist) {
                maxDist = dist;
                outcast = nouns[i];
            }
        }
        return outcast;
    }
}