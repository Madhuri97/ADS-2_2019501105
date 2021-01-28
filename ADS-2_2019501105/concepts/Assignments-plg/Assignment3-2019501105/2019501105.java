/**
 * @author Madhuri
 * card class which stores faces and suits
 */
public class Card implements Comparable<Card>{
    int faces;
    int suits;
    /**
     * @param faces are the values of card
     * @param suits are the type of card
     */
    public Card(int faces,int suits) {
        this.faces = faces;
        this.suits = suits;
    }
    /**
     * compareTo method is used to compare the objects.
     * @param that 
     * @return int value after comparisions
     * this compareTo method has three conditions 
     * if the that number is greater than the current number
     * it returns -1, if current number is greater than that
     * number it returns 1 else 0
     */
    public int compareTo(Card that) { 
        if(this.suits < that.suits) return -1;
        else if(this.suits > that.suits) return 1;
        else {
            if(this.faces < that.faces) return -1;
            else if(this.faces > that.faces) return 1;
            else return 0;
        }
    }
    /**
     * this method retruns the suits and respected faces 
     * for printing the array of cards series
     * @return String 
     */
    public String toString() {
        String s = " ";
        if(this.suits == 1) s = s + "Spades";
        else if(this.suits == 2) s = s + "Hearts";
        else if(this.suits == 3) s = s + "Clubs";
        else if(this.suits == 4) s = s + "Diamonds";

        if(this.faces == 1) return "A" + " " + s;
        else if(this.faces == 11) return "J" + " " + s;
        else if(this.faces == 12) return "Q" + " " + s;
        else if(this.faces == 13) return "K" + " " + s;
        else return this.faces + " " + s;

    }
}
