public class Outcast {

    private WordNet wn;
    
    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        wn = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {

        int max = 0;
        String finalOutcast = "";
        for (String noun : nouns) {
            int currentOutcast = 0;
            for (String otherNoun : nouns) {
                if (otherNoun != noun) {
                    currentOutcast += wn.distance(noun, otherNoun);
                }
            }

            if (currentOutcast > max) {
                max = currentOutcast;
                finalOutcast = noun;
            }
        }

        return finalOutcast;
    }
}